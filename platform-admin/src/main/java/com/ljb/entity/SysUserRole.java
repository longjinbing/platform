package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户角色实体
 * 表名 sys_user_role
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */
public class SysUserRole implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysUserRole(){

    }
        private Integer id;
        private Integer userId;
        private Integer roleId;
        private Integer createId;
        private Date createTime;
        private Integer updateId;
        private Date updateTime;
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
     * 设置：用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：用户ID
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置：角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取：角色ID
     */
    public Integer getRoleId() {
        return roleId;
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
}
