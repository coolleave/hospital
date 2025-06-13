package com.kd.system.service.impl;

import java.util.List;

import com.kd.common.exception.ServiceException;
import com.kd.common.utils.StringUtils;
import com.kd.common.utils.bean.BeanValidators;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataLiverFunctionBiochemistryMapper;
import com.kd.system.domain.DataLiverFunctionBiochemistry;
import com.kd.system.service.IDataLiverFunctionBiochemistryService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 肝功能生化指标Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataLiverFunctionBiochemistryServiceImpl implements IDataLiverFunctionBiochemistryService 
{
    @Autowired
    private DataLiverFunctionBiochemistryMapper dataLiverFunctionBiochemistryMapper;

    /**
     * 查询肝功能生化指标
     * 
     * @param Id 肝功能生化指标主键
     * @return 肝功能生化指标
     */
    @Override
    public DataLiverFunctionBiochemistry selectDataLiverFunctionBiochemistryById(Long Id)
    {
        return dataLiverFunctionBiochemistryMapper.selectDataLiverFunctionBiochemistryById(Id);
    }
    @Override
    public List<DataLiverFunctionBiochemistry> selectDataLiverFunctionBiochemistryByEncounterId(Long encounterId) {
        return dataLiverFunctionBiochemistryMapper.selectDataLiverFunctionBiochemistryByEncounterId(encounterId);
    }
    /**
     * 查询肝功能生化指标列表
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 肝功能生化指标
     */
    @Override
    public List<DataLiverFunctionBiochemistry> selectDataLiverFunctionBiochemistryList(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        return dataLiverFunctionBiochemistryMapper.selectDataLiverFunctionBiochemistryList(dataLiverFunctionBiochemistry);
    }

    /**
     * 新增肝功能生化指标
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 结果
     */
    @Override
    public int insertDataLiverFunctionBiochemistry(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        return dataLiverFunctionBiochemistryMapper.insertDataLiverFunctionBiochemistry(dataLiverFunctionBiochemistry);
    }

    /**
     * 修改肝功能生化指标
     * 
     * @param dataLiverFunctionBiochemistry 肝功能生化指标
     * @return 结果
     */
    @Override
    public int updateDataLiverFunctionBiochemistry(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        return dataLiverFunctionBiochemistryMapper.updateDataLiverFunctionBiochemistry(dataLiverFunctionBiochemistry);
    }

    /**
     * 批量删除肝功能生化指标
     * 
     * @param Ids 需要删除的肝功能生化指标主键
     * @return 结果
     */
    @Override
    public int deleteDataLiverFunctionBiochemistryByIds(Long[] Ids)
    {
        return dataLiverFunctionBiochemistryMapper.deleteDataLiverFunctionBiochemistryByIds(Ids);
    }

    /**
     * 删除肝功能生化指标信息
     * 
     * @param Id 肝功能生化指标主键
     * @return 结果
     */
    @Override
    public int deleteDataLiverFunctionBiochemistryById(Long Id)
    {
        return dataLiverFunctionBiochemistryMapper.deleteDataLiverFunctionBiochemistryById(Id);
    }


    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataBasesignServiceImpl.class);

    @Override
    public String importUser(List<DataLiverFunctionBiochemistry> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataLiverFunctionBiochemistry user = userList.get(i);
            Log log = null;
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataLiverFunctionBiochemistry(user);

                successNum++;
                successMsg.append("<br/>" + successNum + "、导入成功：");

            } catch (ConstraintViolationException e) {
                // 校验失败
                failureNum++;
                String errorMsg = "字段校验失败：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败：原因：" + errorMsg);


            } catch (IllegalArgumentException e) {
                // 数字类型错误或非法参数
                failureNum++;
                String errorMsg = "字段类型错误：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败：原因：" + errorMsg);


            } catch (Exception e) {
                // 其他未知异常
                failureNum++;
                String errorMsg = e.getClass().getSimpleName() + "：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败：原因：" + errorMsg);

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
