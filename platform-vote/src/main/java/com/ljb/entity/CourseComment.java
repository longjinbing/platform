package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 课程评价实体
 * 表名 course_comment
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:12
 */
public class CourseComment implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CourseComment(){

    }
        private Integer id;
        private Integer courseId;
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
     * 设置：课程
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取：课程
     */
    public Integer getCourseId() {
        return courseId;
    }
    /**
     * 设置：评价
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取：评价
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
     * 设置：创建人
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建人
     */
    public Date getCreateTime() {
        return createTime;
    }
}
