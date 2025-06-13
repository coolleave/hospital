package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 病例管理对象 data_basesign
 * 
 * @author kd
 * @date 2025-05-08
 */
public class DataBasesign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @Excel(name = "主键ID")
    private Long Id;

    /** 身份ID */
    @Excel(name = "身份ID")
    private Long idcard;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 医院ID */
    @Excel(name = "医院ID")
    private String hospitalId;

    /** 插入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "插入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chartTime;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateOfBirth;

    /** 身高（厘米） */
    @Excel(name = "身高")
    private BigDecimal heightCm;

    /** 体重（千克） */
    @Excel(name = "体重")
    private BigDecimal weightKg;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 入院诊断 */
    @Excel(name = "入院诊断")
    private String admissionDiagnosis;

    /** 入院时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入院时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departmentAdmissionTime;

    /** 出院时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出院时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departmentDischargeTime;

    /** 出院结果 */
    @Excel(name = "出院结果")
    private String dischargeOutcome;

    /** 死亡时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "死亡时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date timeOfDeath;

    public void setId(Long Id) 
    {
        this.Id = Id;
    }

    public Long getId() 
    {
        return Id;
    }

    public void setIdcard(Long idcard) 
    {
        this.idcard = idcard;
    }

    public Long getIdcard() 
    {
        return idcard;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setHospitalId(String hospitalId) 
    {
        this.hospitalId = hospitalId;
    }

    public String getHospitalId() 
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

    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }

    public void setDateOfBirth(Date dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() 
    {
        return dateOfBirth;
    }

    public void setHeightCm(BigDecimal heightCm) 
    {
        this.heightCm = heightCm;
    }

    public BigDecimal getHeightCm() 
    {
        return heightCm;
    }

    public void setWeightKg(BigDecimal weightKg) 
    {
        this.weightKg = weightKg;
    }

    public BigDecimal getWeightKg() 
    {
        return weightKg;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setAdmissionDiagnosis(String admissionDiagnosis) 
    {
        this.admissionDiagnosis = admissionDiagnosis;
    }

    public String getAdmissionDiagnosis() 
    {
        return admissionDiagnosis;
    }

    public void setDepartmentAdmissionTime(Date departmentAdmissionTime) 
    {
        this.departmentAdmissionTime = departmentAdmissionTime;
    }

    public Date getDepartmentAdmissionTime() 
    {
        return departmentAdmissionTime;
    }

    public void setDepartmentDischargeTime(Date departmentDischargeTime) 
    {
        this.departmentDischargeTime = departmentDischargeTime;
    }

    public Date getDepartmentDischargeTime() 
    {
        return departmentDischargeTime;
    }

    public void setDischargeOutcome(String dischargeOutcome) 
    {
        this.dischargeOutcome = dischargeOutcome;
    }

    public String getDischargeOutcome() 
    {
        return dischargeOutcome;
    }

    public void setTimeOfDeath(Date timeOfDeath) 
    {
        this.timeOfDeath = timeOfDeath;
    }

    public Date getTimeOfDeath() 
    {
        return timeOfDeath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("Id", getId())
            .append("idcard", getIdcard())
            .append("name", getName())
            .append("hospitalId", getHospitalId())
            .append("chartTime", getChartTime())
            .append("age", getAge())
            .append("dateOfBirth", getDateOfBirth())
            .append("heightCm", getHeightCm())
            .append("weightKg", getWeightKg())
            .append("gender", getGender())
            .append("admissionDiagnosis", getAdmissionDiagnosis())
            .append("departmentAdmissionTime", getDepartmentAdmissionTime())
            .append("departmentDischargeTime", getDepartmentDischargeTime())
            .append("dischargeOutcome", getDischargeOutcome())
            .append("timeOfDeath", getTimeOfDeath())
            .toString();
    }
}
