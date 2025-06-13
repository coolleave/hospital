package com.kd.system.service.impl;

import java.util.List;

import com.kd.common.exception.ServiceException;
import com.kd.common.utils.StringUtils;
import com.kd.common.utils.bean.BeanValidators;
import com.kd.system.domain.DataBasesign;
import com.kd.system.domain.DataVitalsign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataBloodGasMapper;
import com.kd.system.domain.DataBloodGas;
import com.kd.system.service.IDataBloodGasService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 血氧分析Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataBloodGasServiceImpl implements IDataBloodGasService 
{
    @Autowired
    private DataBloodGasMapper dataBloodGasMapper;

    /**
     * 查询血氧分析
     * 
     * @param Id 血氧分析主键
     * @return 血氧分析
     */
    @Override
    public DataBloodGas selectDataBloodGasById(Long Id)
    {
        return dataBloodGasMapper.selectDataBloodGasById(Id);
    }

    /**
     * 查询血氧分析列表
     * 
     * @param dataBloodGas 血氧分析
     * @return 血氧分析
     */
    @Override
    public List<DataBloodGas> selectDataBloodGasList(DataBloodGas dataBloodGas)
    {
        return dataBloodGasMapper.selectDataBloodGasList(dataBloodGas);
    }

    /**
     * 新增血氧分析
     * 
     * @param dataBloodGas 血氧分析
     * @return 结果
     */
    @Override
    public int insertDataBloodGas(DataBloodGas dataBloodGas)
    {
        return dataBloodGasMapper.insertDataBloodGas(dataBloodGas);
    }

    /**
     * 修改血氧分析
     * 
     * @param dataBloodGas 血氧分析
     * @return 结果
     */
    @Override
    public int updateDataBloodGas(DataBloodGas dataBloodGas)
    {
        return dataBloodGasMapper.updateDataBloodGas(dataBloodGas);
    }

    /**
     * 批量删除血氧分析
     * 
     * @param Ids 需要删除的血氧分析主键
     * @return 结果
     */
    @Override
    public int deleteDataBloodGasByIds(Long[] Ids)
    {
        return dataBloodGasMapper.deleteDataBloodGasByIds(Ids);
    }

    /**
     * 删除血氧分析信息
     * 
     * @param Id 血氧分析主键
     * @return 结果
     */
    @Override
    public int deleteDataBloodGasById(Long Id)
    {
        return dataBloodGasMapper.deleteDataBloodGasById(Id);
    }

    @Override
    public List<DataBloodGas> selectDataBloodGasByEncounterId(Long encounterId) {
        return dataBloodGasMapper.selectDataBloodGasByEncounterId(encounterId);
    }


    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataBloodGasServiceImpl.class);


    @Override
    public String importUser(List<DataBloodGas> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataBloodGas user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataBloodGas(user);
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
