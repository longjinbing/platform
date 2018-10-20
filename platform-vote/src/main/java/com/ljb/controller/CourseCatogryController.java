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
import com.ljb.entity.CourseCatogry;
import com.ljb.service.CourseCatogryService;

/**
 * 课程分类Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("coursecatogry")
@Desc(group="教务管理中心",name="课程分类",type=1,url="vote/coursecatogry.html")
public class CourseCatogryController extends BaseController {
    @Autowired
    private CourseCatogryService courseCatogryService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="课程分类列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", courseCatogryService.selectList(params));
    }

    @RequestMapping("/categorylist")
    @Desc(name="课程分类列表（教师）",type=2,level = 0)
    public R list() {
        //查询列表数据
        return R.ok().put("data", courseCatogryService.allList());
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看课程分类",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object courseCatogry  = courseCatogryService.selectById(id);
        return R.ok().put("data", courseCatogry);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="课程分类详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object courseCatogry  = courseCatogryService.selectMapById(id);
        return R.ok().put("data", courseCatogry);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加课程分类",type=2)
    public R save(@Validated @RequestBody CourseCatogry courseCatogry) {
        courseCatogryService.save(courseCatogry);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改课程分类",type=2)
    public R update(@Validated @RequestBody CourseCatogry courseCatogry) {
        courseCatogryService.update(courseCatogry);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除课程分类",type=2)
    public R delete(@RequestBody Integer[]ids) {
        courseCatogryService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="课程分类导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = courseCatogryService.selectList(params);
        return R.ok().put("data", list);
    }
}
