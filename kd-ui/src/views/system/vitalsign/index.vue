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
      <!-- <el-form-item label="体温" prop="temperature">
        <el-input
          v-model="queryParams.temperature"
          placeholder="请输入体温"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="心率" prop="heartRate">
        <el-input
          v-model="queryParams.heartRate"
          placeholder="请输入心率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="呼吸频率" prop="respiratoryRate">
        <el-input
          v-model="queryParams.respiratoryRate"
          placeholder="请输入呼吸频率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收缩压非侵入性血压" prop="systolicNIBP">
        <el-input
          v-model="queryParams.systolicNIBP"
          placeholder="请输入收缩压非侵入性血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="舒张压非侵入性血压" prop="diastolicNIBP">
        <el-input
          v-model="queryParams.diastolicNIBP"
          placeholder="请输入舒张压非侵入性血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均非侵入性血压" prop="meanNIBP">
        <el-input
          v-model="queryParams.meanNIBP"
          placeholder="请输入平均非侵入性血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收缩压动脉血压" prop="systolicABP">
        <el-input
          v-model="queryParams.systolicABP"
          placeholder="请输入收缩压动脉血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="舒张压动脉血压" prop="diastolicABP">
        <el-input
          v-model="queryParams.diastolicABP"
          placeholder="请输入舒张压动脉血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均动脉血压" prop="meanABP">
        <el-input
          v-model="queryParams.meanABP"
          placeholder="请输入平均动脉血压"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血氧饱和度" prop="oxygenSaturation">
        <el-input
          v-model="queryParams.oxygenSaturation"
          placeholder="请输入血氧饱和度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="代表中心静脉压" prop="centralvenouspressureMmhg">
        <el-input
          v-model="queryParams.centralvenouspressureMmhg"
          placeholder="请输入代表中心静脉压"
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
          v-hasPermi="['system:vitalsign:add']"
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
          v-hasPermi="['system:vitalsign:edit']"
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
          v-hasPermi="['system:vitalsign:remove']"
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
          v-hasPermi="['system:vitalsign:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="vitalsignList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="体温" align="center" prop="temperature" />
      <el-table-column label="心率" align="center" prop="heartRate" />
      <el-table-column label="呼吸频率" align="center" prop="respiratoryRate" />
      <el-table-column label="收缩压非侵入性血压" align="center" prop="systolicNIBP" />
      <el-table-column label="舒张压非侵入性血压" align="center" prop="diastolicNIBP" />
      <el-table-column label="平均非侵入性血压" align="center" prop="meanNIBP" />
      <el-table-column label="收缩压动脉血压" align="center" prop="systolicABP" />
      <el-table-column label="舒张压动脉血压" align="center" prop="diastolicABP" />
      <el-table-column label="平均动脉血压" align="center" prop="meanABP" />
      <el-table-column label="血氧饱和度" align="center" prop="oxygenSaturation" />
      <el-table-column label="代表中心静脉压" align="center" prop="centralvenouspressureMmhg" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:vitalsign:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:vitalsign:remove']"
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
    <!-- 添加或修改生命体征对话框 -->
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
        <el-form-item label="体温" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入体温" />
        </el-form-item>
        <el-form-item label="心率" prop="heartRate">
          <el-input v-model="form.heartRate" placeholder="请输入心率" />
        </el-form-item>
        <el-form-item label="呼吸频率" prop="respiratoryRate">
          <el-input v-model="form.respiratoryRate" placeholder="请输入呼吸频率" />
        </el-form-item>
        <el-form-item label="收缩压非侵入性血压" prop="systolicNIBP">
          <el-input v-model="form.systolicNIBP" placeholder="请输入收缩压非侵入性血压" />
        </el-form-item>
        <el-form-item label="舒张压非侵入性血压" prop="diastolicNIBP">
          <el-input v-model="form.diastolicNIBP" placeholder="请输入舒张压非侵入性血压" />
        </el-form-item>
        <el-form-item label="平均非侵入性血压" prop="meanNIBP">
          <el-input v-model="form.meanNIBP" placeholder="请输入平均非侵入性血压" />
        </el-form-item>
        <el-form-item label="收缩压动脉血压" prop="systolicABP">
          <el-input v-model="form.systolicABP" placeholder="请输入收缩压动脉血压" />
        </el-form-item>
        <el-form-item label="舒张压动脉血压" prop="diastolicABP">
          <el-input v-model="form.diastolicABP" placeholder="请输入舒张压动脉血压" />
        </el-form-item>
        <el-form-item label="平均动脉血压" prop="meanABP">
          <el-input v-model="form.meanABP" placeholder="请输入平均动脉血压" />
        </el-form-item>
        <el-form-item label="血氧饱和度" prop="oxygenSaturation">
          <el-input v-model="form.oxygenSaturation" placeholder="请输入血氧饱和度" />
        </el-form-item>
        <el-form-item label="代表中心静脉压" prop="centralvenouspressureMmhg">
          <el-input v-model="form.centralvenouspressureMmhg" placeholder="请输入代表中心静脉压" />
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
import { listVitalsign, getVitalsign, delVitalsign, addVitalsign, updateVitalsign } from "@/api/system/vitalsign"
import { getToken } from "@/utils/auth";
export default {
  name: "Vitalsign",
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
      // 生命体征表格数据
      vitalsignList: [],
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
        temperature: null,
        heartRate: null,
        respiratoryRate: null,
        systolicNIBP: null,
        diastolicNIBP: null,
        meanNIBP: null,
        systolicABP: null,
        diastolicABP: null,
        meanABP: null,
        oxygenSaturation: null,
        centralvenouspressureMmhg: null,
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
        url: process.env.VUE_APP_BASE_API + "/system/vitalsign/importData"
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
    /** 查询生命体征列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listVitalsign(this.queryParams).then(response => {
        this.vitalsignList = response.rows
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
        temperature: null,
        heartRate: null,
        respiratoryRate: null,
        systolicNIBP: null,
        diastolicNIBP: null,
        meanNIBP: null,
        systolicABP: null,
        diastolicABP: null,
        meanABP: null,
        oxygenSaturation: null,
        centralvenouspressureMmhg: null,
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
      this.title = "添加生命体征"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getVitalsign(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改生命体征"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateVitalsign(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addVitalsign(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除生命体征编号为"' + Ids + '"的数据项？').then(function() {
        return delVitalsign(Ids)
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
  this.download('system/vitalsign/importTemplate', {
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
      this.download('system/vitalsign/export', {
        ...this.queryParams
      }, `vitalsign_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
