package com.kd.system.service.impl;

import java.util.List;

import com.kd.common.exception.ServiceException;
import com.kd.common.utils.StringUtils;
import com.kd.common.utils.bean.BeanValidators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kd.system.mapper.DataBasesignMapper;
import com.kd.system.domain.DataBasesign;
import com.kd.system.service.IDataBasesignService;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * 病例管理Service业务层处理
 * 
 * @author kd
 * @date 2025-05-08
 */
@Service
public class DataBasesignServiceImpl implements IDataBasesignService 
{
    @Autowired
    private DataBasesignMapper dataBasesignMapper;
    @Autowired
    private Validator validator;
    private static final Logger log = LoggerFactory.getLogger(DataBasesignServiceImpl.class);
    /**
     * 查询病例管理
     * 
     * @param Id 病例管理主键
     * @return 病例管理
     */
    @Override
    public DataBasesign selectDataBasesignById(Long Id)
    {
        return dataBasesignMapper.selectDataBasesignById(Id);
    }

    /**
     * 查询病例管理列表
     * 
     * @param dataBasesign 病例管理
     * @return 病例管理
     */
    @Override
    public List<DataBasesign> selectDataBasesignList(DataBasesign dataBasesign)
    {
        return dataBasesignMapper.selectDataBasesignList(dataBasesign);
    }

    /**
     * 新增病例管理
     * 
     * @param dataBasesign 病例管理
     * @return 结果
     */
    @Override
    public int insertDataBasesign(DataBasesign dataBasesign)
    {
        return dataBasesignMapper.insertDataBasesign(dataBasesign);
    }

    /**
     * 修改病例管理
     * 
     * @param dataBasesign 病例管理
     * @return 结果
     */
    @Override
    public int updateDataBasesign(DataBasesign dataBasesign)
    {
        return dataBasesignMapper.updateDataBasesign(dataBasesign);
    }

    /**
     * 批量删除病例管理
     * 
     * @param Ids 需要删除的病例管理主键
     * @return 结果
     */
    @Override
    public int deleteDataBasesignByIds(Long[] Ids)
    {
        return dataBasesignMapper.deleteDataBasesignByIds(Ids);
    }

    /**
     * 删除病例管理信息
     * 
     * @param Id 病例管理主键
     * @return 结果
     */
    @Override
    public int deleteDataBasesignById(Long Id)
    {
        return dataBasesignMapper.deleteDataBasesignById(Id);
    }

//    @Override
//    public String importUser(List<DataBasesign> xmbhList, boolean updateSupport, String operName) {
//        return null;
//    }


@Override
public String importUser(List<DataBasesign> userList, boolean isUpdateSupport, String operName) {
    if (StringUtils.isNull(userList) || userList.isEmpty()) {
        throw new ServiceException("导入用户数据不能为空！");
    }

    int successNum = 0;
    int failureNum = 0;
    StringBuilder successMsg = new StringBuilder();
    StringBuilder failureMsg = new StringBuilder();

    for (int i = 0; i < userList.size(); i++) {
        DataBasesign user = userList.get(i);
        try {
            // 校验实体类字段合法性
            BeanValidators.validateWithException(validator, user);

            // 设置创建人
            user.setCreateBy(operName);

            // 插入数据库
            this.insertDataBasesign(user);

            successNum++;
            successMsg.append("<br/>" + successNum + "、导入成功：姓名[" + user.getName() + "]");

        } catch (ConstraintViolationException e) {
            // 校验失败
            failureNum++;
            String errorMsg = "字段校验失败：" + e.getMessage();
            failureMsg.append("<br/>" + failureNum + "、导入失败：姓名[" + user.getName() + "]，原因：" + errorMsg);
            log.error("第{}行数据校验失败：{}", i + 1, user, e);

        } catch (IllegalArgumentException e) {
            // 数字类型错误或非法参数
            failureNum++;
            String errorMsg = "字段类型错误：" + e.getMessage();
            failureMsg.append("<br/>" + failureNum + "、导入失败：姓名[" + user.getName() + "]，原因：" + errorMsg);
            log.error("第{}行字段类型错误：{}", i + 1, user, e);

        } catch (Exception e) {
            // 其他未知异常
            failureNum++;
            String errorMsg = e.getClass().getSimpleName() + "：" + e.getMessage();
            failureMsg.append("<br/>" + failureNum + "、导入失败：姓名[" + user.getName() + "]，原因：" + errorMsg);
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
