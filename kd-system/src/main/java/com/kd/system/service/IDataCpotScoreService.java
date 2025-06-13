package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataCpotScore;

/**
 * 重症护理疼痛观察Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataCpotScoreService 
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
     * 批量删除重症护理疼痛观察
     * 
     * @param Ids 需要删除的重症护理疼痛观察主键集合
     * @return 结果
     */
    public int deleteDataCpotScoreByIds(Long[] Ids);

    /**
     * 删除重症护理疼痛观察信息
     * 
     * @param Id 重症护理疼痛观察主键
     * @return 结果
     */
    public int deleteDataCpotScoreById(Long Id);

    String importUser(List<DataCpotScore> xmbhList, boolean updateSupport, String operName);

    public List<DataCpotScore> selectDataCpotScoreByEncounterId(Long encounterId);
}
