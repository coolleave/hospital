package com.kd.system.service;

import java.util.List;

import com.kd.system.domain.DataBloodGas;
import com.kd.system.domain.DataFluidBalance;

/**
 * 液体平衡Service接口
 * 
 * @author kd
 * @date 2025-05-09
 */
public interface IDataFluidBalanceService 
{
    /**
     * 查询液体平衡
     * 
     * @param Id 液体平衡主键
     * @return 液体平衡
     */
    public DataFluidBalance selectDataFluidBalanceById(Long Id);

    /**
     * 查询液体平衡列表
     * 
     * @param dataFluidBalance 液体平衡
     * @return 液体平衡集合
     */
    public List<DataFluidBalance> selectDataFluidBalanceList(DataFluidBalance dataFluidBalance);

    /**
     * 新增液体平衡
     * 
     * @param dataFluidBalance 液体平衡
     * @return 结果
     */
    public int insertDataFluidBalance(DataFluidBalance dataFluidBalance);

    /**
     * 修改液体平衡
     * 
     * @param dataFluidBalance 液体平衡
     * @return 结果
     */
    public int updateDataFluidBalance(DataFluidBalance dataFluidBalance);

    /**
     * 批量删除液体平衡
     * 
     * @param Ids 需要删除的液体平衡主键集合
     * @return 结果
     */
    public int deleteDataFluidBalanceByIds(Long[] Ids);

    /**
     * 删除液体平衡信息
     * 
     * @param Id 液体平衡主键
     * @return 结果
     */
    public int deleteDataFluidBalanceById(Long Id);

    String importUser(List<DataFluidBalance> xmbhList, boolean updateSupport, String operName);

    public List<DataFluidBalance> selectDataFluidBalanceByEncounterId(Long encounterId);
}
