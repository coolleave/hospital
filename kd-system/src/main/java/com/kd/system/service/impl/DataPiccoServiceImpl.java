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
import com.kd.system.mapper.DataPiccoMapper;
import com.kd.system.domain.DataPicco;
import com.kd.system.service.IDataPiccoService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 心输出量监测Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataPiccoServiceImpl implements IDataPiccoService 
{
    @Autowired
    private DataPiccoMapper dataPiccoMapper;

    /**
     * 查询心输出量监测
     * 
     * @param Id 心输出量监测主键
     * @return 心输出量监测
     */
    @Override
    public DataPicco selectDataPiccoById(Long Id)
    {
        return dataPiccoMapper.selectDataPiccoById(Id);
    }

    /**
     * 查询心输出量监测列表
     * 
     * @param dataPicco 心输出量监测
     * @return 心输出量监测
     */
    @Override
    public List<DataPicco> selectDataPiccoList(DataPicco dataPicco)
    {
        return dataPiccoMapper.selectDataPiccoList(dataPicco);
    }

    /**
     * 新增心输出量监测
     * 
     * @param dataPicco 心输出量监测
     * @return 结果
     */
    @Override
    public int insertDataPicco(DataPicco dataPicco)
    {
        return dataPiccoMapper.insertDataPicco(dataPicco);
    }

    /**
     * 修改心输出量监测
     * 
     * @param dataPicco 心输出量监测
     * @return 结果
     */
    @Override
    public int updateDataPicco(DataPicco dataPicco)
    {
        return dataPiccoMapper.updateDataPicco(dataPicco);
    }

    /**
     * 批量删除心输出量监测
     * 
     * @param Ids 需要删除的心输出量监测主键
     * @return 结果
     */
    @Override
    public int deleteDataPiccoByIds(Long[] Ids)
    {
        return dataPiccoMapper.deleteDataPiccoByIds(Ids);
    }

    /**
     * 删除心输出量监测信息
     * 
     * @param Id 心输出量监测主键
     * @return 结果
     */
    @Override
    public int deleteDataPiccoById(Long Id)
    {
        return dataPiccoMapper.deleteDataPiccoById(Id);
    }

    @Override
    public List<DataPicco> selectDataPiccoByEncounterId(Long encounterId) {
        return dataPiccoMapper.selectDataPiccoByEncounterId(encounterId);
    }

    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataPiccoServiceImpl.class);


    @Override
    public String importUser(List<DataPicco> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataPicco user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataPicco(user);
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
