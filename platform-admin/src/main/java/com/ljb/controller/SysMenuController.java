package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.service.SystemService;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysMenu;
import com.ljb.service.SysMenuService;

/**
 * 菜单管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */

@RestController
@RequestMapping("sysmenu")
@Desc(group="系统用户中心",name="菜单管理",type=1,url="admin/sysmenu.html")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SystemService systemService;

    @RequestMapping("/menulist")
    @Desc(name="左侧菜单",type=2,level = 0)
    public R list() {
        // 查询列表数据
        return R.ok().put("data", sysMenuService.menuList(getSysUserId()));
    }

    @RequestMapping("/menuselectlist")
    @Desc(name="菜单列表",type=2)
    public R selectList() {
        // 查询列表数据
        return R.ok().put("data", sysMenuService.menuSelectList(getSysUserId()));
    }

    @RequestMapping("/ztreelist")
    @Desc(name="菜单列表",type=2)
    public R ztreeList() {
        // 查询列表数据
        return R.ok().put("data", sysMenuService.zTreeList(getSysUserId()));
    }

    @RequestMapping("/reset")
    @Desc(name="初始化系统",type=2)
    public R reset() {
        // 查询列表数据
        systemService.initSystem();
        return R.ok("初始化成功");
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="菜单列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysMenuService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看菜单",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysMenu  = sysMenuService.selectById(id);
        return R.ok().put("data", sysMenu);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="菜单详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysMenu  = sysMenuService.selectMapById(id);
        return R.ok().put("data", sysMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加菜单",type=2)
    public R save(@Validated @RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改菜单",type=2)
    public R update(@Validated  @RequestBody SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除菜单",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysMenuService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="菜单导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysMenuService.selectList(params);
        return R.ok().put("data", list);
    }
}
