<template>
    <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病历编号" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病历编号" />
        </el-form-item>
        <el-form-item label="医院ID" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入医院ID" />
        </el-form-item>
        <el-form-item label="记录时间" prop="chartTime">
          <el-date-picker
            clearable
            v-model="form.chartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择记录时间"
          />
        </el-form-item>
        <el-form-item label="GCS运动评分" prop="gcsMotor">
          <el-input v-model="form.gcsMotor" placeholder="请输入GCS运动评分" />
        </el-form-item>
        <el-form-item label="GCS睁眼评分" prop="gcsEyeOpening">
          <el-input v-model="form.gcsEyeOpening" placeholder="请输入GCS睁眼评分" />
        </el-form-item>
        <el-form-item label="GCS评分" prop="gcsScore">
          <el-input v-model="form.gcsScore" placeholder="请输入GCS评分" />
        </el-form-item>
        <el-form-item label="GCS言语评分" prop="gcsVerbalResponse">
          <el-input v-model="form.gcsVerbalResponse" placeholder="请输入GCS言语评分" />
        </el-form-item>
        <el-form-item label="GCS总分" prop="gcsTotal">
          <el-input v-model="form.gcsTotal" placeholder="请输入GCS总分" />
        </el-form-item>
        <el-form-item label="操作说明" prop="instructions">
          <el-input v-model="form.instructions" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </div>
    </el-dialog>
  </template>
  
  <script>
  import { addGcsscore, updateGcsscore } from "@/api/system/Gcsscore";
  
  export default {
    name: "AddGcsscoreDialog", // 组件名与业务匹配
    props: {
      open: Boolean, // 接收父组件打开状态
      title: String // 接收标题
    },
    data() {
      return {
        localOpen: this.open, // 本地双向绑定状态
        form: {
          // 表单字段与模板一致，包含 id 用于区分新增/修改
          id: null,
          encounterId: null,
          hospitalId: null,
          chartTime: null,
          gcsMotor: null,
          gcsEyeOpening: null,
          gcsScore: null,
          gcsVerbalResponse: null,
          gcsTotal: null,
          instructions: null
        },
        rules: {
          encounterId: [{ required: true, message: "病历编号不能为空", trigger: "blur" }],
          chartTime: [{ required: true, message: "记录时间不能为空", trigger: "change" }] // 新增时间必填校验
        }
      };
    },
    // 监听父组件 open 状态，同步到本地并重置表单
    watch: {
      open(newVal) {
        this.localOpen = newVal;
        if (!newVal) this.reset(); // 关闭时重置表单
      },
      localOpen(newVal) {
        this.$emit("update:open", newVal); // 通知父组件状态变化
      }
    },
    methods: {
      // **关键：保留原 handleAdd 逻辑**
      handleAdd() {
        this.reset(); // 重置表单
        this.localOpen = true; // 打开对话框
        this.$emit("update:open", true); // 通知父组件
      },
      // 重置表单（清空所有字段）
      reset() {
        this.form = {
          id: null,
          encounterId: null,
          hospitalId: null,
          chartTime: null,
          gcsMotor: null,
          gcsEyeOpening: null,
          gcsScore: null,
          gcsVerbalResponse: null,
          gcsTotal: null,
          instructions: null
        };
      },
      // 提交表单（自动判断新增/修改）
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {
            const api = this.form.id ? updateGcsscore : addGcsscore; // 根据 id 判断操作类型
            api(this.form).then(response => {
              this.$message.success(this.form.id ? "修改成功" : "新增成功"); // 差异化提示
              this.localOpen = false; // 关闭对话框
              this.$emit("submit-success"); // 通知父组件提交成功（如刷新列表）
              this.reset(); // 提交后重置表单
            }).catch(err => {
              console.error("提交失败：", err);
              this.$message.error("提交失败，请检查输入或网络");
            });
          }
        });
      },
      // 取消操作（关闭对话框并重置表单）
      cancel() {
        this.localOpen = false;
        this.$emit("update:open", false);
        this.reset();
      }
    }
  };
  </script>
  
  <style scoped>
  .dialog-footer {
    text-align: right;
  }
  </style>