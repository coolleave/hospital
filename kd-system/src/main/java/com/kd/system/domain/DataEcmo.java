package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 体外膜肺氧合对象 data_ecmo
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataEcmo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long Id;

    /** 病人标识符 */
    @Excel(name = "病人标识符")
    private Long encounterId;

    /** 医院ID */
    @Excel(name = "医院ID")
    private Long hospitalId;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chartTime;

    /** 实测水温（℃） */
    @Excel(name = "实测水温", readConverterExp = "℃=")
    private BigDecimal ecmoMeasuredWaterTemperature;

    /** 预测水温（℃） */
    @Excel(name = "预测水温", readConverterExp = "℃=")
    private BigDecimal ecmoPredictedWaterTemperature;

    /** 跨膜压（mmHg） */
    @Excel(name = "跨膜压", readConverterExp = "m=mHg")
    private BigDecimal ecmoTransmembranePressureMmhg;

    /** 滤器前压（mmHg） */
    @Excel(name = "滤器前压", readConverterExp = "m=mHg")
    private BigDecimal filterPrePressureMmhg;

    /** 血流量（ml/min） */
    @Excel(name = "血流量", readConverterExp = "m=l/min")
    private BigDecimal ecmoBloodFlowRate;

    /** 气流量（L/min） */
    @Excel(name = "气流量", readConverterExp = "L=/min")
    private BigDecimal ecmoGasFlowLMin;

    /** ECMO开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "ECMO开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ecmoStartTime;

    /** ECMO结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "ECMO结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ecmoEndTime;

    /** SaO2百分比（%） */
    @Excel(name = "SaO2百分比", readConverterExp = "%=")
    private BigDecimal ecmosao2Percent;

    /** 膜肺后压力（mmHg） */
    @Excel(name = "膜肺后压力", readConverterExp = "m=mHg")
    private BigDecimal ecmoMembranePostPressureMmhg;

    /** 转流模式 */
    @Excel(name = "转流模式")
    private String ecmoDiversionMode;

    /** 膜肺前压力（mmHg） */
    @Excel(name = "膜肺前压力", readConverterExp = "m=mHg")
    private BigDecimal ecmoMembranePrePressureMmhg;

    /** 气流量（L） */
    @Excel(name = "气流量", readConverterExp = "L=")
    private BigDecimal gasFlowL;

    /** 泵转速（rpm） */
    @Excel(name = "泵转速", readConverterExp = "r=pm")
    private BigDecimal ecmoPumpSpeed;

    /** 单泵泵速（葡萄糖酸钙，ml/h） */
    @Excel(name = "单泵泵速", readConverterExp = "葡=萄糖酸钙，ml/h")
    private BigDecimal singlePumpSpeedCalciumGlubionate;

    /** 单泵泵速（氯化钙，ml/h） */
    @Excel(name = "单泵泵速", readConverterExp = "氯=化钙，ml/h")
    private BigDecimal singlePumpSpeedCalciumChloride;

    /** 单泵泵速（枸橼酸钠，ml/h） */
    @Excel(name = "单泵泵速", readConverterExp = "枸=橼酸钠，ml/h")
    private BigDecimal singlePumpSpeedSodiumCitrate;

    /** 单泵泵速（肝素/低分子肝素，ml/h） */
    @Excel(name = "单泵泵速", readConverterExp = "肝=素/低分子肝素，ml/h")
    private BigDecimal singlePumpSpeedHeparin;

    /** 操作说明 */
    @Excel(name = "操作说明")
    private String Instructions;

    public void setId(Long Id) 
    {
        this.Id = Id;
    }

    public Long getId() 
    {
        return Id;
    }

    public void setEncounterId(Long encounterId) 
    {
        this.encounterId = encounterId;
    }

    public Long getEncounterId() 
    {
        return encounterId;
    }

    public void setHospitalId(Long hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public Long getHospitalId() 
    {
        return hospitalId;
    }

    public void setChartTime(Date chartTime) 
    {
        this.chartTime = chartTime;
    }

    public Date getChartTime() 
    {
        return chartTime;
    }

    public void setEcmoMeasuredWaterTemperature(BigDecimal ecmoMeasuredWaterTemperature) 
    {
        this.ecmoMeasuredWaterTemperature = ecmoMeasuredWaterTemperature;
    }

    public BigDecimal getEcmoMeasuredWaterTemperature() 
    {
        return ecmoMeasuredWaterTemperature;
    }

    public void setEcmoPredictedWaterTemperature(BigDecimal ecmoPredictedWaterTemperature) 
    {
        this.ecmoPredictedWaterTemperature = ecmoPredictedWaterTemperature;
    }

    public BigDecimal getEcmoPredictedWaterTemperature() 
    {
        return ecmoPredictedWaterTemperature;
    }

    public void setEcmoTransmembranePressureMmhg(BigDecimal ecmoTransmembranePressureMmhg) 
    {
        this.ecmoTransmembranePressureMmhg = ecmoTransmembranePressureMmhg;
    }

    public BigDecimal getEcmoTransmembranePressureMmhg() 
    {
        return ecmoTransmembranePressureMmhg;
    }

    public void setFilterPrePressureMmhg(BigDecimal filterPrePressureMmhg) 
    {
        this.filterPrePressureMmhg = filterPrePressureMmhg;
    }

    public BigDecimal getFilterPrePressureMmhg() 
    {
        return filterPrePressureMmhg;
    }

    public void setEcmoBloodFlowRate(BigDecimal ecmoBloodFlowRate) 
    {
        this.ecmoBloodFlowRate = ecmoBloodFlowRate;
    }

    public BigDecimal getEcmoBloodFlowRate() 
    {
        return ecmoBloodFlowRate;
    }

    public void setEcmoGasFlowLMin(BigDecimal ecmoGasFlowLMin) 
    {
        this.ecmoGasFlowLMin = ecmoGasFlowLMin;
    }

    public BigDecimal getEcmoGasFlowLMin() 
    {
        return ecmoGasFlowLMin;
    }

    public void setEcmoStartTime(Date ecmoStartTime) 
    {
        this.ecmoStartTime = ecmoStartTime;
    }

    public Date getEcmoStartTime() 
    {
        return ecmoStartTime;
    }

    public void setEcmoEndTime(Date ecmoEndTime) 
    {
        this.ecmoEndTime = ecmoEndTime;
    }

    public Date getEcmoEndTime() 
    {
        return ecmoEndTime;
    }

    public void setEcmosao2Percent(BigDecimal ecmosao2Percent) 
    {
        this.ecmosao2Percent = ecmosao2Percent;
    }

    public BigDecimal getEcmosao2Percent() 
    {
        return ecmosao2Percent;
    }

    public void setEcmoMembranePostPressureMmhg(BigDecimal ecmoMembranePostPressureMmhg) 
    {
        this.ecmoMembranePostPressureMmhg = ecmoMembranePostPressureMmhg;
    }

    public BigDecimal getEcmoMembranePostPressureMmhg() 
    {
        return ecmoMembranePostPressureMmhg;
    }

    public void setEcmoDiversionMode(String ecmoDiversionMode) 
    {
        this.ecmoDiversionMode = ecmoDiversionMode;
    }

    public String getEcmoDiversionMode() 
    {
        return ecmoDiversionMode;
    }

    public void setEcmoMembranePrePressureMmhg(BigDecimal ecmoMembranePrePressureMmhg) 
    {
        this.ecmoMembranePrePressureMmhg = ecmoMembranePrePressureMmhg;
    }

    public BigDecimal getEcmoMembranePrePressureMmhg() 
    {
        return ecmoMembranePrePressureMmhg;
    }

    public void setGasFlowL(BigDecimal gasFlowL) 
    {
        this.gasFlowL = gasFlowL;
    }

    public BigDecimal getGasFlowL() 
    {
        return gasFlowL;
    }

    public void setEcmoPumpSpeed(BigDecimal ecmoPumpSpeed) 
    {
        this.ecmoPumpSpeed = ecmoPumpSpeed;
    }

    public BigDecimal getEcmoPumpSpeed() 
    {
        return ecmoPumpSpeed;
    }

    public void setSinglePumpSpeedCalciumGlubionate(BigDecimal singlePumpSpeedCalciumGlubionate) 
    {
        this.singlePumpSpeedCalciumGlubionate = singlePumpSpeedCalciumGlubionate;
    }

    public BigDecimal getSinglePumpSpeedCalciumGlubionate() 
    {
        return singlePumpSpeedCalciumGlubionate;
    }

    public void setSinglePumpSpeedCalciumChloride(BigDecimal singlePumpSpeedCalciumChloride) 
    {
        this.singlePumpSpeedCalciumChloride = singlePumpSpeedCalciumChloride;
    }

    public BigDecimal getSinglePumpSpeedCalciumChloride() 
    {
        return singlePumpSpeedCalciumChloride;
    }

    public void setSinglePumpSpeedSodiumCitrate(BigDecimal singlePumpSpeedSodiumCitrate) 
    {
        this.singlePumpSpeedSodiumCitrate = singlePumpSpeedSodiumCitrate;
    }

    public BigDecimal getSinglePumpSpeedSodiumCitrate() 
    {
        return singlePumpSpeedSodiumCitrate;
    }

    public void setSinglePumpSpeedHeparin(BigDecimal singlePumpSpeedHeparin) 
    {
        this.singlePumpSpeedHeparin = singlePumpSpeedHeparin;
    }

    public BigDecimal getSinglePumpSpeedHeparin() 
    {
        return singlePumpSpeedHeparin;
    }

    public void setInstructions(String Instructions) 
    {
        this.Instructions = Instructions;
    }

    public String getInstructions() 
    {
        return Instructions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("Id", getId())
            .append("encounterId", getEncounterId())
            .append("hospitalId", getHospitalId())
            .append("chartTime", getChartTime())
            .append("ecmoMeasuredWaterTemperature", getEcmoMeasuredWaterTemperature())
            .append("ecmoPredictedWaterTemperature", getEcmoPredictedWaterTemperature())
            .append("ecmoTransmembranePressureMmhg", getEcmoTransmembranePressureMmhg())
            .append("filterPrePressureMmhg", getFilterPrePressureMmhg())
            .append("ecmoBloodFlowRate", getEcmoBloodFlowRate())
            .append("ecmoGasFlowLMin", getEcmoGasFlowLMin())
            .append("ecmoStartTime", getEcmoStartTime())
            .append("ecmoEndTime", getEcmoEndTime())
            .append("ecmosao2Percent", getEcmosao2Percent())
            .append("ecmoMembranePostPressureMmhg", getEcmoMembranePostPressureMmhg())
            .append("ecmoDiversionMode", getEcmoDiversionMode())
            .append("ecmoMembranePrePressureMmhg", getEcmoMembranePrePressureMmhg())
            .append("gasFlowL", getGasFlowL())
            .append("ecmoPumpSpeed", getEcmoPumpSpeed())
            .append("singlePumpSpeedCalciumGlubionate", getSinglePumpSpeedCalciumGlubionate())
            .append("singlePumpSpeedCalciumChloride", getSinglePumpSpeedCalciumChloride())
            .append("singlePumpSpeedSodiumCitrate", getSinglePumpSpeedSodiumCitrate())
            .append("singlePumpSpeedHeparin", getSinglePumpSpeedHeparin())
            .append("Instructions", getInstructions())
            .toString();
    }
}
