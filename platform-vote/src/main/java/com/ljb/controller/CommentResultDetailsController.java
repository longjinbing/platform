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
import com.ljb.entity.CommentResultDetails;
import com.ljb.service.CommentResultDetailsService;

/**
 * 评价结果明细Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-19 12:53:57
 */

@RestController
@RequestMapping("commentresultdetails")
public class CommentResultDetailsController extends BaseController {
    @Autowired
    private CommentResultDetailsService commentResultDetailsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="评价结果明细列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentResultDetailsService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看评价结果明细",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object commentResultDetails  = commentResultDetailsService.selectById(id);
        return R.ok().put("data", commentResultDetails);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="评价结果明细详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object commentResultDetails  = commentResultDetailsService.selectMapById(id);
        return R.ok().put("data", commentResultDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加评价结果明细",type=2)
    public R save(@Validated @RequestBody CommentResultDetails commentResultDetails) {
        commentResultDetailsService.save(commentResultDetails);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改评价结果明细",type=2)
    public R update(@Validated @RequestBody CommentResultDetails commentResultDetails) {
        commentResultDetailsService.update(commentResultDetails);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除评价结果明细",type=2)
    public R delete(@RequestBody Integer[]ids) {
        commentResultDetailsService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="评价结果明细导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = commentResultDetailsService.selectList(params);
        return R.ok().put("data", list);
    }
}
