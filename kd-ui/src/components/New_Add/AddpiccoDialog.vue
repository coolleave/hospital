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
          <el-date-picker clearable
                          v-model="form.chartTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择记录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="心输出量(L/min)" prop="CO">
          <el-input v-model="form.CO" placeholder="请输入心输出量(Cardiac Output, L/min)" />
        </el-form-item>
        <el-form-item label="收缩压(mmHg)" prop="sABP">
          <el-input v-model="form.sABP" placeholder="请输入收缩压(Systolic Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="舒张压(mmHg)" prop="dABP">
          <el-input v-model="form.dABP" placeholder="请输入舒张压(Diastolic Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="平均动脉压(mmHg)" prop="mABP">
          <el-input v-model="form.mABP" placeholder="请输入平均动脉压(Mean Arterial Blood Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="体表面积(m²)" prop="BSA">
          <el-input v-model="form.BSA" placeholder="请输入体表面积(Body Surface Area, m²)" />
        </el-form-item>
        <el-form-item label="中心静脉压(mmHg)" prop="CVP">
          <el-input v-model="form.CVP" placeholder="请输入中心静脉压(Central Venous Pressure, mmHg)" />
        </el-form-item>
        <el-form-item label="心指数(L/min/m²)" prop="CI">
          <el-input v-model="form.CI" placeholder="请输入心指数(Cardiac Index, L/min/m²)" />
        </el-form-item>
        <el-form-item label="连续心排血量(L/min)" prop="PCCO">
          <el-input v-model="form.PCCO" placeholder="请输入连续心排血量(Pulse Contour Cardiac Output, L/min)" />
        </el-form-item>
        <el-form-item label="每搏输出量(Sml)" prop="SV">
          <el-input v-model="form.SV" placeholder="请输入每搏输出量(Stroke Volume, ml)" />
        </el-form-item>
        <el-form-item label="血管阻力(dyn·s/cm⁵)" prop="SVR">
          <el-input v-model="form.SVR" placeholder="请输入血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)" />
        </el-form-item>
        <el-form-item label="每搏变异度(%)" prop="SVV">
          <el-input v-model="form.SVV" placeholder="请输入每搏变异度(Stroke Volume Variation, %)" />
        </el-form-item>
        <el-form-item label="全身射血分数(%)" prop="GEF">
          <el-input v-model="form.GEF" placeholder="请输入全身射血分数(Global Ejection Fraction, %)" />
        </el-form-item>
        <el-form-item label="心功能指数" prop="CFI">
          <el-input v-model="form.CFI" placeholder="请输入心功能指数(Cardiac Function Index)" />
        </el-form-item>
        <el-form-item label="容积性温度测量的胸内血容量(ml)" prop="ITBV">
          <el-input v-model="form.ITBV" placeholder="请输入容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)" />
        </el-form-item>
        <el-form-item label="全身舒张末期容积( ml)" prop="GEDV">
          <el-input v-model="form.GEDV" placeholder="请输入全身舒张末期容积(Global End-Diastolic Volume, ml)" />
        </el-form-item>
        <el-form-item label="肺血管阻力( dyn·s/cm⁵)" prop="PVR">
          <el-input v-model="form.PVR" placeholder="请输入肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)" />
        </el-form-item>
        <el-form-item label="肺水含量(ml)" prop="EVLW">
          <el-input v-model="form.EVLW" placeholder="请输入肺水含量(Extravascular Lung Water, ml)" />
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
  import { addPicco, updatePicco, getPicco } from "@/api/system/picco";
  import { getToken } from "@/utils/auth";
  
  export default {
    name: "AddpiccoDialog",
    props: {
      open: Boolean,
      title: String
    },
    data() {
      return {
        localOpen: this.open,
        form: {
          id: null,
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
          instructions: null
        },
        rules: {
          encounterId: [
            { required: true, message: "病历编号不能为空", trigger: "blur" }
          ],
          // 可以在此添加其他字段的验证规则
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
          instructions: null
        };
        if (this.$refs['form']) this.$refs['form'].resetFields(); // 重置表单验证状态
      },
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            const method = this.form.id ? updatePicco : addPicco;
            method(this.form).then(response => {
              this.$message.success(`${this.form.id ? '修改' : '新增'}成功`);
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