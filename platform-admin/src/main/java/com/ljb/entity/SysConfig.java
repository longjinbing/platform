package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 系统配置实体
 * 表名 sys_config
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
public class SysConfig implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysConfig(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String item;
    	@NotBlank(message = "{field.not.blank}")
        private String value;
        private Integer status;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
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
     * 设置：key
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * 获取：key
     */
    public String getItem() {
        return item;
    }
    /**
     * 设置：value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取：value
     */
    public String getValue() {
        return value;
    }
    /**
     * 设置：状态   0：隐藏   1：显示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态   0：隐藏   1：显示
     */
    public Integer getStatus() {
        return status;
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
    /**
     * 设置：创建者ID
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：创建者ID
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
