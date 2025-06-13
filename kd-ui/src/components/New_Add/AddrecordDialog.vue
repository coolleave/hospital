<template>
    <el-dialog :title="title" :visible.sync="localOpen" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="病人标识符" prop="encounterId">
          <el-input v-model="form.encounterId" placeholder="请输入病人标识符" />
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
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="执行时间" prop="Time">
          <el-date-picker
            clearable
            v-model="form.Time"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择执行时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="医疗行为" prop="Instructions">
          <el-input v-model="form.Instructions" type="textarea" :rows="3" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
  
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </div>
    </el-dialog>
  </template>
  
  <script>
  import { addRecord } from "@/api/system/record";
  
  export default {
    name: "AddRecordDialog",
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
          encounterId: "",
          hospitalId: "",
          chartTime: "",
          Time: "",
          Instructions: ""
        },
        rules: {
          encounterId: [
            { required: true, message: "病人标识符不能为空", trigger: "blur" }
          ],
          hospitalId: [
            { required: true, message: "医院ID不能为空", trigger: "blur" }
          ],
          chartTime: [
            { required: true, message: "记录时间不能为空", trigger: "blur" }
          ],
          Time: [
            { required: true, message: "执行时间不能为空", trigger: "blur" }
          ],
          Instructions: [
            { required: true, message: "医疗行为不能为空", trigger: "blur" }
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
      // 父组件可以通过 ref 调用这个方法来打开弹窗并重置表单
      handleAdd() {
        this.reset();
        this.localOpen = true;
        this.$emit("update:open", true);
      },
      reset() {
        this.form = {
          id: null,
          encounterId: "",
          hospitalId: "",
          chartTime: "",
          Time: "",
          Instructions: ""
        };
      },
      submitForm() {
        this.$refs.form.validate(valid => {
          if (valid) {
            addRecord(this.form)
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