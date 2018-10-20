package com.ljb.entity;

import java.util.*;
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
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    public Region() {

    }

    public Region(Integer id) {
this.id=id;
    }

    private Integer id;
    private String name;
    private List<Map<String,Object>> citys;
    private List<Map<String,Object>> universitys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getCitys() {
        return citys;
    }

    public void setCitys(List<Map<String, Object>> citys) {
        this.citys = citys;
    }

    public List<Map<String, Object>> getUniversitys() {
        return universitys;
    }

    public void setUniversitys(List<Map<String, Object>> universitys) {
        this.universitys = universitys;
    }
}
