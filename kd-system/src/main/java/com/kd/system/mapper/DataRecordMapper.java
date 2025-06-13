package com.kd.system.mapper;

import java.util.List;
import com.kd.system.domain.DataRecord;

/**
 * 行医记录Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataRecordMapper 
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
     * 删除行医记录
     * 
     * @param Id 行医记录主键
     * @return 结果
     */
    public int deleteDataRecordById(Long Id);

    /**
     * 批量删除行医记录
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataRecordByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataRecord> selectDataRecordByEncounterId(Long encounterId);
}
