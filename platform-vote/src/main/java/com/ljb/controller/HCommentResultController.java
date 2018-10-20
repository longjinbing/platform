package com.ljb.controller;

import com.ljb.annotion.Desc;
import com.ljb.entity.CommentResult;
import com.ljb.entity.Question;
import com.ljb.entity.QuestionAnswer;
import com.ljb.service.CommentResultService;
import com.ljb.service.CommentService;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 评价结果Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */

@RestController
@RequestMapping("hcommentresult")
@Desc(group="评价中心",name="评价管理",type=1,url="vote/hcommentresult.html")
public class HCommentResultController extends BaseController {
    @Autowired
    private CommentResultService commentResultService;
    @Autowired
    CommentService commentService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="学生待评价列表",type=2)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", commentResultService.selectHList(params));
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="学生评价结果详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object commentResult  = commentResultService.selectHMapById(id);
        return R.ok().put("data", commentResult);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="学生评价保存",type=2)
    public R save(@RequestBody QuestionAnswer questionAnswer) {
        commentResultService.save(questionAnswer);
        return R.ok();
    }

    @RequestMapping("/result/{id}")
    @Desc(name="学生查看总成绩",type=2,level = 0)
    public R result(@PathVariable("id") Integer id) {
        Object comment  = commentService.selectResult(id);
        return R.ok().put("data", comment);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="学生评价更新",type=2)
    public R update(@Validated @RequestBody QuestionAnswer questionAnswer) {
        commentResultService.update(questionAnswer);
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
