package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 学院教师实体
 * 表名 college_user
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
public class CollegeUser implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CollegeUser(){

    }
        private Integer id;
        private Integer collegeId;
        private Integer userId;
        private Integer createId;
        private Date creataTime;
        private Integer updateId;
        private Date updateTime;
        private String remark;
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
     * 设置：学院
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * 获取：学院
     */
    public Integer getCollegeId() {
        return collegeId;
    }
    /**
     * 设置：管理员
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：管理员
     */
    public Integer getUserId() {
        return userId;
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
    public void setCreataTime(Date creataTime) {
        this.creataTime = creataTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreataTime() {
        return creataTime;
    }
    /**
     * 设置：操作人
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：操作人
     */
    public Integer getUpdateId() {
        return updateId;
    }
    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
}
