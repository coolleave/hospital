package com.kd.system.service;

import java.util.List;
import com.kd.system.domain.DataApacheScore;

/**
 * 生理评分Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataApacheScoreService 
{
    /**
     * 查询生理评分
     * 
     * @param Id 生理评分主键
     * @return 生理评分
     */
    public DataApacheScore selectDataApacheScoreById(Long Id);

    /**
     * 查询生理评分列表
     * 
     * @param dataApacheScore 生理评分
     * @return 生理评分集合
     */
    public List<DataApacheScore> selectDataApacheScoreList(DataApacheScore dataApacheScore);

    /**
     * 新增生理评分
     * 
     * @param dataApacheScore 生理评分
     * @return 结果
     */
    public int insertDataApacheScore(DataApacheScore dataApacheScore);

    /**
     * 修改生理评分
     * 
     * @param dataApacheScore 生理评分
     * @return 结果
     */
    public int updateDataApacheScore(DataApacheScore dataApacheScore);

    /**
     * 批量删除生理评分
     * 
     * @param Ids 需要删除的生理评分主键集合
     * @return 结果
     */
    public int deleteDataApacheScoreByIds(Long[] Ids);

    /**
     * 删除生理评分信息
     * 
     * @param Id 生理评分主键
     * @return 结果
     */
    public int deleteDataApacheScoreById(Long Id);
}
