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
import com.ljb.entity.GradesUser;
import com.ljb.service.GradesUserService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.annotation.MultipartConfig;

/**
 * 班级用户Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */

@RestController
@RequestMapping("gradesuser")
@Desc(group="教务管理中心",name="班级用户",type=1,url="vote/gradesuser.html",display = false)
public class GradesUserController extends BaseController {
    @Autowired
    private GradesUserService gradesUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="班级用户列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", gradesUserService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看班级用户",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object gradesUser  = gradesUserService.selectById(id);
        return R.ok().put("data", gradesUser);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="班级用户详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object gradesUser  = gradesUserService.selectMapById(id);
        return R.ok().put("data", gradesUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加班级用户",type=2)
    public R save(@Validated @RequestBody GradesUser gradesUser) {
        if(gradesUserService.save(gradesUser)==0){
         return R.error(-1, "班级中已存在该学生,无需添加");
        }
        return R.ok();
    }

    @RequestMapping("/savebatch")
    @Desc(name="批量添加班级用户",type=2)
    public R saveBatch(@RequestParam("file") MultipartFile file,@RequestParam("id") Integer id) {
        if(gradesUserService.saveBatch(file,id).getMsg()!= FileResult.Success){
            return R.error(-1, "导入失败，请检查数据");
        }
        return R.ok("本系统未注册学生使用将使用导入文件中设置的密码");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改班级用户",type=2)
    public R update(@Validated @RequestBody GradesUser gradesUser) {
        gradesUserService.update(gradesUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除班级用户",type=2)
    public R delete(@RequestBody Integer[]ids) {
        gradesUserService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="班级用户导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = gradesUserService.selectList(params);
        return R.ok().put("data", list);
    }
}
