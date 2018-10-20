package com.ljb.model;

import com.ljb.entity.SysRole;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/14<br>
 * 描述: <br>
 */
public class RoleDeptModel extends SysRole implements Serializable {

    public  RoleDeptModel(){
    }

    private Integer deptId;

    private String deptName;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
