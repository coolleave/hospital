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
import com.kd.system.mapper.DataGcsScoreMapper;
import com.kd.system.domain.DataGcsScore;
import com.kd.system.service.IDataGcsScoreService;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 格拉斯哥昏迷评分Service业务层处理
 * 
 * @author kd
 * @date 2025-05-09
 */
@Service
public class DataGcsScoreServiceImpl implements IDataGcsScoreService 
{
    @Autowired
    private DataGcsScoreMapper dataGcsScoreMapper;

    /**
     * 查询格拉斯哥昏迷评分
     * 
     * @param Id 格拉斯哥昏迷评分主键
     * @return 格拉斯哥昏迷评分
     */
    @Override
    public DataGcsScore selectDataGcsScoreById(Long Id)
    {
        return dataGcsScoreMapper.selectDataGcsScoreById(Id);
    }

    /**
     * 查询格拉斯哥昏迷评分列表
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 格拉斯哥昏迷评分
     */
    @Override
    public List<DataGcsScore> selectDataGcsScoreList(DataGcsScore dataGcsScore)
    {
        return dataGcsScoreMapper.selectDataGcsScoreList(dataGcsScore);
    }

    /**
     * 新增格拉斯哥昏迷评分
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 结果
     */
    @Override
    public int insertDataGcsScore(DataGcsScore dataGcsScore)
    {
        return dataGcsScoreMapper.insertDataGcsScore(dataGcsScore);
    }

    /**
     * 修改格拉斯哥昏迷评分
     * 
     * @param dataGcsScore 格拉斯哥昏迷评分
     * @return 结果
     */
    @Override
    public int updateDataGcsScore(DataGcsScore dataGcsScore)
    {
        return dataGcsScoreMapper.updateDataGcsScore(dataGcsScore);
    }

    /**
     * 批量删除格拉斯哥昏迷评分
     * 
     * @param Ids 需要删除的格拉斯哥昏迷评分主键
     * @return 结果
     */
    @Override
    public int deleteDataGcsScoreByIds(Long[] Ids)
    {
        return dataGcsScoreMapper.deleteDataGcsScoreByIds(Ids);
    }

    /**
     * 删除格拉斯哥昏迷评分信息
     * 
     * @param Id 格拉斯哥昏迷评分主键
     * @return 结果
     */
    @Override
    public int deleteDataGcsScoreById(Long Id)
    {
        return dataGcsScoreMapper.deleteDataGcsScoreById(Id);
    }

    @Override
    public List<DataGcsScore> selectDataGcsScoreByEncounterId(Long encounterId) {
        return dataGcsScoreMapper.selectDataGcsScoreByEncounterId(encounterId);
    }


    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataGcsScoreServiceImpl.class);


    @Override
    public String importUser(List<DataGcsScore> userList, boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(userList) || userList.isEmpty()) {
            throw new ServiceException("导入用户数据不能为空！");
        }

        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < userList.size(); i++) {
            DataGcsScore user = userList.get(i);
            try {
                // 校验实体类字段合法性
                BeanValidators.validateWithException(validator, user);

                // 设置创建人
                user.setCreateBy(operName);

                // 插入数据库
                this.insertDataGcsScore(user);
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
