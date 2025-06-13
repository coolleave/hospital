package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 尿液分析数据对象 data_urinalysis
 * 
 * @author ruoyi
 * @date 2025-05-09
 */
public class DataUrinalysis extends BaseEntity
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

    /** 尿液pH值 */
    @Excel(name = "尿液pH值")
    private BigDecimal urinePH;

    /** 尿红细胞(RBC)，合并 rbc 字段 */
    @Excel(name = "尿红细胞(RBC)，合并 rbc 字段")
    private Long urineRBC;

    /** 尿白细胞(WBC)，合并 wbc 字段 */
    @Excel(name = "尿白细胞(WBC)，合并 wbc 字段")
    private Long urineWBC;

    /** 尿比重 */
    @Excel(name = "尿比重")
    private BigDecimal urineSpecificGravity;

    /** 尿酸盐结晶 */
    @Excel(name = "尿酸盐结晶")
    private String urineUrate;

    /** 尿淀粉酶 */
    @Excel(name = "尿淀粉酶")
    private String urineAmylase;

    /** 透明管型 */
    @Excel(name = "透明管型")
    private String hyalineCasts;

    /** 病理性管型 */
    @Excel(name = "病理性管型")
    private String pathologicalCasts;

    /** 尿酸结晶 */
    @Excel(name = "尿酸结晶")
    private String urateCrystals;

    /** 草酸钙结晶 */
    @Excel(name = "草酸钙结晶")
    private String calciumOxalateCrystals;

    /** 尿酸结晶 */
    @Excel(name = "尿酸结晶")
    private String uricAcidCrystals;

    /** 鳞状上皮细胞 */
    @Excel(name = "鳞状上皮细胞")
    private Long squamousEpithelialCells;

    /** 磷酸镁铵结晶 */
    @Excel(name = "磷酸镁铵结晶")
    private String magnesiumAmmoniumPhosphateCrystals;

    /** 维生素C */
    @Excel(name = "维生素C")
    private String vitaminC;

    /** 白细胞簇 */
    @Excel(name = "白细胞簇")
    private String leukocyteClusters;

    /** 黏液丝 */
    @Excel(name = "黏液丝")
    private String mucusThreads;

    /** 酵母菌 */
    @Excel(name = "酵母菌")
    private String yeast;

    /** 杆菌 */
    @Excel(name = "杆菌")
    private String bacilli;

    /** 红细胞(RBC) */
    @Excel(name = "红细胞(RBC)")
    private Long rbcHPF;

    /** 非鳞状上皮细胞 */
    @Excel(name = "非鳞状上皮细胞")
    private Long nonSquamousEpithelialCells;

    /** 精子 */
    @Excel(name = "精子")
    private String spermatozoa;

    /** 鳞状上皮细胞 */
    @Excel(name = "鳞状上皮细胞")
    private Long squamousEpithelialCellsHPF;

    /** 可疑球菌 */
    @Excel(name = "可疑球菌")
    private String suspectedCocci;

    /** 白细胞(WBC) */
    @Excel(name = "白细胞(WBC)")
    private Long wbcHPF;

    /** 细菌 */
    @Excel(name = "细菌")
    private String bacteria;

    /** 球菌 */
    @Excel(name = "球菌")
    private String cocci;

    /** 磷酸盐结晶 */
    @Excel(name = "磷酸盐结晶")
    private String phosphateCrystals;

    /** 一水草酸钙结晶 */
    @Excel(name = "一水草酸钙结晶")
    private String monohydrateCalciumOxalateCrystals;

    /** 二水草酸钙结晶 */
    @Excel(name = "二水草酸钙结晶")
    private String dihydrateCalciumOxalateCrystals;

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

    public void setUrinePH(BigDecimal urinePH) 
    {
        this.urinePH = urinePH;
    }

    public BigDecimal getUrinePH() 
    {
        return urinePH;
    }

    public void setUrineRBC(Long urineRBC) 
    {
        this.urineRBC = urineRBC;
    }

    public Long getUrineRBC() 
    {
        return urineRBC;
    }

    public void setUrineWBC(Long urineWBC) 
    {
        this.urineWBC = urineWBC;
    }

    public Long getUrineWBC() 
    {
        return urineWBC;
    }

    public void setUrineSpecificGravity(BigDecimal urineSpecificGravity) 
    {
        this.urineSpecificGravity = urineSpecificGravity;
    }

    public BigDecimal getUrineSpecificGravity() 
    {
        return urineSpecificGravity;
    }

    public void setUrineUrate(String urineUrate) 
    {
        this.urineUrate = urineUrate;
    }

    public String getUrineUrate() 
    {
        return urineUrate;
    }

    public void setUrineAmylase(String urineAmylase) 
    {
        this.urineAmylase = urineAmylase;
    }

    public String getUrineAmylase() 
    {
        return urineAmylase;
    }

    public void setHyalineCasts(String hyalineCasts) 
    {
        this.hyalineCasts = hyalineCasts;
    }

    public String getHyalineCasts() 
    {
        return hyalineCasts;
    }

    public void setPathologicalCasts(String pathologicalCasts) 
    {
        this.pathologicalCasts = pathologicalCasts;
    }

    public String getPathologicalCasts() 
    {
        return pathologicalCasts;
    }

    public void setUrateCrystals(String urateCrystals) 
    {
        this.urateCrystals = urateCrystals;
    }

    public String getUrateCrystals() 
    {
        return urateCrystals;
    }

    public void setCalciumOxalateCrystals(String calciumOxalateCrystals) 
    {
        this.calciumOxalateCrystals = calciumOxalateCrystals;
    }

    public String getCalciumOxalateCrystals() 
    {
        return calciumOxalateCrystals;
    }

    public void setUricAcidCrystals(String uricAcidCrystals) 
    {
        this.uricAcidCrystals = uricAcidCrystals;
    }

    public String getUricAcidCrystals() 
    {
        return uricAcidCrystals;
    }

    public void setSquamousEpithelialCells(Long squamousEpithelialCells) 
    {
        this.squamousEpithelialCells = squamousEpithelialCells;
    }

    public Long getSquamousEpithelialCells() 
    {
        return squamousEpithelialCells;
    }

    public void setMagnesiumAmmoniumPhosphateCrystals(String magnesiumAmmoniumPhosphateCrystals) 
    {
        this.magnesiumAmmoniumPhosphateCrystals = magnesiumAmmoniumPhosphateCrystals;
    }

    public String getMagnesiumAmmoniumPhosphateCrystals() 
    {
        return magnesiumAmmoniumPhosphateCrystals;
    }

    public void setVitaminC(String vitaminC) 
    {
        this.vitaminC = vitaminC;
    }

    public String getVitaminC() 
    {
        return vitaminC;
    }

    public void setLeukocyteClusters(String leukocyteClusters) 
    {
        this.leukocyteClusters = leukocyteClusters;
    }

    public String getLeukocyteClusters() 
    {
        return leukocyteClusters;
    }

    public void setMucusThreads(String mucusThreads) 
    {
        this.mucusThreads = mucusThreads;
    }

    public String getMucusThreads() 
    {
        return mucusThreads;
    }

    public void setYeast(String yeast) 
    {
        this.yeast = yeast;
    }

    public String getYeast() 
    {
        return yeast;
    }

    public void setBacilli(String bacilli) 
    {
        this.bacilli = bacilli;
    }

    public String getBacilli() 
    {
        return bacilli;
    }

    public void setRbcHPF(Long rbcHPF) 
    {
        this.rbcHPF = rbcHPF;
    }

    public Long getRbcHPF() 
    {
        return rbcHPF;
    }

    public void setNonSquamousEpithelialCells(Long nonSquamousEpithelialCells) 
    {
        this.nonSquamousEpithelialCells = nonSquamousEpithelialCells;
    }

    public Long getNonSquamousEpithelialCells() 
    {
        return nonSquamousEpithelialCells;
    }

    public void setSpermatozoa(String spermatozoa) 
    {
        this.spermatozoa = spermatozoa;
    }

    public String getSpermatozoa() 
    {
        return spermatozoa;
    }

    public void setSquamousEpithelialCellsHPF(Long squamousEpithelialCellsHPF) 
    {
        this.squamousEpithelialCellsHPF = squamousEpithelialCellsHPF;
    }

    public Long getSquamousEpithelialCellsHPF() 
    {
        return squamousEpithelialCellsHPF;
    }

    public void setSuspectedCocci(String suspectedCocci) 
    {
        this.suspectedCocci = suspectedCocci;
    }

    public String getSuspectedCocci() 
    {
        return suspectedCocci;
    }

    public void setWbcHPF(Long wbcHPF) 
    {
        this.wbcHPF = wbcHPF;
    }

    public Long getWbcHPF() 
    {
        return wbcHPF;
    }

    public void setBacteria(String bacteria) 
    {
        this.bacteria = bacteria;
    }

    public String getBacteria() 
    {
        return bacteria;
    }

    public void setCocci(String cocci) 
    {
        this.cocci = cocci;
    }

    public String getCocci() 
    {
        return cocci;
    }

    public void setPhosphateCrystals(String phosphateCrystals) 
    {
        this.phosphateCrystals = phosphateCrystals;
    }

    public String getPhosphateCrystals() 
    {
        return phosphateCrystals;
    }

    public void setMonohydrateCalciumOxalateCrystals(String monohydrateCalciumOxalateCrystals) 
    {
        this.monohydrateCalciumOxalateCrystals = monohydrateCalciumOxalateCrystals;
    }

    public String getMonohydrateCalciumOxalateCrystals() 
    {
        return monohydrateCalciumOxalateCrystals;
    }

    public void setDihydrateCalciumOxalateCrystals(String dihydrateCalciumOxalateCrystals) 
    {
        this.dihydrateCalciumOxalateCrystals = dihydrateCalciumOxalateCrystals;
    }

    public String getDihydrateCalciumOxalateCrystals() 
    {
        return dihydrateCalciumOxalateCrystals;
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
            .append("urinePH", getUrinePH())
            .append("urineRBC", getUrineRBC())
            .append("urineWBC", getUrineWBC())
            .append("urineSpecificGravity", getUrineSpecificGravity())
            .append("urineUrate", getUrineUrate())
            .append("urineAmylase", getUrineAmylase())
            .append("hyalineCasts", getHyalineCasts())
            .append("pathologicalCasts", getPathologicalCasts())
            .append("urateCrystals", getUrateCrystals())
            .append("calciumOxalateCrystals", getCalciumOxalateCrystals())
            .append("uricAcidCrystals", getUricAcidCrystals())
            .append("squamousEpithelialCells", getSquamousEpithelialCells())
            .append("magnesiumAmmoniumPhosphateCrystals", getMagnesiumAmmoniumPhosphateCrystals())
            .append("vitaminC", getVitaminC())
            .append("leukocyteClusters", getLeukocyteClusters())
            .append("mucusThreads", getMucusThreads())
            .append("yeast", getYeast())
            .append("bacilli", getBacilli())
            .append("rbcHPF", getRbcHPF())
            .append("nonSquamousEpithelialCells", getNonSquamousEpithelialCells())
            .append("spermatozoa", getSpermatozoa())
            .append("squamousEpithelialCellsHPF", getSquamousEpithelialCellsHPF())
            .append("suspectedCocci", getSuspectedCocci())
            .append("wbcHPF", getWbcHPF())
            .append("bacteria", getBacteria())
            .append("cocci", getCocci())
            .append("phosphateCrystals", getPhosphateCrystals())
            .append("monohydrateCalciumOxalateCrystals", getMonohydrateCalciumOxalateCrystals())
            .append("dihydrateCalciumOxalateCrystals", getDihydrateCalciumOxalateCrystals())
            .append("Instructions", getInstructions())
            .toString();
    }
}
