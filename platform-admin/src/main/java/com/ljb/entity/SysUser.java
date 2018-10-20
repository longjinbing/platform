package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * 系统用户实体
 * 表名 sys_user
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */
public class SysUser implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysUser(){
    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        @Size(max=10,min=2,message = "{field.size}")
        private String username;
    	/*@NotBlank(message = "{field.not.blank}")
        @Size(max=16,min=6,message = "{field.size}")*/
        private String password;
    	@NotBlank(message = "{field.not.blank}")
        @Email(message = "{field.not.email}")
        private String email;
    	@NotBlank(message = "{field.not.blank}")
        private String mobile;
        private Integer status;
        private Integer createId;
        private Date createTime;
        private Integer updateId;
        private Date updateTime;
        private Integer isDelete;
        @Size(max=15,min=6,message = "{field.size}")
        private String number;
        private String remark;
    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设置：邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     */
    public String getEmail() {
        return email;
    }
    /**
     * 设置：手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态
     */
    public Integer getStatus() {
        return status;
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
    /**
     * 设置：更新者ID
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：更新者ID
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
     * 设置：
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取：
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
