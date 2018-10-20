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
import com.ljb.entity.SysUserRole;
import com.ljb.service.SysUserRoleService;

/**
 * 用户角色Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */

@RestController
@RequestMapping("sysuserrole")
@Desc(group="系统用户中心",name="用户角色",type=1,url="admin/sysuserrole.html",display = false)
public class SysUserRoleController extends BaseController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="用户角色列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysUserRoleService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看用户角色",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysUserRole  = sysUserRoleService.selectById(id);
        return R.ok().put("data", sysUserRole);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="用户角色详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysUserRole  = sysUserRoleService.selectMapById(id);
        return R.ok().put("data", sysUserRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加用户角色",type=2)
    public R save(@RequestParam("id") Integer id,@RequestParam(value = "roleIds",required = false) Integer[] roleIds) {
        sysUserRoleService.save(id,roleIds,getSysUserId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改用户角色",type=2)
    public R update(@Validated @RequestBody SysUserRole sysUserRole) {
        sysUserRoleService.update(sysUserRole);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除用户角色",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysUserRoleService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="用户角色导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysUserRoleService.selectList(params);
        return R.ok().put("data", list);
    }
}
