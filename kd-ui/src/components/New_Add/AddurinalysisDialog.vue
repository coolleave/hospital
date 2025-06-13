<template>
  <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
    <el-form ref="form" :model="form" :rules="rules" label-width="120px">
      <!-- 基础信息 -->
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
                        placeholder="请选择记录时间"/>
      </el-form-item>

      <!-- 尿液分析指标 -->
      <el-form-item label="尿液pH值" prop="urinePH">
        <el-input v-model="form.urinePH" placeholder="请输入尿液pH值" />
      </el-form-item>
      <el-form-item label="尿红细胞(RBC)" prop="urineRBC">
        <el-input v-model="form.urineRBC" placeholder="请输入尿红细胞(RBC)" />
      </el-form-item>
      <el-form-item label="尿白细胞(WBC)" prop="urineWBC">
        <el-input v-model="form.urineWBC" placeholder="请输入尿白细胞(WBC)" />
      </el-form-item>
      <el-form-item label="尿比重" prop="urineSpecificGravity">
        <el-input v-model="form.urineSpecificGravity" placeholder="请输入尿比重" />
      </el-form-item>
      <el-form-item label="尿酸盐结晶" prop="urineUrate">
        <el-input v-model="form.urineUrate" placeholder="请输入尿酸盐结晶" />
      </el-form-item>
      <el-form-item label="尿淀粉酶" prop="urineAmylase">
        <el-input v-model="form.urineAmylase" placeholder="请输入尿淀粉酶" />
      </el-form-item>
      <el-form-item label="透明管型" prop="hyalineCasts">
        <el-input v-model="form.hyalineCasts" placeholder="请输入透明管型" />
      </el-form-item>
      <el-form-item label="病理性管型" prop="pathologicalCasts">
        <el-input v-model="form.pathologicalCasts" placeholder="请输入病理性管型" />
      </el-form-item>
      <el-form-item label="尿酸结晶" prop="urateCrystals">
        <el-input v-model="form.urateCrystals" placeholder="请输入尿酸结晶" />
      </el-form-item>
      <el-form-item label="草酸钙结晶" prop="calciumOxalateCrystals">
        <el-input v-model="form.calciumOxalateCrystals" placeholder="请输入草酸钙结晶" />
      </el-form-item>
      <el-form-item label="尿酸结晶" prop="uricAcidCrystals">
        <el-input v-model="form.uricAcidCrystals" placeholder="请输入尿酸结晶" />
      </el-form-item>
      <el-form-item label="鳞状上皮细胞" prop="squamousEpithelialCells">
        <el-input v-model="form.squamousEpithelialCells" placeholder="请输入鳞状上皮细胞" />
      </el-form-item>
      <el-form-item label="磷酸镁铵结晶" prop="magnesiumAmmoniumPhosphateCrystals">
        <el-input v-model="form.magnesiumAmmoniumPhosphateCrystals" placeholder="请输入磷酸镁铵结晶" />
      </el-form-item>
      <el-form-item label="维生素C" prop="vitaminC">
        <el-input v-model="form.vitaminC" placeholder="请输入维生素C" />
      </el-form-item>
      <el-form-item label="白细胞簇" prop="leukocyteClusters">
        <el-input v-model="form.leukocyteClusters" placeholder="请输入白细胞簇" />
      </el-form-item>
      <el-form-item label="黏液丝" prop="mucusThreads">
        <el-input v-model="form.mucusThreads" placeholder="请输入黏液丝" />
      </el-form-item>
      <el-form-item label="酵母菌" prop="yeast">
        <el-input v-model="form.yeast" placeholder="请输入酵母菌" />
      </el-form-item>
      <el-form-item label="杆菌" prop="bacilli">
        <el-input v-model="form.bacilli" placeholder="请输入杆菌" />
      </el-form-item>
      <el-form-item label="红细胞(RBC)/HPF" prop="rbcHPF">
        <el-input v-model="form.rbcHPF" placeholder="请输入红细胞(RBC)/HPF" />
      </el-form-item>
      <el-form-item label="非鳞状上皮细胞" prop="nonSquamousEpithelialCells">
        <el-input v-model="form.nonSquamousEpithelialCells" placeholder="请输入非鳞状上皮细胞" />
      </el-form-item>
      <el-form-item label="精子" prop="spermatozoa">
        <el-input v-model="form.spermatozoa" placeholder="请输入精子" />
      </el-form-item>
      <el-form-item label="鳞状上皮细胞/HPF" prop="squamousEpithelialCellsHPF">
        <el-input v-model="form.squamousEpithelialCellsHPF" placeholder="请输入鳞状上皮细胞/HPF" />
      </el-form-item>
      <el-form-item label="可疑球菌" prop="suspectedCocci">
        <el-input v-model="form.suspectedCocci" placeholder="请输入可疑球菌" />
      </el-form-item>
      <el-form-item label="白细胞(WBC)/HPF" prop="wbcHPF">
        <el-input v-model="form.wbcHPF" placeholder="请输入白细胞(WBC)/HPF" />
      </el-form-item>
      <el-form-item label="细菌" prop="bacteria">
        <el-input v-model="form.bacteria" placeholder="请输入细菌" />
      </el-form-item>
      <el-form-item label="球菌" prop="cocci">
        <el-input v-model="form.cocci" placeholder="请输入球菌" />
      </el-form-item>
      <el-form-item label="磷酸盐结晶" prop="phosphateCrystals">
        <el-input v-model="form.phosphateCrystals" placeholder="请输入磷酸盐结晶" />
      </el-form-item>
      <el-form-item label="一水草酸钙结晶" prop="monohydrateCalciumOxalateCrystals">
        <el-input v-model="form.monohydrateCalciumOxalateCrystals" placeholder="请输入一水草酸钙结晶" />
      </el-form-item>
      <el-form-item label="二水草酸钙结晶" prop="dihydrateCalciumOxalateCrystals">
        <el-input v-model="form.dihydrateCalciumOxalateCrystals" placeholder="请输入二水草酸钙结晶" />
      </el-form-item>

      <!-- 操作说明 -->
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
export default {
  name: "AddurinalysisDialog",
  props: {
    open: Boolean,
    title: String
  },
  data() {
    return {
      localOpen: this.open,
      form: {
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        urinePH: null,
        urineRBC: null,
        urineWBC: null,
        urineSpecificGravity: null,
        urineUrate: null,
        urineAmylase: null,
        hyalineCasts: null,
        pathologicalCasts: null,
        urateCrystals: null,
        calciumOxalateCrystals: null,
        uricAcidCrystals: null,
        squamousEpithelialCells: null,
        magnesiumAmmoniumPhosphateCrystals: null,
        vitaminC: null,
        leukocyteClusters: null,
        mucusThreads: null,
        yeast: null,
        bacilli: null,
        rbcHPF: null,
        nonSquamousEpithelialCells: null,
        spermatozoa: null,
        squamousEpithelialCellsHPF: null,
        suspectedCocci: null,
        wbcHPF: null,
        bacteria: null,
        cocci: null,
        phosphateCrystals: null,
        monohydrateCalciumOxalateCrystals: null,
        dihydrateCalciumOxalateCrystals: null,
        instructions: null
      },
      rules: {
        encounterId: [
          { required: true, message: "病历编号不能为空", trigger: "blur" }
        ],
        hospitalId: [
          { required: true, message: "医院ID不能为空", trigger: "blur" }
        ]
        // 可以根据需要添加更多的验证规则
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
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        urinePH: null,
        urineRBC: null,
        urineWBC: null,
        urineSpecificGravity: null,
        urineUrate: null,
        urineAmylase: null,
        hyalineCasts: null,
        pathologicalCasts: null,
        urateCrystals: null,
        calciumOxalateCrystals: null,
        uricAcidCrystals: null,
        squamousEpithelialCells: null,
        magnesiumAmmoniumPhosphateCrystals: null,
        vitaminC: null,
        leukocyteClusters: null,
        mucusThreads: null,
        yeast: null,
        bacilli: null,
        rbcHPF: null,
        nonSquamousEpithelialCells: null,
        spermatozoa: null,
        squamousEpithelialCellsHPF: null,
        suspectedCocci: null,
        wbcHPF: null,
        bacteria: null,
        cocci: null,
        phosphateCrystals: null,
        monohydrateCalciumOxalateCrystals: null,
        dihydrateCalciumOxalateCrystals: null,
        instructions: null
      };
    },
    submitForm() {
      this.$refs.form.validate(valid => {
        if (valid) {
          console.log('提交表单:', this.form);
          // 这里可以添加实际的表单提交逻辑
          this.localOpen = false;
          this.$emit("update:open", false);
          this.$emit("submit-success");
        } else {
          console.error('验证失败');
          return false;
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