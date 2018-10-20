package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.example.SysRoleDeptExample;
import com.ljb.example.SysUserRoleExample;
import com.ljb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysDept;
import com.ljb.service.SysDeptService;

/**
 * 部门管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */

@RestController
@RequestMapping("sysdept")
@Desc(group="系统用户中心",name="部门管理",type=1,url="admin/sysdept.html")
public class SysDeptController extends BaseController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping("/deptlist")
    @Desc(name="部门列表",type=2)
    public R zTreelist() {
        //查询列表数据
        return R.ok().put("data", sysDeptService.zTreeList(getSysUserId()));
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="部门列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysDeptService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看部门",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysDept  = sysDeptService.selectById(id);
        return R.ok().put("data", sysDept);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="部门详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysDept  = sysDeptService.selectMapById(id);
        return R.ok().put("data", sysDept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加部门",type=2)
    public R save(@Validated @RequestBody SysDept sysDept) {
        sysDeptService.save(sysDept);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改部门",type=2)
    public R update(@Validated @RequestBody SysDept sysDept) {
        sysDeptService.update(sysDept);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除部门",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysDeptService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="部门导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysDeptService.selectList(params);
        return R.ok().put("data", list);
    }
}
