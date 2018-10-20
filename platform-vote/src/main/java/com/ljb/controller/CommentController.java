package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.entity.CommentModel;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.Comment;
import com.ljb.service.CommentService;

/**
 * 评价管理Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */

@RestController
@RequestMapping("comment")
@Desc(group="课程中心",name="评价管理",type=1,url="vote/comment.html",display = false)
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="评价列表(教师)",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentService.selectList(params));
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看评价(教师)",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object comment  = commentService.selectById(id);
        return R.ok().put("data", comment);
    }

    @RequestMapping("/result/{id}")
    @Desc(name="查看总成绩(教师)",type=2,level = 0)
    public R result(@PathVariable("id") Integer id) {
        Object comment  = commentService.selectResult(id);
        return R.ok().put("data", comment);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="评价详情(教师)",type=2,level = 0)
    public R details(@PathVariable("id") Integer id) {
        Object comment  = commentService.selectMapById(id);
        return R.ok().put("data", comment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加评价(教师)",type=2)
    public R save(@Validated @RequestBody CommentModel comment) {
        commentService.saveByCourse(comment);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改评价(教师)",type=2)
    public R update(@Validated @RequestBody Comment comment) {
        commentService.update(comment);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除评价功能",type=2)
    public R delete(@RequestBody Integer[]ids) {
        commentService.deleteBatch(ids);
        return R.ok();
    }
    @RequestMapping("/start")
    @Desc(name="开始评价功能",type=2)
    public R start(@RequestBody Integer id) {
        ;
        return commentService.start(id);
    }

    @RequestMapping("/end")
    @Desc(name="完成评价功能",type=2)
    public R end(@RequestBody Integer id) {
        return commentService.complete(id);
    }

    @RequestMapping("/clear")
    @Desc(name="清除评价功能",type=2)
    public R clear(@RequestBody Integer id) {
        return commentService.clear(id);
    }


    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="评价导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = commentService.selectList(params);
        return R.ok().put("data", list);
    }
}
