package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 血液学数据对象 data_hematology
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataHematology extends BaseEntity
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

    /** 红细胞计数（×10^12/L） */
    @Excel(name = "红细胞计数", readConverterExp = "×=10^12/L")
    private BigDecimal redBloodCellCount;

    /** 红细胞体积分布宽度_SD（fL） */
    @Excel(name = "红细胞体积分布宽度_SD", readConverterExp = "f=L")
    private BigDecimal rdwSD;

    /** 红细胞分布宽度CV（%） */
    @Excel(name = "红细胞分布宽度CV", readConverterExp = "%=")
    private BigDecimal rdwCV;

    /** 红细胞压积HCT（%） */
    @Excel(name = "红细胞压积HCT", readConverterExp = "%=")
    private BigDecimal hct;

    /** 血红蛋白（g/dL） */
    @Excel(name = "血红蛋白", readConverterExp = "g=/dL")
    private BigDecimal hemoglobin;

    /** 平均血红蛋白浓度MCHC（g/dL） */
    @Excel(name = "平均血红蛋白浓度MCHC", readConverterExp = "g=/dL")
    private BigDecimal mchc;

    /** 平均血红蛋白量MCH（pg） */
    @Excel(name = "平均血红蛋白量MCH", readConverterExp = "p=g")
    private BigDecimal mch;

    /** 红细胞平均体积MCV（fL） */
    @Excel(name = "红细胞平均体积MCV", readConverterExp = "f=L")
    private BigDecimal mcv;

    /** 白细胞计数（×10^9/L） */
    @Excel(name = "白细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal whiteBloodCellCount;

    /** 中性粒细胞计数（×10^9/L） */
    @Excel(name = "中性粒细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal neutrophilCount;

    /** 淋巴细胞计数（×10^9/L） */
    @Excel(name = "淋巴细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal lymphocyteCount;

    /** 嗜酸性粒细胞计数（×10^9/L） */
    @Excel(name = "嗜酸性粒细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal eosinophilCount;

    /** 嗜碱性粒细胞计数（×10^9/L） */
    @Excel(name = "嗜碱性粒细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal basophilCount;

    /** 单核细胞计数（×10^9/L） */
    @Excel(name = "单核细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal monocyteCount;

    /** 不成熟粒细胞计数（×10^9/L） */
    @Excel(name = "不成熟粒细胞计数", readConverterExp = "×=10^9/L")
    private BigDecimal immatureGranulocyteCount;

    /** 血小板计数（×10^9/L） */
    @Excel(name = "血小板计数", readConverterExp = "×=10^9/L")
    private BigDecimal plateletCount;

    /** 血小板压积（%） */
    @Excel(name = "血小板压积", readConverterExp = "%=")
    private BigDecimal plateletcrit;

    /** 平均血小板体积（fL） */
    @Excel(name = "平均血小板体积", readConverterExp = "f=L")
    private BigDecimal meanPlateletVolume;

    /** 血小板分布宽度（fL） */
    @Excel(name = "血小板分布宽度", readConverterExp = "f=L")
    private BigDecimal plateletDistributionWidth;

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

    public void setRedBloodCellCount(BigDecimal redBloodCellCount) 
    {
        this.redBloodCellCount = redBloodCellCount;
    }

    public BigDecimal getRedBloodCellCount() 
    {
        return redBloodCellCount;
    }

    public void setRdwSD(BigDecimal rdwSD) 
    {
        this.rdwSD = rdwSD;
    }

    public BigDecimal getRdwSD() 
    {
        return rdwSD;
    }

    public void setRdwCV(BigDecimal rdwCV) 
    {
        this.rdwCV = rdwCV;
    }

    public BigDecimal getRdwCV() 
    {
        return rdwCV;
    }

    public void setHct(BigDecimal hct) 
    {
        this.hct = hct;
    }

    public BigDecimal getHct() 
    {
        return hct;
    }

    public void setHemoglobin(BigDecimal hemoglobin) 
    {
        this.hemoglobin = hemoglobin;
    }

    public BigDecimal getHemoglobin() 
    {
        return hemoglobin;
    }

    public void setMchc(BigDecimal mchc) 
    {
        this.mchc = mchc;
    }

    public BigDecimal getMchc() 
    {
        return mchc;
    }

    public void setMch(BigDecimal mch) 
    {
        this.mch = mch;
    }

    public BigDecimal getMch() 
    {
        return mch;
    }

    public void setMcv(BigDecimal mcv) 
    {
        this.mcv = mcv;
    }

    public BigDecimal getMcv() 
    {
        return mcv;
    }

    public void setWhiteBloodCellCount(BigDecimal whiteBloodCellCount) 
    {
        this.whiteBloodCellCount = whiteBloodCellCount;
    }

    public BigDecimal getWhiteBloodCellCount() 
    {
        return whiteBloodCellCount;
    }

    public void setNeutrophilCount(BigDecimal neutrophilCount) 
    {
        this.neutrophilCount = neutrophilCount;
    }

    public BigDecimal getNeutrophilCount() 
    {
        return neutrophilCount;
    }

    public void setLymphocyteCount(BigDecimal lymphocyteCount) 
    {
        this.lymphocyteCount = lymphocyteCount;
    }

    public BigDecimal getLymphocyteCount() 
    {
        return lymphocyteCount;
    }

    public void setEosinophilCount(BigDecimal eosinophilCount) 
    {
        this.eosinophilCount = eosinophilCount;
    }

    public BigDecimal getEosinophilCount() 
    {
        return eosinophilCount;
    }

    public void setBasophilCount(BigDecimal basophilCount) 
    {
        this.basophilCount = basophilCount;
    }

    public BigDecimal getBasophilCount() 
    {
        return basophilCount;
    }

    public void setMonocyteCount(BigDecimal monocyteCount) 
    {
        this.monocyteCount = monocyteCount;
    }

    public BigDecimal getMonocyteCount() 
    {
        return monocyteCount;
    }

    public void setImmatureGranulocyteCount(BigDecimal immatureGranulocyteCount) 
    {
        this.immatureGranulocyteCount = immatureGranulocyteCount;
    }

    public BigDecimal getImmatureGranulocyteCount() 
    {
        return immatureGranulocyteCount;
    }

    public void setPlateletCount(BigDecimal plateletCount) 
    {
        this.plateletCount = plateletCount;
    }

    public BigDecimal getPlateletCount() 
    {
        return plateletCount;
    }

    public void setPlateletcrit(BigDecimal plateletcrit) 
    {
        this.plateletcrit = plateletcrit;
    }

    public BigDecimal getPlateletcrit() 
    {
        return plateletcrit;
    }

    public void setMeanPlateletVolume(BigDecimal meanPlateletVolume) 
    {
        this.meanPlateletVolume = meanPlateletVolume;
    }

    public BigDecimal getMeanPlateletVolume() 
    {
        return meanPlateletVolume;
    }

    public void setPlateletDistributionWidth(BigDecimal plateletDistributionWidth) 
    {
        this.plateletDistributionWidth = plateletDistributionWidth;
    }

    public BigDecimal getPlateletDistributionWidth() 
    {
        return plateletDistributionWidth;
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
            .append("redBloodCellCount", getRedBloodCellCount())
            .append("rdwSD", getRdwSD())
            .append("rdwCV", getRdwCV())
            .append("hct", getHct())
            .append("hemoglobin", getHemoglobin())
            .append("mchc", getMchc())
            .append("mch", getMch())
            .append("mcv", getMcv())
            .append("whiteBloodCellCount", getWhiteBloodCellCount())
            .append("neutrophilCount", getNeutrophilCount())
            .append("lymphocyteCount", getLymphocyteCount())
            .append("eosinophilCount", getEosinophilCount())
            .append("basophilCount", getBasophilCount())
            .append("monocyteCount", getMonocyteCount())
            .append("immatureGranulocyteCount", getImmatureGranulocyteCount())
            .append("plateletCount", getPlateletCount())
            .append("plateletcrit", getPlateletcrit())
            .append("meanPlateletVolume", getMeanPlateletVolume())
            .append("plateletDistributionWidth", getPlateletDistributionWidth())
            .append("Instructions", getInstructions())
            .toString();
    }
}
