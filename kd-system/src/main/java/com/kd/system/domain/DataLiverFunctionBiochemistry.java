package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 肝功能生化指标对象 data_liver_function_biochemistry
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataLiverFunctionBiochemistry extends BaseEntity
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

    /** 总蛋白（g/L） */
    @Excel(name = "总蛋白", readConverterExp = "g=/L")
    private BigDecimal totalProtein;

    /** 白蛋白（g/L） */
    @Excel(name = "白蛋白", readConverterExp = "g=/L")
    private BigDecimal albumin;

    /** 球蛋白（g/L） */
    @Excel(name = "球蛋白", readConverterExp = "g=/L")
    private BigDecimal globulin;

    /** 总胆红素（μmol/L） */
    @Excel(name = "总胆红素", readConverterExp = "μ=mol/L")
    private BigDecimal totalBilirubin;

    /** 间接胆红素（μmol/L） */
    @Excel(name = "间接胆红素", readConverterExp = "μ=mol/L")
    private BigDecimal indirectBilirubin;

    /** 直接胆红素（μmol/L） */
    @Excel(name = "直接胆红素", readConverterExp = "μ=mol/L")
    private BigDecimal directBilirubin;

    /** 天冬氨酸氨基转移酶（U/L） */
    @Excel(name = "天冬氨酸氨基转移酶", readConverterExp = "U=/L")
    private BigDecimal aspartateAminotransferase;

    /** 丙氨酸氨基转移酶(SGPT)（U/L） */
    @Excel(name = "丙氨酸氨基转移酶(SGPT)", readConverterExp = "U=/L")
    private BigDecimal alanineAminotransferase;

    /** 碱性磷酸酶（U/L） */
    @Excel(name = "碱性磷酸酶", readConverterExp = "U=/L")
    private BigDecimal alkalinePhosphatase;

    /** 同型半胱氨酸（μmol/L） */
    @Excel(name = "同型半胱氨酸", readConverterExp = "μ=mol/L")
    private BigDecimal homocysteine;

    /** 总胆汁酸（μmol/L） */
    @Excel(name = "总胆汁酸", readConverterExp = "μ=mol/L")
    private BigDecimal totalBileAcids;

    /** γ谷氨酰转肽酶（U/L） */
    @Excel(name = "γ谷氨酰转肽酶", readConverterExp = "U=/L")
    private BigDecimal gammaGlutamylTransferase;

    /** 乳酸脱氢酶（U/L） */
    @Excel(name = "乳酸脱氢酶", readConverterExp = "U=/L")
    private BigDecimal lactateDehydrogenase;

    /** 羟丁酸脱氢酶（U/L） */
    @Excel(name = "羟丁酸脱氢酶", readConverterExp = "U=/L")
    private BigDecimal hydroxybutyrateDehydrogenase;

    /** 血清淀粉样蛋白A（mg/L） */
    @Excel(name = "血清淀粉样蛋白A", readConverterExp = "m=g/L")
    private BigDecimal serumAmyloidA;

    /** 谷草比谷丙 */
    @Excel(name = "谷草比谷丙")
    private BigDecimal astToAltRatio;

    /** 前白蛋白（mg/L） */
    @Excel(name = "前白蛋白", readConverterExp = "m=g/L")
    private BigDecimal prealbumin;

    /** 胆碱酯酶（U/L） */
    @Excel(name = "胆碱酯酶", readConverterExp = "U=/L")
    private BigDecimal cholinesterase;

    /** 肌酐（μmol/L） */
    @Excel(name = "肌酐", readConverterExp = "μ=mol/L")
    private BigDecimal creatinine;

    /** 尿素氮（mmol/L） */
    @Excel(name = "尿素氮", readConverterExp = "m=mol/L")
    private BigDecimal ureaNitrogen;

    /** 肾小球滤过率（ml/min） */
    @Excel(name = "肾小球滤过率", readConverterExp = "m=l/min")
    private BigDecimal glomerularFiltrationRate;

    /** 血清胱抑素C（mg/L） */
    @Excel(name = "血清胱抑素C", readConverterExp = "m=g/L")
    private BigDecimal serumCystatinC;

    /** 钾（mmol/L） */
    @Excel(name = "钾", readConverterExp = "m=mol/L")
    private BigDecimal potassium;

    /** 钙（mmol/L） */
    @Excel(name = "钙", readConverterExp = "m=mol/L")
    private BigDecimal calcium;

    /** 氯（mmol/L） */
    @Excel(name = "氯", readConverterExp = "m=mol/L")
    private BigDecimal chloride;

    /** 钠（mmol/L） */
    @Excel(name = "钠", readConverterExp = "m=mol/L")
    private BigDecimal sodium;

    /** 二氧化碳总量（mmol/L） */
    @Excel(name = "二氧化碳总量", readConverterExp = "m=mol/L")
    private BigDecimal totalCarbonDioxide;

    /** 镁（mmol/L） */
    @Excel(name = "镁", readConverterExp = "m=mol/L")
    private BigDecimal magnesium;

    /** 磷（mmol/L） */
    @Excel(name = "磷", readConverterExp = "m=mol/L")
    private BigDecimal phosphorus;

    /** 阴离子间隙（mmol/L） */
    @Excel(name = "阴离子间隙", readConverterExp = "m=mol/L")
    private BigDecimal anionGap;

    /** 渗透压（mOsm/kg H2O） */
    @Excel(name = "渗透压", readConverterExp = "m=Osm/kg,H=2O")
    private BigDecimal osmolality;

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

    public void setTotalProtein(BigDecimal totalProtein) 
    {
        this.totalProtein = totalProtein;
    }

    public BigDecimal getTotalProtein() 
    {
        return totalProtein;
    }

    public void setAlbumin(BigDecimal albumin) 
    {
        this.albumin = albumin;
    }

    public BigDecimal getAlbumin() 
    {
        return albumin;
    }

    public void setGlobulin(BigDecimal globulin) 
    {
        this.globulin = globulin;
    }

    public BigDecimal getGlobulin() 
    {
        return globulin;
    }

    public void setTotalBilirubin(BigDecimal totalBilirubin) 
    {
        this.totalBilirubin = totalBilirubin;
    }

    public BigDecimal getTotalBilirubin() 
    {
        return totalBilirubin;
    }

    public void setIndirectBilirubin(BigDecimal indirectBilirubin) 
    {
        this.indirectBilirubin = indirectBilirubin;
    }

    public BigDecimal getIndirectBilirubin() 
    {
        return indirectBilirubin;
    }

    public void setDirectBilirubin(BigDecimal directBilirubin) 
    {
        this.directBilirubin = directBilirubin;
    }

    public BigDecimal getDirectBilirubin() 
    {
        return directBilirubin;
    }

    public void setAspartateAminotransferase(BigDecimal aspartateAminotransferase) 
    {
        this.aspartateAminotransferase = aspartateAminotransferase;
    }

    public BigDecimal getAspartateAminotransferase() 
    {
        return aspartateAminotransferase;
    }

    public void setAlanineAminotransferase(BigDecimal alanineAminotransferase) 
    {
        this.alanineAminotransferase = alanineAminotransferase;
    }

    public BigDecimal getAlanineAminotransferase() 
    {
        return alanineAminotransferase;
    }

    public void setAlkalinePhosphatase(BigDecimal alkalinePhosphatase) 
    {
        this.alkalinePhosphatase = alkalinePhosphatase;
    }

    public BigDecimal getAlkalinePhosphatase() 
    {
        return alkalinePhosphatase;
    }

    public void setHomocysteine(BigDecimal homocysteine) 
    {
        this.homocysteine = homocysteine;
    }

    public BigDecimal getHomocysteine() 
    {
        return homocysteine;
    }

    public void setTotalBileAcids(BigDecimal totalBileAcids) 
    {
        this.totalBileAcids = totalBileAcids;
    }

    public BigDecimal getTotalBileAcids() 
    {
        return totalBileAcids;
    }

    public void setGammaGlutamylTransferase(BigDecimal gammaGlutamylTransferase) 
    {
        this.gammaGlutamylTransferase = gammaGlutamylTransferase;
    }

    public BigDecimal getGammaGlutamylTransferase() 
    {
        return gammaGlutamylTransferase;
    }

    public void setLactateDehydrogenase(BigDecimal lactateDehydrogenase) 
    {
        this.lactateDehydrogenase = lactateDehydrogenase;
    }

    public BigDecimal getLactateDehydrogenase() 
    {
        return lactateDehydrogenase;
    }

    public void setHydroxybutyrateDehydrogenase(BigDecimal hydroxybutyrateDehydrogenase) 
    {
        this.hydroxybutyrateDehydrogenase = hydroxybutyrateDehydrogenase;
    }

    public BigDecimal getHydroxybutyrateDehydrogenase() 
    {
        return hydroxybutyrateDehydrogenase;
    }

    public void setSerumAmyloidA(BigDecimal serumAmyloidA) 
    {
        this.serumAmyloidA = serumAmyloidA;
    }

    public BigDecimal getSerumAmyloidA() 
    {
        return serumAmyloidA;
    }

    public void setAstToAltRatio(BigDecimal astToAltRatio) 
    {
        this.astToAltRatio = astToAltRatio;
    }

    public BigDecimal getAstToAltRatio() 
    {
        return astToAltRatio;
    }

    public void setPrealbumin(BigDecimal prealbumin) 
    {
        this.prealbumin = prealbumin;
    }

    public BigDecimal getPrealbumin() 
    {
        return prealbumin;
    }

    public void setCholinesterase(BigDecimal cholinesterase) 
    {
        this.cholinesterase = cholinesterase;
    }

    public BigDecimal getCholinesterase() 
    {
        return cholinesterase;
    }

    public void setCreatinine(BigDecimal creatinine) 
    {
        this.creatinine = creatinine;
    }

    public BigDecimal getCreatinine() 
    {
        return creatinine;
    }

    public void setUreaNitrogen(BigDecimal ureaNitrogen) 
    {
        this.ureaNitrogen = ureaNitrogen;
    }

    public BigDecimal getUreaNitrogen() 
    {
        return ureaNitrogen;
    }

    public void setGlomerularFiltrationRate(BigDecimal glomerularFiltrationRate) 
    {
        this.glomerularFiltrationRate = glomerularFiltrationRate;
    }

    public BigDecimal getGlomerularFiltrationRate() 
    {
        return glomerularFiltrationRate;
    }

    public void setSerumCystatinC(BigDecimal serumCystatinC) 
    {
        this.serumCystatinC = serumCystatinC;
    }

    public BigDecimal getSerumCystatinC() 
    {
        return serumCystatinC;
    }

    public void setPotassium(BigDecimal potassium) 
    {
        this.potassium = potassium;
    }

    public BigDecimal getPotassium() 
    {
        return potassium;
    }

    public void setCalcium(BigDecimal calcium) 
    {
        this.calcium = calcium;
    }

    public BigDecimal getCalcium() 
    {
        return calcium;
    }

    public void setChloride(BigDecimal chloride) 
    {
        this.chloride = chloride;
    }

    public BigDecimal getChloride() 
    {
        return chloride;
    }

    public void setSodium(BigDecimal sodium) 
    {
        this.sodium = sodium;
    }

    public BigDecimal getSodium() 
    {
        return sodium;
    }

    public void setTotalCarbonDioxide(BigDecimal totalCarbonDioxide) 
    {
        this.totalCarbonDioxide = totalCarbonDioxide;
    }

    public BigDecimal getTotalCarbonDioxide() 
    {
        return totalCarbonDioxide;
    }

    public void setMagnesium(BigDecimal magnesium) 
    {
        this.magnesium = magnesium;
    }

    public BigDecimal getMagnesium() 
    {
        return magnesium;
    }

    public void setPhosphorus(BigDecimal phosphorus) 
    {
        this.phosphorus = phosphorus;
    }

    public BigDecimal getPhosphorus() 
    {
        return phosphorus;
    }

    public void setAnionGap(BigDecimal anionGap) 
    {
        this.anionGap = anionGap;
    }

    public BigDecimal getAnionGap() 
    {
        return anionGap;
    }

    public void setOsmolality(BigDecimal osmolality) 
    {
        this.osmolality = osmolality;
    }

    public BigDecimal getOsmolality() 
    {
        return osmolality;
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
            .append("totalProtein", getTotalProtein())
            .append("albumin", getAlbumin())
            .append("globulin", getGlobulin())
            .append("totalBilirubin", getTotalBilirubin())
            .append("indirectBilirubin", getIndirectBilirubin())
            .append("directBilirubin", getDirectBilirubin())
            .append("aspartateAminotransferase", getAspartateAminotransferase())
            .append("alanineAminotransferase", getAlanineAminotransferase())
            .append("alkalinePhosphatase", getAlkalinePhosphatase())
            .append("homocysteine", getHomocysteine())
            .append("totalBileAcids", getTotalBileAcids())
            .append("gammaGlutamylTransferase", getGammaGlutamylTransferase())
            .append("lactateDehydrogenase", getLactateDehydrogenase())
            .append("hydroxybutyrateDehydrogenase", getHydroxybutyrateDehydrogenase())
            .append("serumAmyloidA", getSerumAmyloidA())
            .append("astToAltRatio", getAstToAltRatio())
            .append("prealbumin", getPrealbumin())
            .append("cholinesterase", getCholinesterase())
            .append("creatinine", getCreatinine())
            .append("ureaNitrogen", getUreaNitrogen())
            .append("glomerularFiltrationRate", getGlomerularFiltrationRate())
            .append("serumCystatinC", getSerumCystatinC())
            .append("potassium", getPotassium())
            .append("calcium", getCalcium())
            .append("chloride", getChloride())
            .append("sodium", getSodium())
            .append("totalCarbonDioxide", getTotalCarbonDioxide())
            .append("magnesium", getMagnesium())
            .append("phosphorus", getPhosphorus())
            .append("anionGap", getAnionGap())
            .append("osmolality", getOsmolality())
            .append("Instructions", getInstructions())
            .toString();
    }
}
