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
import com.ljb.entity.CourseTeacher;
import com.ljb.service.CourseTeacherService;

/**
 * 课程教师Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */

@RestController
@RequestMapping("courseteacher")
@Desc(group="教务管理中心",name="课程教师",type=1,url="vote/teacher.html",display = false)
public class CourseTeacherController extends BaseController {
    @Autowired
    private CourseTeacherService courseTeacherService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="课程教师列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", courseTeacherService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看课程教师",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object courseTeacher  = courseTeacherService.selectById(id);
        return R.ok().put("data", courseTeacher);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/course/{id}")
    @Desc(name="查看课程教师",type=2)
    public R infoBy(@PathVariable("id") Integer id) {
        Object courseTeacher  = courseTeacherService.selectByCourse(id);
        return R.ok().put("data", courseTeacher);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="课程教师详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object courseTeacher  = courseTeacherService.selectMapById(id);
        return R.ok().put("data", courseTeacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加课程教师",type=2)
    public R save(@Validated @RequestBody CourseTeacher courseTeacher) {
        courseTeacherService.save(courseTeacher);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改课程教师",type=2)
    public R update(@Validated @RequestBody CourseTeacher courseTeacher) {
        courseTeacherService.update(courseTeacher);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除课程教师",type=2)
    public R delete(@RequestBody Integer[]ids) {
        courseTeacherService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="课程教师导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = courseTeacherService.selectList(params);
        return R.ok().put("data", list);
    }
}
