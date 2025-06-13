package com.kd.system.mapper;

import java.util.List;
import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataVitalsign;

/**
 * 血氧分析Mapper接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface DataBloodGasMapper 
{
    /**
     * 查询血氧分析
     * 
     * @param Id 血氧分析主键
     * @return 血氧分析
     */
    public DataBloodGas selectDataBloodGasById(Long Id);

    /**
     * 查询血氧分析列表
     * 
     * @param dataBloodGas 血氧分析
     * @return 血氧分析集合
     */
    public List<DataBloodGas> selectDataBloodGasList(DataBloodGas dataBloodGas);

    /**
     * 新增血氧分析
     * 
     * @param dataBloodGas 血氧分析
     * @return 结果
     */
    public int insertDataBloodGas(DataBloodGas dataBloodGas);

    /**
     * 修改血氧分析
     * 
     * @param dataBloodGas 血氧分析
     * @return 结果
     */
    public int updateDataBloodGas(DataBloodGas dataBloodGas);

    /**
     * 删除血氧分析
     * 
     * @param Id 血氧分析主键
     * @return 结果
     */
    public int deleteDataBloodGasById(Long Id);

    /**
     * 批量删除血氧分析
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDataBloodGasByIds(Long[] Ids);

    // 新增：根据 encounterId 查询
    List<DataBloodGas> selectDataBloodGasByEncounterId(Long encounterId);
}
