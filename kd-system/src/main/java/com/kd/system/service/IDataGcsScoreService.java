package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataGcsScore;

/**
 * 格拉斯哥昏迷评分Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataGcsScoreService 
{
    /**
     * 查询格拉斯哥昏迷评分
     * 
     * @param Id 格拉斯哥昏迷评分主键
     * @return 格拉斯哥昏迷评分
     */
    public DataGcsScore selectDataGcsScoreById(Long Id);

    /**
     * 查询格拉斯哥昏迷评分列表
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 格拉斯哥昏迷评分集合
     */
    public List<DataGcsScore> selectDataGcsScoreList(DataGcsScore dataGcsScore);

    /**
     * 新增格拉斯哥昏迷评分
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 结果
     */
    public int insertDataGcsScore(DataGcsScore dataGcsScore);

    /**
     * 修改格拉斯哥昏迷评分
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 结果
     */
    public int updateDataGcsScore(DataGcsScore dataGcsScore);

    /**
     * 批量删除格拉斯哥昏迷评分
     * 
     * @param Ids 需要删除的格拉斯哥昏迷评分主键集合
     * @return 结果
     */
    public int deleteDataGcsScoreByIds(Long[] Ids);

    /**
     * 删除格拉斯哥昏迷评分信息
     * 
     * @param Id 格拉斯哥昏迷评分主键
     * @return 结果
     */
    public int deleteDataGcsScoreById(Long Id);

    String importUser(List<DataGcsScore> xmbhList, boolean updateSupport, String operName);

    public List<DataGcsScore> selectDataGcsScoreByEncounterId(Long encounterId);
}
