package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 生理评分对象 data_apache_score
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataApacheScore extends BaseEntity
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

    /** 计算状态 */
    @Excel(name = "计算状态")
    private String apacheiiComputedStatus;

    /** 默认计算观测值状态 */
    @Excel(name = "默认计算观测值状态")
    private String apacheiiDefaultComputedObservationStatus;

    /** 体温（℃） */
    @Excel(name = "体温", readConverterExp = "℃=")
    private BigDecimal apacheiiTemperature;

    /** 评估时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评估时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date apacheiiAssessmentTime;

    /** 患者年龄（岁） */
    @Excel(name = "患者年龄", readConverterExp = "岁=")
    private Long apacheiiAge;

    /** APACHEII总分（0-71分） */
    @Excel(name = "APACHEII总分", readConverterExp = "0=-71分")
    private Long apacheiiTotalScore;

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

    public void setApacheiiComputedStatus(String apacheiiComputedStatus) 
    {
        this.apacheiiComputedStatus = apacheiiComputedStatus;
    }

    public String getApacheiiComputedStatus() 
    {
        return apacheiiComputedStatus;
    }

    public void setApacheiiDefaultComputedObservationStatus(String apacheiiDefaultComputedObservationStatus) 
    {
        this.apacheiiDefaultComputedObservationStatus = apacheiiDefaultComputedObservationStatus;
    }

    public String getApacheiiDefaultComputedObservationStatus() 
    {
        return apacheiiDefaultComputedObservationStatus;
    }

    public void setApacheiiTemperature(BigDecimal apacheiiTemperature) 
    {
        this.apacheiiTemperature = apacheiiTemperature;
    }

    public BigDecimal getApacheiiTemperature() 
    {
        return apacheiiTemperature;
    }

    public void setApacheiiAssessmentTime(Date apacheiiAssessmentTime) 
    {
        this.apacheiiAssessmentTime = apacheiiAssessmentTime;
    }

    public Date getApacheiiAssessmentTime() 
    {
        return apacheiiAssessmentTime;
    }

    public void setApacheiiAge(Long apacheiiAge) 
    {
        this.apacheiiAge = apacheiiAge;
    }

    public Long getApacheiiAge() 
    {
        return apacheiiAge;
    }

    public void setApacheiiTotalScore(Long apacheiiTotalScore) 
    {
        this.apacheiiTotalScore = apacheiiTotalScore;
    }

    public Long getApacheiiTotalScore() 
    {
        return apacheiiTotalScore;
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
            .append("apacheiiComputedStatus", getApacheiiComputedStatus())
            .append("apacheiiDefaultComputedObservationStatus", getApacheiiDefaultComputedObservationStatus())
            .append("apacheiiTemperature", getApacheiiTemperature())
            .append("apacheiiAssessmentTime", getApacheiiAssessmentTime())
            .append("apacheiiAge", getApacheiiAge())
            .append("apacheiiTotalScore", getApacheiiTotalScore())
            .append("Instructions", getInstructions())
            .toString();
    }
}
