package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBasesign;
import com.kd.system.domain.DataRecord;

/**
 * 行医记录Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataRecordService 
{
    /**
     * 查询行医记录
     * 
     * @param Id 行医记录主键
     * @return 行医记录
     */
    public DataRecord selectDataRecordById(Long Id);

    /**
     * 查询行医记录列表
     * 
     * @param dataRecord 行医记录
     * @return 行医记录集合
     */
    public List<DataRecord> selectDataRecordList(DataRecord dataRecord);

    /**
     * 新增行医记录
     * 
     * @param dataRecord 行医记录
     * @return 结果
     */
    public int insertDataRecord(DataRecord dataRecord);

    /**
     * 修改行医记录
     * 
     * @param dataRecord 行医记录
     * @return 结果
     */
    public int updateDataRecord(DataRecord dataRecord);

    /**
     * 批量删除行医记录
     * 
     * @param Ids 需要删除的行医记录主键集合
     * @return 结果
     */
    public int deleteDataRecordByIds(Long[] Ids);

    /**
     * 删除行医记录信息
     * 
     * @param Id 行医记录主键
     * @return 结果
     */
    public int deleteDataRecordById(Long Id);

    String importUser(List<DataRecord> xmbhList, boolean updateSupport, String operName);

    public List<DataRecord> selectDataRecordByEncounterId(Long encounterId);
}
