package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 短信日志实体
 * 表名 sys_sms_log
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:05:13
 */
public class SysSmsLog implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysSmsLog(){

    }
        private Integer id;
        private Integer createId;
    	@NotBlank(message = "{field.not.blank}")
        private String content;
    	@NotBlank(message = "{field.not.blank}")
        private String mobile;
        private Date createTime;
    	@NotBlank(message = "{field.not.blank}")
        private String sign;
    	@NotBlank(message = "{field.not.blank}")
        private String type;
    	@NotBlank(message = "{field.not.blank}")
        private String extno;
        private Integer sendStatus;
    	@NotBlank(message = "{field.not.blank}")
        private String sendId;
    	@NotBlank(message = "{field.not.blank}")
        private Integer invalidNum;
        private Integer successNum;
        private Integer blackNum;
    	@NotBlank(message = "{field.not.blank}")
        private String returnMsg;
        private Integer userId;
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
     * 设置：必填参数。发送内容（1-500 个汉字）UTF-8编码
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：必填参数。发送内容（1-500 个汉字）UTF-8编码
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：必填参数。手机号码。多个以英文逗号隔开
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：必填参数。手机号码。多个以英文逗号隔开
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置：可选参数。发送时间，填写时已填写的时间发送，不填时为当前时间发送
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：可选参数。发送时间，填写时已填写的时间发送，不填时为当前时间发送
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：必填参数。用户签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取：必填参数。用户签名
     */
    public String getSign() {
        return sign;
    }
    /**
     * 设置：必填参数。固定值 pt
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取：必填参数。固定值 pt
     */
    public String getType() {
        return type;
    }
    /**
     * 设置：可选参数。扩展码，用户定义扩展码，只能为数字
     */
    public void setExtno(String extno) {
        this.extno = extno;
    }

    /**
     * 获取：可选参数。扩展码，用户定义扩展码，只能为数字
     */
    public String getExtno() {
        return extno;
    }
    /**
     * 设置：1成功 0失败
     */
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    /**
     * 获取：1成功 0失败
     */
    public Integer getSendStatus() {
        return sendStatus;
    }
    /**
     * 设置：发送编号
     */
    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    /**
     * 获取：发送编号
     */
    public String getSendId() {
        return sendId;
    }
    /**
     * 设置：无效号码数
     */
    public void setInvalidNum(Integer invalidNum) {
        this.invalidNum = invalidNum;
    }

    /**
     * 获取：无效号码数
     */
    public Integer getInvalidNum() {
        return invalidNum;
    }
    /**
     * 设置：成功提交数
     */
    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    /**
     * 获取：成功提交数
     */
    public Integer getSuccessNum() {
        return successNum;
    }
    /**
     * 设置：黑名单数
     */
    public void setBlackNum(Integer blackNum) {
        this.blackNum = blackNum;
    }

    /**
     * 获取：黑名单数
     */
    public Integer getBlackNum() {
        return blackNum;
    }
    /**
     * 设置：返回消息
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    /**
     * 获取：返回消息
     */
    public String getReturnMsg() {
        return returnMsg;
    }
    /**
     * 设置：
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     */
    public Integer getUserId() {
        return userId;
    }
}
