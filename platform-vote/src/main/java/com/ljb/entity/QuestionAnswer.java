package com.ljb.entity;

import java.util.List;

import java.io.Serializable;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/19<br>
 * 描述: <br>
 */
public class QuestionAnswer implements Serializable {

    public Integer getCommentResultId() {
        return commentResultId;
    }

    public void setCommentResultId(Integer commentResultId) {
        this.commentResultId = commentResultId;
    }

    public Integer commentResultId;

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> answers;
}
