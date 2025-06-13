package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kd.common.annotation.Log;
import com.kd.common.core.controller.BaseController;
import com.kd.common.core.domain.AjaxResult;
import com.kd.common.enums.BusinessType;
import com.kd.system.domain.DataApacheScore;
import com.kd.system.service.IDataApacheScoreService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;

/**
 * 生理评分Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/Apachescore")
public class DataApacheScoreController extends BaseController
{
    @Autowired
    private IDataApacheScoreService dataApacheScoreService;

    /**
     * 查询生理评分列表
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataApacheScore dataApacheScore)
    {
        startPage();
        List<DataApacheScore> list = dataApacheScoreService.selectDataApacheScoreList(dataApacheScore);
        return getDataTable(list);
    }

    /**
     * 导出生理评分列表
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:export')")
    @Log(title = "生理评分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataApacheScore dataApacheScore)
    {
        List<DataApacheScore> list = dataApacheScoreService.selectDataApacheScoreList(dataApacheScore);
        ExcelUtil<DataApacheScore> util = new ExcelUtil<DataApacheScore>(DataApacheScore.class);
        util.exportExcel(response, list, "生理评分数据");
    }

    /**
     * 获取生理评分详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataApacheScoreService.selectDataApacheScoreById(Id));
    }

    /**
     * 新增生理评分
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:add')")
    @Log(title = "生理评分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataApacheScore dataApacheScore)
    {
        return toAjax(dataApacheScoreService.insertDataApacheScore(dataApacheScore));
    }

    /**
     * 修改生理评分
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:edit')")
    @Log(title = "生理评分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataApacheScore dataApacheScore)
    {
        return toAjax(dataApacheScoreService.updateDataApacheScore(dataApacheScore));
    }

    /**
     * 删除生理评分
     */
    @PreAuthorize("@ss.hasPermi('system:Apachescore:remove')")
    @Log(title = "生理评分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataApacheScoreService.deleteDataApacheScoreByIds(Ids));
    }
}
