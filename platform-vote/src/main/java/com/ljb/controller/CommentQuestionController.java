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
import com.ljb.entity.CommentQuestion;
import com.ljb.service.CommentQuestionService;

/**
 * 评价问题关联Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */

@RestController
@RequestMapping("commentquestion")
@Desc(group="评价管理中心",name="评价问题关联",type=1,url="vote/commentquestion.html",display = false)
public class CommentQuestionController extends BaseController {
    @Autowired
    private CommentQuestionService commentQuestionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="评价问题关联列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentQuestionService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看评价问题关联",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object commentQuestion  = commentQuestionService.selectById(id);
        return R.ok().put("data", commentQuestion);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="评价问题关联详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object commentQuestion  = commentQuestionService.selectMapById(id);
        return R.ok().put("data", commentQuestion);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加评价问题关联",type=2)
    public R save(@Validated @RequestBody CommentQuestion commentQuestion) {
        commentQuestionService.save(commentQuestion);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改评价问题关联",type=2)
    public R update(@Validated @RequestBody CommentQuestion commentQuestion) {
        commentQuestionService.update(commentQuestion);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除评价问题关联",type=2)
    public R delete(@RequestBody Integer[]ids) {
        commentQuestionService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="评价问题关联导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = commentQuestionService.selectList(params);
        return R.ok().put("data", list);
    }
}
