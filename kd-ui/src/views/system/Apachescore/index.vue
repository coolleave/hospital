<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病人标识符" prop="encounterId">
        <el-input
          v-model="queryParams.encounterId"
          placeholder="请输入病人标识符"
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
      <el-form-item label="体温" prop="apacheiiTemperature">
        <el-input
          v-model="queryParams.apacheiiTemperature"
          placeholder="请输入体温"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评估时间" prop="apacheiiAssessmentTime">
        <el-date-picker clearable
          v-model="queryParams.apacheiiAssessmentTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择评估时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="患者年龄" prop="apacheiiAge">
        <el-input
          v-model="queryParams.apacheiiAge"
          placeholder="请输入患者年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="APACHEII总分" prop="apacheiiTotalScore">
        <el-input
          v-model="queryParams.apacheiiTotalScore"
          placeholder="请输入APACHEII总分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['system:Apachescore:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:Apachescore:edit']"
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
          v-hasPermi="['system:Apachescore:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:Apachescore:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ApachescoreList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="Id" />
      <el-table-column label="病人标识符" align="center" prop="encounterId" />
      <el-table-column label="医院ID" align="center" prop="hospitalId" />
      <el-table-column label="记录时间" align="center" prop="chartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.chartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="计算状态" align="center" prop="apacheiiComputedStatus" />
      <el-table-column label="默认计算观测值状态" align="center" prop="apacheiiDefaultComputedObservationStatus" />
      <el-table-column label="体温" align="center" prop="apacheiiTemperature" />
      <el-table-column label="评估时间" align="center" prop="apacheiiAssessmentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.apacheiiAssessmentTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="患者年龄" align="center" prop="apacheiiAge" />
      <el-table-column label="APACHEII总分" align="center" prop="apacheiiTotalScore" />
      <el-table-column label="操作说明" align="center" prop="Instructions" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:Apachescore:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:Apachescore:remove']"
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

    <!-- 添加或修改生理评分对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病人标识符" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病人标识符" />
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
        <el-form-item label="体温" prop="apacheiiTemperature">
          <el-input v-model="form.apacheiiTemperature" placeholder="请输入体温" />
        </el-form-item>
        <el-form-item label="评估时间" prop="apacheiiAssessmentTime">
          <el-date-picker clearable
            v-model="form.apacheiiAssessmentTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择评估时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="患者年龄" prop="apacheiiAge">
          <el-input v-model="form.apacheiiAge" placeholder="请输入患者年龄" />
        </el-form-item>
        <el-form-item label="APACHEII总分" prop="apacheiiTotalScore">
          <el-input v-model="form.apacheiiTotalScore" placeholder="请输入APACHEII总分" />
        </el-form-item>
        <el-form-item label="操作说明" prop="Instructions">
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
import { listApachescore, getApachescore, delApachescore, addApachescore, updateApachescore } from "@/api/system/Apachescore"

export default {
  name: "Apachescore",
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
      // 生理评分表格数据
      ApachescoreList: [],
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
        apacheiiComputedStatus: null,
        apacheiiDefaultComputedObservationStatus: null,
        apacheiiTemperature: null,
        apacheiiAssessmentTime: null,
        apacheiiAge: null,
        apacheiiTotalScore: null,
        Instructions: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询生理评分列表 */
    getList() {
      this.loading = true
      this.queryParams.params = {}
      if (null != this.daterangeChartTime && '' != this.daterangeChartTime) {
        this.queryParams.params["beginChartTime"] = this.daterangeChartTime[0]
        this.queryParams.params["endChartTime"] = this.daterangeChartTime[1]
      }
      listApachescore(this.queryParams).then(response => {
        this.ApachescoreList = response.rows
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
        apacheiiComputedStatus: null,
        apacheiiDefaultComputedObservationStatus: null,
        apacheiiTemperature: null,
        apacheiiAssessmentTime: null,
        apacheiiAge: null,
        apacheiiTotalScore: null,
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
      this.title = "添加生理评分"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const Id = row.Id || this.ids
      getApachescore(Id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改生理评分"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.Id != null) {
            updateApachescore(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addApachescore(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除生理评分编号为"' + Ids + '"的数据项？').then(function() {
        return delApachescore(Ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/Apachescore/export', {
        ...this.queryParams
      }, `Apachescore_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
