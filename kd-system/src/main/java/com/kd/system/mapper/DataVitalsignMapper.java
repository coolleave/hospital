package com.kd.system.mapper;

import java.util.List;
import com.kd.system.domain.DataVitalsign;

/**
 * 生命体征Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataVitalsignMapper 
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
     * 删除生命体征
     * 
     * @param Id 生命体征主键
     * @return 结果
     */
    public int deleteDataVitalsignById(Long Id);

    /**
     * 批量删除生命体征
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataVitalsignByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataVitalsign> selectDataVitalsignByEncounterId(Long encounterId);

}
