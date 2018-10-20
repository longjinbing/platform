package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 班级用户实体
 * 表名 grades_user
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 22:29:56
 */
public class GradesUser implements Serializable{

    private static final long serialVersionUID = 1L;

    public  GradesUser(){

    }
        private Integer id;
        private Integer userId;
        private Integer gradesId;
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
     * 设置：班级
     */
    public void setGradesId(Integer gradesId) {
        this.gradesId = gradesId;
    }

    /**
     * 获取：班级
     */
    public Integer getGradesId() {
        return gradesId;
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
