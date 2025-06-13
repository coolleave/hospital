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
import com.kd.system.domain.DataVitalsign;
import com.kd.system.service.IDataVitalsignService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 生命体征Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/vitalsign")
public class DataVitalsignController extends BaseController
{
    @Autowired
    private IDataVitalsignService dataVitalsignService;

    /**
     * 查询生命体征列表
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataVitalsign dataVitalsign)
    {
        startPage();
        List<DataVitalsign> list = dataVitalsignService.selectDataVitalsignList(dataVitalsign);
        return getDataTable(list);
    }

    /**
     * 导出生命体征列表
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:export')")
    @Log(title = "生命体征", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataVitalsign dataVitalsign)
    {
        List<DataVitalsign> list = dataVitalsignService.selectDataVitalsignList(dataVitalsign);
        ExcelUtil<DataVitalsign> util = new ExcelUtil<DataVitalsign>(DataVitalsign.class);
        util.exportExcel(response, list, "生命体征数据");
    }

    /**
     * 获取生命体征详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataVitalsignService.selectDataVitalsignById(Id));
    }





    @PreAuthorize("@ss.hasPermi('system:vitalsign:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataVitalsign> list = dataVitalsignService.selectDataVitalsignByEncounterId(encounterId);
        return success(list);
    }






    /**
     * 新增生命体征
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:add')")
    @Log(title = "生命体征", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataVitalsign dataVitalsign)
    {
        return toAjax(dataVitalsignService.insertDataVitalsign(dataVitalsign));
    }

    /**
     * 修改生命体征
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:edit')")
    @Log(title = "生命体征", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataVitalsign dataVitalsign)
    {
        return toAjax(dataVitalsignService.updateDataVitalsign(dataVitalsign));
    }

    /**
     * 删除生命体征
     */
    @PreAuthorize("@ss.hasPermi('system:vitalsign:remove')")
    @Log(title = "生命体征", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataVitalsignService.deleteDataVitalsignByIds(Ids));
    }


    @Autowired
    private IDataVitalsignService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataVitalsign> util = new ExcelUtil<>(DataVitalsign.class);
        List<DataVitalsign> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataVitalsign> util = new ExcelUtil<>(DataVitalsign.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }


}
