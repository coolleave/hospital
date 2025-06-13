package com.kd.system.mapper;

import java.util.List;
import com.kd.system.domain.DataApacheScore;

/**
 * 生理评分Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataApacheScoreMapper 
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
     * 删除生理评分
     * 
     * @param Id 生理评分主键
     * @return 结果
     */
    public int deleteDataApacheScoreById(Long Id);

    /**
     * 批量删除生理评分
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataApacheScoreByIds(Long[] Ids);
}
