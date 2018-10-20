package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 评价问题关联实体
 * 表名 comment_question
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 16:12:32
 */
public class CommentQuestion implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CommentQuestion(){

    }
        private Integer id;
        private Integer questionId;
        private Integer commentId;
        private Integer createId;
        private Date createTime;
    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：问题
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取：问题
     */
    public Integer getQuestionId() {
        return questionId;
    }
    /**
     * 设置：评价名称
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取：评价名称
     */
    public Integer getCommentId() {
        return commentId;
    }
    /**
     * 设置：操作人
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：操作人
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
}
