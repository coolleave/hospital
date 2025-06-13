package com.kd.system.service.impl;

import java.util.List;

import com.kd.common.exception.ServiceException;
import com.kd.common.utils.StringUtils;
import com.kd.common.utils.bean.BeanValidators;
import com.kd.system.domain.DataBloodGas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataUrinalysisMapper;
import com.kd.system.domain.DataUrinalysis;
import com.kd.system.service.IDataUrinalysisService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 尿液分析数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-09
 */
@Service
public class DataUrinalysisServiceImpl implements IDataUrinalysisService 
{
    @Autowired
    private DataUrinalysisMapper dataUrinalysisMapper;

    /**
     * 查询尿液分析数据
     * 
     * @param Id 尿液分析数据主键
     * @return 尿液分析数据
     */
    @Override
    public DataUrinalysis selectDataUrinalysisById(Long Id)
    {
        return dataUrinalysisMapper.selectDataUrinalysisById(Id);
    }

    /**
     * 查询尿液分析数据列表
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 尿液分析数据
     */
    @Override
    public List<DataUrinalysis> selectDataUrinalysisList(DataUrinalysis dataUrinalysis)
    {
        return dataUrinalysisMapper.selectDataUrinalysisList(dataUrinalysis);
    }

    /**
     * 新增尿液分析数据
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 结果
     */
    @Override
    public int insertDataUrinalysis(DataUrinalysis dataUrinalysis)
    {
        return dataUrinalysisMapper.insertDataUrinalysis(dataUrinalysis);
    }

    /**
     * 修改尿液分析数据
     * 
     * @param dataUrinalysis 尿液分析数据
     * @return 结果
     */
    @Override
    public int updateDataUrinalysis(DataUrinalysis dataUrinalysis)
    {
        return dataUrinalysisMapper.updateDataUrinalysis(dataUrinalysis);
    }

    /**
     * 批量删除尿液分析数据
     * 
     * @param Ids 需要删除的尿液分析数据主键
     * @return 结果
     */
    @Override
    public int deleteDataUrinalysisByIds(Long[] Ids)
    {
        return dataUrinalysisMapper.deleteDataUrinalysisByIds(Ids);
    }

    @Override
    public List<DataUrinalysis> selectDataUrinalysisByEncounterId(Long encounterId) {
        return dataUrinalysisMapper.selectDataUrinalysisByEncounterId(encounterId);
    }

    /**
     * 删除尿液分析数据信息
     * 
     * @param Id 尿液分析数据主键
     * @return 结果
     */
    @Override
    public int deleteDataUrinalysisById(Long Id)
    {
        return dataUrinalysisMapper.deleteDataUrinalysisById(Id);
    }


    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataUrinalysisServiceImpl.class);


    @Override
    public String importUser(List<DataUrinalysis> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataUrinalysis user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataUrinalysis(user);
                successNum++;
                successMsg.append("<br/>" + successNum + "、导入成功：");

            } catch (ConstraintViolationException e) {
                // 校验失败
                failureNum++;
                String errorMsg = "字段校验失败：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败： 原因：" + errorMsg);
                log.error("第{}行数据校验失败：{}", i + 1, user, e);

            } catch (IllegalArgumentException e) {
                // 数字类型错误或非法参数
                failureNum++;
                String errorMsg = "字段类型错误：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败： 原因：" + errorMsg);
                log.error("第{}行字段类型错误：{}", i + 1, user, e);

            } catch (Exception e) {
                // 其他未知异常
                failureNum++;
                String errorMsg = e.getClass().getSimpleName() + "：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败：原因：" + errorMsg);
                log.error("第{}行发生未知异常：{}", i + 1, user, e);
            }
        }

        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }

        return successMsg.toString();
    }
}
