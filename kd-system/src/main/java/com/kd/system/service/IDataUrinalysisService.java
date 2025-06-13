package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataUrinalysis;

/**
 * 尿液分析数据Service接口
 * 
 * @author ruoyi
 * @date 2025-05-09
 */
public interface IDataUrinalysisService 
{
    /**
     * 查询尿液分析数据
     * 
     * @param Id 尿液分析数据主键
     * @return 尿液分析数据
     */
    public DataUrinalysis selectDataUrinalysisById(Long Id);

    /**
     * 查询尿液分析数据列表
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 尿液分析数据集合
     */
    public List<DataUrinalysis> selectDataUrinalysisList(DataUrinalysis dataUrinalysis);

    /**
     * 新增尿液分析数据
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 结果
     */
    public int insertDataUrinalysis(DataUrinalysis dataUrinalysis);

    /**
     * 修改尿液分析数据
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 结果
     */
    public int updateDataUrinalysis(DataUrinalysis dataUrinalysis);

    /**
     * 批量删除尿液分析数据
     * 
     * @param Ids 需要删除的尿液分析数据主键集合
     * @return 结果
     */
    public int deleteDataUrinalysisByIds(Long[] Ids);

    /**
     * 删除尿液分析数据信息
     * 
     * @param Id 尿液分析数据主键
     * @return 结果
     */
    public int deleteDataUrinalysisById(Long Id);

    String importUser(List<DataUrinalysis> xmbhList, boolean updateSupport, String operName);

    public List<DataUrinalysis> selectDataUrinalysisByEncounterId(Long encounterId);
}
