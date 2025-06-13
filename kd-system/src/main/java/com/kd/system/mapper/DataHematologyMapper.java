package com.kd.system.mapper;

import java.util.List;
import com.kd.system.domain.DataHematology;

/**
 * 血液学数据Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataHematologyMapper 
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
     * 删除血液学数据
     * 
     * @param Id 血液学数据主键
     * @return 结果
     */
    public int deleteDataHematologyById(Long Id);

    /**
     * 批量删除血液学数据
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataHematologyByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataHematology> selectDataHematologyByEncounterId(Long encounterId);
}
