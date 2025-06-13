<template>
    <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="病历编号" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病历编号" />
        </el-form-item>
        <el-form-item label="医院ID" prop="hospitalId">
          <el-input v-model="form.hospitalId" placeholder="请输入医院ID" />
        </el-form-item>
        <el-form-item label="记录时间" prop="chartTime">
          <el-date-picker clearable v-model="form.chartTime" type="date"
            value-format="yyyy-MM-dd" placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="血清钾浓度" prop="cK">
          <el-input v-model="form.cK" placeholder="请输入血清钾浓度" />
        </el-form-item>
        <el-form-item label="动脉氧分压" prop="pO2">
          <el-input v-model="form.pO2" placeholder="请输入动脉氧分压" />
        </el-form-item>
        <el-form-item label="碱剩余" prop="cBase">
          <el-input v-model="form.cBase" placeholder="请输入碱剩余" />
        </el-form-item>
        <el-form-item label="血清钙离子浓度" prop="cCa2">
          <el-input v-model="form.cCa2" placeholder="请输入血清钙离子浓度" />
        </el-form-item>
        <el-form-item label="红细胞比容" prop="Hct">
          <el-input v-model="form.Hct" placeholder="请输入红细胞比容" />
        </el-form-item>
        <el-form-item label="pH值" prop="pH">
          <el-input v-model="form.pH" placeholder="请输入pH值" />
        </el-form-item>
        <el-form-item label="总血红蛋白含量" prop="ctHb">
          <el-input v-model="form.ctHb" placeholder="请输入总血红蛋白含量" />
        </el-form-item>
        <el-form-item label="血清氯离子浓度" prop="cCl">
          <el-input v-model="form.cCl" placeholder="请输入血清氯离子浓度" />
        </el-form-item>
        <el-form-item label="血清钠离子浓度" prop="cNa">
          <el-input v-model="form.cNa" placeholder="请输入血清钠离子浓度" />
        </el-form-item>
        <el-form-item label="动脉二氧化碳分压" prop="pCO2">
          <el-input v-model="form.pCO2" placeholder="请输入动脉二氧化碳分压" />
        </el-form-item>
        <el-form-item label="氧气分数" prop="FO2">
          <el-input v-model="form.FO2" placeholder="请输入氧气分数" />
        </el-form-item>
        <el-form-item label="血乳酸浓度" prop="cLac">
          <el-input v-model="form.cLac" placeholder="请输入血乳酸浓度" />
        </el-form-item>
        <el-form-item label="碳酸氢盐浓度" prop="cHCO3">
          <el-input v-model="form.cHCO3" placeholder="请输入碳酸氢盐浓度" />
        </el-form-item>
        <el-form-item label="动脉-肺泡氧分压差" prop="AaDpO2">
          <el-input v-model="form.AaDpO2" placeholder="请输入动脉-肺泡氧分压差" />
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
  import { addGas } from "@/api/system/gas";
  
  export default {
    name: "AddGasDialog",
    props: {
      open: {
        type: Boolean,
        required: true
      },
      title: {
        type: String,
        required: true
      }
    },
    data() {
      return {
        localOpen: this.open,
        form: {
          id: null, // 固定为 null，因为我们只做添加
          encounterId: null,
          hospitalId: null,
          chartTime: null,
          cK: null,
          pO2: null,
          cBase: null,
          cCa2: null,
          Hct: null,
          pH: null,
          ctHb: null,
          cCl: null,
          cNa: null,
          pCO2: null,
          FO2: null,
          cLac: null,
          cHCO3: null,
          AaDpO2: null,
          instructions: null
        },
        rules: {
          encounterId: [
            { required: true, message: "病历编号不能为空", trigger: "blur" }
          ],
          hospitalId: [
            { required: true, message: "医院ID不能为空", trigger: "blur" }
          ],
          chartTime: [
            { required: true, message: "记录时间不能为空", trigger: "blur" }
          ],
          cK: [
            { required: true, message: "血清钾浓度不能为空", trigger: "blur" }
          ],
          pO2: [
            { required: true, message: "动脉氧分压不能为空", trigger: "blur" }
          ],
          cBase: [
            { required: true, message: "碱剩余不能为空", trigger: "blur" }
          ],
          cCa2: [
            { required: true, message: "血清钙离子浓度不能为空", trigger: "blur" }
          ],
          Hct: [
            { required: true, message: "红细胞比容不能为空", trigger: "blur" }
          ],
          pH: [
            { required: true, message: "pH值不能为空", trigger: "blur" }
          ],
          ctHb: [
            { required: true, message: "总血红蛋白含量不能为空", trigger: "blur" }
          ],
          cCl: [
            { required: true, message: "血清氯离子浓度不能为空", trigger: "blur" }
          ],
          cNa: [
            { required: true, message: "血清钠离子浓度不能为空", trigger: "blur" }
          ],
          pCO2: [
            { required: true, message: "动脉二氧化碳分压不能为空", trigger: "blur" }
          ],
          FO2: [
            { required: true, message: "氧气分数不能为空", trigger: "blur" }
          ],
          cLac: [
            { required: true, message: "血乳酸浓度不能为空", trigger: "blur" }
          ],
          cHCO3: [
            { required: true, message: "碳酸氢盐浓度不能为空", trigger: "blur" }
          ],
          AaDpO2: [
            { required: true, message: "动脉-肺泡氧分压差不能为空", trigger: "blur" }
          ],
          instructions: [
            { required: true, message: "操作说明不能为空", trigger: "blur" }
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
      // 提供给父组件调用的方法，用于打开弹窗并重置表单
      handleAdd() {
        this.reset();
        this.localOpen = true;
        this.$emit("update:open", true);
      },
      reset() {
        this.form = {
          id: null,
          encounterId: null,
          hospitalId: null,
          chartTime: null,
          cK: null,
          pO2: null,
          cBase: null,
          cCa2: null,
          Hct: null,
          pH: null,
          ctHb: null,
          cCl: null,
          cNa: null,
          pCO2: null,
          FO2: null,
          cLac: null,
          cHCO3: null,
          AaDpO2: null,
          instructions: null
        };
      },
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            addGas(this.form)
              .then(() => {
                this.$message.success("新增成功");
                this.localOpen = false;
                this.$emit("update:open", false);
                this.$emit("submit-success");
              })
              .catch(err => {
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