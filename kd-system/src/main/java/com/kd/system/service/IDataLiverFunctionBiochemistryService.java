package com.kd.system.service;

import java.util.List;


import com.kd.system.domain.DataLiverFunctionBiochemistry;

/**
 * 肝功能生化指标Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataLiverFunctionBiochemistryService 
{
    /**
     * 查询肝功能生化指标
     * 
     * @param Id 肝功能生化指标主键
     * @return 肝功能生化指标
     */
    public DataLiverFunctionBiochemistry selectDataLiverFunctionBiochemistryById(Long Id);

    /**
     * 查询肝功能生化指标列表
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 肝功能生化指标集合
     */
    public List<DataLiverFunctionBiochemistry> selectDataLiverFunctionBiochemistryList(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry);

    /**
     * 新增肝功能生化指标
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 结果
     */
    public int insertDataLiverFunctionBiochemistry(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry);

    /**
     * 修改肝功能生化指标
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 结果
     */
    public int updateDataLiverFunctionBiochemistry(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry);

    /**
     * 批量删除肝功能生化指标
     * 
     * @param Ids 需要删除的肝功能生化指标主键集合
     * @return 结果
     */
    public int deleteDataLiverFunctionBiochemistryByIds(Long[] Ids);

    /**
     * 删除肝功能生化指标信息
     * 
     * @param Id 肝功能生化指标主键
     * @return 结果
     */
    public int deleteDataLiverFunctionBiochemistryById(Long Id);

    String importUser(List<DataLiverFunctionBiochemistry> xmbhList, boolean updateSupport, String operName);

    public List<DataLiverFunctionBiochemistry> selectDataLiverFunctionBiochemistryByEncounterId(Long encounterId);
}
