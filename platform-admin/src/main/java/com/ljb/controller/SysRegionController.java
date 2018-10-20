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
import com.ljb.entity.SysRegion;
import com.ljb.service.SysRegionService;

/**
 * 地区管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */

@RestController
@RequestMapping("sysregion")
@Desc(group="系统配置中心",name="地区管理",type=1,url="admin/sysregion.html")
public class SysRegionController extends BaseController {
    @Autowired
    private SysRegionService sysRegionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="地区列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysRegionService.selectList(params));
    }

    @RequestMapping("/ztreelist")
    @Desc(name="省市信息",type=2,level = 0)
    public R ztreeList() {
        //查询列表数据
        return R.ok().put("data", sysRegionService.zTreeList());
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看地区",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysRegion  = sysRegionService.selectById(id);
        return R.ok().put("data", sysRegion);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="地区详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysRegion  = sysRegionService.selectMapById(id);
        return R.ok().put("data", sysRegion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加地区",type=2)
    public R save(@Validated @RequestBody SysRegion sysRegion) {
        sysRegionService.save(sysRegion);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改地区",type=2)
    public R update(@Validated @RequestBody SysRegion sysRegion) {
        sysRegionService.update(sysRegion);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除地区",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysRegionService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="地区导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysRegionService.selectList(params);
        return R.ok().put("data", list);
    }
}
