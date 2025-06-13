package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 血氧分析对象 data_blood_gas
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataBloodGas extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
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

    /** 血清钾浓度  */
    @Excel(name = "血清钾浓度 ")
    private BigDecimal cK;

    /** 动脉氧分压  */
    @Excel(name = "动脉氧分压 ")
    private BigDecimal pO2;

    /** 碱剩余  */
    @Excel(name = "碱剩余 ")
    private BigDecimal cBase;

    /** 血清钙离子浓度  */
    @Excel(name = "血清钙离子浓度 ")
    private BigDecimal cCa2;

    /** 红细胞比容 */
    @Excel(name = "红细胞比容")
    private BigDecimal Hct;

    /** pH值 */
    @Excel(name = "pH值")
    private BigDecimal pH;

    /** 总血红蛋白含量  */
    @Excel(name = "总血红蛋白含量 ")
    private BigDecimal ctHb;

    /** 血清氯离子浓度  */
    @Excel(name = "血清氯离子浓度 ")
    private BigDecimal cCl;

    /** 血清钠离子浓度  */
    @Excel(name = "血清钠离子浓度 ")
    private BigDecimal cNa;

    /** 动脉二氧化碳分压  */
    @Excel(name = "动脉二氧化碳分压 ")
    private BigDecimal pCO2;

    /** 氧气分数  */
    @Excel(name = "氧气分数 ")
    private BigDecimal FO2;

    /** 血乳酸浓度  */
    @Excel(name = "血乳酸浓度 ")
    private BigDecimal cLac;

    /** 碳酸氢盐浓度  */
    @Excel(name = "碳酸氢盐浓度 ")
    private BigDecimal cHCO3;

    /** 动脉-肺泡氧分压差  */
    @Excel(name = "动脉-肺泡氧分压差 ")
    private BigDecimal AaDpO2;

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

    public void setCK(BigDecimal cK) 
    {
        this.cK = cK;
    }

    public BigDecimal getCK() 
    {
        return cK;
    }

    public void setpO2(BigDecimal pO2) 
    {
        this.pO2 = pO2;
    }

    public BigDecimal getpO2() 
    {
        return pO2;
    }

    public void setcBase(BigDecimal cBase) 
    {
        this.cBase = cBase;
    }

    public BigDecimal getcBase() 
    {
        return cBase;
    }

    public void setcCa2(BigDecimal cCa2) 
    {
        this.cCa2 = cCa2;
    }

    public BigDecimal getcCa2() 
    {
        return cCa2;
    }

    public void setHct(BigDecimal Hct) 
    {
        this.Hct = Hct;
    }

    public BigDecimal getHct() 
    {
        return Hct;
    }

    public void setPH(BigDecimal pH) 
    {
        this.pH = pH;
    }

    public BigDecimal getPH() 
    {
        return pH;
    }

    public void setCtHb(BigDecimal ctHb) 
    {
        this.ctHb = ctHb;
    }

    public BigDecimal getCtHb() 
    {
        return ctHb;
    }

    public void setcCl(BigDecimal cCl) 
    {
        this.cCl = cCl;
    }

    public BigDecimal getcCl() 
    {
        return cCl;
    }

    public void setcNa(BigDecimal cNa) 
    {
        this.cNa = cNa;
    }

    public BigDecimal getcNa() 
    {
        return cNa;
    }

    public void setpCO2(BigDecimal pCO2) 
    {
        this.pCO2 = pCO2;
    }

    public BigDecimal getpCO2() 
    {
        return pCO2;
    }

    public void setFO2(BigDecimal FO2) 
    {
        this.FO2 = FO2;
    }

    public BigDecimal getFO2() 
    {
        return FO2;
    }

    public void setcLac(BigDecimal cLac) 
    {
        this.cLac = cLac;
    }

    public BigDecimal getcLac() 
    {
        return cLac;
    }

    public void setcHCO3(BigDecimal cHCO3) 
    {
        this.cHCO3 = cHCO3;
    }

    public BigDecimal getcHCO3() 
    {
        return cHCO3;
    }

    public void setAaDpO2(BigDecimal AaDpO2) 
    {
        this.AaDpO2 = AaDpO2;
    }

    public BigDecimal getAaDpO2() 
    {
        return AaDpO2;
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
            .append("cK", getCK())
            .append("pO2", getpO2())
            .append("cBase", getcBase())
            .append("cCa2", getcCa2())
            .append("Hct", getHct())
            .append("pH", getPH())
            .append("ctHb", getCtHb())
            .append("cCl", getcCl())
            .append("cNa", getcNa())
            .append("pCO2", getpCO2())
            .append("FO2", getFO2())
            .append("cLac", getcLac())
            .append("cHCO3", getcHCO3())
            .append("AaDpO2", getAaDpO2())
            .append("Instructions", getInstructions())
            .toString();
    }
}
