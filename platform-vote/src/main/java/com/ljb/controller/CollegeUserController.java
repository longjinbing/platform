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
import com.ljb.entity.CollegeUser;
import com.ljb.service.CollegeUserService;

/**
 * 学院教师Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */

@RestController
@RequestMapping("collegeuser")
@Desc(group="教务管理中心",name="教师管理",type=1,url="vote/collegeuser.html")
public class CollegeUserController extends BaseController {
    @Autowired
    private CollegeUserService collegeUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="学院教师列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", collegeUserService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看学院教师",type=2,level = 0)
    public R info(@PathVariable("id") Integer id) {
        Object collegeUser  = collegeUserService.selectByUser(id);
        return R.ok().put("data", collegeUser);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="学院教师详情",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object collegeUser  = collegeUserService.selectById(id);
        return R.ok().put("data", collegeUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加学院教师",type=2)
    public R save(@Validated @RequestBody CollegeUser collegeUser) {
        collegeUserService.save(collegeUser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改学院教师",type=2)
    public R update(@Validated @RequestBody CollegeUser collegeUser) {
        collegeUserService.update(collegeUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除学院教师",type=2)
    public R delete(@RequestBody Integer[]ids) {
        collegeUserService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="学院教师导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = collegeUserService.selectList(params);
        return R.ok().put("data", list);
    }
}
