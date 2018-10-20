package com.ljb.entity;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 评价问题实体
 * 表名 question
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
public class QuestionModel extends Question{

    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
