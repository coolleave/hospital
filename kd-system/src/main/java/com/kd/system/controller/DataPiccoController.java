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
import com.kd.system.domain.DataPicco;
import com.kd.system.service.IDataPiccoService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 心输出量监测Controller
 * 
 * @author kd
 * @date 2025-05-09
 */
@RestController
@RequestMapping("/system/picco")
public class DataPiccoController extends BaseController
{
    @Autowired
    private IDataPiccoService dataPiccoService;

    /**
     * 查询心输出量监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:picco:list')")
    @GetMapping("/list")
    public TableDataInfo list(DataPicco dataPicco)
    {
        startPage();
        List<DataPicco> list = dataPiccoService.selectDataPiccoList(dataPicco);
        return getDataTable(list);
    }

    /**
     * 导出心输出量监测列表
     */
    @PreAuthorize("@ss.hasPermi('system:picco:export')")
    @Log(title = "心输出量监测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataPicco dataPicco)
    {
        List<DataPicco> list = dataPiccoService.selectDataPiccoList(dataPicco);
        ExcelUtil<DataPicco> util = new ExcelUtil<DataPicco>(DataPicco.class);
        util.exportExcel(response, list, "心输出量监测数据");
    }

    /**
     * 获取心输出量监测详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:picco:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataPiccoService.selectDataPiccoById(Id));
    }


    @PreAuthorize("@ss.hasPermi('system:gas:query')")
    @GetMapping("/list2")
    public AjaxResult listByEncounterId(@RequestParam("encounterId") Long encounterId) {
        List<DataPicco> list = dataPiccoService.selectDataPiccoByEncounterId(encounterId);
        return success(list);
    }

    /**
     * 新增心输出量监测
     */
    @PreAuthorize("@ss.hasPermi('system:picco:add')")
    @Log(title = "心输出量监测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataPicco dataPicco)
    {
        return toAjax(dataPiccoService.insertDataPicco(dataPicco));
    }

    /**
     * 修改心输出量监测
     */
    @PreAuthorize("@ss.hasPermi('system:picco:edit')")
    @Log(title = "心输出量监测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataPicco dataPicco)
    {
        return toAjax(dataPiccoService.updateDataPicco(dataPicco));
    }


    @Autowired
    private IDataPiccoService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataPicco> util = new ExcelUtil<>(DataPicco.class);
        List<DataPicco> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataPicco> util = new ExcelUtil<>(DataPicco.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }


    /**
     * 删除心输出量监测
     */
    @PreAuthorize("@ss.hasPermi('system:picco:remove')")
    @Log(title = "心输出量监测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataPiccoService.deleteDataPiccoByIds(Ids));
    }
}
