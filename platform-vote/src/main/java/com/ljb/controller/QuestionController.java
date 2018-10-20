package com.ljb.controller;

import java.util.Map;
import com.ljb.annotion.Desc;
import com.ljb.entity.QuestionModel;
import com.ljb.utils.R;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ljb.entity.Question;
import com.ljb.service.QuestionService;

/**
 * 评价问题Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */

@RestController
@RequestMapping("question")
@Desc(group="评价管理中心",name="评价问题",type=1,url="vote/question.html",display = false)
public class QuestionController extends BaseController {
    @Autowired
    private QuestionService questionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @Desc(name="评价问题列表",type=2,level = 0)
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        return R.ok().put("data", questionService.selectList(params));
    }

    @RequestMapping("/list/{id}")
    @Desc(name="评价问题列表",type=2,level = 0)
    public R list(@PathVariable Integer id) {
        //查询列表数据
        return questionService.selectList(id);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/{id}")
    @Desc(name="查看评价问题",type=2)
    public R info(@PathVariable("id") Integer id) {
        Object question  = questionService.selectById(id);
        return R.ok().put("data", question);
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details/{id}")
    @Desc(name="评价问题详情",type=2)
    public R details(@PathVariable("id") Integer id) {
        Object question  = questionService.selectMapById(id);
        return R.ok().put("data", question);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @Desc(name="添加评价问题",type=2)
    public R save(@Validated @RequestBody QuestionModel question) {
        questionService.saveByComment(question);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改评价问题",type=2)
    public R update(@Validated @RequestBody Question question) {
        questionService.update(question);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @Desc(name="删除评价问题",type=2)
    public R delete(@RequestBody Integer[]ids) {
        questionService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/export")
    @Desc(name="评价问题导出",type=2)
    public R queryAll(@RequestParam Map<String, Object> params) {
        Object list = questionService.selectList(params);
        return R.ok().put("data", list);
    }
}
