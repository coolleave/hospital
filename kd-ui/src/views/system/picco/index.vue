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
      <!-- <el-form-item label="心输出量(Cardiac Output, L/min)" prop="CO">
        <el-input
          v-model="queryParams.CO"
          placeholder="请输入心输出量(Cardiac Output, L/min)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收缩压(Systolic Arterial Blood Pressure, mmHg)" prop="sABP">
        <el-input
          v-model="queryParams.sABP"
          placeholder="请输入收缩压(Systolic Arterial Blood Pressure, mmHg)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="舒张压(Diastolic Arterial Blood Pressure, mmHg)" prop="dABP">
        <el-input
          v-model="queryParams.dABP"
          placeholder="请输入舒张压(Diastolic Arterial Blood Pressure, mmHg)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均动脉压(Mean Arterial Blood Pressure, mmHg)" prop="mABP">
        <el-input
          v-model="queryParams.mABP"
          placeholder="请输入平均动脉压(Mean Arterial Blood Pressure, mmHg)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体表面积(Body Surface Area, m²)" prop="BSA">
        <el-input
          v-model="queryParams.BSA"
          placeholder="请输入体表面积(Body Surface Area, m²)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中心静脉压(Central Venous Pressure, mmHg)" prop="CVP">
        <el-input
          v-model="queryParams.CVP"
          placeholder="请输入中心静脉压(Central Venous Pressure, mmHg)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="心指数(Cardiac Index, L/min/m²)" prop="CI">
        <el-input
          v-model="queryParams.CI"
          placeholder="请输入心指数(Cardiac Index, L/min/m²)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="连续心排血量(Pulse Contour Cardiac Output, L/min)" prop="PCCO">
        <el-input
          v-model="queryParams.PCCO"
          placeholder="请输入连续心排血量(Pulse Contour Cardiac Output, L/min)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每搏输出量(Stroke Volume, ml)" prop="SV">
        <el-input
          v-model="queryParams.SV"
          placeholder="请输入每搏输出量(Stroke Volume, ml)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)" prop="SVR">
        <el-input
          v-model="queryParams.SVR"
          placeholder="请输入血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每搏变异度(Stroke Volume Variation, %)" prop="SVV">
        <el-input
          v-model="queryParams.SVV"
          placeholder="请输入每搏变异度(Stroke Volume Variation, %)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="全身射血分数(Global Ejection Fraction, %)" prop="GEF">
        <el-input
          v-model="queryParams.GEF"
          placeholder="请输入全身射血分数(Global Ejection Fraction, %)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="心功能指数(Cardiac Function Index)" prop="CFI">
        <el-input
          v-model="queryParams.CFI"
          placeholder="请输入心功能指数(Cardiac Function Index)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)" prop="ITBV">
        <el-input
          v-model="queryParams.ITBV"
          placeholder="请输入容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="全身舒张末期容积(Global End-Diastolic Volume, ml)" prop="GEDV">
        <el-input
          v-model="queryParams.GEDV"
          placeholder="请输入全身舒张末期容积(Global End-Diastolic Volume, ml)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)" prop="PVR">
        <el-input
          v-model="queryParams.PVR"
          placeholder="请输入肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="肺水含量(Extravascular Lung Water, ml)" prop="EVLW">
        <el-input
          v-model="queryParams.EVLW"
          placeholder="请输入肺水含量(Extravascular Lung Water, ml)"
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
          v-hasPermi="['system:picco:add']"
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
          v-hasPermi="['system:picco:edit']"
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
          v-hasPermi="['system:picco:remove']"
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
          v-hasPermi="['system:picco:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="piccoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="心输出量(L/min)" align="center" prop="co" />
      <el-table-column label="收缩压(mmHg)" align="center" prop="sABP" />
      <el-table-column label="舒张压(mmHg)" align="center" prop="dABP" />
      <el-table-column label="平均动脉压(mmHg)" align="center" prop="mABP" />
      <el-table-column label="体表面积(m²)" align="center" prop="bsa" />
      <el-table-column label="中心静脉压(mmHg)" align="center" prop="cvp" />
      <el-table-column label="心指数(L/min/m²)" align="center" prop="ci" />
      <el-table-column label="连续心排血量(L/min)" align="center" prop="pcco" />
      <el-table-column label="每搏输出量(ml)" align="center" prop="sv" />
      <el-table-column label="血管阻力(dyn·s/cm⁵)" align="center" prop="svr" />
      <el-table-column label="每搏变异度(%)" align="center" prop="svv" />
      <el-table-column label="全身射血分数(%)" align="center" prop="gef" />
      <el-table-column label="心功能指数" align="center" prop="cfi" />
      <el-table-column label="容积性温度测量的胸内血容量(ml)" align="center" prop="itbv" />
      <el-table-column label="全身舒张末期容积(ml)" align="center" prop="gedv" />
      <el-table-column label="肺血管阻力(dyn·s/cm⁵)" align="center" prop="pvr" />
      <el-table-column label="肺水含量(ml)" align="center" prop="evlw" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:picco:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:picco:remove']"
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
    <!-- 添加或修改心输出量监测对话框 -->
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
        <el-form-item label="心输出量(Cardiac Output, L/min)" prop="CO">
          <el-input v-model="form.CO" placeholder="请输入心输出量(Cardiac Output, L/min)" />
        </el-form-item>
        <el-form-item label="收缩压(Systolic Arterial Blood Pressure, mmHg)" prop="sABP">
          <el-input v-model="form.sABP" placeholder="请输入收缩压(Systolic Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="舒张压(Diastolic Arterial Blood Pressure, mmHg)" prop="dABP">
          <el-input v-model="form.dABP" placeholder="请输入舒张压(Diastolic Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="平均动脉压(Mean Arterial Blood Pressure, mmHg)" prop="mABP">
          <el-input v-model="form.mABP" placeholder="请输入平均动脉压(Mean Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="体表面积(Body Surface Area, m²)" prop="BSA">
          <el-input v-model="form.BSA" placeholder="请输入体表面积(Body Surface Area, m²)" />
        </el-form-item>
        <el-form-item label="中心静脉压(Central Venous Pressure, mmHg)" prop="CVP">
          <el-input v-model="form.CVP" placeholder="请输入中心静脉压(Central Venous Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="心指数(Cardiac Index, L/min/m²)" prop="CI">
          <el-input v-model="form.CI" placeholder="请输入心指数(Cardiac Index, L/min/m²)" />
        </el-form-item>
        <el-form-item label="连续心排血量(Pulse Contour Cardiac Output, L/min)" prop="PCCO">
          <el-input v-model="form.PCCO" placeholder="请输入连续心排血量(Pulse Contour Cardiac Output, L/min)" />
        </el-form-item>
        <el-form-item label="每搏输出量(Stroke Volume, ml)" prop="SV">
          <el-input v-model="form.SV" placeholder="请输入每搏输出量(Stroke Volume, ml)" />
        </el-form-item>
        <el-form-item label="血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)" prop="SVR">
          <el-input v-model="form.SVR" placeholder="请输入血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)" />
        </el-form-item>
        <el-form-item label="每搏变异度(Stroke Volume Variation, %)" prop="SVV">
          <el-input v-model="form.SVV" placeholder="请输入每搏变异度(Stroke Volume Variation, %)" />
        </el-form-item>
        <el-form-item label="全身射血分数(Global Ejection Fraction, %)" prop="GEF">
          <el-input v-model="form.GEF" placeholder="请输入全身射血分数(Global Ejection Fraction, %)" />
        </el-form-item>
        <el-form-item label="心功能指数(Cardiac Function Index)" prop="CFI">
          <el-input v-model="form.CFI" placeholder="请输入心功能指数(Cardiac Function Index)" />
        </el-form-item>
        <el-form-item label="容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)" prop="ITBV">
          <el-input v-model="form.ITBV" placeholder="请输入容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)" />
        </el-form-item>
        <el-form-item label="全身舒张末期容积(Global End-Diastolic Volume, ml)" prop="GEDV">
          <el-input v-model="form.GEDV" placeholder="请输入全身舒张末期容积(Global End-Diastolic Volume, ml)" />
        </el-form-item>
        <el-form-item label="肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)" prop="PVR">
          <el-input v-model="form.PVR" placeholder="请输入肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)" />
        </el-form-item>
        <el-form-item label="肺水含量(Extravascular Lung Water, ml)" prop="EVLW">
          <el-input v-model="form.EVLW" placeholder="请输入肺水含量(Extravascular Lung Water, ml)" />
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
import { listPicco, getPicco, delPicco, addPicco, updatePicco } from "@/api/system/picco"
import { getToken } from "@/utils/auth";
export default {
  name: "Picco",
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
      // 心输出量监测表格数据
      piccoList: [],
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
        CO: null,
        sABP: null,
        dABP: null,
        mABP: null,
        BSA: null,
        CVP: null,
        CI: null,
        PCCO: null,
        SV: null,
        SVR: null,
        SVV: null,
        GEF: null,
        CFI: null,
        ITBV: null,
        GEDV: null,
        PVR: null,
        EVLW: null,
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
        url: process.env.VUE_APP_BASE_API + "/system/picco/importData"
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
    /** 查询心输出量监测列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listPicco(this.queryParams).then(response => {

        this.piccoList = response.rows
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
        CO: null,
        sABP: null,
        dABP: null,
        mABP: null,
        BSA: null,
        CVP: null,
        CI: null,
        PCCO: null,
        SV: null,
        SVR: null,
        SVV: null,
        GEF: null,
        CFI: null,
        ITBV: null,
        GEDV: null,
        PVR: null,
        EVLW: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加心输出量监测"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getPicco(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改心输出量监测"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePicco(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addPicco(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除心输出量监测编号为"' + Ids + '"的数据项？').then(function() {
        return delPicco(Ids)
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
  this.download('system/picco/importTemplate', {
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
      this.download('system/picco/export', {
        ...this.queryParams
      }, `picco_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
