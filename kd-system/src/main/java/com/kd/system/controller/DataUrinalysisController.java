package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.core.domain.model.LoginUser;
import com.kd.system.domain.DataBloodGas;
import com.kd.system.service.IDataBloodGasService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.kd.common.annotation.Log;
import com.kd.common.core.controller.BaseController;
import com.kd.common.core.domain.AjaxResult;
import com.kd.common.enums.BusinessType;
import com.kd.system.domain.DataUrinalysis;
import com.kd.system.service.IDataUrinalysisService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 尿液分析数据Controller
 * 
 * @author ruoyi
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/urinalysis")
public class DataUrinalysisController extends BaseController
{
    @Autowired
    private IDataUrinalysisService dataUrinalysisService;

    /**
     * 查询尿液分析数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataUrinalysis dataUrinalysis)
    {
        startPage();
        List<DataUrinalysis> list = dataUrinalysisService.selectDataUrinalysisList(dataUrinalysis);
        return getDataTable(list);
    }

    /**
     * 导出尿液分析数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:export')")
    @Log(title = "尿液分析数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataUrinalysis dataUrinalysis)
    {
        List<DataUrinalysis> list = dataUrinalysisService.selectDataUrinalysisList(dataUrinalysis);
        ExcelUtil<DataUrinalysis> util = new ExcelUtil<DataUrinalysis>(DataUrinalysis.class);
        util.exportExcel(response, list, "尿液分析数据数据");
    }

    /**
     * 获取尿液分析数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataUrinalysisService.selectDataUrinalysisById(Id));
    }


    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataUrinalysis> list = dataUrinalysisService.selectDataUrinalysisByEncounterId(encounterId);
        return success(list);
    }


    /**
     * 新增尿液分析数据
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:add')")
    @Log(title = "尿液分析数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataUrinalysis dataUrinalysis)
    {
        return toAjax(dataUrinalysisService.insertDataUrinalysis(dataUrinalysis));
    }

    /**
     * 修改尿液分析数据
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:edit')")
    @Log(title = "尿液分析数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataUrinalysis dataUrinalysis)
    {
        return toAjax(dataUrinalysisService.updateDataUrinalysis(dataUrinalysis));
    }


    @Autowired
    private IDataUrinalysisService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataUrinalysis> util = new ExcelUtil<>(DataUrinalysis.class);
        List<DataUrinalysis> XmbhList = util.importExcel(file.getInputStream());

        // ✅ 获取当前登录用户（不是 new LoginUser()！）
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            return AjaxResult.error("用户未登录");
        }

        // 假设你的 User 是 LoginUser 类型
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String operName = loginUser.getUsername(); // ✅ 这时候的 username 不是 null

        String message = userService.importUser(XmbhList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DataUrinalysis> util = new ExcelUtil<>(DataUrinalysis.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }



    /**
     * 删除尿液分析数据
     */
    @PreAuthorize("@ss.hasPermi('system:urinalysis:remove')")
    @Log(title = "尿液分析数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataUrinalysisService.deleteDataUrinalysisByIds(Ids));
    }
}
