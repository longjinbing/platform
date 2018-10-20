package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 部门管理实体
 * 表名 sys_dept
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */
public class SysDept implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysDept(){

    }
        private Integer id;
        private Integer parentId;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
        private Integer orderNum;
        private Integer isDelete;
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
     * 设置：上级部门
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：上级部门
     */
    public Integer getParentId() {
        return parentId;
    }
    /**
     * 设置：部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：部门名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }
    /**
     * 设置：是否删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取：是否删除
     */
    public Integer getIsDelete() {
        return isDelete;
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
