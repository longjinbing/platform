package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysRoleMenu;
import com.ljb.service.SysRoleMenuService;

/**
 * 角色菜单Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */

@RestController
@RequestMapping("sysrolemenu")
@Desc(group="系统用户中心",name="角色菜单",type=1,url="admin/sysrolemenu.html",display = false)
public class SysRoleMenuController extends BaseController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @RequestMapping("/menulist/{id}")
    @Desc(name="角色菜单列表",type=2)
    public R list(@PathVariable Integer id) {
        //查询列表数据
        return R.ok().put("menulist", sysRoleMenuService.menuList(id, getSysUserId()));
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="角色菜单列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysRoleMenuService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看角色菜单",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysRoleMenu  = sysRoleMenuService.selectById(id);
        return R.ok().put("data", sysRoleMenu);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="角色菜单详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysRoleMenu  = sysRoleMenuService.selectMapById(id);
        return R.ok().put("data", sysRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加角色与菜单",type=2)
    public R save(@RequestParam Integer id,@RequestParam Integer[] menuIds ) {
        sysRoleMenuService.save(id, menuIds, getSysUserId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改角色菜单",type=2)
    public R update(@Validated @RequestBody SysRoleMenu sysRoleMenu) {
        sysRoleMenuService.update(sysRoleMenu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除角色菜单",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRoleMenuService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="角色菜单导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysRoleMenuService.selectList(params);
        return R.ok().put("data", list);
    }
}
