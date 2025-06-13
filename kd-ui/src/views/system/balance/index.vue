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
      <!-- <el-form-item label="尿量" prop="urineOutput">
        <el-input
          v-model="queryParams.urineOutput"
          placeholder="请输入尿量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每小时入量" prop="inputPerHour">
        <el-input
          v-model="queryParams.inputPerHour"
          placeholder="请输入每小时入量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每小时出量" prop="outputPerHour">
        <el-input
          v-model="queryParams.outputPerHour"
          placeholder="请输入每小时出量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="每小时平衡量" prop="balancePerHour">
        <el-input
          v-model="queryParams.balancePerHour"
          placeholder="请输入每小时平衡量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="胃肠入合计" prop="gastrointestinalInputTotal">
        <el-input
          v-model="queryParams.gastrointestinalInputTotal"
          placeholder="请输入胃肠入合计"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="大便合计" prop="stoolTotal">
        <el-input
          v-model="queryParams.stoolTotal"
          placeholder="请输入大便合计"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="胃肠出合计" prop="gastrointestinalOutputTotal">
        <el-input
          v-model="queryParams.gastrointestinalOutputTotal"
          placeholder="请输入胃肠出合计"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="引流量合计" prop="drainageTotal">
        <el-input
          v-model="queryParams.drainageTotal"
          placeholder="请输入引流量合计"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际超滤量" prop="actualUltrafiltration">
        <el-input
          v-model="queryParams.actualUltrafiltration"
          placeholder="请输入实际超滤量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血制品合计" prop="bloodProductsTotal">
        <el-input
          v-model="queryParams.bloodProductsTotal"
          placeholder="请输入血制品合计"
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
          v-hasPermi="['system:balance:add']"
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
          v-hasPermi="['system:balance:edit']"
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
          v-hasPermi="['system:balance:remove']"
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
          v-hasPermi="['system:balance:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="balanceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="病历编号" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="尿量" align="center" prop="urineOutput" />
      <el-table-column label="每小时入量" align="center" prop="inputPerHour" />
      <el-table-column label="每小时出量" align="center" prop="outputPerHour" />
      <el-table-column label="每小时平衡量" align="center" prop="balancePerHour" />
      <el-table-column label="胃肠入合计" align="center" prop="gastrointestinalInputTotal" />
      <el-table-column label="大便合计" align="center" prop="stoolTotal" />
      <el-table-column label="胃肠出合计" align="center" prop="gastrointestinalOutputTotal" />
      <el-table-column label="引流量合计" align="center" prop="drainageTotal" />
      <el-table-column label="实际超滤量" align="center" prop="actualUltrafiltration" />
      <el-table-column label="血制品合计" align="center" prop="bloodProductsTotal" />
      <el-table-column label="操作说明" align="center" prop="instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:balance:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:balance:remove']"
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

    <!-- 添加或修改液体平衡对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病例编号" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病例编号" />
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
        <el-form-item label="尿量" prop="urineOutput">
          <el-input v-model="form.urineOutput" placeholder="请输入尿量" />
        </el-form-item>
        <el-form-item label="每小时入量" prop="inputPerHour">
          <el-input v-model="form.inputPerHour" placeholder="请输入每小时入量" />
        </el-form-item>
        <el-form-item label="每小时出量" prop="outputPerHour">
          <el-input v-model="form.outputPerHour" placeholder="请输入每小时出量" />
        </el-form-item>
        <el-form-item label="每小时平衡量" prop="balancePerHour">
          <el-input v-model="form.balancePerHour" placeholder="请输入每小时平衡量" />
        </el-form-item>
        <el-form-item label="胃肠入合计" prop="gastrointestinalInputTotal">
          <el-input v-model="form.gastrointestinalInputTotal" placeholder="请输入胃肠入合计" />
        </el-form-item>
        <el-form-item label="大便合计" prop="stoolTotal">
          <el-input v-model="form.stoolTotal" placeholder="请输入大便合计" />
        </el-form-item>
        <el-form-item label="胃肠出合计" prop="gastrointestinalOutputTotal">
          <el-input v-model="form.gastrointestinalOutputTotal" placeholder="请输入胃肠出合计" />
        </el-form-item>
        <el-form-item label="引流量合计" prop="drainageTotal">
          <el-input v-model="form.drainageTotal" placeholder="请输入引流量合计" />
        </el-form-item>
        <el-form-item label="实际超滤量" prop="actualUltrafiltration">
          <el-input v-model="form.actualUltrafiltration" placeholder="请输入实际超滤量" />
        </el-form-item>
        <el-form-item label="血制品合计" prop="bloodProductsTotal">
          <el-input v-model="form.bloodProductsTotal" placeholder="请输入血制品合计" />
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
import { listBalance, getBalance, delBalance, addBalance, updateBalance } from "@/api/system/balance"
import { getToken } from "@/utils/auth";
export default {
  name: "Balance",
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
      // 液体平衡表格数据
      balanceList: [],
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
        urineOutput: null,
        inputPerHour: null,
        outputPerHour: null,
        balancePerHour: null,
        gastrointestinalInputTotal: null,
        stoolTotal: null,
        gastrointestinalOutputTotal: null,
        drainageTotal: null,
        actualUltrafiltration: null,
        bloodProductsTotal: null,
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
        url: process.env.VUE_APP_BASE_API + "/system/balance/importData"
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
    /** 查询液体平衡列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listBalance(this.queryParams).then(response => {
        this.balanceList = response.rows
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
        urineOutput: null,
        inputPerHour: null,
        outputPerHour: null,
        balancePerHour: null,
        gastrointestinalInputTotal: null,
        stoolTotal: null,
        gastrointestinalOutputTotal: null,
        drainageTotal: null,
        actualUltrafiltration: null,
        bloodProductsTotal: null,
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
      this.title = "添加液体平衡"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.id || this.ids
      getBalance(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改液体平衡"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBalance(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addBalance(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除液体平衡编号为"' + Ids + '"的数据项？').then(function() {
        return delBalance(Ids)
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
  this.download('system/balance/importTemplate', {
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
      this.download('system/balance/export', {
        ...this.queryParams
      }, `balance_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
