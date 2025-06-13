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
import com.kd.system.domain.DataHematology;
import com.kd.system.service.IDataHematologyService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 血液学数据Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/hematology")
public class DataHematologyController extends BaseController
{
    @Autowired
    private IDataHematologyService dataHematologyService;

    /**
     * 查询血液学数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataHematology dataHematology)
    {
        startPage();
        List<DataHematology> list = dataHematologyService.selectDataHematologyList(dataHematology);
        return getDataTable(list);
    }

    /**
     * 导出血液学数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:export')")
    @Log(title = "血液学数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataHematology dataHematology)
    {
        List<DataHematology> list = dataHematologyService.selectDataHematologyList(dataHematology);
        ExcelUtil<DataHematology> util = new ExcelUtil<DataHematology>(DataHematology.class);
        util.exportExcel(response, list, "血液学数据数据");
    }

    /**
     * 获取血液学数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataHematologyService.selectDataHematologyById(Id));
    }

    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataHematology> list = dataHematologyService.selectDataHematologyByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增血液学数据
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:add')")
    @Log(title = "血液学数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataHematology dataHematology)
    {
        return toAjax(dataHematologyService.insertDataHematology(dataHematology));
    }

    /**
     * 修改血液学数据
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:edit')")
    @Log(title = "血液学数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataHematology dataHematology)
    {
        return toAjax(dataHematologyService.updateDataHematology(dataHematology));
    }

    @Autowired
    private IDataHematologyService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataHematology> util = new ExcelUtil<>(DataHematology.class);
        List<DataHematology> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataHematology> util = new ExcelUtil<>(DataHematology.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

    /**
     * 删除血液学数据
     */
    @PreAuthorize("@ss.hasPermi('system:hematology:remove')")
    @Log(title = "血液学数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataHematologyService.deleteDataHematologyByIds(Ids));
    }
}
