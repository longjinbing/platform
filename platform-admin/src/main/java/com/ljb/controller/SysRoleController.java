package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.model.RoleDeptModel;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysRole;
import com.ljb.service.SysRoleService;

/**
 * 角色管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */

@RestController
@RequestMapping("sysrole")
@Desc(group="系统用户中心",name="角色管理",type=1,url="admin/sysrole.html")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;


    @RequestMapping("/rolelist/{id}")
    @Desc(name="角色授权",type=2)
    public R roleList(@PathVariable Integer id) {
        //查询列表数据
        return R.ok().put("rolelist", sysRoleService.roleListByuserIdAndAdminId(id, getSysUserId()));
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="角色列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysRoleService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看角色",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysRole  = sysRoleService.selectByRole(id);
        return R.ok().put("data", sysRole);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="角色详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysRole  = sysRoleService.selectMapById(id);
        return R.ok().put("data", sysRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加角色",type=2)
    public R save(@Validated @RequestBody RoleDeptModel model) {
        sysRoleService.save(model);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改角色",type=2)
    public R update(@Validated @RequestBody RoleDeptModel model) {
        sysRoleService.update(model);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除角色",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRoleService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="角色导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysRoleService.selectList(params);
        return R.ok().put("data", list);
    }
}
