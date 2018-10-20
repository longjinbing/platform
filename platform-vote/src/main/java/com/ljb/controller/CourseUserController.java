package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.utils.FileResult;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.CourseUser;
import com.ljb.service.CourseUserService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 课程学生Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("courseuser")
@Desc(group="课程中心",name="课程学生",type=1,url="vote/courseuser.html",display = false)
public class CourseUserController extends BaseController {
    @Autowired
    private CourseUserService courseUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="课程学生列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", courseUserService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看课程学生",type=2,level = 0)
    public R info(@PathVariable("id") Integer id) {
        Object courseUser  = courseUserService.selectById(id);
        return R.ok().put("data", courseUser);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="课程学生详情",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object courseUser  = courseUserService.selectMapById(id);
        return R.ok().put("data", courseUser);
    }

    @RequestMapping("/savebatch")
    @Desc(name="批量添加课程学生",type=2,level = 0)
    public R saveBatch(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        if(courseUserService.saveBatch(file,id).getMsg()!= FileResult.Success){
            return R.error(-1, "导入失败，请检查数据");
        }
        return R.ok("本系统未注册学生使用将使用导入文件中设置的密码");
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加课程学生",type=2,level = 0)
    public R save(@Validated @RequestBody CourseUser courseUser) {
        if(courseUserService.save(courseUser)==0){
            return R.error(-1, "该学生已经在课程中，无需添加");
        };
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除课程学生",type=2,level = 0)
    public R delete(@RequestBody Integer[]ids) {
        courseUserService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="课程学生导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = courseUserService.selectList(params);
        return R.ok().put("data", list);
    }
}
