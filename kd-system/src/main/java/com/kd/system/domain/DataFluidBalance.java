package com.kd.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kd.common.annotation.Excel;
import com.kd.common.core.domain.BaseEntity;

/**
 * 液体平衡对象 data_fluid_balance
 * 
 * @author kd
 * @date 2025-05-09
 */
public class DataFluidBalance extends BaseEntity
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

    /** 尿量（ml） */
    @Excel(name = "尿量", readConverterExp = "m=l")
    private BigDecimal urineOutput;

    /** 每小时入量（ml/h） */
    @Excel(name = "每小时入量", readConverterExp = "m=l/h")
    private BigDecimal inputPerHour;

    /** 每小时出量（ml/h） */
    @Excel(name = "每小时出量", readConverterExp = "m=l/h")
    private BigDecimal outputPerHour;

    /** 每小时平衡量（ml/h） */
    @Excel(name = "每小时平衡量", readConverterExp = "m=l/h")
    private BigDecimal balancePerHour;

    /** 胃肠入合计（ml） */
    @Excel(name = "胃肠入合计", readConverterExp = "m=l")
    private BigDecimal gastrointestinalInputTotal;

    /** 大便合计（ml） */
    @Excel(name = "大便合计", readConverterExp = "m=l")
    private BigDecimal stoolTotal;

    /** 胃肠出合计（ml） */
    @Excel(name = "胃肠出合计", readConverterExp = "m=l")
    private BigDecimal gastrointestinalOutputTotal;

    /** 引流量合计（ml） */
    @Excel(name = "引流量合计", readConverterExp = "m=l")
    private BigDecimal drainageTotal;

    /** 实际超滤量（ml） */
    @Excel(name = "实际超滤量", readConverterExp = "m=l")
    private BigDecimal actualUltrafiltration;

    /** 血制品合计（ml） */
    @Excel(name = "血制品合计", readConverterExp = "m=l")
    private BigDecimal bloodProductsTotal;

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

    public void setUrineOutput(BigDecimal urineOutput) 
    {
        this.urineOutput = urineOutput;
    }

    public BigDecimal getUrineOutput() 
    {
        return urineOutput;
    }

    public void setInputPerHour(BigDecimal inputPerHour) 
    {
        this.inputPerHour = inputPerHour;
    }

    public BigDecimal getInputPerHour() 
    {
        return inputPerHour;
    }

    public void setOutputPerHour(BigDecimal outputPerHour) 
    {
        this.outputPerHour = outputPerHour;
    }

    public BigDecimal getOutputPerHour() 
    {
        return outputPerHour;
    }

    public void setBalancePerHour(BigDecimal balancePerHour) 
    {
        this.balancePerHour = balancePerHour;
    }

    public BigDecimal getBalancePerHour() 
    {
        return balancePerHour;
    }

    public void setGastrointestinalInputTotal(BigDecimal gastrointestinalInputTotal) 
    {
        this.gastrointestinalInputTotal = gastrointestinalInputTotal;
    }

    public BigDecimal getGastrointestinalInputTotal() 
    {
        return gastrointestinalInputTotal;
    }

    public void setStoolTotal(BigDecimal stoolTotal) 
    {
        this.stoolTotal = stoolTotal;
    }

    public BigDecimal getStoolTotal() 
    {
        return stoolTotal;
    }

    public void setGastrointestinalOutputTotal(BigDecimal gastrointestinalOutputTotal) 
    {
        this.gastrointestinalOutputTotal = gastrointestinalOutputTotal;
    }

    public BigDecimal getGastrointestinalOutputTotal() 
    {
        return gastrointestinalOutputTotal;
    }

    public void setDrainageTotal(BigDecimal drainageTotal) 
    {
        this.drainageTotal = drainageTotal;
    }

    public BigDecimal getDrainageTotal() 
    {
        return drainageTotal;
    }

    public void setActualUltrafiltration(BigDecimal actualUltrafiltration) 
    {
        this.actualUltrafiltration = actualUltrafiltration;
    }

    public BigDecimal getActualUltrafiltration() 
    {
        return actualUltrafiltration;
    }

    public void setBloodProductsTotal(BigDecimal bloodProductsTotal) 
    {
        this.bloodProductsTotal = bloodProductsTotal;
    }

    public BigDecimal getBloodProductsTotal() 
    {
        return bloodProductsTotal;
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
            .append("urineOutput", getUrineOutput())
            .append("inputPerHour", getInputPerHour())
            .append("outputPerHour", getOutputPerHour())
            .append("balancePerHour", getBalancePerHour())
            .append("gastrointestinalInputTotal", getGastrointestinalInputTotal())
            .append("stoolTotal", getStoolTotal())
            .append("gastrointestinalOutputTotal", getGastrointestinalOutputTotal())
            .append("drainageTotal", getDrainageTotal())
            .append("actualUltrafiltration", getActualUltrafiltration())
            .append("bloodProductsTotal", getBloodProductsTotal())
            .append("Instructions", getInstructions())
            .toString();
    }
}
