package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 心输出量监测对象 data_picco
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataPicco extends BaseEntity
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

    /** 心输出量(Cardiac Output, L/min) */
    @Excel(name = "心输出量(Cardiac Output, L/min)")
    private BigDecimal CO;

    /** 收缩压(Systolic Arterial Blood Pressure, mmHg) */
    @Excel(name = "收缩压(Systolic Arterial Blood Pressure, mmHg)")
    private BigDecimal sABP;

    /** 舒张压(Diastolic Arterial Blood Pressure, mmHg) */
    @Excel(name = "舒张压(Diastolic Arterial Blood Pressure, mmHg)")
    private BigDecimal dABP;

    /** 平均动脉压(Mean Arterial Blood Pressure, mmHg) */
    @Excel(name = "平均动脉压(Mean Arterial Blood Pressure, mmHg)")
    private BigDecimal mABP;

    /** 体表面积(Body Surface Area, m²) */
    @Excel(name = "体表面积(Body Surface Area, m²)")
    private BigDecimal BSA;

    /** 中心静脉压(Central Venous Pressure, mmHg) */
    @Excel(name = "中心静脉压(Central Venous Pressure, mmHg)")
    private BigDecimal CVP;

    /** 心指数(Cardiac Index, L/min/m²) */
    @Excel(name = "心指数(Cardiac Index, L/min/m²)")
    private BigDecimal CI;

    /** 连续心排血量(Pulse Contour Cardiac Output, L/min) */
    @Excel(name = "连续心排血量(Pulse Contour Cardiac Output, L/min)")
    private BigDecimal PCCO;

    /** 每搏输出量(Stroke Volume, ml) */
    @Excel(name = "每搏输出量(Stroke Volume, ml)")
    private BigDecimal SV;

    /** 血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵) */
    @Excel(name = "血管阻力(Systemic Vascular Resistance, dyn·s/cm⁵)")
    private BigDecimal SVR;

    /** 每搏变异度(Stroke Volume Variation, %) */
    @Excel(name = "每搏变异度(Stroke Volume Variation, %)")
    private BigDecimal SVV;

    /** 全身射血分数(Global Ejection Fraction, %) */
    @Excel(name = "全身射血分数(Global Ejection Fraction, %)")
    private BigDecimal GEF;

    /** 心功能指数(Cardiac Function Index) */
    @Excel(name = "心功能指数(Cardiac Function Index)")
    private BigDecimal CFI;

    /** 容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml) */
    @Excel(name = "容积性温度测量的胸内血容量(Intrathoracic Blood Volume, ml)")
    private BigDecimal ITBV;

    /** 全身舒张末期容积(Global End-Diastolic Volume, ml) */
    @Excel(name = "全身舒张末期容积(Global End-Diastolic Volume, ml)")
    private BigDecimal GEDV;

    /** 肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵) */
    @Excel(name = "肺血管阻力(Pulmonary Vascular Resistance, dyn·s/cm⁵)")
    private BigDecimal PVR;

    /** 肺水含量(Extravascular Lung Water, ml) */
    @Excel(name = "肺水含量(Extravascular Lung Water, ml)")
    private BigDecimal EVLW;

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

    public void setCO(BigDecimal CO) 
    {
        this.CO = CO;
    }

    public BigDecimal getCO() 
    {
        return CO;
    }

    public void setsABP(BigDecimal sABP) 
    {
        this.sABP = sABP;
    }

    public BigDecimal getsABP() 
    {
        return sABP;
    }

    public void setdABP(BigDecimal dABP) 
    {
        this.dABP = dABP;
    }

    public BigDecimal getdABP() 
    {
        return dABP;
    }

    public void setmABP(BigDecimal mABP) 
    {
        this.mABP = mABP;
    }

    public BigDecimal getmABP() 
    {
        return mABP;
    }

    public void setBSA(BigDecimal BSA) 
    {
        this.BSA = BSA;
    }

    public BigDecimal getBSA() 
    {
        return BSA;
    }

    public void setCVP(BigDecimal CVP) 
    {
        this.CVP = CVP;
    }

    public BigDecimal getCVP() 
    {
        return CVP;
    }

    public void setCI(BigDecimal CI) 
    {
        this.CI = CI;
    }

    public BigDecimal getCI() 
    {
        return CI;
    }

    public void setPCCO(BigDecimal PCCO) 
    {
        this.PCCO = PCCO;
    }

    public BigDecimal getPCCO() 
    {
        return PCCO;
    }

    public void setSV(BigDecimal SV) 
    {
        this.SV = SV;
    }

    public BigDecimal getSV() 
    {
        return SV;
    }

    public void setSVR(BigDecimal SVR) 
    {
        this.SVR = SVR;
    }

    public BigDecimal getSVR() 
    {
        return SVR;
    }

    public void setSVV(BigDecimal SVV) 
    {
        this.SVV = SVV;
    }

    public BigDecimal getSVV() 
    {
        return SVV;
    }

    public void setGEF(BigDecimal GEF) 
    {
        this.GEF = GEF;
    }

    public BigDecimal getGEF() 
    {
        return GEF;
    }

    public void setCFI(BigDecimal CFI) 
    {
        this.CFI = CFI;
    }

    public BigDecimal getCFI() 
    {
        return CFI;
    }

    public void setITBV(BigDecimal ITBV) 
    {
        this.ITBV = ITBV;
    }

    public BigDecimal getITBV() 
    {
        return ITBV;
    }

    public void setGEDV(BigDecimal GEDV) 
    {
        this.GEDV = GEDV;
    }

    public BigDecimal getGEDV() 
    {
        return GEDV;
    }

    public void setPVR(BigDecimal PVR) 
    {
        this.PVR = PVR;
    }

    public BigDecimal getPVR() 
    {
        return PVR;
    }

    public void setEVLW(BigDecimal EVLW) 
    {
        this.EVLW = EVLW;
    }

    public BigDecimal getEVLW() 
    {
        return EVLW;
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
            .append("CO", getCO())
            .append("sABP", getsABP())
            .append("dABP", getdABP())
            .append("mABP", getmABP())
            .append("BSA", getBSA())
            .append("CVP", getCVP())
            .append("CI", getCI())
            .append("PCCO", getPCCO())
            .append("SV", getSV())
            .append("SVR", getSVR())
            .append("SVV", getSVV())
            .append("GEF", getGEF())
            .append("CFI", getCFI())
            .append("ITBV", getITBV())
            .append("GEDV", getGEDV())
            .append("PVR", getPVR())
            .append("EVLW", getEVLW())
            .append("Instructions", getInstructions())
            .toString();
    }
}
