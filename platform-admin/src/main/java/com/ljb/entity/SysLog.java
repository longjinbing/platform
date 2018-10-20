package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 系统日志实体
 * 表名 sys_log
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 20:02:00
 */
public class SysLog implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysLog(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String operation;
    	@NotBlank(message = "{field.not.blank}")
        private String method;
    	@NotBlank(message = "{field.not.blank}")
        private String params;
    	@NotBlank(message = "{field.not.blank}")
        private String ip;
        private Integer createId;
        private Date createTime;
        private Date updateTime;
        private Integer updateId;
    	@NotBlank(message = "{field.not.blank}")
        private String url;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
    	@NotBlank(message = "{field.not.blank}")
        private Integer level;
    	@NotBlank(message = "{field.not.blank}")
        private String errorStack;
        private Integer status;
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
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取：用户操作
     */
    public String getOperation() {
        return operation;
    }
    /**
     * 设置：请求方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取：请求方法
     */
    public String getMethod() {
        return method;
    }
    /**
     * 设置：请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取：请求参数
     */
    public String getParams() {
        return params;
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
     * 设置：用户名
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：用户名
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：发生时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：发生时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：操作时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：操作时间
     */
    public Date getUpdateTime() {
        return updateTime;
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
     * 设置：URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：URL
     */
    public String getUrl() {
        return url;
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
     * 设置：级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取：级别
     */
    public Integer getLevel() {
        return level;
    }
    /**
     * 设置：错误堆栈信息
     */
    public void setErrorStack(String errorStack) {
        this.errorStack = errorStack;
    }

    /**
     * 获取：错误堆栈信息
     */
    public String getErrorStack() {
        return errorStack;
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
}
