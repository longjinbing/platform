package com.ljb.controller;

import com.ljb.annotion.Desc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/17<br>
 * 描述: <br>
 */
@Controller
@RequestMapping("course")
@Desc(group="课程中心",name="课程管理",type=1,url="vote/hcourse.html",display =false)
public class CourseManageController {

    @RequestMapping("/manage/{id}")
    @Desc(name="教师课程学生管理",type=2)
    public String student(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/courseuser";
    }

    @RequestMapping("/grades/{id}")
    public String grades(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/gradesuser";
    }

    @RequestMapping("/comment/{id}")
    @Desc(name="教师课程评价管理",type=2)
    public String commentDetails(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/comment";
    }

    @RequestMapping("/question/{id}")
    @Desc(name="教师管理评价问题",type=2)
    public String question(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/question";
    }

    @RequestMapping("/resultdetails/{id}")
    @Desc(name="教师查看评价详细进度",type=2)
    public String resultdetails(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/commentresult";
    }

    @RequestMapping("/result/{id}")
    @Desc(name="教师查看评价进度",type=2)
    public String result(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        return "vote/commentresultprogress";
    }
}
