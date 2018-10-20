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
import com.ljb.entity.CourseComment;
import com.ljb.service.CourseCommentService;

/**
 * 课程评价Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:12
 */

@RestController
@RequestMapping("coursecomment")
@Desc(group="评价管理中心",name="课程评价",type=1,url="vote/coursecomment.html",display = false)
public class CourseCommentController extends BaseController {
    @Autowired
    private CourseCommentService courseCommentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="课程评价列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", courseCommentService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看课程评价",type=2,level = 0)
    public R info(@PathVariable("id") Integer id) {
        Object courseComment  = courseCommentService.selectById(id);
        return R.ok().put("data", courseComment);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="课程评价详情",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object courseComment  = courseCommentService.selectMapById(id);
        return R.ok().put("data", courseComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加课程评价",type=2)
    public R save(@Validated @RequestBody CourseComment courseComment) {
        courseCommentService.save(courseComment);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改课程评价",type=2)
    public R update(@Validated @RequestBody CourseComment courseComment) {
        courseCommentService.update(courseComment);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除课程评价",type=2)
    public R delete(@RequestBody Integer[]ids) {
        courseCommentService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="课程评价导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = courseCommentService.selectList(params);
        return R.ok().put("data", list);
    }
}
