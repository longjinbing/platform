package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 用户票据实体
 * 表名 token
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 17:20:47
 */
public class Token implements Serializable{

    private static final long serialVersionUID = 1L;

    public  Token(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private Date expireTime;
        private Date createTime;
    	@NotBlank(message = "{field.not.blank}")
        private String ticket;
        private Integer createId;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
    	@NotBlank(message = "{field.not.blank}")
        private String ip;
    	@NotBlank(message = "{field.not.blank}")
        private String principle;
    /**
     * 设置：编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：编号
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：过期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取：过期时间
     */
    public Date getExpireTime() {
        return expireTime;
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
     * 设置：票据
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 获取：票据
     */
    public String getTicket() {
        return ticket;
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
     * 设置：授权
     */
    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    /**
     * 获取：授权
     */
    public String getPrinciple() {
        return principle;
    }
}
