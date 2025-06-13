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
            <el-form-item label="实测水温" prop="ecmoMeasuredWaterTemperature">
                <el-input v-model="form.ecmoMeasuredWaterTemperature" placeholder="请输入实测水温" />
            </el-form-item>
            <el-form-item label="预测水温" prop="ecmoPredictedWaterTemperature">
                <el-input v-model="form.ecmoPredictedWaterTemperature" placeholder="请输入预测水温" />
            </el-form-item>
            <el-form-item label="跨膜压" prop="ecmoTransmembranePressureMmhg">
                <el-input v-model="form.ecmoTransmembranePressureMmhg" placeholder="请输入跨膜压" />
            </el-form-item>
            <el-form-item label="滤器前压" prop="filterPrePressureMmhg">
                <el-input v-model="form.filterPrePressureMmhg" placeholder="请输入滤器前压" />
            </el-form-item>
            <el-form-item label="血流量" prop="ecmoBloodFlowRate">
                <el-input v-model="form.ecmoBloodFlowRate" placeholder="请输入血流量" />
            </el-form-item>
            <el-form-item label="气流量" prop="ecmoGasFlowLMin">
                <el-input v-model="form.ecmoGasFlowLMin" placeholder="请输入气流量" />
            </el-form-item>
            <el-form-item label="ECMO开始时间" prop="ecmoStartTime">
                <el-date-picker 
                    clearable
                    v-model="form.ecmoStartTime"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="请选择ECMO开始时间"
                />
            </el-form-item>
            <el-form-item label="ECMO结束时间" prop="ecmoEndTime">
                <el-date-picker 
                    clearable
                    v-model="form.ecmoEndTime"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="请选择ECMO结束时间"
                />
            </el-form-item>
            <el-form-item label="SaO2百分比" prop="ecmosao2Percent">
                <el-input v-model="form.ecmosao2Percent" placeholder="请输入SaO2百分比" />
            </el-form-item>
            <el-form-item label="膜肺后压力" prop="ecmoMembranePostPressureMmhg">
                <el-input v-model="form.ecmoMembranePostPressureMmhg" placeholder="请输入膜肺后压力" />
            </el-form-item>
            <el-form-item label="转流模式" prop="ecmoDiversionMode">
                <el-input v-model="form.ecmoDiversionMode" placeholder="请输入转流模式" />
            </el-form-item>
            <el-form-item label="膜肺前压力" prop="ecmoMembranePrePressureMmhg">
                <el-input v-model="form.ecmoMembranePrePressureMmhg" placeholder="请输入膜肺前压力" />
            </el-form-item>
            <el-form-item label="气流量" prop="gasFlowL">
                <el-input v-model="form.gasFlowL" placeholder="请输入气流量" />
            </el-form-item>
            <el-form-item label="泵转速" prop="ecmoPumpSpeed">
                <el-input v-model="form.ecmoPumpSpeed" placeholder="请输入泵转速" />
            </el-form-item>
            <el-form-item label="单泵泵速(葡萄糖酸钙)" prop="singlePumpSpeedCalciumGlubionate">
                <el-input v-model="form.singlePumpSpeedCalciumGlubionate" placeholder="请输入单泵泵速" />
            </el-form-item>
            <el-form-item label="单泵泵速(氯化钙)" prop="singlePumpSpeedCalciumChloride">
                <el-input v-model="form.singlePumpSpeedCalciumChloride" placeholder="请输入单泵泵速" />
            </el-form-item>
            <el-form-item label="单泵泵速(柠檬酸钠)" prop="singlePumpSpeedSodiumCitrate">
                <el-input v-model="form.singlePumpSpeedSodiumCitrate" placeholder="请输入单泵泵速" />
            </el-form-item>
            <el-form-item label="单泵泵速(肝素)" prop="singlePumpSpeedHeparin">
                <el-input v-model="form.singlePumpSpeedHeparin" placeholder="请输入单泵泵速" />
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
import { addEcmo, updateEcmo } from "@/api/system/ecmo";

export default {
    name: "AddecmoDialog",
    props: {
        open: Boolean,
        title: String,
        record: Object
    },
    data() {
        return {
            localOpen: this.open,
            form: {
                id: null,
                encounterId: null,
                hospitalId: null,
                chartTime: null,
                ecmoMeasuredWaterTemperature: null,
                ecmoPredictedWaterTemperature: null,
                ecmoTransmembranePressureMmhg: null,
                filterPrePressureMmhg: null,
                ecmoBloodFlowRate: null,
                ecmoGasFlowLMin: null,
                ecmoStartTime: null,
                ecmoEndTime: null,
                ecmosao2Percent: null,
                ecmoMembranePostPressureMmhg: null,
                ecmoDiversionMode: null,
                ecmoMembranePrePressureMmhg: null,
                gasFlowL: null,
                ecmoPumpSpeed: null,
                singlePumpSpeedCalciumGlubionate: null,
                singlePumpSpeedCalciumChloride: null,
                singlePumpSpeedSodiumCitrate: null,
                singlePumpSpeedHeparin: null,
                instructions: null
            },
            rules: {
                encounterId: [
                    { required: true, message: "病历编号不能为空", trigger: "blur" }
                ],
                chartTime: [
                    { required: true, message: "记录时间不能为空", trigger: "change" }
                ],
                ecmoStartTime: [
                    { required: true, message: "ECMO开始时间不能为空", trigger: "change" }
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
        record(newVal) {
            if (newVal && newVal.id) {
                this.form = { ...newVal };
            } else {
                this.reset();
            }
        }
    },
    methods: {
        reset() {
            this.form = {
                id: null,
                encounterId: null,
                hospitalId: null,
                chartTime: null,
                ecmoMeasuredWaterTemperature: null,
                ecmoPredictedWaterTemperature: null,
                ecmoTransmembranePressureMmhg: null,
                filterPrePressureMmhg: null,
                ecmoBloodFlowRate: null,
                ecmoGasFlowLMin: null,
                ecmoStartTime: null,
                ecmoEndTime: null,
                ecmosao2Percent: null,
                ecmoMembranePostPressureMmhg: null,
                ecmoDiversionMode: null,
                ecmoMembranePrePressureMmhg: null,
                gasFlowL: null,
                ecmoPumpSpeed: null,
                singlePumpSpeedCalciumGlubionate: null,
                singlePumpSpeedCalciumChloride: null,
                singlePumpSpeedSodiumCitrate: null,
                singlePumpSpeedHeparin: null,
                instructions: null
            };
        },
        handleAdd() {
            this.reset();
            this.localOpen = true;
            this.$emit("update:open", true);
        },
        submitForm() {
            this.$refs.form.validate(valid => {
                if (valid) {
                    const apiMethod = this.form.id ? updateEcmo : addEcmo;
                    apiMethod(this.form).then(response => {
                        this.$message.success(this.form.id ? "修改成功" : "新增成功");
                        this.localOpen = false;
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