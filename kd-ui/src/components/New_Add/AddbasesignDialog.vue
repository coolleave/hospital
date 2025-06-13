<template>
    <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
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
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </div>
    </el-dialog>
  </template>
  
  <script>
  import { addBasesign } from "@/api/system/basesign";
  
  export default {
    name: "AddbasesignDialog",
    props: {
      open: Boolean,
      title: String
    },
    data() {
      return {
        localOpen: this.open,
        form: {
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
        rules: {
          idcard: [
            { required: true, message: "身份ID不能为空", trigger: "blur" }
          ],
          name: [
            { required: true, message: "名称不能为空", trigger: "blur" }
          ]
        }
      };
    },
    watch: {
      open(newVal) {
        this.localOpen = newVal;
      },
      localOpen(newVal) {
        this.$emit("update:open", newVal);
      }
    },
    methods: {
      handleAdd() {
        this.reset();
        this.localOpen = true;
        this.$emit("update:open", true);
      },
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
        };
      },
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {
            addBasesign(this.form).then(response => {
              this.$message.success("新增成功");
              this.localOpen = false;
              this.$emit("update:open", false);
              this.$emit("submit-success");
            }).catch(err => {
              console.error("提交失败：", err);
              this.$message.error("提交失败，请检查输入或网络");
            });
          }
        });
      },
      cancel() {
        this.localOpen = false;
        this.$emit("update:open", false);
      }
    }
  };
  </script>
  
  <style scoped>
  .dialog-footer {
    text-align: right;
  }
  </style>