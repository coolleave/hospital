package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataHematology;

/**
 * 血液学数据Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataHematologyService 
{
    /**
     * 查询血液学数据
     * 
     * @param Id 血液学数据主键
     * @return 血液学数据
     */
    public DataHematology selectDataHematologyById(Long Id);

    /**
     * 查询血液学数据列表
     * 
     * @param dataHematology 血液学数据
     * @return 血液学数据集合
     */
    public List<DataHematology> selectDataHematologyList(DataHematology dataHematology);

    /**
     * 新增血液学数据
     * 
     * @param dataHematology 血液学数据
     * @return 结果
     */
    public int insertDataHematology(DataHematology dataHematology);

    /**
     * 修改血液学数据
     * 
     * @param dataHematology 血液学数据
     * @return 结果
     */
    public int updateDataHematology(DataHematology dataHematology);

    /**
     * 批量删除血液学数据
     * 
     * @param Ids 需要删除的血液学数据主键集合
     * @return 结果
     */
    public int deleteDataHematologyByIds(Long[] Ids);

    /**
     * 删除血液学数据信息
     * 
     * @param Id 血液学数据主键
     * @return 结果
     */
    public int deleteDataHematologyById(Long Id);

    String importUser(List<DataHematology> xmbhList, boolean updateSupport, String operName);

    public List<DataHematology> selectDataHematologyByEncounterId(Long encounterId);
}
