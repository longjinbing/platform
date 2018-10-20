package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.FileResult;
import com.ljb.utils.R;
import com.ljb.utils.SHA256Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.SysUser;
import com.ljb.service.SysUserService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 系统用户Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */

@RestController
@RequestMapping("sysuser")
@Desc(group="系统用户中心",name="系统用户",type=1,url="admin/sysuser.html")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/resetpass")
    @Desc(name="重置密码",type=2)
    public R update(@RequestParam("userId") Integer userId,@RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword) {
        if(!password.equals(confirmpassword)||password.length()<6){
            return R.error(-1, "密码不符合要求，请重新尝试");
        }
        SysUser sysUser=new SysUser();
        sysUser.setId(userId);
        sysUser.setPassword(SHA256Util.getSHA256Str(password));
        sysUserService.update(sysUser);
        return R.ok("重置成功");
    }

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="系统用户列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysUserService.selectList(params));
    }

    @RequestMapping("/tlist")
    @Desc(name="教师列表",type=2)
    public R tList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", sysUserService.selectTList(params));
    }


    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看系统用户",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object sysUser  = sysUserService.selectById(id);
        return R.ok().put("data", sysUser);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/number")
    @Desc(name="根据学号获取学生ID",type=2,level =0 )
    public R number(@RequestParam String number) {
        SysUser sysUser  = sysUserService.findByNumber(number);
        if(sysUser==null){
            return R.error();
        }
        return R.ok().put("data", sysUser.getId());
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="系统用户详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object sysUser  = sysUserService.selectMapById(id);
        return R.ok().put("data", sysUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加系统用户",type=2)
    public R save(@Validated @RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return R.ok();
    }

    @RequestMapping("/add")
    @Desc(name="添加学生",type=2,level = 0)
    public R add(@Validated @RequestBody SysUser sysUser) {
        sysUserService.save(sysUser);
        return R.ok().put("data", sysUser.getId());
    }

    @RequestMapping("/savebatch")
    @Desc(name="批量添加用户",type=2)
    public R saveBatch(@RequestParam("file") MultipartFile file) {
        if(sysUserService.saveBatch(file).getMsg()!= FileResult.Success){
            return R.error(-1, "导入失败，请检查数据");
        }
        return R.ok("用户密码为文件中设置的密码");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改系统用户",type=2)
    public R update(@Validated  @RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除系统用户",type=2)
    public R delete(@RequestBody Integer[]ids) {
        sysUserService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="系统用户导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = sysUserService.selectList(params);
        return R.ok().put("data", list);
    }
}
