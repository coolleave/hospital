package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 生命体征对象 data_vitalsign
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataVitalsign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long Id;

    /** 病例编号 */
    @Excel(name = "病例编号")
    private Long encounterId;

    /** 医院ID */
    @Excel(name = "医院ID")
    private Long hospitalId;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chartTime;

    /** 体温 */
    @Excel(name = "体温")
    private BigDecimal temperature;

    /** 心率 */
    @Excel(name = "心率")
    private BigDecimal heartRate;

    /** 呼吸频率 */
    @Excel(name = "呼吸频率")
    private BigDecimal respiratoryRate;

    /** 收缩压非侵入性血压 */
    @Excel(name = "收缩压非侵入性血压")
    private BigDecimal systolicNIBP;

    /** 舒张压非侵入性血压 */
    @Excel(name = "舒张压非侵入性血压")
    private BigDecimal diastolicNIBP;

    /** 平均非侵入性血压 */
    @Excel(name = "平均非侵入性血压")
    private BigDecimal meanNIBP;

    /** 收缩压动脉血压 */
    @Excel(name = "收缩压动脉血压")
    private BigDecimal systolicABP;

    /** 舒张压动脉血压 */
    @Excel(name = "舒张压动脉血压")
    private BigDecimal diastolicABP;

    /** 平均动脉血压 */
    @Excel(name = "平均动脉血压")
    private BigDecimal meanABP;

    /** 血氧饱和度 */
    @Excel(name = "血氧饱和度")
    private BigDecimal oxygenSaturation;

    /** 代表中心静脉压 */
    @Excel(name = "代表中心静脉压")
    private BigDecimal centralvenouspressureMmhg;

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

    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }

    public void setHeartRate(BigDecimal heartRate) 
    {
        this.heartRate = heartRate;
    }

    public BigDecimal getHeartRate() 
    {
        return heartRate;
    }

    public void setRespiratoryRate(BigDecimal respiratoryRate) 
    {
        this.respiratoryRate = respiratoryRate;
    }

    public BigDecimal getRespiratoryRate() 
    {
        return respiratoryRate;
    }

    public void setSystolicNIBP(BigDecimal systolicNIBP) 
    {
        this.systolicNIBP = systolicNIBP;
    }

    public BigDecimal getSystolicNIBP() 
    {
        return systolicNIBP;
    }

    public void setDiastolicNIBP(BigDecimal diastolicNIBP) 
    {
        this.diastolicNIBP = diastolicNIBP;
    }

    public BigDecimal getDiastolicNIBP() 
    {
        return diastolicNIBP;
    }

    public void setMeanNIBP(BigDecimal meanNIBP) 
    {
        this.meanNIBP = meanNIBP;
    }

    public BigDecimal getMeanNIBP() 
    {
        return meanNIBP;
    }

    public void setSystolicABP(BigDecimal systolicABP) 
    {
        this.systolicABP = systolicABP;
    }

    public BigDecimal getSystolicABP() 
    {
        return systolicABP;
    }

    public void setDiastolicABP(BigDecimal diastolicABP) 
    {
        this.diastolicABP = diastolicABP;
    }

    public BigDecimal getDiastolicABP() 
    {
        return diastolicABP;
    }

    public void setMeanABP(BigDecimal meanABP) 
    {
        this.meanABP = meanABP;
    }

    public BigDecimal getMeanABP() 
    {
        return meanABP;
    }

    public void setOxygenSaturation(BigDecimal oxygenSaturation) 
    {
        this.oxygenSaturation = oxygenSaturation;
    }

    public BigDecimal getOxygenSaturation() 
    {
        return oxygenSaturation;
    }

    public void setCentralvenouspressureMmhg(BigDecimal centralvenouspressureMmhg) 
    {
        this.centralvenouspressureMmhg = centralvenouspressureMmhg;
    }

    public BigDecimal getCentralvenouspressureMmhg() 
    {
        return centralvenouspressureMmhg;
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
            .append("temperature", getTemperature())
            .append("heartRate", getHeartRate())
            .append("respiratoryRate", getRespiratoryRate())
            .append("systolicNIBP", getSystolicNIBP())
            .append("diastolicNIBP", getDiastolicNIBP())
            .append("meanNIBP", getMeanNIBP())
            .append("systolicABP", getSystolicABP())
            .append("diastolicABP", getDiastolicABP())
            .append("meanABP", getMeanABP())
            .append("oxygenSaturation", getOxygenSaturation())
            .append("centralvenouspressureMmhg", getCentralvenouspressureMmhg())
            .append("Instructions", getInstructions())
            .toString();
    }
}
