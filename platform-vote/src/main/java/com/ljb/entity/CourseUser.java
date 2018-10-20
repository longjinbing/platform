package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 课程学生实体
 * 表名 course_user
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 22:29:56
 */
public class CourseUser implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CourseUser(){

    }
        private Integer id;
        private Integer userId;
        private Integer courseId;
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
     * 设置：用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：课程号
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取：课程号
     */
    public Integer getCourseId() {
        return courseId;
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
     * 设置：操作时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：操作时间
     */
    public Date getCreateTime() {
        return createTime;
    }
}
