<template>
    <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
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
  import { addBalance, updateBalance } from "@/api/system/balance";
  
  export default {
    name: "AddBalanceDialog",
    props: {
      open: Boolean,
      title: String,
      balanceData: Object // 可选参数，用于编辑时传入数据
    },
    data() {
      return {
        localOpen: this.open,
        form: {
          id: null,
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
          instructions: null
        },
        rules: {
          encounterId: [
            { required: true, message: "病例编号不能为空", trigger: "blur" }
          ],
          hospitalId: [
            { required: true, message: "医院ID不能为空", trigger: "blur" }
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
      },
      balanceData: {
        handler(newVal) {
          if (newVal) {
            this.form = { ...newVal }; // 拷贝数据用于编辑
          }
        },
        deep: true,
        immediate: true
      }
    },
    methods: {
      // 父组件通过 ref 调用该方法打开弹窗并重置表单
      handleAdd() {
        this.reset();
        this.localOpen = true;
        this.$emit("update:open", true);
      },
      // 父组件通过 ref 调用该方法打开弹窗并加载编辑数据
      handleUpdate(data) {
        this.reset();
        this.form = { ...data };
        this.localOpen = true;
        this.$emit("update:open", true);
      },
      reset() {
        this.form = {
          id: null,
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
          instructions: null
        };
      },
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {
            const request = this.form.id ? updateBalance(this.form) : addBalance(this.form);
            request.then(response => {
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