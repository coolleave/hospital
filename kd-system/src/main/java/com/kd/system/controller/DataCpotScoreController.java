package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.core.domain.model.LoginUser;
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
import com.kd.system.domain.DataCpotScore;
import com.kd.system.service.IDataCpotScoreService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 重症护理疼痛观察Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/Cpotscore")
public class DataCpotScoreController extends BaseController
{
    @Autowired
    private IDataCpotScoreService dataCpotScoreService;

    /**
     * 查询重症护理疼痛观察列表
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataCpotScore dataCpotScore)
    {
        startPage();
        List<DataCpotScore> list = dataCpotScoreService.selectDataCpotScoreList(dataCpotScore);
        return getDataTable(list);
    }

    /**
     * 导出重症护理疼痛观察列表
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:export')")
    @Log(title = "重症护理疼痛观察", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataCpotScore dataCpotScore)
    {
        List<DataCpotScore> list = dataCpotScoreService.selectDataCpotScoreList(dataCpotScore);
        ExcelUtil<DataCpotScore> util = new ExcelUtil<DataCpotScore>(DataCpotScore.class);
        util.exportExcel(response, list, "重症护理疼痛观察数据");
    }

    /**
     * 获取重症护理疼痛观察详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataCpotScoreService.selectDataCpotScoreById(Id));
    }

    @PreAuthorize("@ss.hasPermi('system:Cpotscore:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataCpotScore> list = dataCpotScoreService.selectDataCpotScoreByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增重症护理疼痛观察
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:add')")
    @Log(title = "重症护理疼痛观察", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataCpotScore dataCpotScore)
    {
        return toAjax(dataCpotScoreService.insertDataCpotScore(dataCpotScore));
    }

    /**
     * 修改重症护理疼痛观察
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:edit')")
    @Log(title = "重症护理疼痛观察", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataCpotScore dataCpotScore)
    {
        return toAjax(dataCpotScoreService.updateDataCpotScore(dataCpotScore));
    }


    @Autowired
    private IDataCpotScoreService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataCpotScore> util = new ExcelUtil<>(DataCpotScore.class);
        List<DataCpotScore> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataCpotScore> util = new ExcelUtil<>(DataCpotScore.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }


    /**
     * 删除重症护理疼痛观察
     */
    @PreAuthorize("@ss.hasPermi('system:Cpotscore:remove')")
    @Log(title = "重症护理疼痛观察", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataCpotScoreService.deleteDataCpotScoreByIds(Ids));
    }
}
