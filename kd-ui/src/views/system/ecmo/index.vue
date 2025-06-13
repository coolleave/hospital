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
      <!-- <el-form-item label="实测水温" prop="ecmoMeasuredWaterTemperature">
        <el-input
          v-model="queryParams.ecmoMeasuredWaterTemperature"
          placeholder="请输入实测水温"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预测水温" prop="ecmoPredictedWaterTemperature">
        <el-input
          v-model="queryParams.ecmoPredictedWaterTemperature"
          placeholder="请输入预测水温"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="跨膜压" prop="ecmoTransmembranePressureMmhg">
        <el-input
          v-model="queryParams.ecmoTransmembranePressureMmhg"
          placeholder="请输入跨膜压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="滤器前压" prop="filterPrePressureMmhg">
        <el-input
          v-model="queryParams.filterPrePressureMmhg"
          placeholder="请输入滤器前压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血流量" prop="ecmoBloodFlowRate">
        <el-input
          v-model="queryParams.ecmoBloodFlowRate"
          placeholder="请输入血流量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="气流量" prop="ecmoGasFlowLMin">
        <el-input
          v-model="queryParams.ecmoGasFlowLMin"
          placeholder="请输入气流量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="ECMO开始时间" prop="ecmoStartTime">
        <el-date-picker clearable
          v-model="queryParams.ecmoStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择ECMO开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="ECMO结束时间" prop="ecmoEndTime">
        <el-date-picker clearable
          v-model="queryParams.ecmoEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择ECMO结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="SaO2百分比" prop="ecmosao2Percent">
        <el-input
          v-model="queryParams.ecmosao2Percent"
          placeholder="请输入SaO2百分比"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="膜肺后压力" prop="ecmoMembranePostPressureMmhg">
        <el-input
          v-model="queryParams.ecmoMembranePostPressureMmhg"
          placeholder="请输入膜肺后压力"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="转流模式" prop="ecmoDiversionMode">
        <el-input
          v-model="queryParams.ecmoDiversionMode"
          placeholder="请输入转流模式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="膜肺前压力" prop="ecmoMembranePrePressureMmhg">
        <el-input
          v-model="queryParams.ecmoMembranePrePressureMmhg"
          placeholder="请输入膜肺前压力"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="气流量" prop="gasFlowL">
        <el-input
          v-model="queryParams.gasFlowL"
          placeholder="请输入气流量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="泵转速" prop="ecmoPumpSpeed">
        <el-input
          v-model="queryParams.ecmoPumpSpeed"
          placeholder="请输入泵转速"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单泵泵速" prop="singlePumpSpeedCalciumGlubionate">
        <el-input
          v-model="queryParams.singlePumpSpeedCalciumGlubionate"
          placeholder="请输入单泵泵速"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单泵泵速" prop="singlePumpSpeedCalciumChloride">
        <el-input
          v-model="queryParams.singlePumpSpeedCalciumChloride"
          placeholder="请输入单泵泵速"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单泵泵速" prop="singlePumpSpeedSodiumCitrate">
        <el-input
          v-model="queryParams.singlePumpSpeedSodiumCitrate"
          placeholder="请输入单泵泵速"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单泵泵速" prop="singlePumpSpeedHeparin">
        <el-input
          v-model="queryParams.singlePumpSpeedHeparin"
          placeholder="请输入单泵泵速"
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
          v-hasPermi="['system:ecmo:add']"
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
          v-hasPermi="['system:ecmo:edit']"
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
          v-hasPermi="['system:ecmo:remove']"
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
          v-hasPermi="['system:ecmo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ecmoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实测水温" align="center" prop="ecmoMeasuredWaterTemperature" />
      <el-table-column label="预测水温" align="center" prop="ecmoPredictedWaterTemperature" />
      <el-table-column label="跨膜压" align="center" prop="ecmoTransmembranePressureMmhg" />
      <el-table-column label="滤器前压" align="center" prop="filterPrePressureMmhg" />
      <el-table-column label="血流量" align="center" prop="ecmoBloodFlowRate" />
      <el-table-column label="气流量" align="center" prop="ecmoGasFlowLMin" />
      <el-table-column label="ECMO开始时间" align="center" prop="ecmoStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.ecmoStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="ECMO结束时间" align="center" prop="ecmoEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.ecmoEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="SaO2百分比" align="center" prop="ecmosao2Percent" />
      <el-table-column label="膜肺后压力" align="center" prop="ecmoMembranePostPressureMmhg" />
      <el-table-column label="转流模式" align="center" prop="ecmoDiversionMode" />
      <el-table-column label="膜肺前压力" align="center" prop="ecmoMembranePrePressureMmhg" />
      <el-table-column label="气流量" align="center" prop="gasFlowL" />
      <el-table-column label="泵转速" align="center" prop="ecmoPumpSpeed" />
      <el-table-column label="单泵泵速" align="center" prop="singlePumpSpeedCalciumGlubionate" />
      <el-table-column label="单泵泵速" align="center" prop="singlePumpSpeedCalciumChloride" />
      <el-table-column label="单泵泵速" align="center" prop="singlePumpSpeedSodiumCitrate" />
      <el-table-column label="单泵泵速" align="center" prop="singlePumpSpeedHeparin" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:ecmo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:ecmo:remove']"
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

    <!-- 添加或修改体外膜肺氧合对话框 -->
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
        <el-form-item label="实测水温" prop="ecmoMeasuredWaterTemperature">
          <el-input v-model="form.ecmoMeasuredWaterTemperature" placeholder="请输入实测水温" />
        </el-form-item>
        <el-form-item label="预测水温" prop="ecmoPredictedWaterTemperature">
          <el-input v-model="form.ecmoPredictedWaterTemperature" placeholder="请输入预测水温" />
        </el-form-item>
        <el-form-item label="跨膜压" prop="ecmoTransmembranePressureMmhg">
          <el-input v-model="form.ecmoTransmembranePressureMmhg" placeholder="请输入跨膜压" />
        </el-form-item>
        <el-form-item label="滤器前压" prop="filterPrePressureMmhg">
          <el-input v-model="form.filterPrePressureMmhg" placeholder="请输入滤器前压" />
        </el-form-item>
        <el-form-item label="血流量" prop="ecmoBloodFlowRate">
          <el-input v-model="form.ecmoBloodFlowRate" placeholder="请输入血流量" />
        </el-form-item>
        <el-form-item label="气流量" prop="ecmoGasFlowLMin">
          <el-input v-model="form.ecmoGasFlowLMin" placeholder="请输入气流量" />
        </el-form-item>
        <el-form-item label="ECMO开始时间" prop="ecmoStartTime">
          <el-date-picker clearable
            v-model="form.ecmoStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择ECMO开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="ECMO结束时间" prop="ecmoEndTime">
          <el-date-picker clearable
            v-model="form.ecmoEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择ECMO结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="SaO2百分比" prop="ecmosao2Percent">
          <el-input v-model="form.ecmosao2Percent" placeholder="请输入SaO2百分比" />
        </el-form-item>
        <el-form-item label="膜肺后压力" prop="ecmoMembranePostPressureMmhg">
          <el-input v-model="form.ecmoMembranePostPressureMmhg" placeholder="请输入膜肺后压力" />
        </el-form-item>
        <el-form-item label="转流模式" prop="ecmoDiversionMode">
          <el-input v-model="form.ecmoDiversionMode" placeholder="请输入转流模式" />
        </el-form-item>
        <el-form-item label="膜肺前压力" prop="ecmoMembranePrePressureMmhg">
          <el-input v-model="form.ecmoMembranePrePressureMmhg" placeholder="请输入膜肺前压力" />
        </el-form-item>
        <el-form-item label="气流量" prop="gasFlowL">
          <el-input v-model="form.gasFlowL" placeholder="请输入气流量" />
        </el-form-item>
        <el-form-item label="泵转速" prop="ecmoPumpSpeed">
          <el-input v-model="form.ecmoPumpSpeed" placeholder="请输入泵转速" />
        </el-form-item>
        <el-form-item label="单泵泵速" prop="singlePumpSpeedCalciumGlubionate">
          <el-input v-model="form.singlePumpSpeedCalciumGlubionate" placeholder="请输入单泵泵速" />
        </el-form-item>
        <el-form-item label="单泵泵速" prop="singlePumpSpeedCalciumChloride">
          <el-input v-model="form.singlePumpSpeedCalciumChloride" placeholder="请输入单泵泵速" />
        </el-form-item>
        <el-form-item label="单泵泵速" prop="singlePumpSpeedSodiumCitrate">
          <el-input v-model="form.singlePumpSpeedSodiumCitrate" placeholder="请输入单泵泵速" />
        </el-form-item>
        <el-form-item label="单泵泵速" prop="singlePumpSpeedHeparin">
          <el-input v-model="form.singlePumpSpeedHeparin" placeholder="请输入单泵泵速" />
        </el-form-item>
        <el-form-item label="操作说明" prop="instructions">
          <el-input v-model="form.Instructions" type="textarea" placeholder="请输入内容" />
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
import { listEcmo, getEcmo, delEcmo, addEcmo, updateEcmo } from "@/api/system/ecmo"
import { getToken } from "@/utils/auth";
export default {
  name: "Ecmo",
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
      // 体外膜肺氧合表格数据
      ecmoList: [],
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
        ecmoMeasuredWaterTemperature: null,
        ecmoPredictedWaterTemperature: null,
        ecmoTransmembranePressureMmhg: null,
        filterPrePressureMmhg: null,
        ecmoBloodFlowRate: null,
        ecmoGasFlowLMin: null,
        ecmoStartTime: null,
        ecmoEndTime: null,
        ecmosao2Percent: null,
        ecmoMembranePostPressureMmhg: null,
        ecmoDiversionMode: null,
        ecmoMembranePrePressureMmhg: null,
        gasFlowL: null,
        ecmoPumpSpeed: null,
        singlePumpSpeedCalciumGlubionate: null,
        singlePumpSpeedCalciumChloride: null,
        singlePumpSpeedSodiumCitrate: null,
        singlePumpSpeedHeparin: null,
        Instructions: null
      },
      // 表单参数
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
        url: process.env.VUE_APP_BASE_API + "/system/ecmo/importData"
      },
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询体外膜肺氧合列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listEcmo(this.queryParams).then(response => {
        this.ecmoList = response.rows
        console.log(response)
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
        ecmoMeasuredWaterTemperature: null,
        ecmoPredictedWaterTemperature: null,
        ecmoTransmembranePressureMmhg: null,
        filterPrePressureMmhg: null,
        ecmoBloodFlowRate: null,
        ecmoGasFlowLMin: null,
        ecmoStartTime: null,
        ecmoEndTime: null,
        ecmosao2Percent: null,
        ecmoMembranePostPressureMmhg: null,
        ecmoDiversionMode: null,
        ecmoMembranePrePressureMmhg: null,
        gasFlowL: null,
        ecmoPumpSpeed: null,
        singlePumpSpeedCalciumGlubionate: null,
        singlePumpSpeedCalciumChloride: null,
        singlePumpSpeedSodiumCitrate: null,
        singlePumpSpeedHeparin: null,
        Instructions: null
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
      this.title = "添加体外膜肺氧合"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getEcmo(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改体外膜肺氧合"
      })
    },

 
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEcmo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addEcmo(this.form).then(response => {
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
      const Ids = row.id || this.ids
      this.$modal.confirm('是否确认删除体外膜肺氧合编号为"' + Ids + '"的数据项？').then(function() {
        return delEcmo(Ids)
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
  this.download('system/ecmo/importTemplate', {
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
      this.download('system/ecmo/export', {
        ...this.queryParams
      }, `ecmo_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
