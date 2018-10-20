package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 系统日志实体
 * 表名 sys_login_log
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 16:51:52
 */
public class SysLoginLog implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysLoginLog(){

    }
        private Integer id;
        private Integer status;
    	@NotBlank(message = "{field.not.blank}")
        private String ip;
        private Integer createId;
        private Date createTime;
        private Integer updateId;
        private Date updateTime;
    	@NotBlank(message = "{field.not.blank}")
        private String device;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
    	@NotBlank(message = "{field.not.blank}")
        private String result;
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
     * 设置：用户操作
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：用户操作
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取：IP地址
     */
    public String getIp() {
        return ip;
    }
    /**
     * 设置：用户名称
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：用户名称
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：登录时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：登录时间
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
     * 设置：登陆来源
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * 获取：登陆来源
     */
    public String getDevice() {
        return device;
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
     * 设置：结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取：结果
     */
    public String getResult() {
        return result;
    }
}
