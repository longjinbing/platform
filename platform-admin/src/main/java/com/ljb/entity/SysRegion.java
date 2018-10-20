package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 地区管理实体
 * 表名 sys_region
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
public class SysRegion implements Serializable{

    private static final long serialVersionUID = 1L;

    public  SysRegion(){

    }
        private Integer id;
        private Integer parentId;
    	@NotBlank(message = "{field.not.blank}")
        private String name;
        private Integer type;
        private Integer agencyId;
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
     * 设置：
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：
     */
    public Integer getParentId() {
        return parentId;
    }
    /**
     * 设置：
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：
     */
    public String getName() {
        return name;
    }
    /**
     * 设置：
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取：
     */
    public Integer getType() {
        return type;
    }
    /**
     * 设置：
     */
    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 获取：
     */
    public Integer getAgencyId() {
        return agencyId;
    }
}
