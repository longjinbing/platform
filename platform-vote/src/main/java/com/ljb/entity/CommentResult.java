package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 评价结果实体
 * 表名 comment_result
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 17:18:42
 */
public class CommentResult implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CommentResult(){

    }
        private Integer id;
        private Integer userId;
        private Integer commentId;
        private Integer createId;
        private Date createTime;
        private Integer updateId;
        private Date updateTime;
        private Integer questionId;
    	@NotBlank(message = "{field.not.blank}")
        private String answer;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
        private Integer status;
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
     * 设置：被评者
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：被评者
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：评价I
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取：评价I
     */
    public Integer getCommentId() {
        return commentId;
    }
    /**
     * 设置：评价者
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：评价者
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：评价时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：评价时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：更新人
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：更新人
     */
    public Integer getUpdateId() {
        return updateId;
    }
    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取：
     */
    public Integer getQuestionId() {
        return questionId;
    }
    /**
     * 设置：
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取：
     */
    public String getAnswer() {
        return answer;
    }
    /**
     * 设置：
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 设置：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }
}
