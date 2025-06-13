package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.core.domain.model.LoginUser;
import com.kd.system.domain.DataBasesign;
import com.kd.system.domain.DataVitalsign;
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
import com.kd.system.domain.DataBloodGas;
import com.kd.system.service.IDataBloodGasService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 血氧分析Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/gas")
public class DataBloodGasController extends BaseController
{
    @Autowired
    private IDataBloodGasService dataBloodGasService;

    /**
     * 查询血氧分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:gas:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataBloodGas dataBloodGas)
    {
        startPage();
        List<DataBloodGas> list = dataBloodGasService.selectDataBloodGasList(dataBloodGas);
        return getDataTable(list);
    }

    /**
     * 导出血氧分析列表
     */
    @PreAuthorize("@ss.hasPermi('system:gas:export')")
    @Log(title = "血氧分析", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataBloodGas dataBloodGas)
    {
        List<DataBloodGas> list = dataBloodGasService.selectDataBloodGasList(dataBloodGas);
        ExcelUtil<DataBloodGas> util = new ExcelUtil<DataBloodGas>(DataBloodGas.class);
        util.exportExcel(response, list, "血氧分析数据");
    }

    /**
     * 获取血氧分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataBloodGasService.selectDataBloodGasById(Id));
    }


    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataBloodGas> list = dataBloodGasService.selectDataBloodGasByEncounterId(encounterId);
        return success(list);
    }


    /**
     * 新增血氧分析
     */
    @PreAuthorize("@ss.hasPermi('system:gas:add')")
    @Log(title = "血氧分析", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataBloodGas dataBloodGas)
    {
        return toAjax(dataBloodGasService.insertDataBloodGas(dataBloodGas));
    }

    /**
     * 修改血氧分析
     */
    @PreAuthorize("@ss.hasPermi('system:gas:edit')")
    @Log(title = "血氧分析", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataBloodGas dataBloodGas)
    {
        return toAjax(dataBloodGasService.updateDataBloodGas(dataBloodGas));
    }


    @Autowired
    private IDataBloodGasService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataBloodGas> util = new ExcelUtil<>(DataBloodGas.class);
        List<DataBloodGas> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataBloodGas> util = new ExcelUtil<>(DataBloodGas.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

    /**
     * 删除血氧分析
     */
    @PreAuthorize("@ss.hasPermi('system:gas:remove')")
    @Log(title = "血氧分析", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataBloodGasService.deleteDataBloodGasByIds(Ids));
    }
}
