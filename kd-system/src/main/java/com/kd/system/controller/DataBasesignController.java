package com.kd.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.kd.common.annotation.Anonymous;
import com.kd.common.core.domain.entity.SysUser;
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
import com.kd.system.domain.DataBasesign;
import com.kd.system.service.IDataBasesignService;
import com.kd.common.utils.poi.ExcelUtil;
import com.kd.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 病例管理Controller
 * 
 * @author kd
 * @date 2025-05-08
 */
@RestController
@RequestMapping("/system/basesign")
public class DataBasesignController extends BaseController
{
    @Autowired
    private IDataBasesignService dataBasesignService;

    @GetMapping("/list")
    public TableDataInfo list(DataBasesign dataBasesign,
                              @RequestParam(name = "needTotal", required = false) Boolean needTotal) {
        if (needTotal == null || !needTotal) {
            // 如果不是 needTotal，则开启分页
            startPage();
        }

        List<DataBasesign> list = dataBasesignService.selectDataBasesignList(dataBasesign);
        return getDataTable(list);
    }

//    /**
//     * 查询病例管理列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:basesign:list')")
////    @Anonymous
//    @GetMapping("/list")
//    public TableDataInfo list(DataBasesign dataBasesign)
//    {
//        startPage();
//        List<DataBasesign> list = dataBasesignService.selectDataBasesignList(dataBasesign);
//        return getDataTable(list);
//    }



    @Anonymous
    @GetMapping("/hellow")
    public String sayHello() {
        // 返回简单的 "Hello" 字符串
        return "Hello";
    }
    /**
     * 导出病例管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:basesign:export')")
    @Log(title = "病例管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DataBasesign dataBasesign)
    {
        List<DataBasesign> list = dataBasesignService.selectDataBasesignList(dataBasesign);
        ExcelUtil<DataBasesign> util = new ExcelUtil<DataBasesign>(DataBasesign.class);
        util.exportExcel(response, list, "病例管理数据");
    }

    /**
     * 获取病例管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:basesign:query')")
    @GetMapping(value = "/{Id}")
    public AjaxResult getInfo(@PathVariable("Id") Long Id)
    {
        return success(dataBasesignService.selectDataBasesignById(Id));
    }
    /**
     * 新增病例管理
     */
    @PreAuthorize("@ss.hasPermi('system:basesign:add')")
    @Log(title = "病例管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DataBasesign dataBasesign)
    {
        return toAjax(dataBasesignService.insertDataBasesign(dataBasesign));
    }

    /**
     * 修改病例管理
     */
    @PreAuthorize("@ss.hasPermi('system:basesign:edit')")
    @Log(title = "病例管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DataBasesign dataBasesign)
    {
        return toAjax(dataBasesignService.updateDataBasesign(dataBasesign));
    }

    /**
     * 删除病例管理
     */
    @PreAuthorize("@ss.hasPermi('system:basesign:remove')")
    @Log(title = "病例管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{Ids}")
    public AjaxResult remove(@PathVariable Long[] Ids)
    {
        return toAjax(dataBasesignService.deleteDataBasesignByIds(Ids));
    }


    @Autowired
    private IDataBasesignService userService;


    @Log(title = "输入导入", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<DataBasesign> util = new ExcelUtil<>(DataBasesign.class);
        List<DataBasesign> XmbhList = util.importExcel(file.getInputStream());

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
        ExcelUtil<DataBasesign> util = new ExcelUtil<>(DataBasesign.class); // todo
        util.importTemplateExcel(response, "项目编号数据","无");
    }

}
