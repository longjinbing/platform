package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 问题分类实体
 * 表名 question_category
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 22:29:56
 */
public class QuestionCategory implements Serializable{

    private static final long serialVersionUID = 1L;

    public  QuestionCategory(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
        private Integer createId;
        private Date createTime;
        private Integer parentId;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
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
     * 设置：名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：名称
     */
    public String getName() {
        return name;
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
     * 设置：上级
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：上级
     */
    public Integer getParentId() {
        return parentId;
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
}
