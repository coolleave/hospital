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
import com.kd.system.domain.DataFluidBalance;
import com.kd.system.service.IDataFluidBalanceService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 液体平衡Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/balance")
public class DataFluidBalanceController extends BaseController
{
    @Autowired
    private IDataFluidBalanceService dataFluidBalanceService;

    /**
     * 查询液体平衡列表
     */
    @PreAuthorize("@ss.hasPermi('system:balance:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataFluidBalance dataFluidBalance)
    {
        startPage();
        List<DataFluidBalance> list = dataFluidBalanceService.selectDataFluidBalanceList(dataFluidBalance);
        return getDataTable(list);
    }

    /**
     * 导出液体平衡列表
     */
    @PreAuthorize("@ss.hasPermi('system:balance:export')")
    @Log(title = "液体平衡", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataFluidBalance dataFluidBalance)
    {
        List<DataFluidBalance> list = dataFluidBalanceService.selectDataFluidBalanceList(dataFluidBalance);
        ExcelUtil<DataFluidBalance> util = new ExcelUtil<DataFluidBalance>(DataFluidBalance.class);
        util.exportExcel(response, list, "液体平衡数据");
    }

    /**
     * 获取液体平衡详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:balance:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataFluidBalanceService.selectDataFluidBalanceById(Id));
    }

    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataFluidBalance> list = dataFluidBalanceService.selectDataFluidBalanceByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增液体平衡
     */
    @PreAuthorize("@ss.hasPermi('system:balance:add')")
    @Log(title = "液体平衡", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataFluidBalance dataFluidBalance)
    {
        return toAjax(dataFluidBalanceService.insertDataFluidBalance(dataFluidBalance));
    }

    /**
     * 修改液体平衡
     */
    @PreAuthorize("@ss.hasPermi('system:balance:edit')")
    @Log(title = "液体平衡", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataFluidBalance dataFluidBalance)
    {
        return toAjax(dataFluidBalanceService.updateDataFluidBalance(dataFluidBalance));
    }

    @Autowired
    private IDataFluidBalanceService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataFluidBalance> util = new ExcelUtil<>(DataFluidBalance.class);
        List<DataFluidBalance> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataFluidBalance> util = new ExcelUtil<>(DataFluidBalance.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

    /**
     * 删除液体平衡
     */
    @PreAuthorize("@ss.hasPermi('system:balance:remove')")
    @Log(title = "液体平衡", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataFluidBalanceService.deleteDataFluidBalanceByIds(Ids));
    }
}
