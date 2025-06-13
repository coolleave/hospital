package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataPicco;

/**
 * 心输出量监测Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataPiccoService 
{
    /**
     * 查询心输出量监测
     * 
     * @param Id 心输出量监测主键
     * @return 心输出量监测
     */
    public DataPicco selectDataPiccoById(Long Id);

    /**
     * 查询心输出量监测列表
     * 
     * @param dataPicco 心输出量监测
     * @return 心输出量监测集合
     */
    public List<DataPicco> selectDataPiccoList(DataPicco dataPicco);

    /**
     * 新增心输出量监测
     * 
     * @param dataPicco 心输出量监测
     * @return 结果
     */
    public int insertDataPicco(DataPicco dataPicco);

    /**
     * 修改心输出量监测
     * 
     * @param dataPicco 心输出量监测
     * @return 结果
     */
    public int updateDataPicco(DataPicco dataPicco);

    /**
     * 批量删除心输出量监测
     * 
     * @param Ids 需要删除的心输出量监测主键集合
     * @return 结果
     */
    public int deleteDataPiccoByIds(Long[] Ids);

    /**
     * 删除心输出量监测信息
     * 
     * @param Id 心输出量监测主键
     * @return 结果
     */
    public int deleteDataPiccoById(Long Id);

    String importUser(List<DataPicco> xmbhList, boolean updateSupport, String operName);

    public List<DataPicco> selectDataPiccoByEncounterId(Long encounterId);
}
