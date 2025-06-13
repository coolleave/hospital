<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病历编号" prop="encounterId">
        <el-input
          v-model="queryParams.encounterId"
          placeholder="请输入病历编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医院ID" prop="hospitalId">
        <el-input
          v-model="queryParams.hospitalId"
          placeholder="请输入医院ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录时间">
        <el-date-picker
          v-model="daterangeChartTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="红细胞计数" prop="redBloodCellCount">
        <el-input
          v-model="queryParams.redBloodCellCount"
          placeholder="请输入红细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="红细胞体积分布宽度_SD" prop="rdwSD">
        <el-input
          v-model="queryParams.rdwSD"
          placeholder="请输入红细胞体积分布宽度_SD"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="红细胞分布宽度CV" prop="rdwCV">
        <el-input
          v-model="queryParams.rdwCV"
          placeholder="请输入红细胞分布宽度CV"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="红细胞压积HCT" prop="hct">
        <el-input
          v-model="queryParams.hct"
          placeholder="请输入红细胞压积HCT"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血红蛋白" prop="hemoglobin">
        <el-input
          v-model="queryParams.hemoglobin"
          placeholder="请输入血红蛋白"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均血红蛋白浓度MCHC" prop="mchc">
        <el-input
          v-model="queryParams.mchc"
          placeholder="请输入平均血红蛋白浓度MCHC"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均血红蛋白量MCH" prop="mch">
        <el-input
          v-model="queryParams.mch"
          placeholder="请输入平均血红蛋白量MCH"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="红细胞平均体积MCV" prop="mcv">
        <el-input
          v-model="queryParams.mcv"
          placeholder="请输入红细胞平均体积MCV"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="白细胞计数" prop="whiteBloodCellCount">
        <el-input
          v-model="queryParams.whiteBloodCellCount"
          placeholder="请输入白细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中性粒细胞计数" prop="neutrophilCount">
        <el-input
          v-model="queryParams.neutrophilCount"
          placeholder="请输入中性粒细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="淋巴细胞计数" prop="lymphocyteCount">
        <el-input
          v-model="queryParams.lymphocyteCount"
          placeholder="请输入淋巴细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="嗜酸性粒细胞计数" prop="eosinophilCount">
        <el-input
          v-model="queryParams.eosinophilCount"
          placeholder="请输入嗜酸性粒细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="嗜碱性粒细胞计数" prop="basophilCount">
        <el-input
          v-model="queryParams.basophilCount"
          placeholder="请输入嗜碱性粒细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单核细胞计数" prop="monocyteCount">
        <el-input
          v-model="queryParams.monocyteCount"
          placeholder="请输入单核细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="不成熟粒细胞计数" prop="immatureGranulocyteCount">
        <el-input
          v-model="queryParams.immatureGranulocyteCount"
          placeholder="请输入不成熟粒细胞计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血小板计数" prop="plateletCount">
        <el-input
          v-model="queryParams.plateletCount"
          placeholder="请输入血小板计数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血小板压积" prop="plateletcrit">
        <el-input
          v-model="queryParams.plateletcrit"
          placeholder="请输入血小板压积"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均血小板体积" prop="meanPlateletVolume">
        <el-input
          v-model="queryParams.meanPlateletVolume"
          placeholder="请输入平均血小板体积"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血小板分布宽度" prop="plateletDistributionWidth">
        <el-input
          v-model="queryParams.plateletDistributionWidth"
          placeholder="请输入血小板分布宽度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:hematology:add']"
        >新增</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:hematology:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:hematology:remove']"
        >删除</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="info"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:basesign:import']"
        >导入</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:hematology:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="hematologyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="红细胞计数" align="center" prop="redBloodCellCount" />
      <el-table-column label="红细胞体积分布宽度_SD" align="center" prop="rdwSD" />
      <el-table-column label="红细胞分布宽度CV" align="center" prop="rdwCV" />
      <el-table-column label="红细胞压积HCT" align="center" prop="hct" />
      <el-table-column label="血红蛋白" align="center" prop="hemoglobin" />
      <el-table-column label="平均血红蛋白浓度MCHC" align="center" prop="mchc" />
      <el-table-column label="平均血红蛋白量MCH" align="center" prop="mch" />
      <el-table-column label="红细胞平均体积MCV" align="center" prop="mcv" />
      <el-table-column label="白细胞计数" align="center" prop="whiteBloodCellCount" />
      <el-table-column label="中性粒细胞计数" align="center" prop="neutrophilCount" />
      <el-table-column label="淋巴细胞计数" align="center" prop="lymphocyteCount" />
      <el-table-column label="嗜酸性粒细胞计数" align="center" prop="eosinophilCount" />
      <el-table-column label="嗜碱性粒细胞计数" align="center" prop="basophilCount" />
      <el-table-column label="单核细胞计数" align="center" prop="monocyteCount" />
      <el-table-column label="不成熟粒细胞计数" align="center" prop="immatureGranulocyteCount" />
      <el-table-column label="血小板计数" align="center" prop="plateletCount" />
      <el-table-column label="血小板压积" align="center" prop="plateletcrit" />
      <el-table-column label="平均血小板体积" align="center" prop="meanPlateletVolume" />
      <el-table-column label="血小板分布宽度" align="center" prop="plateletDistributionWidth" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:hematology:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:hematology:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <div class="el-upload__tip" slot="tip">
            <el-checkbox v-model="upload.updateSupport" /> 是否更新已经存在的用户数据
          </div>
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;" @click="importTemplate">下载模板</el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加或修改血液学数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病历编号" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病历编号" />
        </el-form-item>
        <el-form-item label="医院ID" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入医院ID" />
        </el-form-item>
        <el-form-item label="记录时间" prop="chartTime">
          <el-date-picker clearable
            v-model="form.chartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="红细胞计数" prop="redBloodCellCount">
          <el-input v-model="form.redBloodCellCount" placeholder="请输入红细胞计数" />
        </el-form-item>
        <el-form-item label="红细胞体积分布宽度_SD" prop="rdwSD">
          <el-input v-model="form.rdwSD" placeholder="请输入红细胞体积分布宽度_SD" />
        </el-form-item>
        <el-form-item label="红细胞分布宽度CV" prop="rdwCV">
          <el-input v-model="form.rdwCV" placeholder="请输入红细胞分布宽度CV" />
        </el-form-item>
        <el-form-item label="红细胞压积HCT" prop="hct">
          <el-input v-model="form.hct" placeholder="请输入红细胞压积HCT" />
        </el-form-item>
        <el-form-item label="血红蛋白" prop="hemoglobin">
          <el-input v-model="form.hemoglobin" placeholder="请输入血红蛋白" />
        </el-form-item>
        <el-form-item label="平均血红蛋白浓度MCHC" prop="mchc">
          <el-input v-model="form.mchc" placeholder="请输入平均血红蛋白浓度MCHC" />
        </el-form-item>
        <el-form-item label="平均血红蛋白量MCH" prop="mch">
          <el-input v-model="form.mch" placeholder="请输入平均血红蛋白量MCH" />
        </el-form-item>
        <el-form-item label="红细胞平均体积MCV" prop="mcv">
          <el-input v-model="form.mcv" placeholder="请输入红细胞平均体积MCV" />
        </el-form-item>
        <el-form-item label="白细胞计数" prop="whiteBloodCellCount">
          <el-input v-model="form.whiteBloodCellCount" placeholder="请输入白细胞计数" />
        </el-form-item>
        <el-form-item label="中性粒细胞计数" prop="neutrophilCount">
          <el-input v-model="form.neutrophilCount" placeholder="请输入中性粒细胞计数" />
        </el-form-item>
        <el-form-item label="淋巴细胞计数" prop="lymphocyteCount">
          <el-input v-model="form.lymphocyteCount" placeholder="请输入淋巴细胞计数" />
        </el-form-item>
        <el-form-item label="嗜酸性粒细胞计数" prop="eosinophilCount">
          <el-input v-model="form.eosinophilCount" placeholder="请输入嗜酸性粒细胞计数" />
        </el-form-item>
        <el-form-item label="嗜碱性粒细胞计数" prop="basophilCount">
          <el-input v-model="form.basophilCount" placeholder="请输入嗜碱性粒细胞计数" />
        </el-form-item>
        <el-form-item label="单核细胞计数" prop="monocyteCount">
          <el-input v-model="form.monocyteCount" placeholder="请输入单核细胞计数" />
        </el-form-item>
        <el-form-item label="不成熟粒细胞计数" prop="immatureGranulocyteCount">
          <el-input v-model="form.immatureGranulocyteCount" placeholder="请输入不成熟粒细胞计数" />
        </el-form-item>
        <el-form-item label="血小板计数" prop="plateletCount">
          <el-input v-model="form.plateletCount" placeholder="请输入血小板计数" />
        </el-form-item>
        <el-form-item label="血小板压积" prop="plateletcrit">
          <el-input v-model="form.plateletcrit" placeholder="请输入血小板压积" />
        </el-form-item>
        <el-form-item label="平均血小板体积" prop="meanPlateletVolume">
          <el-input v-model="form.meanPlateletVolume" placeholder="请输入平均血小板体积" />
        </el-form-item>
        <el-form-item label="血小板分布宽度" prop="plateletDistributionWidth">
          <el-input v-model="form.plateletDistributionWidth" placeholder="请输入血小板分布宽度" />
        </el-form-item>
        <el-form-item label="操作说明" prop="instructions">
          <el-input v-model="form.instructions" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHematology, getHematology, delHematology, addHematology, updateHematology } from "@/api/system/hematology"
import { getToken } from "@/utils/auth";
export default {
  name: "Hematology",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 血液学数据表格数据
      hematologyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 操作说明时间范围
      daterangeChartTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        redBloodCellCount: null,
        rdwSD: null,
        rdwCV: null,
        hct: null,
        hemoglobin: null,
        mchc: null,
        mch: null,
        mcv: null,
        whiteBloodCellCount: null,
        neutrophilCount: null,
        lymphocyteCount: null,
        eosinophilCount: null,
        basophilCount: null,
        monocyteCount: null,
        immatureGranulocyteCount: null,
        plateletCount: null,
        plateletcrit: null,
        meanPlateletVolume: null,
        plateletDistributionWidth: null,
        instructions: null
      },
      // 表单参数
      form: {},
      form: {},
      upload: {
        // 是否显示弹出层（单词导入）
        open: false,
        // 弹出层标题（单词导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/hematology/importData"
      },
      // 表单校验
      rules: {
        encounterId: [
          { required: true, message: "病历编号不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询血液学数据列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listHematology(this.queryParams).then(response => {
        this.hematologyList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        Id: null,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        redBloodCellCount: null,
        rdwSD: null,
        rdwCV: null,
        hct: null,
        hemoglobin: null,
        mchc: null,
        mch: null,
        mcv: null,
        whiteBloodCellCount: null,
        neutrophilCount: null,
        lymphocyteCount: null,
        eosinophilCount: null,
        basophilCount: null,
        monocyteCount: null,
        immatureGranulocyteCount: null,
        plateletCount: null,
        plateletcrit: null,
        meanPlateletVolume: null,
        plateletDistributionWidth: null,
        instructions: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeChartTime = []
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.Id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加血液学数据"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.Id || this.ids
      getHematology(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改血液学数据"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.Id != null) {
            updateHematology(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addHematology(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const Ids = row.Id || this.ids
      this.$modal.confirm('是否确认删除血液学数据编号为"' + Ids + '"的数据项？').then(function() {
        return delHematology(Ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },

    
/** 导入按钮操作 */
handleImport() {
  this.upload.title = "用户导入"
  this.upload.open = true
},
/** 下载模板操作 */
importTemplate() {
  this.download('system/hematology/importTemplate', {
  }, `user_template_${new Date().getTime()}.xlsx`)
},
// 文件上传中处理
handleFileUploadProgress(event, file, fileList) {
  this.upload.isUploading = true
},
// 文件上传成功处理
handleFileSuccess(response, file, fileList) {
  this.upload.open = false
  this.upload.isUploading = false
  this.$refs.upload.clearFiles()
  this.$alert("<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>" + response.msg + "</div>", "导入结果", { dangerouslyUseHTMLString: true })
  this.getList()
},
// 提交上传文件
submitFileForm() {
  this.$refs.upload.submit()
},



    /** 导出按钮操作 */
    handleExport() {
      this.download('system/hematology/export', {
        ...this.queryParams
      }, `hematology_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
