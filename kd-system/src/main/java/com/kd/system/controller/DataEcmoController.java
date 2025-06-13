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
import com.kd.system.domain.DataEcmo;
import com.kd.system.service.IDataEcmoService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 体外膜肺氧合Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/ecmo")
public class DataEcmoController extends BaseController
{
    @Autowired
    private IDataEcmoService dataEcmoService;

    /**
     * 查询体外膜肺氧合列表
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataEcmo dataEcmo)
    {
        startPage();
        List<DataEcmo> list = dataEcmoService.selectDataEcmoList(dataEcmo);
        return getDataTable(list);
    }

    /**
     * 导出体外膜肺氧合列表
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:export')")
    @Log(title = "体外膜肺氧合", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataEcmo dataEcmo)
    {
        List<DataEcmo> list = dataEcmoService.selectDataEcmoList(dataEcmo);
        ExcelUtil<DataEcmo> util = new ExcelUtil<DataEcmo>(DataEcmo.class);
        util.exportExcel(response, list, "体外膜肺氧合数据");
    }

    /**
     * 获取体外膜肺氧合详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataEcmoService.selectDataEcmoById(Id));
    }


    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataEcmo> list = dataEcmoService.selectDataEcmoByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增体外膜肺氧合
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:add')")
    @Log(title = "体外膜肺氧合", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataEcmo dataEcmo)
    {
        return toAjax(dataEcmoService.insertDataEcmo(dataEcmo));
    }

    /**
     * 修改体外膜肺氧合
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:edit')")
    @Log(title = "体外膜肺氧合", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataEcmo dataEcmo)
    {
        return toAjax(dataEcmoService.updateDataEcmo(dataEcmo));
    }

    /**
     * 删除体外膜肺氧合
     */
    @PreAuthorize("@ss.hasPermi('system:ecmo:remove')")
    @Log(title = "体外膜肺氧合", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataEcmoService.deleteDataEcmoByIds(Ids));
    }


    @Autowired
    private IDataEcmoService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataEcmo> util = new ExcelUtil<>(DataEcmo.class);
        List<DataEcmo> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataEcmo> util = new ExcelUtil<>(DataEcmo.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

}
