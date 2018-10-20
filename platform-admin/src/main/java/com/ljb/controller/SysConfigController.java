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
import com.ljb.entity.SysConfig;
import com.ljb.service.SysConfigService;

/**
 * 系统配置Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */

@RestController
@RequestMapping("sysconfig")
@Desc(group="系统配置中心",name="系统配置",type=1,url="admin/sysconfig.html")
public class SysConfigController extends BaseController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="系统配置列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysConfigService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看系统配置",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysConfig  = sysConfigService.selectById(id);
        return R.ok().put("data", sysConfig);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="系统配置详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysConfig  = sysConfigService.selectMapById(id);
        return R.ok().put("data", sysConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加系统配置",type=2)
    public R save(@Validated @RequestBody SysConfig sysConfig) {
        sysConfigService.save(sysConfig);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改系统配置",type=2)
    public R update(@Validated @RequestBody SysConfig sysConfig) {
        sysConfigService.update(sysConfig);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除系统配置",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysConfigService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="系统配置导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysConfigService.selectList(params);
        return R.ok().put("data", list);
    }
}
