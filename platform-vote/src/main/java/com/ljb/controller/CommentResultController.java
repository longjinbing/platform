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
import com.ljb.entity.CommentResult;
import com.ljb.service.CommentResultService;

/**
 * 评价结果Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */

@RestController
@RequestMapping("commentresult")
@Desc(group="评价管理中心",name="评价结果",type=1,url="vote/commentresult.html",display = false)
public class CommentResultController extends BaseController {
    @Autowired
    private CommentResultService commentResultService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="评价结果列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentResultService.selectList(params));
    }

    @RequestMapping("/resultlist")
    @Desc(name="评价结果列表",type=2,level = 0)
    public R resultList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentResultService.selectResultList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看评价结果",type=2,level = 0)
    public R info(@PathVariable("id") Integer id) {
        Object commentResult  = commentResultService.selectById(id);
        return R.ok().put("data", commentResult);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="评价结果详情",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object commentResult  = commentResultService.selectMapById(id);
        return R.ok().put("data", commentResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加评价结果",type=2)
    public R save(@Validated @RequestBody CommentResult commentResult) {
        commentResultService.save(commentResult);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改评价结果",type=2)
    public R update(@Validated @RequestBody CommentResult commentResult) {
        commentResultService.update(commentResult);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除评价结果",type=2)
    public R delete(@RequestBody Integer[]ids) {
        commentResultService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="评价结果导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = commentResultService.selectList(params);
        return R.ok().put("data", list);
    }
}
