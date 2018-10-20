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
import com.ljb.entity.College;
import com.ljb.service.CollegeService;

/**
 * 学院管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("college")
@Desc(group="教务管理中心",name="学院管理",type=1,url="vote/college.html")
public class CollegeController extends BaseController {
    @Autowired
    private CollegeService collegeService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="学院列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", collegeService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看学院",type=2,level = 0)
    public R info(@PathVariable("id") Integer id) {
        Object college  = collegeService.selectMapById(id);
        return R.ok().put("data", college);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="学院详情",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object college  = collegeService.selectMapById(id);
        return R.ok().put("data", college);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加学院",type=2,level = 0)
    public R save(@Validated @RequestBody College college) {
        collegeService.save(college);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改学院",type=2)
    public R update(@Validated @RequestBody College college) {
        collegeService.update(college);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除学院",type=2)
    public R delete(@RequestBody Integer[]ids) {
        collegeService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="学院导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = collegeService.selectList(params);
        return R.ok().put("data", list);
    }
}
