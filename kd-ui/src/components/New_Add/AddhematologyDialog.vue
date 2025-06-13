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
        <el-form-item label="红细胞计数" prop="redBloodCellCount">
          <el-input v-model="form.redBloodCellCount" placeholder="请输入红细胞计数" />
        </el-form-item>
        <el-form-item label="红细胞体积分布宽度_SD" prop="rdwSD">
          <el-input v-model="form.rdwSD" placeholder="请输入红细胞体积分布宽度_SD" />
        </el-form-item>
        <el-form-item label="红细胞分布宽度CV" prop="rdwCV">
          <el-input v-model="form.rdwCV" placeholder="请输入红细胞分布宽度CV" />
        </el-form-item>
        <el-form-item label="红细胞压积HCT" prop="hct">
          <el-input v-model="form.hct" placeholder="请输入红细胞压积HCT" />
        </el-form-item>
        <el-form-item label="血红蛋白" prop="hemoglobin">
          <el-input v-model="form.hemoglobin" placeholder="请输入血红蛋白" />
        </el-form-item>
        <el-form-item label="平均血红蛋白浓度MCHC" prop="mchc">
          <el-input v-model="form.mchc" placeholder="请输入平均血红蛋白浓度MCHC" />
        </el-form-item>
        <el-form-item label="平均血红蛋白量MCH" prop="mch">
          <el-input v-model="form.mch" placeholder="请输入平均血红蛋白量MCH" />
        </el-form-item>
        <el-form-item label="红细胞平均体积MCV" prop="mcv">
          <el-input v-model="form.mcv" placeholder="请输入红细胞平均体积MCV" />
        </el-form-item>
        <el-form-item label="白细胞计数" prop="whiteBloodCellCount">
          <el-input v-model="form.whiteBloodCellCount" placeholder="请输入白细胞计数" />
        </el-form-item>
        <el-form-item label="中性粒细胞计数" prop="neutrophilCount">
          <el-input v-model="form.neutrophilCount" placeholder="请输入中性粒细胞计数" />
        </el-form-item>
        <el-form-item label="淋巴细胞计数" prop="lymphocyteCount">
          <el-input v-model="form.lymphocyteCount" placeholder="请输入淋巴细胞计数" />
        </el-form-item>
        <el-form-item label="嗜酸性粒细胞计数" prop="eosinophilCount">
          <el-input v-model="form.eosinophilCount" placeholder="请输入嗜酸性粒细胞计数" />
        </el-form-item>
        <el-form-item label="嗜碱性粒细胞计数" prop="basophilCount">
          <el-input v-model="form.basophilCount" placeholder="请输入嗜碱性粒细胞计数" />
        </el-form-item>
        <el-form-item label="单核细胞计数" prop="monocyteCount">
          <el-input v-model="form.monocyteCount" placeholder="请输入单核细胞计数" />
        </el-form-item>
        <el-form-item label="不成熟粒细胞计数" prop="immatureGranulocyteCount">
          <el-input v-model="form.immatureGranulocyteCount" placeholder="请输入不成熟粒细胞计数" />
        </el-form-item>
        <el-form-item label="血小板计数" prop="plateletCount">
          <el-input v-model="form.plateletCount" placeholder="请输入血小板计数" />
        </el-form-item>
        <el-form-item label="血小板压积" prop="plateletcrit">
          <el-input v-model="form.plateletcrit" placeholder="请输入血小板压积" />
        </el-form-item>
        <el-form-item label="平均血小板体积" prop="meanPlateletVolume">
          <el-input v-model="form.meanPlateletVolume" placeholder="请输入平均血小板体积" />
        </el-form-item>
        <el-form-item label="血小板分布宽度" prop="plateletDistributionWidth">
          <el-input v-model="form.plateletDistributionWidth" placeholder="请输入血小板分布宽度" />
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
  import { addHematology, updateHematology, getHematology } from "@/api/system/hematology";
  import { getToken } from "@/utils/auth";
  
  export default {
    name: "AddhematologyDialog",
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
          redBloodCellCount: null,
          rdwSD: null,
          rdwCV: null,
          hct: null,
          hemoglobin: null,
          mchc: null,
          mch: null,
          mcv: null,
          whiteBloodCellCount: null,
          neutrophilCount: null,
          lymphocyteCount: null,
          eosinophilCount: null,
          basophilCount: null,
          monocyteCount: null,
          immatureGranulocyteCount: null,
          plateletCount: null,
          plateletcrit: null,
          meanPlateletVolume: null,
          plateletDistributionWidth: null,
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
          redBloodCellCount: null,
          rdwSD: null,
          rdwCV: null,
          hct: null,
          hemoglobin: null,
          mchc: null,
          mch: null,
          mcv: null,
          whiteBloodCellCount: null,
          neutrophilCount: null,
          lymphocyteCount: null,
          eosinophilCount: null,
          basophilCount: null,
          monocyteCount: null,
          immatureGranulocyteCount: null,
          plateletCount: null,
          plateletcrit: null,
          meanPlateletVolume: null,
          plateletDistributionWidth: null,
          instructions: null
        };
        if (this.$refs['form']) this.$refs['form'].resetFields(); // 重置表单验证状态
      },
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            const method = this.form.id ? updateHematology : addHematology;
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