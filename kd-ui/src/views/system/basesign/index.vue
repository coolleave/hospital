<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病历编号" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入病历编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份ID" prop="idcard">
        <el-input
          v-model="queryParams.idcard"
          placeholder="请输入身份ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
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
      <!-- <el-form-item label="插入时间">
        <el-date-picker
          v-model="daterangeChartTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item> -->
      <!-- <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="出生日期">
        <el-date-picker
          v-model="daterangeDateOfBirth"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="身高" prop="heightCm">
        <el-input
          v-model="queryParams.heightCm"
          placeholder="请输入身高"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体重" prop="weightKg">
        <el-input
          v-model="queryParams.weightKg"
          placeholder="请输入体重"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> --> 
      <el-form-item label="性别" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="诊断" prop="admissionDiagnosis">
        <el-input
          v-model="queryParams.admissionDiagnosis"
          placeholder="请输入诊断"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入院时间">
        <el-date-picker
          v-model="daterangeDepartmentAdmissionTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="出院时间">
        <el-date-picker
          v-model="daterangeDepartmentDischargeTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <!-- <el-form-item label="死亡时间">
        <el-date-picker
          v-model="daterangeTimeOfDeath"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker> -->
      <!-- </el-form-item> -->
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
          v-hasPermi="['system:basesign:add']"
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
          v-hasPermi="['system:basesign:edit']"
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
          v-hasPermi="['system:basesign:remove']"
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
          v-hasPermi="['system:basesign:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="basesignList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="身份ID" align="center" prop="idcard" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="插入时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="出生日期" align="center" prop="dateOfBirth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfBirth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="身高" align="center" prop="heightCm" />
      <el-table-column label="体重" align="center" prop="weightKg" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="入院诊断" align="center" prop="admissionDiagnosis" />
      <el-table-column label="入院时间" align="center" prop="departmentAdmissionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departmentAdmissionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出院时间" align="center" prop="departmentDischargeTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.departmentDischargeTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出院结果" align="center" prop="dischargeOutcome" />
      <el-table-column label="死亡时间" align="center" prop="timeOfDeath" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.timeOfDeath, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:basesign:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:basesign:remove']"
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
 
    
    
    <!-- 添加或修改病历管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="身份ID" prop="idcard">
          <el-input v-model="form.idcard" placeholder="请输入身份ID" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="医院ID" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入医院ID" />
        </el-form-item>
        <!-- <el-form-item label="插入时间" prop="chartTime">
          <el-date-picker clearable
            v-model="form.chartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择插入时间">
          </el-date-picker> -->
        <!-- </el-form-item> -->
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="出生日期" prop="dateOfBirth">
          <el-date-picker clearable
            v-model="form.dateOfBirth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="身高" prop="heightCm">
          <el-input v-model="form.heightCm" placeholder="请输入身高" />
        </el-form-item>
        <el-form-item label="体重" prop="weightKg">
          <el-input v-model="form.weightKg" placeholder="请输入体重" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="入院诊断" prop="admissionDiagnosis">
          <el-input v-model="form.admissionDiagnosis" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="入院时间" prop="departmentAdmissionTime">
          <el-date-picker clearable
            v-model="form.departmentAdmissionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院时间" prop="departmentDischargeTime">
          <el-date-picker clearable
            v-model="form.departmentDischargeTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院结果" prop="dischargeOutcome">
          <el-input v-model="form.dischargeOutcome" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="死亡时间" prop="timeOfDeath">
          <el-date-picker clearable
            v-model="form.timeOfDeath"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择死亡时间">
          </el-date-picker>
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
import { listBasesign, getBasesign, delBasesign, addBasesign, updateBasesign } from "@/api/system/basesign"
import { getToken } from "@/utils/auth";
export default {
  name: "Basesign",
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
      // 病历管理表格数据
      basesignList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 死亡时间时间范围
      daterangeChartTime: [],
      // 死亡时间时间范围
      daterangeDateOfBirth: [],
      // 死亡时间时间范围
      daterangeDepartmentAdmissionTime: [],
      // 死亡时间时间范围
      daterangeDepartmentDischargeTime: [],
      // 死亡时间时间范围
      daterangeTimeOfDeath: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: null,
        idcard: null,
        name: null,
        hospitalId: null,
        chartTime: null,
        age: null,
        dateOfBirth: null,
        heightCm: null,
        weightKg: null,
        gender: null,
        admissionDiagnosis: null,
        departmentAdmissionTime: null,
        departmentDischargeTime: null,
        dischargeOutcome: null,
        timeOfDeath: null
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
        url: process.env.VUE_APP_BASE_API + "/system/basesign/importData"
      },
 
      // 表单校验
      rules: {
        idcard: [
          { required: true, message: "身份ID不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询病历管理列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      if (null != this.daterangeDateOfBirth && '' != this.daterangeDateOfBirth) {
        this.queryParams.params["beginDateOfBirth"] = this.daterangeDateOfBirth[0]
        this.queryParams.params["endDateOfBirth"] = this.daterangeDateOfBirth[1]
      }
      if (null != this.daterangeDepartmentAdmissionTime && '' != this.daterangeDepartmentAdmissionTime) {
        this.queryParams.params["beginDepartmentAdmissionTime"] = this.daterangeDepartmentAdmissionTime[0]
        this.queryParams.params["endDepartmentAdmissionTime"] = this.daterangeDepartmentAdmissionTime[1]
      }
      if (null != this.daterangeDepartmentDischargeTime && '' != this.daterangeDepartmentDischargeTime) {
        this.queryParams.params["beginDepartmentDischargeTime"] = this.daterangeDepartmentDischargeTime[0]
        this.queryParams.params["endDepartmentDischargeTime"] = this.daterangeDepartmentDischargeTime[1]
      }
      if (null != this.daterangeTimeOfDeath && '' != this.daterangeTimeOfDeath) {
        this.queryParams.params["beginTimeOfDeath"] = this.daterangeTimeOfDeath[0]
        this.queryParams.params["endTimeOfDeath"] = this.daterangeTimeOfDeath[1]
      }
      listBasesign(this.queryParams).then(response => {
        this.basesignList = response.rows
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
        id: null,
        idcard: null,
        name: null,
        hospitalId: null,
        chartTime: null,
        age: null,
        dateOfBirth: null,
        heightCm: null,
        weightKg: null,
        gender: null,
        admissionDiagnosis: null,
        departmentAdmissionTime: null,
        departmentDischargeTime: null,
        dischargeOutcome: null,
        timeOfDeath: null
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
      this.daterangeDateOfBirth = []
      this.daterangeDepartmentAdmissionTime = []
      this.daterangeDepartmentDischargeTime = []
      this.daterangeTimeOfDeath = []
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
      this.title = "添加病历管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getBasesign(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改病历管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBasesign(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addBasesign(this.form).then(response => {
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
      console.log("打印参数")
      console.log(row)
      console.log("打印id")
      console.log(row.id)
      console.log("打印ids")
      console.log(this.ids)
      const Ids = row.id || this.ids
      console.log("打印最终")
      console.log(Ids)

      this.$modal.confirm('是否确认删除病历管理编号为"' + Ids + '"的数据项？').then(function() {
        return delBasesign(Ids)
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
  this.download('system/basesign/importTemplate', {
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
      this.download('system/basesign/export', {
        ...this.queryParams
      }, `basesign_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
