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
  import { addVitalsign, updateVitalsign } from "@/api/system/vitalsign";
  
  export default {
    name: "AddvitalsignDialog", // 组件名与模板保持一致
    props: {
      open: Boolean, // 接收父组件的打开状态
      title: String // 接收标题
    },
    data() {
      return {
        localOpen: this.open, // 双向绑定的本地打开状态
        form: {
          // 表单字段与模板完全一致，包含 `id`（用于区分新增/修改）
          id: null,
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
          instructions: null
        },
        rules: {
          encounterId: [{ required: true, message: "病历编号不能为空", trigger: "blur" }],
          chartTime: [{ required: true, message: "记录时间不能为空", trigger: "change" }] // 新增时间必填校验
        }
      };
    },
    // 监听父组件的 `open` 状态，同步到本地
    watch: {
      open(newVal) {
        this.localOpen = newVal;
        // 若关闭对话框，重置表单（与模板逻辑一致）
        if (!newVal) this.reset();
      },
      localOpen(newVal) {
        this.$emit("update:open", newVal); // 通知父组件状态变化
      }
    },
    methods: {
      // **关键：保留原 `handleAdd` 逻辑，并按模板命名为 `handleAdd`**
      handleAdd() {
        this.reset(); // 重置表单
        this.localOpen = true; // 打开对话框
        this.$emit("update:open", true); // 通知父组件
      },
      // 重置表单（与模板一致）
      reset() {
        this.form = {
          id: null,
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
          instructions: null
        };
      },
      // 提交表单（支持新增和修改）
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {
            const api = this.form.id ? updateVitalsign : addVitalsign; // 判断新增/修改
            api(this.form).then(response => {
              this.$message.success(this.form.id ? "修改成功" : "新增成功");
              this.localOpen = false;
              this.$emit("submit-success"); // 通知父组件提交成功
              this.reset(); // 提交后重置表单
            }).catch(err => {
              console.error("提交失败：", err);
              this.$message.error("提交失败，请检查输入或网络");
            });
          }
        });
      },
      // 取消操作（与模板一致）
      cancel() {
        this.localOpen = false;
        this.$emit("update:open", false);
        this.reset(); // 取消时重置表单
      }
    }
  };
  </script>
  
  <style scoped>
  .dialog-footer {
    text-align: right;
  }
  </style>