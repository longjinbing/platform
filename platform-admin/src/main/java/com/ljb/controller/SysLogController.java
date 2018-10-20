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
import com.ljb.entity.SysLog;
import com.ljb.service.SysLogService;

/**
 * 系统日志Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 16:51:52
 */

@RestController
@RequestMapping("syslog")
@Desc(group="系统安全中心",name="系统运行日志",type=1,url="admin/syslog.html")
public class SysLogController extends BaseController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="系统日志列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysLogService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看系统日志",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysLog  = sysLogService.selectById(id);
        return R.ok().put("data", sysLog);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="系统日志详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysLog  = sysLogService.selectMapById(id);
        return R.ok().put("data", sysLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加系统日志",type=2)
    public R save(@Validated @RequestBody SysLog sysLog) {
        sysLogService.save(sysLog);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改系统日志",type=2)
    public R update(@Validated @RequestBody SysLog sysLog) {
        sysLogService.update(sysLog);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除系统日志",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysLogService.deleteBatch(ids);
        return R.ok();
    }


    @RequestMapping("/complete")
    @Desc(name="系统故障处理完毕",type=2)
    public R complete(@RequestBody Integer[]ids) {
        sysLogService.complete(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="系统日志导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysLogService.selectList(params);
        return R.ok().put("data", list);
    }
}
