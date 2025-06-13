package com.kd.system.mapper;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataEcmo;

/**
 * 体外膜肺氧合Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataEcmoMapper 
{
    /**
     * 查询体外膜肺氧合
     * 
     * @param Id 体外膜肺氧合主键
     * @return 体外膜肺氧合
     */
    public DataEcmo selectDataEcmoById(Long Id);

    /**
     * 查询体外膜肺氧合列表
     * 
     * @param dataEcmo 体外膜肺氧合
     * @return 体外膜肺氧合集合
     */
    public List<DataEcmo> selectDataEcmoList(DataEcmo dataEcmo);

    /**
     * 新增体外膜肺氧合
     * 
     * @param dataEcmo 体外膜肺氧合
     * @return 结果
     */
    public int insertDataEcmo(DataEcmo dataEcmo);

    /**
     * 修改体外膜肺氧合
     * 
     * @param dataEcmo 体外膜肺氧合
     * @return 结果
     */
    public int updateDataEcmo(DataEcmo dataEcmo);

    /**
     * 删除体外膜肺氧合
     * 
     * @param Id 体外膜肺氧合主键
     * @return 结果
     */
    public int deleteDataEcmoById(Long Id);

    /**
     * 批量删除体外膜肺氧合
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataEcmoByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataEcmo> selectDataEcmoByEncounterId(Long encounterId);


}
