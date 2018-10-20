package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 菜单管理实体
 * 表名 sys_menu
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-12 22:07:56
 */
public class SysMenu implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysMenu(){

    }
        private Integer id;
        private Integer parentId;

    	@NotBlank(message = "{field.not.blank}")
        private String name;

    	@NotBlank(message = "{field.not.blank}")
        private String url;

        private Integer type;

    	@NotBlank(message = "{field.not.blank}")
        private String icon;

        private Integer orderNum;

        private Integer status;
        private Integer updateId;
        private Date updateTime;
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
     * 设置：上级菜单
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：上级菜单
     */
    public Integer getParentId() {
        return parentId;
    }
    /**
     * 设置：菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：菜单名称
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：菜单URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：菜单URL
     */
    public String getUrl() {
        return url;
    }
    /**
     * 设置：类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：类型
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取：菜单图标
     */
    public String getIcon() {
        return icon;
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
     * 设置：创建者ID
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：创建者ID
     */
    public Integer getUpdateId() {
        return updateId;
    }
    /**
     * 设置：创建时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getUpdateTime() {
        return updateTime;
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
