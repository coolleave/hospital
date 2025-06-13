    <!-- 添加或修改肝功能生化指标对话框 -->
    <template>
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
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
          <el-form-item label="总蛋白" prop="totalProtein">
            <el-input v-model="form.totalProtein" placeholder="请输入总蛋白" />
          </el-form-item>
          <el-form-item label="白蛋白" prop="albumin">
            <el-input v-model="form.albumin" placeholder="请输入白蛋白" />
          </el-form-item>
          <el-form-item label="球蛋白" prop="globulin">
            <el-input v-model="form.globulin" placeholder="请输入球蛋白" />
          </el-form-item>
          <el-form-item label="总胆红素" prop="totalBilirubin">
            <el-input v-model="form.totalBilirubin" placeholder="请输入总胆红素" />
          </el-form-item>
          <el-form-item label="间接胆红素" prop="indirectBilirubin">
            <el-input v-model="form.indirectBilirubin" placeholder="请输入间接胆红素" />
          </el-form-item>
          <el-form-item label="直接胆红素" prop="directBilirubin">
            <el-input v-model="form.directBilirubin" placeholder="请输入直接胆红素" />
          </el-form-item>
          <el-form-item label="天冬氨酸氨基转移酶" prop="aspartateAminotransferase">
            <el-input v-model="form.aspartateAminotransferase" placeholder="请输入天冬氨酸氨基转移酶" />
          </el-form-item>
          <el-form-item label="丙氨酸氨基转移酶(SGPT)" prop="alanineAminotransferase">
            <el-input v-model="form.alanineAminotransferase" placeholder="请输入丙氨酸氨基转移酶(SGPT)" />
          </el-form-item>
          <el-form-item label="碱性磷酸酶" prop="alkalinePhosphatase">
            <el-input v-model="form.alkalinePhosphatase" placeholder="请输入碱性磷酸酶" />
          </el-form-item>
          <el-form-item label="同型半胱氨酸" prop="homocysteine">
            <el-input v-model="form.homocysteine" placeholder="请输入同型半胱氨酸" />
          </el-form-item>
          <el-form-item label="总胆汁酸" prop="totalBileAcids">
            <el-input v-model="form.totalBileAcids" placeholder="请输入总胆汁酸" />
          </el-form-item>
          <el-form-item label="γ谷氨酰转肽酶" prop="gammaGlutamylTransferase">
            <el-input v-model="form.gammaGlutamylTransferase" placeholder="请输入γ谷氨酰转肽酶" />
          </el-form-item>
          <el-form-item label="乳酸脱氢酶" prop="lactateDehydrogenase">
            <el-input v-model="form.lactateDehydrogenase" placeholder="请输入乳酸脱氢酶" />
          </el-form-item>
          <el-form-item label="羟丁酸脱氢酶" prop="hydroxybutyrateDehydrogenase">
            <el-input v-model="form.hydroxybutyrateDehydrogenase" placeholder="请输入羟丁酸脱氢酶" />
          </el-form-item>
          <el-form-item label="血清淀粉样蛋白A" prop="serumAmyloidA">
            <el-input v-model="form.serumAmyloidA" placeholder="请输入血清淀粉样蛋白A" />
          </el-form-item>
          <el-form-item label="谷草比谷丙" prop="astToAltRatio">
            <el-input v-model="form.astToAltRatio" placeholder="请输入谷草比谷丙" />
          </el-form-item>
          <el-form-item label="前白蛋白" prop="prealbumin">
            <el-input v-model="form.prealbumin" placeholder="请输入前白蛋白" />
          </el-form-item>
          <el-form-item label="胆碱酯酶" prop="cholinesterase">
            <el-input v-model="form.cholinesterase" placeholder="请输入胆碱酯酶" />
          </el-form-item>
          <el-form-item label="肌酐" prop="creatinine">
            <el-input v-model="form.creatinine" placeholder="请输入肌酐" />
          </el-form-item>
          <el-form-item label="尿素氮" prop="ureaNitrogen">
            <el-input v-model="form.ureaNitrogen" placeholder="请输入尿素氮" />
          </el-form-item>
          <el-form-item label="肾小球滤过率" prop="glomerularFiltrationRate">
            <el-input v-model="form.glomerularFiltrationRate" placeholder="请输入肾小球滤过率" />
          </el-form-item>
          <el-form-item label="血清胱抑素C" prop="serumCystatinC">
            <el-input v-model="form.serumCystatinC" placeholder="请输入血清胱抑素C" />
          </el-form-item>
          <el-form-item label="钾" prop="potassium">
            <el-input v-model="form.potassium" placeholder="请输入钾" />
          </el-form-item>
          <el-form-item label="钙" prop="calcium">
            <el-input v-model="form.calcium" placeholder="请输入钙" />
          </el-form-item>
          <el-form-item label="氯" prop="chloride">
            <el-input v-model="form.chloride" placeholder="请输入氯" />
          </el-form-item>
          <el-form-item label="钠" prop="sodium">
            <el-input v-model="form.sodium" placeholder="请输入钠" />
          </el-form-item>
          <el-form-item label="二氧化碳总量" prop="totalCarbonDioxide">
            <el-input v-model="form.totalCarbonDioxide" placeholder="请输入二氧化碳总量" />
          </el-form-item>
          <el-form-item label="镁" prop="magnesium">
            <el-input v-model="form.magnesium" placeholder="请输入镁" />
          </el-form-item>
          <el-form-item label="磷" prop="phosphorus">
            <el-input v-model="form.phosphorus" placeholder="请输入磷" />
          </el-form-item>
          <el-form-item label="阴离子间隙" prop="anionGap">
            <el-input v-model="form.anionGap" placeholder="请输入阴离子间隙" />
          </el-form-item>
          <el-form-item label="渗透压" prop="osmolality">
            <el-input v-model="form.osmolality" placeholder="请输入渗透压" />
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
  </template>

<script>
import { addBiochemistry, getBiochemistry } from "@/api/system/biochemistry";
import { getToken } from "@/utils/auth";
 
export default {
  name: "AddbiochemistryDialog", // 更改名字为 BiochemistryDialog
  props: {
    open: Boolean,
    title: String
  },
  data() {
    return {
      localOpen: this.open,
      form: {
        Id: null,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        totalProtein: null,
        albumin: null,
        globulin: null,
        totalBilirubin: null,
        indirectBilirubin: null,
        directBilirubin: null,
        aspartateAminotransferase: null,
        alanineAminotransferase: null,
        alkalinePhosphatase: null,
        homocysteine: null,
        totalBileAcids: null,
        gammaGlutamylTransferase: null,
        lactateDehydrogenase: null,
        hydroxybutyrateDehydrogenase: null,
        serumAmyloidA: null,
        astToAltRatio: null,
        prealbumin: null,
        cholinesterase: null,
        creatinine: null,
        ureaNitrogen: null,
        glomerularFiltrationRate: null,
        serumCystatinC: null,
        potassium: null,
        calcium: null,
        chloride: null,
        sodium: null,
        totalCarbonDioxide: null,
        magnesium: null,
        phosphorus: null,
        anionGap: null,
        osmolality: null,
        Instructions: null
      },
      rules: {
        // 根据需要添加表单验证规则
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
        Id: null,
        encounterId: null,
        hospitalId: null,
        chartTime: null,
        totalProtein: null,
        albumin: null,
        globulin: null,
        totalBilirubin: null,
        indirectBilirubin: null,
        directBilirubin: null,
        aspartateAminotransferase: null,
        alanineAminotransferase: null,
        alkalinePhosphatase: null,
        homocysteine: null,
        totalBileAcids: null,
        gammaGlutamylTransferase: null,
        lactateDehydrogenase: null,
        hydroxybutyrateDehydrogenase: null,
        serumAmyloidA: null,
        astToAltRatio: null,
        prealbumin: null,
        cholinesterase: null,
        creatinine: null,
        ureaNitrogen: null,
        glomerularFiltrationRate: null,
        serumCystatinC: null,
        potassium: null,
        calcium: null,
        chloride: null,
        sodium: null,
        totalCarbonDioxide: null,
        magnesium: null,
        phosphorus: null,
        anionGap: null,
        osmolality: null,
        Instructions: null
      };
    },
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.Id != null) {
            updateBiochemistry(this.form).then(response => {
              this.$message.success("修改成功");
              this.localOpen = false;
              this.$emit("update:open", false);
              this.$emit("submit-success");
            }).catch(err => {
              console.error("提交失败：", err);
              this.$message.error("提交失败，请检查输入或网络");
            });
          } else {
            addBiochemistry(this.form).then(response => {
              this.$message.success("新增成功");
              this.localOpen = false;
              this.$emit("update:open", false);
              this.$emit("submit-success");
            }).catch(err => {
              console.error("提交失败：", err);
              this.$message.error("提交失败，请检查输入或网络");
            });
          }
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