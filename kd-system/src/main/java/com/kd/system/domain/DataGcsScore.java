package com.kd.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 格拉斯哥昏迷评分对象 data_gcs_score
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataGcsScore extends BaseEntity
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

    /** GCS运动评分（1-6分） */
    @Excel(name = "GCS运动评分", readConverterExp = "1=-6分")
    private Long gcsMotor;

    /** GCS睁眼评分（1-4分） */
    @Excel(name = "GCS睁眼评分", readConverterExp = "1=-4分")
    private Long gcsEyeOpening;

    /** GCS评分（3-15分） */
    @Excel(name = "GCS评分", readConverterExp = "3=-15分")
    private Long gcsScore;

    /** GCS言语评分（1-5分） */
    @Excel(name = "GCS言语评分", readConverterExp = "1=-5分")
    private Long gcsVerbalResponse;

    /** GCS总分（3-15分） */
    @Excel(name = "GCS总分", readConverterExp = "3=-15分")
    private Long gcsTotal;

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

    public void setGcsMotor(Long gcsMotor) 
    {
        this.gcsMotor = gcsMotor;
    }

    public Long getGcsMotor() 
    {
        return gcsMotor;
    }

    public void setGcsEyeOpening(Long gcsEyeOpening) 
    {
        this.gcsEyeOpening = gcsEyeOpening;
    }

    public Long getGcsEyeOpening() 
    {
        return gcsEyeOpening;
    }

    public void setGcsScore(Long gcsScore) 
    {
        this.gcsScore = gcsScore;
    }

    public Long getGcsScore() 
    {
        return gcsScore;
    }

    public void setGcsVerbalResponse(Long gcsVerbalResponse) 
    {
        this.gcsVerbalResponse = gcsVerbalResponse;
    }

    public Long getGcsVerbalResponse() 
    {
        return gcsVerbalResponse;
    }

    public void setGcsTotal(Long gcsTotal) 
    {
        this.gcsTotal = gcsTotal;
    }

    public Long getGcsTotal() 
    {
        return gcsTotal;
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
            .append("gcsMotor", getGcsMotor())
            .append("gcsEyeOpening", getGcsEyeOpening())
            .append("gcsScore", getGcsScore())
            .append("gcsVerbalResponse", getGcsVerbalResponse())
            .append("gcsTotal", getGcsTotal())
            .append("Instructions", getInstructions())
            .toString();
    }
}
