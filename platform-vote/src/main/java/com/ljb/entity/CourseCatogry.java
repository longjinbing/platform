package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 课程分类实体
 * 表名 course_catogry
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-17 16:12:15
 */
public class CourseCatogry implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CourseCatogry(){

    }
        private Integer id;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
    	@NotBlank(message = "{field.not.blank}")
        private String remark;
        private Integer createId;
        private Date createTime;
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
