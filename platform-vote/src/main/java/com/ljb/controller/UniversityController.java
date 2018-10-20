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
import com.ljb.entity.University;
import com.ljb.service.UniversityService;

/**
 * 学校管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("university")
@Desc(group="教务管理中心",name="学校管理",type=1,url="vote/university.html")
public class UniversityController extends BaseController {
    @Autowired
    private UniversityService universityService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="学校列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", universityService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看学校",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object university  = universityService.selectMapById(id);
        return R.ok().put("data", university);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="学校详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object university  = universityService.selectMapById(id);
        return R.ok().put("data", university);
    }

    /**
     * 保存
     */
    @RequestMapping("/school")
    @Desc(name="通过地区查看学校",type=2,level = 0)
    public R schoolList() {
        return R.ok().put("data", universityService.schoolList());
    }

    @RequestMapping("/college")
    @Desc(name="通过地区查看学院",type=2,level = 0)
    public R collegeList() {
        return R.ok().put("data", universityService.collegeList());
    }

    @RequestMapping("/teacher")
    @Desc(name="通过学院查看教师",type=2,level = 0)
    public R teacherList() {
        return R.ok().put("data", universityService.teacherList());
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加学校",type=2)
    public R save(@Validated @RequestBody University university) {
        universityService.save(university);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改学校",type=2)
    public R update(@Validated @RequestBody University university) {
        universityService.update(university);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除学校",type=2)
    public R delete(@RequestBody Integer[]ids) {
        universityService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="学校导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = universityService.selectList(params);
        return R.ok().put("data", list);
    }
}
