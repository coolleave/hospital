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
import com.kd.system.mapper.DataVitalsignMapper;
import com.kd.system.domain.DataVitalsign;
import com.kd.system.service.IDataVitalsignService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 生命体征Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataVitalsignServiceImpl implements IDataVitalsignService 
{
    @Autowired
    private DataVitalsignMapper dataVitalsignMapper;

    /**
     * 查询生命体征
     * 
     * @param Id 生命体征主键
     * @return 生命体征
     */
    @Override
    public DataVitalsign selectDataVitalsignById(Long Id)
    {
        return dataVitalsignMapper.selectDataVitalsignById(Id);
    }

    /**
     * 查询生命体征列表
     * 
     * @param dataVitalsign 生命体征
     * @return 生命体征
     */
    @Override
    public List<DataVitalsign> selectDataVitalsignList(DataVitalsign dataVitalsign)
    {
        return dataVitalsignMapper.selectDataVitalsignList(dataVitalsign);
    }

    /**
     * 新增生命体征
     * 
     * @param dataVitalsign 生命体征
     * @return 结果
     */
    @Override
    public int insertDataVitalsign(DataVitalsign dataVitalsign)
    {
        return dataVitalsignMapper.insertDataVitalsign(dataVitalsign);
    }

    /**
     * 修改生命体征
     * 
     * @param dataVitalsign 生命体征
     * @return 结果
     */
    @Override
    public int updateDataVitalsign(DataVitalsign dataVitalsign)
    {
        return dataVitalsignMapper.updateDataVitalsign(dataVitalsign);
    }

    /**
     * 批量删除生命体征
     * 
     * @param Ids 需要删除的生命体征主键
     * @return 结果
     */
    @Override
    public int deleteDataVitalsignByIds(Long[] Ids)
    {
        return dataVitalsignMapper.deleteDataVitalsignByIds(Ids);
    }

    /**
     * 删除生命体征信息
     * 
     * @param Id 生命体征主键
     * @return 结果
     */
    @Override
    public int deleteDataVitalsignById(Long Id)
    {
        return dataVitalsignMapper.deleteDataVitalsignById(Id);
    }

    @Override
    public List<DataVitalsign> selectDataVitalsignByEncounterId(Long encounterId) {
        return dataVitalsignMapper.selectDataVitalsignByEncounterId(encounterId);
    }

    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataVitalsignServiceImpl.class);


    @Override
    public String importUser(List<DataVitalsign> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataVitalsign user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataVitalsign(user);
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
