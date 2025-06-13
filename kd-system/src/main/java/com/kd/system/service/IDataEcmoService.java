package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataEcmo;

/**
 * 体外膜肺氧合Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataEcmoService 
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
     * 批量删除体外膜肺氧合
     * 
     * @param Ids 需要删除的体外膜肺氧合主键集合
     * @return 结果
     */
    public int deleteDataEcmoByIds(Long[] Ids);

    /**
     * 删除体外膜肺氧合信息
     * 
     * @param Id 体外膜肺氧合主键
     * @return 结果
     */
    public int deleteDataEcmoById(Long Id);

    String importUser(List<DataEcmo> xmbhList, boolean updateSupport, String operName);

    public List<DataEcmo> selectDataEcmoByEncounterId(Long encounterId);
}
