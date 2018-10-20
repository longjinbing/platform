package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 班级管理实体
 * 表名 grades
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-17 21:01:06
 */
public class Grades implements Serializable{

    private static final long serialVersionUID = 1L;

    public  Grades(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
        private Date createTime;
        private Integer collegeId;
        private Integer createId;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
        private Integer updateId;
        private Date updateTime;
        private Integer number;
    	@NotBlank(message = "{field.not.blank}")
        private String contacts;
    	@NotBlank(message = "{field.not.blank}")
        private String phone;
        private Integer year;
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
     * 设置：班级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：班级名称
     */
    public String getName() {
        return name;
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
     * 设置：人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取：人数
     */
    public Integer getNumber() {
        return number;
    }
    /**
     * 设置：联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    /**
     * 获取：联系人
     */
    public String getContacts() {
        return contacts;
    }
    /**
     * 设置：电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：电话
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：入学年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 获取：入学年份
     */
    public Integer getYear() {
        return year;
    }
}
