package com.kd.system.service.impl;

import java.util.List;

import com.kd.common.exception.ServiceException;
import com.kd.common.utils.StringUtils;
import com.kd.common.utils.bean.BeanValidators;
import com.kd.system.domain.DataBasesign;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataRecordMapper;
import com.kd.system.domain.DataRecord;
import com.kd.system.service.IDataRecordService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 行医记录Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataRecordServiceImpl implements IDataRecordService 
{
    @Autowired
    private DataRecordMapper dataRecordMapper;
    @Autowired
    private Validator validator;
    /**
     * 查询行医记录
     * 
     * @param Id 行医记录主键
     * @return 行医记录
     */
    @Override
    public DataRecord selectDataRecordById(Long Id)
    {
        return dataRecordMapper.selectDataRecordById(Id);
    }

    /**
     * 查询行医记录列表
     * 
     * @param dataRecord 行医记录
     * @return 行医记录
     */
    @Override
    public List<DataRecord> selectDataRecordList(DataRecord dataRecord)
    {
        return dataRecordMapper.selectDataRecordList(dataRecord);
    }

    /**
     * 新增行医记录
     * 
     * @param dataRecord 行医记录
     * @return 结果
     */
    @Override
    public int insertDataRecord(DataRecord dataRecord)
    {
        return dataRecordMapper.insertDataRecord(dataRecord);
    }

    /**
     * 修改行医记录
     * 
     * @param dataRecord 行医记录
     * @return 结果
     */
    @Override
    public int updateDataRecord(DataRecord dataRecord)
    {
        return dataRecordMapper.updateDataRecord(dataRecord);
    }

    /**
     * 批量删除行医记录
     * 
     * @param Ids 需要删除的行医记录主键
     * @return 结果
     */
    @Override
    public int deleteDataRecordByIds(Long[] Ids)
    {
        return dataRecordMapper.deleteDataRecordByIds(Ids);
    }


    @Override
    public List<DataRecord> selectDataRecordByEncounterId(Long encounterId) {
        return dataRecordMapper.selectDataRecordByEncounterId(encounterId);
    }

    /**
     * 删除行医记录信息
     * 
     * @param Id 行医记录主键
     * @return 结果
     */
    @Override
    public int deleteDataRecordById(Long Id)
    {
        return dataRecordMapper.deleteDataRecordById(Id);
    }



    @Override
    public String importUser(List<DataRecord> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataRecord user = userList.get(i);
            Log log;
            try {
                // 校验实体类字段合法性

                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataRecord(user);

                successNum++;
                successMsg.append("<br/>" + successNum + "、导入成功");

            } catch (ConstraintViolationException e) {
                // 校验失败
                failureNum++;
                String errorMsg = "字段校验失败：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败，原因：" + errorMsg);


            } catch (IllegalArgumentException e) {
                // 数字类型错误或非法参数
                failureNum++;
                String errorMsg = "字段类型错误：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败，原因：" + errorMsg);


            } catch (Exception e) {
                // 其他未知异常
                failureNum++;
                String errorMsg = e.getClass().getSimpleName() + "：" + e.getMessage();
                failureMsg.append("<br/>" + failureNum + "、导入失败，原因：" + errorMsg);

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
