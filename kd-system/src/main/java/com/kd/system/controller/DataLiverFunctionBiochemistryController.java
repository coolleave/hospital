package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.core.domain.model.LoginUser;
import com.kd.system.domain.DataBasesign;
import com.kd.system.domain.DataBloodGas;
import com.kd.system.service.IDataBasesignService;
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
import com.kd.system.domain.DataLiverFunctionBiochemistry;
import com.kd.system.service.IDataLiverFunctionBiochemistryService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 肝功能生化指标Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/biochemistry")
public class DataLiverFunctionBiochemistryController extends BaseController
{
    @Autowired
    private IDataLiverFunctionBiochemistryService dataLiverFunctionBiochemistryService;

    /**
     * 查询肝功能生化指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        startPage();
        List<DataLiverFunctionBiochemistry> list = dataLiverFunctionBiochemistryService.selectDataLiverFunctionBiochemistryList(dataLiverFunctionBiochemistry);
        return getDataTable(list);
    }

    /**
     * 导出肝功能生化指标列表
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:export')")
    @Log(title = "肝功能生化指标", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        List<DataLiverFunctionBiochemistry> list = dataLiverFunctionBiochemistryService.selectDataLiverFunctionBiochemistryList(dataLiverFunctionBiochemistry);
        ExcelUtil<DataLiverFunctionBiochemistry> util = new ExcelUtil<DataLiverFunctionBiochemistry>(DataLiverFunctionBiochemistry.class);
        util.exportExcel(response, list, "肝功能生化指标数据");
    }

    /**
     * 获取肝功能生化指标详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataLiverFunctionBiochemistryService.selectDataLiverFunctionBiochemistryById(Id));
    }


    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataLiverFunctionBiochemistry> list = dataLiverFunctionBiochemistryService.selectDataLiverFunctionBiochemistryByEncounterId(encounterId);
        return success(list);
    }


    /**
     * 新增肝功能生化指标
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:add')")
    @Log(title = "肝功能生化指标", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        return toAjax(dataLiverFunctionBiochemistryService.insertDataLiverFunctionBiochemistry(dataLiverFunctionBiochemistry));
    }

    /**
     * 修改肝功能生化指标
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:edit')")
    @Log(title = "肝功能生化指标", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataLiverFunctionBiochemistry dataLiverFunctionBiochemistry)
    {
        return toAjax(dataLiverFunctionBiochemistryService.updateDataLiverFunctionBiochemistry(dataLiverFunctionBiochemistry));
    }



    @Autowired
    private IDataLiverFunctionBiochemistryService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataLiverFunctionBiochemistry> util = new ExcelUtil<>(DataLiverFunctionBiochemistry.class);
        List<DataLiverFunctionBiochemistry> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataLiverFunctionBiochemistry> util = new ExcelUtil<>(DataLiverFunctionBiochemistry.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }



    /**
     * 删除肝功能生化指标
     */
    @PreAuthorize("@ss.hasPermi('system:biochemistry:remove')")
    @Log(title = "肝功能生化指标", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataLiverFunctionBiochemistryService.deleteDataLiverFunctionBiochemistryByIds(Ids));
    }
}
