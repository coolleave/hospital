<template>
  <div class="app-container">
    <!-- 查询表单 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="病历号" prop="medicalRecordNo">
        <el-input
          v-model="queryParams.medicalRecordNo"
          placeholder="请输入病历号"
          clearable
          style="width: 240px;"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
        >AI分析</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 表格 -->
    <el-table ref="tables" v-loading="loading" :data="listWithIndex" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="50" align="center" />
      <el-table-column type="index" width="70" align="center" label="内部序号">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="病历号" align="center">
        <template slot-scope="scope">
          {{ scope.row.encounterId }} <!-- 映射 encounterId 到 medicalRecordNo -->
        </template>
      </el-table-column>
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="操作类型" align="center">
  <template slot-scope="scope">
    {{ operationTypeMap[scope.row.operationType] || scope.row.operationType }}
  </template>
</el-table-column>
      <el-table-column label="更新时间" align="center">
        <template slot-scope="scope">
          {{ parseTime(scope.row.updateTime) }}
        </template>
      </el-table-column>
      <el-table-column label="原因" align="center" prop="reason" :show-overflow-tooltip="true" />
      <el-table-column label="操作" align="center" width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
          >详情</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <el-dialog
  :title="currentDetail ? currentDetail.typeLabel : '详情信息'"
  :visible.sync="open"
  width="600px"
  append-to-body
>
  <div v-if="detailLoading">
    <el-spin tip="加载中..."></el-spin>
  </div>

  <div v-else-if="currentDetail" class="detail-content">
    <!-- 使用 el-descriptions 模拟表单样式 -->
    <el-descriptions :column="1" border size="medium">
      <el-descriptions-item v-for="(value, key) in currentDetail.data" :key="key" :label="key">
        {{ value || '暂无数据' }}
      </el-descriptions-item>
    </el-descriptions>
  </div>

  <div v-else>
    <el-empty description="暂无数据"></el-empty>
  </div>

  <div slot="footer" class="dialog-footer">
    <el-button type="primary" @click="open = false">关闭</el-button>
  </div>
</el-dialog>

 
<!-- 对话框 -->
<el-dialog
  title="deepseek分析结果"
  :visible.sync="dialogVisible"
  width="50%"
>
  <div>{{ dialogContent }}</div>
</el-dialog>




  </div>
</template>
 




<script>
import { getBasesign } from "@/api/system/basesign";
import { listVitalsignByEncounterId } from '@/api/system/vitalsign';
import { listGasByEncounterId } from '@/api/system/gas';
import { listBalanceByEncounterId } from '@/api/system/balance';
import { listBiochemistryByEncounterId } from '@/api/system/biochemistry';
import { listCpotByEncounterId } from '@/api/system/Cpotscore';
import { listEcmoByEncounterId } from '@/api/system/ecmo';
import { listGcsscoreByEncounterId } from '@/api/system/Gcsscore';
import { listHematologyByEncounterId } from '@/api/system/hematology';
import { listPiccoByEncounterId } from '@/api/system/picco';
import { listRecordByEncounterId } from '@/api/system/record';
import { listUrinalysisByEncounterId } from '@/api/system/urinalysis';
import { getVitalsign } from "@/api/system/vitalsign";
import { getGas } from "@/api/system/gas";
import { getBalance } from "@/api/system/balance";
import { getBiochemistry } from "@/api/system/biochemistry";
import { getCpotscore } from "@/api/system/Cpotscore";
import { getEcmo } from "@/api/system/ecmo";
import { getGcsscore } from "@/api/system/Gcsscore";
import { getHematology } from "@/api/system/hematology";
import { getPicco } from "@/api/system/picco";
import { getRecord } from "@/api/system/record";
import { getUrinalysis } from "@/api/system/urinalysis";
import { Loading } from 'element-ui'; // 确保已导入 ElLoading

export default {
  data() {
    return {
      showSearch: true,
      loading: false,
      open: false,

      loading2: false, // 控制加载状态
      dialogVisible: false, // 控制对话框是否可见
      dialogContent: '', // 对话框要展示的内容


      consolidatedData: [], // 新增：用于保存整合后的数据
      selectedRows: [] ,// 用于保存选中的行数据


      currentDetail: null, // 接收当前详情数据
      detailLoading: false,

      fullList: [], // 存储所有接口返回的数据
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        medicalRecordNo: null
      },
      list: [], // 当前页数据
      total: 0,
      form: {},
      operationTypeMap: {
        basesign: '病例录入',
        vitalsign: '生命体征',
        gas: '血气分析',
        balance: '出入量',
        biochemistry: '生化指标',
        cpot: 'CPOT评分',
        ecmo: 'ECMO记录',
        gcsscore: 'GCS评分',
        hematology: '血常规',
        picco: 'PICCO监测',
        record: '护理记录',
        urinalysis: '尿液分析'
      },
      detailDataMap: {
      basesign: { api: getBasesign, label: '病历录入' },
      vitalsign: { api: getVitalsign, label: '生命体征' },
      gas: { api: getGas, label: '血气分析' },
      balance: { api: getBalance, label: '出入量' },
      biochemistry: { api: getBiochemistry, label: '生化指标' },
      cpot: { api: getCpotscore, label: 'CPOT评分' },
      ecmo: { api: getEcmo, label: 'ECMO记录' },
      gcsscore: { api: getGcsscore, label: 'GCS评分' },
      hematology: { api: getHematology, label: '血常规' },
      picco: { api: getPicco, label: 'PICCO监测' },
      record: { api: getRecord, label: '护理记录' },
      urinalysis: { api: getUrinalysis, label: '尿液分析' }
    },
    currentDetail: null,
    open: false,
    detailLoading: false
 
    };
  },
  computed: {
    listWithIndex() {
      return this.list.map((item, index) => ({
        ...item,
        index: (this.queryParams.pageNum - 1) * this.queryParams.pageSize + index + 1
      }));
    }
  },
  watch: {
    'queryParams.pageNum': 'handlePagination',
    'queryParams.pageSize': 'handlePagination'
  },
  methods: {
    async handleQuery() {
      const id = this.queryParams.medicalRecordNo;
      if (!id) {
        this.$message.warning("请输入病历号进行查询");
        return;
      }

      this.loading = true;

      // 所有接口方法数组，包含接口方法和操作类型名称
      const apiCalls = [
        { method: getBasesign, name: 'basesign' },
        { method: listVitalsignByEncounterId, name: 'vitalsign' },
        { method: listGasByEncounterId, name: 'gas' },
        { method: listBalanceByEncounterId, name: 'balance' },
        { method: listBiochemistryByEncounterId, name: 'biochemistry' },
        { method: listCpotByEncounterId, name: 'cpot' },
        { method: listEcmoByEncounterId, name: 'ecmo' },
        { method: listGcsscoreByEncounterId, name: 'gcsscore' },
        { method: listHematologyByEncounterId, name: 'hematology' },
        { method: listPiccoByEncounterId, name: 'picco' },
        { method: listRecordByEncounterId, name: 'record' },
        { method: listUrinalysisByEncounterId, name: 'urinalysis' }
      ];

      // 公共字段映射函数，传入 requestName 作为 operationType
      function extractCommonFields(dataItem, requestName) {
        // return {
        //   id: dataItem.id || '', // 保留 id 用于排序
        //   encounterId: dataItem.encounterId || '',
        //   hospitalId: dataItem.hospitalId || '',
        //   operationType: requestName, // 使用接口名作为 operationType
        //   updateTime: dataItem.chartTime || '',
        //   reason: dataItem.instructions || ''
        // };
        let commonData = {
          encounterId: dataItem.encounterId || '',
          hospitalId: dataItem.hospitalId || '',
          operationType: requestName,
          updateTime: dataItem.chartTime || ''
        };

        // basesign 的 id 是病历号，而不是数据库 ID
        if (requestName === 'basesign') {
          commonData.id = dataItem.id; // 病历号作为 id
          commonData.encounterId = dataItem.id; // 病历号作为 id
          commonData.reason = dataItem.admissionDiagnosis || ''; // 不同字段名
        } else {
          commonData.id = dataItem.id || '';
          commonData.reason = dataItem.instructions || '';
        }

 

        return commonData;

      }

      const fullData = [];

      for (const { method, name } of apiCalls) {
        try {
          const response = await method(id);
          console.log(`获取到${name}数据:`, response);

          if (response.code === 200 && response.data) {
            let dataList = Array.isArray(response.data) ? response.data : [response.data];
            fullData.push(...dataList.map(item => extractCommonFields(item, name)));
          }
        } catch (error) {
          console.error('请求出错:', error);
          this.$message.error("网络错误，请重试");
        }
      }

      // // 根据 id 排序
      // fullData.sort((a, b) => a.id - b.id);

      // 设置数据
      this.fullList = fullData;
      this.total = fullData.length;
      this.handlePagination(); // 初始加载第一页
      this.loading = false;
    },

    handlePagination() {
      const { pageNum, pageSize } = this.queryParams;
      const start = (pageNum - 1) * pageSize;
      const end = start + pageSize;
      this.list = this.fullList.slice(start, end);
    },

    resetQuery() {
      this.$refs.queryForm.resetFields();
      this.handleQuery();
    },
    async handleAdd() {

 
  if (!this.selectedRows.length) {
    this.$message.warning("请先选择要新增的记录");
    return;
  }

  this.consolidatedData = []; // 清空之前的数据

  for (const row of this.selectedRows) {
    const { operationType, id } = row;
    const detailConfig = this.detailDataMap[operationType];

    if (!detailConfig) {
      console.warn(`不支持的操作类型: ${operationType}`);
      continue;
    }

    try {
      const response = await detailConfig.api(id);
      if (response.code === 200 && response.data) {
        let formattedData = `操作类型：${detailConfig.label}\n`;

        // 遍历 data 的每个 key-value 对
        for (const [key, value] of Object.entries(response.data)) {
          formattedData += `${key}: ${value || '暂无数据'}\n`;
        }
        formattedData += "\n"; // 每个操作类型之间空一行

        // 将格式化后的数据添加到 consolidatedData 数组中
        this.consolidatedData.push(formattedData);
      } else {
        this.consolidatedData.push(`操作类型：${detailConfig.label} - 加载失败\n\n`);
      }
    } catch (error) {
      console.error(`请求详情出错 (${operationType}):`, error);
      this.consolidatedData.push(`操作类型：${detailConfig.label} - 请求异常\n\n`);
    }
  }

  // 如果需要在控制台输出查看，可以在这里进行
  console.log(this.consolidatedData.join('')); // 输出为字符串形式
  this.downloadToTestFile();
  // 这里可以继续对 this.consolidatedData 进行其他操作
  this.$message.success("数据已整合，请查看或进一步处理");
},
downloadToTestFile() {
    const content = this.consolidatedData.join('');
    const blob = new Blob([content], { type: 'text/plain;charset=utf-8' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'test.txt'; // 指定文件名
    a.click();
    URL.revokeObjectURL(url);
  },



  async fetchDetailData() {
    const selectedRows = this.selectedRows;
    if (!selectedRows.length) {
      this.$message.warning("请先选择要导出的记录");
      return Promise.reject("未选择任何记录");
    }

    const detailDataMap = this.detailDataMap;
    const consolidatedData = [];

    for (const row of selectedRows) {
      const { operationType, id } = row;
      const detailConfig = detailDataMap[operationType];

      if (!detailConfig) {
        console.warn(`不支持的操作类型: ${operationType}`);
        continue;
      }

      try {
        const response = await detailConfig.api(id);
        if (response.code === 200 && response.data) {
          let formattedData = `操作类型：${detailConfig.label}\n`;

          for (const [key, value] of Object.entries(response.data)) {
            formattedData += `${key}: ${value || '暂无数据'}\n`;
          }
          formattedData += "\n";

          consolidatedData.push(formattedData);
        } else {
          consolidatedData.push(`操作类型：${detailConfig.label} - 加载失败\n\n`);
        }
      } catch (error) {
        console.error(`请求详情出错 (${operationType}):`, error);
        consolidatedData.push(`操作类型：${detailConfig.label} - 请求异常\n\n`);
      }
    }

    // 将整合好的数据保存在组件实例上供后续使用
    this.consolidatedData = consolidatedData;
    return consolidatedData;
  },

  async handleExport() {
      // 创建加载实例，设置为全屏模式，并自定义样式
      const loadingInstance = Loading.service({
        lock: true, // 锁定背景，防止用户操作
        text: '正在加载，请稍候', // 加载文字
        spinner: 'el-icon-loading', // 自定义加载图标
        background: 'rgba(0, 0, 0, 0.7)' // 背景颜色，使界面变暗
      });

      try {
        // 获取数据
        const consolidatedData = await this.fetchDetailData();
        if (!consolidatedData || consolidatedData.length === 0) {
          return;
        }

        const content = consolidatedData.join('');

        // 发送请求到后端接口
        const response = await fetch('http://localhost:8080/ask', { 
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            userMessage: content
          })
        });

        if (!response.ok) {
          throw new Error('Network response was not ok');
        }

        const data = await response.json();
        console.log('Success:', data); 

        // 显示对话框并设置内容
        this.dialogContent = data.choices[0].message.content; // 假设结构如你所述
        this.dialogVisible = true;
      } catch (error) {
        console.error('导出错误:', error);
        this.$message.error(error.message || "发送或接收数据时出错");
      } finally {
        // 关闭加载指示器
        loadingInstance.close();
      }
    },

  // 原来的 handleView 方法可以保留用于查看详情（可选修改）
  async handleView(row) {
    const { operationType, id } = row;
    const detailConfig = this.detailDataMap[operationType];

    if (!detailConfig) {
      console.warn("暂不支持该类型");
      return;
    }

    this.detailLoading = true;

    try {
      const response = await detailConfig.api(id);
      if (response.code === 200 && response.data) {
        this.currentDetail = {
          typeLabel: detailConfig.label,
          data: response.data
        };
        this.open = true; // 打开弹窗
      } else {
        console.error("数据加载失败:", response.message || "未知错误");
      }
    } catch (error) {
      console.error('请求详情出错:', error);
    } finally {
      this.detailLoading = false;
    }
  },




 
    parseTime(time) {
      const date = new Date(time);
      return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
    },
    handleSelectionChange(selection) {
 
      console.log('Selected Rows:', selection);
      this.selectedRows = selection;
    }
  },
  mounted() {
    this.getList();
  }
};
</script>