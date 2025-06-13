package com.kd.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataApacheScoreMapper;
import com.kd.system.domain.DataApacheScore;
import com.kd.system.service.IDataApacheScoreService;

/**
 * 生理评分Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataApacheScoreServiceImpl implements IDataApacheScoreService 
{
    @Autowired
    private DataApacheScoreMapper dataApacheScoreMapper;

    /**
     * 查询生理评分
     * 
     * @param Id 生理评分主键
     * @return 生理评分
     */
    @Override
    public DataApacheScore selectDataApacheScoreById(Long Id)
    {
        return dataApacheScoreMapper.selectDataApacheScoreById(Id);
    }

    /**
     * 查询生理评分列表
     * 
     * @param dataApacheScore 生理评分
     * @return 生理评分
     */
    @Override
    public List<DataApacheScore> selectDataApacheScoreList(DataApacheScore dataApacheScore)
    {
        return dataApacheScoreMapper.selectDataApacheScoreList(dataApacheScore);
    }

    /**
     * 新增生理评分
     * 
     * @param dataApacheScore 生理评分
     * @return 结果
     */
    @Override
    public int insertDataApacheScore(DataApacheScore dataApacheScore)
    {
        return dataApacheScoreMapper.insertDataApacheScore(dataApacheScore);
    }

    /**
     * 修改生理评分
     * 
     * @param dataApacheScore 生理评分
     * @return 结果
     */
    @Override
    public int updateDataApacheScore(DataApacheScore dataApacheScore)
    {
        return dataApacheScoreMapper.updateDataApacheScore(dataApacheScore);
    }

    /**
     * 批量删除生理评分
     * 
     * @param Ids 需要删除的生理评分主键
     * @return 结果
     */
    @Override
    public int deleteDataApacheScoreByIds(Long[] Ids)
    {
        return dataApacheScoreMapper.deleteDataApacheScoreByIds(Ids);
    }

    /**
     * 删除生理评分信息
     * 
     * @param Id 生理评分主键
     * @return 结果
     */
    @Override
    public int deleteDataApacheScoreById(Long Id)
    {
        return dataApacheScoreMapper.deleteDataApacheScoreById(Id);
    }
}
