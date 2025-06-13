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
import com.kd.system.mapper.DataFluidBalanceMapper;
import com.kd.system.domain.DataFluidBalance;
import com.kd.system.service.IDataFluidBalanceService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 液体平衡Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataFluidBalanceServiceImpl implements IDataFluidBalanceService 
{
    @Autowired
    private DataFluidBalanceMapper dataFluidBalanceMapper;

    /**
     * 查询液体平衡
     * 
     * @param Id 液体平衡主键
     * @return 液体平衡
     */
    @Override
    public DataFluidBalance selectDataFluidBalanceById(Long Id)
    {
        return dataFluidBalanceMapper.selectDataFluidBalanceById(Id);
    }


    @Override
    public List<DataFluidBalance> selectDataFluidBalanceByEncounterId(Long encounterId) {
        return dataFluidBalanceMapper.selectDataFluidBalanceByEncounterId(encounterId);
    }

    /**
     * 查询液体平衡列表
     * 
     * @param dataFluidBalance 液体平衡
     * @return 液体平衡
     */
    @Override
    public List<DataFluidBalance> selectDataFluidBalanceList(DataFluidBalance dataFluidBalance)
    {
        return dataFluidBalanceMapper.selectDataFluidBalanceList(dataFluidBalance);
    }

    /**
     * 新增液体平衡
     * 
     * @param dataFluidBalance 液体平衡
     * @return 结果
     */
    @Override
    public int insertDataFluidBalance(DataFluidBalance dataFluidBalance)
    {
        return dataFluidBalanceMapper.insertDataFluidBalance(dataFluidBalance);
    }

    /**
     * 修改液体平衡
     * 
     * @param dataFluidBalance 液体平衡
     * @return 结果
     */
    @Override
    public int updateDataFluidBalance(DataFluidBalance dataFluidBalance)
    {
        return dataFluidBalanceMapper.updateDataFluidBalance(dataFluidBalance);
    }

    /**
     * 批量删除液体平衡
     * 
     * @param Ids 需要删除的液体平衡主键
     * @return 结果
     */
    @Override
    public int deleteDataFluidBalanceByIds(Long[] Ids)
    {
        return dataFluidBalanceMapper.deleteDataFluidBalanceByIds(Ids);
    }

    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataFluidBalanceServiceImpl.class);


    @Override
    public String importUser(List<DataFluidBalance> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataFluidBalance user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataFluidBalance(user);
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
    /**
     * 删除液体平衡信息
     * 
     * @param Id 液体平衡主键
     * @return 结果
     */
    @Override
    public int deleteDataFluidBalanceById(Long Id)
    {
        return dataFluidBalanceMapper.deleteDataFluidBalanceById(Id);
    }
}
