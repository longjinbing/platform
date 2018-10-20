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
import com.ljb.entity.Token;
import com.ljb.service.TokenService;

/**
 * 用户票据Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 17:20:47
 */

@RestController
@RequestMapping("token")
@Desc(group="系统安全中心",name="在线用户",type=1,url="admin/token.html")
public class TokenController extends BaseController {
    @Autowired
    private TokenService tokenService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="用户票据列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", tokenService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看用户票据",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object token  = tokenService.selectById(id);
        return R.ok().put("data", token);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="用户票据详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object token  = tokenService.selectMapById(id);
        return R.ok().put("data", token);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加用户票据",type=2)
    public R save(@Validated @RequestBody Token token) {
        tokenService.save(token);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改用户票据",type=2)
    public R update(@Validated @RequestBody Token token) {
        tokenService.update(token);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除用户票据",type=2)
    public R delete(@RequestBody Integer[]ids) {
        tokenService.deleteBatch(ids);
        return R.ok();
    }

    @RequestMapping("/logout")
    @Desc(name="强制下线用户",type=2)
    public R logout(@RequestBody Integer[]ids) {
        tokenService.logout(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="用户票据导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = tokenService.selectList(params);
        return R.ok().put("data", list);
    }
}
