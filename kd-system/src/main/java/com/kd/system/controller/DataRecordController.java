package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.core.controller.BaseController;
import com.kd.common.core.domain.model.LoginUser;
import com.kd.system.domain.DataBloodGas;
import com.kd.system.service.IDataBasesignService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.kd.common.annotation.Log;

import com.kd.common.core.domain.AjaxResult;
import com.kd.common.enums.BusinessType;
import com.kd.system.domain.DataRecord;
import com.kd.system.service.IDataRecordService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 行医记录Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/record")
public class DataRecordController extends BaseController
{
    @Autowired
    private IDataRecordService dataRecordService;

    /**
     * 查询行医记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataRecord dataRecord)
    {
        startPage();
        List<DataRecord> list = dataRecordService.selectDataRecordList(dataRecord);
        return getDataTable(list);
    }

    /**
     * 导出行医记录列表
     */
    @PreAuthorize("@ss.hasPermi('system:record:export')")
    @Log(title = "行医记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataRecord dataRecord)
    {
        List<DataRecord> list = dataRecordService.selectDataRecordList(dataRecord);
        ExcelUtil<DataRecord> util = new ExcelUtil<DataRecord>(DataRecord.class);
        util.exportExcel(response, list, "行医记录数据");
    }

    /**
     * 获取行医记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:record:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataRecordService.selectDataRecordById(Id));
    }

    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataRecord> list = dataRecordService.selectDataRecordByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增行医记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:add')")
    @Log(title = "行医记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataRecord dataRecord)
    {
        return toAjax(dataRecordService.insertDataRecord(dataRecord));
    }

    /**
     * 修改行医记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:edit')")
    @Log(title = "行医记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataRecord dataRecord)
    {
        return toAjax(dataRecordService.updateDataRecord(dataRecord));
    }

    @Autowired
    private IDataRecordService userService;

    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        System.out.println("触发上传");
        ExcelUtil<DataRecord> util = new ExcelUtil<>(DataRecord.class);
        List<DataRecord> XmbhList = util.importExcel(file.getInputStream());

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
        System.out.println("触发");
        ExcelUtil<DataRecord> util = new ExcelUtil<>(DataRecord.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

    /**
     * 删除行医记录
     */
    @PreAuthorize("@ss.hasPermi('system:record:remove')")
    @Log(title = "行医记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataRecordService.deleteDataRecordByIds(Ids));
    }
}
