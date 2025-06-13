package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataVitalsign;

/**
 * 生命体征Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataVitalsignService 
{
    /**
     * 查询生命体征
     * 
     * @param Id 生命体征主键
     * @return 生命体征
     */
    public DataVitalsign selectDataVitalsignById(Long Id);

    /**
     * 查询生命体征列表
     * 
     * @param dataVitalsign 生命体征
     * @return 生命体征集合
     */
    public List<DataVitalsign> selectDataVitalsignList(DataVitalsign dataVitalsign);

    /**
     * 新增生命体征
     * 
     * @param dataVitalsign 生命体征
     * @return 结果
     */
    public int insertDataVitalsign(DataVitalsign dataVitalsign);

    /**
     * 修改生命体征
     * 
     * @param dataVitalsign 生命体征
     * @return 结果
     */
    public int updateDataVitalsign(DataVitalsign dataVitalsign);

    /**
     * 批量删除生命体征
     * 
     * @param Ids 需要删除的生命体征主键集合
     * @return 结果
     */
    public int deleteDataVitalsignByIds(Long[] Ids);

    /**
     * 删除生命体征信息
     * 
     * @param Id 生命体征主键
     * @return 结果
     */
    public int deleteDataVitalsignById(Long Id);

    String importUser(List<DataVitalsign> xmbhList, boolean updateSupport, String operName);

    public List<DataVitalsign> selectDataVitalsignByEncounterId(Long encounterId);
}
