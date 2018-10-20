package com.ljb.controller;

import com.ljb.annotion.Desc;
import com.ljb.entity.Course;
import com.ljb.service.CourseService;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 课程管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("hcourse")
@Desc(group="课程中心",name="课程管理",type=1,url="vote/hcourse.html")
public class HCourseController extends BaseController {
    @Autowired
    private CourseService courseService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="教师课程列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", courseService.selectHList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="教师查看课程",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object course  = courseService.selectById(id);
        return R.ok().put("data", course);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="教师课程详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object course  = courseService.selectMapById(id);
        return R.ok().put("data", course);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="教师添加课程",type=2)
    public R save(@Validated @RequestBody Course course) {
        courseService.save(course);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="教师修改课程",type=2)
    public R update(@Validated @RequestBody Course course) {
        courseService.update(course);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="教师删除课程",type=2)
    public R delete(@RequestBody Integer[]ids) {
        courseService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="教师课程导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = courseService.selectList(params);
        return R.ok().put("data", list);
    }
}
