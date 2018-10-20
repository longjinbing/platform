package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysRoleDept;
import com.ljb.service.SysRoleDeptService;

/**
 * 角色部门Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */

@RestController
@RequestMapping("sysroledept")
@Desc(group="系统用户中心",name="角色部门",type=1,url="admin/sysroledept.html",display = false)
public class SysRoleDeptController extends BaseController {
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="角色部门列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysRoleDeptService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看角色部门",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysRoleDept  = sysRoleDeptService.selectById(id);
        return R.ok().put("data", sysRoleDept);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="角色部门详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysRoleDept  = sysRoleDeptService.selectMapById(id);
        return R.ok().put("data", sysRoleDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加角色部门",type=2)
    public R save(@Validated @RequestBody SysRoleDept sysRoleDept) {
        sysRoleDeptService.save(sysRoleDept);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改角色部门",type=2)
    public R update(@Validated @RequestBody SysRoleDept sysRoleDept) {
        sysRoleDeptService.update(sysRoleDept);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除角色部门",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRoleDeptService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="角色部门导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysRoleDeptService.selectList(params);
        return R.ok().put("data", list);
    }
}
