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
import com.ljb.entity.SysSmsLog;
import com.ljb.service.SysSmsLogService;

/**
 * 短信日志Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:05:13
 */

@RestController
@RequestMapping("syssmslog")
@Desc(group="系统安全中心",name="短信日志",type=1,url="admin/syssmslog.html")
public class SysSmsLogController extends BaseController {
    @Autowired
    private SysSmsLogService sysSmsLogService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="短信日志列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysSmsLogService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看短信日志",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysSmsLog  = sysSmsLogService.selectById(id);
        return R.ok().put("data", sysSmsLog);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="短信日志详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysSmsLog  = sysSmsLogService.selectMapById(id);
        return R.ok().put("data", sysSmsLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加短信日志",type=2)
    public R save(@Validated @RequestBody SysSmsLog sysSmsLog) {
        sysSmsLogService.save(sysSmsLog);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改短信日志",type=2)
    public R update(@Validated @RequestBody SysSmsLog sysSmsLog) {
        sysSmsLogService.update(sysSmsLog);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除短信日志",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysSmsLogService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="短信日志导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysSmsLogService.selectList(params);
        return R.ok().put("data", list);
    }
}
