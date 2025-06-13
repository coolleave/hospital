package com.kd.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 重症护理疼痛观察对象 data_cpot_score
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataCpotScore extends BaseEntity
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

    /** 面部表情 */
    @Excel(name = "面部表情")
    private Long cpotFacialExpression;

    /** CPOT人机协调（气切/插管者）（0-2分） */
    @Excel(name = "CPOT人机协调", readConverterExp = "气=切/插管者")
    private Long cpotSynchronyWithVentilator;

    /** CPOT发声（无气切/插管者）（0-2分） */
    @Excel(name = "CPOT发声", readConverterExp = "无=气切/插管者")
    private Long cpotVocalizationWithoutTracheostomyOrIntubation;

    /** 使用的镇痛药物 */
    @Excel(name = "使用的镇痛药物")
    private String cpotAnalgesics;

    /** 提示信息 */
    @Excel(name = "提示信息")
    private String cpotCue;

    /** CPOT肢体运动（0-2分） */
    @Excel(name = "CPOT肢体运动", readConverterExp = "0=-2分")
    private Long cpotLimbMovement;

    /** CPOT肌肉张力（0-2分） */
    @Excel(name = "CPOT肌肉张力", readConverterExp = "0=-2分")
    private Long cpotMuscleTension;

    /** CPOT总分（0-8分） */
    @Excel(name = "CPOT总分", readConverterExp = "0=-8分")
    private Long cpotTotal;

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

    public void setCpotFacialExpression(Long cpotFacialExpression) 
    {
        this.cpotFacialExpression = cpotFacialExpression;
    }

    public Long getCpotFacialExpression() 
    {
        return cpotFacialExpression;
    }

    public void setCpotSynchronyWithVentilator(Long cpotSynchronyWithVentilator) 
    {
        this.cpotSynchronyWithVentilator = cpotSynchronyWithVentilator;
    }

    public Long getCpotSynchronyWithVentilator() 
    {
        return cpotSynchronyWithVentilator;
    }

    public void setCpotVocalizationWithoutTracheostomyOrIntubation(Long cpotVocalizationWithoutTracheostomyOrIntubation) 
    {
        this.cpotVocalizationWithoutTracheostomyOrIntubation = cpotVocalizationWithoutTracheostomyOrIntubation;
    }

    public Long getCpotVocalizationWithoutTracheostomyOrIntubation() 
    {
        return cpotVocalizationWithoutTracheostomyOrIntubation;
    }

    public void setCpotAnalgesics(String cpotAnalgesics) 
    {
        this.cpotAnalgesics = cpotAnalgesics;
    }

    public String getCpotAnalgesics() 
    {
        return cpotAnalgesics;
    }

    public void setCpotCue(String cpotCue) 
    {
        this.cpotCue = cpotCue;
    }

    public String getCpotCue() 
    {
        return cpotCue;
    }

    public void setCpotLimbMovement(Long cpotLimbMovement) 
    {
        this.cpotLimbMovement = cpotLimbMovement;
    }

    public Long getCpotLimbMovement() 
    {
        return cpotLimbMovement;
    }

    public void setCpotMuscleTension(Long cpotMuscleTension) 
    {
        this.cpotMuscleTension = cpotMuscleTension;
    }

    public Long getCpotMuscleTension() 
    {
        return cpotMuscleTension;
    }

    public void setCpotTotal(Long cpotTotal) 
    {
        this.cpotTotal = cpotTotal;
    }

    public Long getCpotTotal() 
    {
        return cpotTotal;
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
            .append("cpotFacialExpression", getCpotFacialExpression())
            .append("cpotSynchronyWithVentilator", getCpotSynchronyWithVentilator())
            .append("cpotVocalizationWithoutTracheostomyOrIntubation", getCpotVocalizationWithoutTracheostomyOrIntubation())
            .append("cpotAnalgesics", getCpotAnalgesics())
            .append("cpotCue", getCpotCue())
            .append("cpotLimbMovement", getCpotLimbMovement())
            .append("cpotMuscleTension", getCpotMuscleTension())
            .append("cpotTotal", getCpotTotal())
            .append("Instructions", getInstructions())
            .toString();
    }
}
