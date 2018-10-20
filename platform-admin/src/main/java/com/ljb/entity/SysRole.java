package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 角色管理实体
 * 表名 sys_role
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */
public class SysRole implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysRole(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
        private Integer createId;
        private Date createTime;
        private Integer updateId;
        private Date updateTime;
    	@NotBlank(message = "{field.not.blank}")
        private String description;
        private Integer isDelete;
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
     * 设置：角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：角色名称
     */
    public String getName() {
        return name;
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
    /**
     * 设置：描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取：描述
     */
    public String getDescription() {
        return description;
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
}
