package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 学院管理实体
 * 表名 college
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 22:29:56
 */
public class College implements Serializable{

    private static final long serialVersionUID = 1L;

    public  College(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
        private Integer createId;
        private Date createTime;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
        private Integer updateId;
        private Date updateTime;
        private Integer univerityId;
    	@NotBlank(message = "{field.not.blank}")
        private String contacts;
    	@NotBlank(message = "{field.not.blank}")
        private String phone;
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
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
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
     * 设置：学校Id
     */
    public void setUniverityId(Integer univerityId) {
        this.univerityId = univerityId;
    }

    /**
     * 获取：学校Id
     */
    public Integer getUniverityId() {
        return univerityId;
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
}
