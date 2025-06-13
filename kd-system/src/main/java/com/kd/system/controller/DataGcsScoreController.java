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
import com.kd.system.domain.DataGcsScore;
import com.kd.system.service.IDataGcsScoreService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 格拉斯哥昏迷评分Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/Gcsscore")
public class DataGcsScoreController extends BaseController
{
    @Autowired
    private IDataGcsScoreService dataGcsScoreService;

    /**
     * 查询格拉斯哥昏迷评分列表
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataGcsScore dataGcsScore)
    {
        startPage();
        List<DataGcsScore> list = dataGcsScoreService.selectDataGcsScoreList(dataGcsScore);
        return getDataTable(list);
    }

    /**
     * 导出格拉斯哥昏迷评分列表
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:export')")
    @Log(title = "格拉斯哥昏迷评分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataGcsScore dataGcsScore)
    {
        List<DataGcsScore> list = dataGcsScoreService.selectDataGcsScoreList(dataGcsScore);
        ExcelUtil<DataGcsScore> util = new ExcelUtil<DataGcsScore>(DataGcsScore.class);
        util.exportExcel(response, list, "格拉斯哥昏迷评分数据");
    }

    /**
     * 获取格拉斯哥昏迷评分详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataGcsScoreService.selectDataGcsScoreById(Id));
    }

    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataGcsScore> list = dataGcsScoreService.selectDataGcsScoreByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增格拉斯哥昏迷评分
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:add')")
    @Log(title = "格拉斯哥昏迷评分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataGcsScore dataGcsScore)
    {
        return toAjax(dataGcsScoreService.insertDataGcsScore(dataGcsScore));
    }

    /**
     * 修改格拉斯哥昏迷评分
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:edit')")
    @Log(title = "格拉斯哥昏迷评分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataGcsScore dataGcsScore)
    {
        return toAjax(dataGcsScoreService.updateDataGcsScore(dataGcsScore));
    }

    /**
     * 删除格拉斯哥昏迷评分
     */
    @PreAuthorize("@ss.hasPermi('system:Gcsscore:remove')")
    @Log(title = "格拉斯哥昏迷评分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataGcsScoreService.deleteDataGcsScoreByIds(Ids));
    }


    @Autowired
    private IDataGcsScoreService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataGcsScore> util = new ExcelUtil<>(DataGcsScore.class);
        List<DataGcsScore> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataGcsScore> util = new ExcelUtil<>(DataGcsScore.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

}
