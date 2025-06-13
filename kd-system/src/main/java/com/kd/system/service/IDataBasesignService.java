package com.kd.system.service;

import java.util.List;
import com.kd.system.domain.DataBasesign;

/**
 * 病例管理Service接口
 * 
 * @author kd
 * @date 2025-05-08
 */
public interface IDataBasesignService 
{
    /**
     * 查询病例管理
     * 
     * @param Id 病例管理主键
     * @return 病例管理
     */
    public DataBasesign selectDataBasesignById(Long Id);

    /**
     * 查询病例管理列表
     * 
     * @param dataBasesign 病例管理
     * @return 病例管理集合
     */
    public List<DataBasesign> selectDataBasesignList(DataBasesign dataBasesign);

    /**
     * 新增病例管理
     * 
     * @param dataBasesign 病例管理
     * @return 结果
     */
    public int insertDataBasesign(DataBasesign dataBasesign);

    /**
     * 修改病例管理
     * 
     * @param dataBasesign 病例管理
     * @return 结果
     */
    public int updateDataBasesign(DataBasesign dataBasesign);

    /**
     * 批量删除病例管理
     * 
     * @param Ids 需要删除的病例管理主键集合
     * @return 结果
     */
    public int deleteDataBasesignByIds(Long[] Ids);

    /**
     * 删除病例管理信息
     * 
     * @param Id 病例管理主键
     * @return 结果
     */
    public int deleteDataBasesignById(Long Id);

    String importUser(List<DataBasesign> xmbhList, boolean updateSupport, String operName);
}
