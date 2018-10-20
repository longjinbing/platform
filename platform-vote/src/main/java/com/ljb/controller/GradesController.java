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
import com.ljb.entity.Grades;
import com.ljb.service.GradesService;

/**
 * 班级管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
    
@RestController
@RequestMapping("grades")
@Desc(group="教务管理中心",name="班级管理",type=1,url="vote/grades.html")
public class GradesController extends BaseController {
    @Autowired
    private GradesService gradesService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="班级列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", gradesService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看班级",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object grades  = gradesService.selectById(id);
        return R.ok().put("data", grades);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="班级详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object grades  = gradesService.selectMapById(id);
        return R.ok().put("data", grades);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加班级",type=2)
    public R save(@Validated @RequestBody Grades grades) {
        gradesService.save(grades);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改班级",type=2)
    public R update(@Validated @RequestBody Grades grades) {
        gradesService.update(grades);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除班级",type=2)
    public R delete(@RequestBody Integer[]ids) {
        gradesService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="班级导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = gradesService.selectList(params);
        return R.ok().put("data", list);
    }
}
