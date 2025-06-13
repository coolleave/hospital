package com.kd.system.mapper;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataCpotScore;

/**
 * 重症护理疼痛观察Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataCpotScoreMapper 
{
    /**
     * 查询重症护理疼痛观察
     * 
     * @param Id 重症护理疼痛观察主键
     * @return 重症护理疼痛观察
     */
    public DataCpotScore selectDataCpotScoreById(Long Id);

    /**
     * 查询重症护理疼痛观察列表
     * 
     * @param dataCpotScore 重症护理疼痛观察
     * @return 重症护理疼痛观察集合
     */
    public List<DataCpotScore> selectDataCpotScoreList(DataCpotScore dataCpotScore);

    /**
     * 新增重症护理疼痛观察
     * 
     * @param dataCpotScore 重症护理疼痛观察
     * @return 结果
     */
    public int insertDataCpotScore(DataCpotScore dataCpotScore);

    /**
     * 修改重症护理疼痛观察
     * 
     * @param dataCpotScore 重症护理疼痛观察
     * @return 结果
     */
    public int updateDataCpotScore(DataCpotScore dataCpotScore);

    /**
     * 删除重症护理疼痛观察
     * 
     * @param Id 重症护理疼痛观察主键
     * @return 结果
     */
    public int deleteDataCpotScoreById(Long Id);

    /**
     * 批量删除重症护理疼痛观察
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataCpotScoreByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataCpotScore> selectDataCpotScoreByEncounterId(Long encounterId);
}
