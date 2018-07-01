package com.gzxant.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.SysMenu;
import com.gzxant.enums.SysMenuType;
import com.gzxant.service.ISysMenuService;
import com.gzxant.shiro.GzxantSysUser;
import com.gzxant.util.ReturnDTOUtil;

/**
 *
 * @author chen
 * @date 2017/7/28
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 系统菜单
 */
@Controller
@RequestMapping(value = "/sys/menu")
public class SysMenuController extends BaseController{


    @Autowired
    private ISysMenuService sysMenuService;


    /**
     * 获取菜单详情
     *
     * @param id 菜单ID
     */
    @GetMapping(value = "select/{id}")
    @ResponseBody
    public Map selectById(@PathVariable Long id) {
        Map map = new HashMap();
        map.put("menu", sysMenuService.selectById(id));
        return map;
    }

    /**
     * 进入系统菜单管理首页
     */
    @RequiresPermissions("sys:menu:list")
    @GetMapping(value = "")
    public String list(Model model) {

        model.addAttribute("menuTree", JSON.toJSONString(sysMenuService.getMenuTree()));
        model.addAttribute("menuTypes", SysMenuType.values());
        return "menu/list";
    }

    /**
     * 查询系统用户 侧边栏菜单
     */
    @GetMapping(value = "/usersidemenu")
    @ResponseBody
    public ReturnDTO selectUserSideMenu() {

        return ReturnDTOUtil.success(sysMenuService.CaseMenu(GzxantSysUser.id()));
    }

    /**
     * 保存资源信息
     *
     * @param sysMenu
     * @param redirectAttributes
     *
     * @return
     */
    @PostMapping(value="insert")
    public String save(@Valid SysMenu sysMenu, RedirectAttributes redirectAttributes){
        if (ObjectUtils.isEmpty(sysMenu.getId())) {
            sysMenuService.add(sysMenu);
        }else {
            sysMenuService.update(sysMenu);
        }

        redirectAttributes.addFlashAttribute("message","保存菜单成功");
        return "redirect:/sys/menu";
    }


    /**
     * 设置为不可用
     * @param id
     * @return
     */
    @PostMapping(value="disable/{id}")
    @ResponseBody
    public ReturnDTO disable(@PathVariable("id") Long id){
        sysMenuService.disableMenu(id);
        return ReturnDTOUtil.success();
    }


    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping(value="delete/{id}")
    @ResponseBody
    public ReturnDTO delete(@PathVariable("id") Long id){
        sysMenuService.deleteMenu(id);
        return ReturnDTOUtil.success();
    }
}
