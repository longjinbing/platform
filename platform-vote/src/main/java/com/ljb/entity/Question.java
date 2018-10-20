package com.ljb.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 评价问题实体
 * 表名 question
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 16:27:57
 */
public class Question implements Serializable{

    private static final long serialVersionUID = 1L;

    public  Question(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String content;
        private BigDecimal proportion;
        private Integer createId;
        private Date createTime;
        private String optiona;
        private String optionb;
        private String optionc;
        private String optiond;
        private String optione;
        private Integer type;
        private String remark;
        private String answer;
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
     * 设置：内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：内容
     */
    public String getContent() {
        return content;
    }
    /**
     * 设置：权重
     */
    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    /**
     * 获取：权重
     */
    public BigDecimal getProportion() {
        return proportion;
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
     * 设置：选项A
     */
    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    /**
     * 获取：选项A
     */
    public String getOptiona() {
        return optiona;
    }
    /**
     * 设置：选项B
     */
    public void setOptionb(String optionb) {
        this.optionb = optionb;
    }

    /**
     * 获取：选项B
     */
    public String getOptionb() {
        return optionb;
    }
    /**
     * 设置：选项C
     */
    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    /**
     * 获取：选项C
     */
    public String getOptionc() {
        return optionc;
    }
    /**
     * 设置：选项D
     */
    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    /**
     * 获取：选项D
     */
    public String getOptiond() {
        return optiond;
    }
    /**
     * 设置：选项E
     */
    public void setOptione(String optione) {
        this.optione = optione;
    }

    /**
     * 获取：选项E
     */
    public String getOptione() {
        return optione;
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
     * 设置：答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取：答案
     */
    public String getAnswer() {
        return answer;
    }
}
