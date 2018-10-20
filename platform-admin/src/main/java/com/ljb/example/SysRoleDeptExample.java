package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 角色部门实体
 * 表名 sys_role_dept
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysRoleDeptExample extends BaseExample {
    private static final long serialVersionUID = 1L;

    @Override
    public Criteria or() {
        return (Criteria) super.or();
    }

    @Override
    public Criteria createCriteria() {
        return (Criteria) super.createCriteria();
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }

                                                        public Criteria andRoleIdIsNull() {
                    addCriterion("role_id is null");
                    return (Criteria) this;
                }

                public Criteria andRoleIdIsNotNull() {
                    addCriterion("role_id is not null");
                    return (Criteria) this;
                }

                public Criteria andRoleIdEqualTo(Integer value) {
                    addCriterion("role_id =", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdNotEqualTo(Integer value) {
                    addCriterion("role_id <>", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdGreaterThan(Integer value) {
                    addCriterion("role_id >", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("role_id >=", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdLessThan(Integer value) {
                    addCriterion("role_id <", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
                    addCriterion("role_id <=", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdLike(Integer value) {
                    addCriterion("role_id like", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdNotLike(Integer value) {
                    addCriterion("role_id not like", value, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdIn(List<Integer> values) {
                    addCriterion("role_id in", values, "roleId");
                    return (Criteria) this;
                }

                public Criteria androleIdNotIn(List<Integer> values) {
                    addCriterion("role_id not in", values, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdBetween(Integer value1, Integer value2) {
                    addCriterion("role_id between", value1, value2, "roleId");
                    return (Criteria) this;
                }

                public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("role_id not between", value1, value2, "roleId");
                    return (Criteria) this;
                }

                                                public Criteria andDeptIdIsNull() {
                    addCriterion("dept_id is null");
                    return (Criteria) this;
                }

                public Criteria andDeptIdIsNotNull() {
                    addCriterion("dept_id is not null");
                    return (Criteria) this;
                }

                public Criteria andDeptIdEqualTo(Integer value) {
                    addCriterion("dept_id =", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdNotEqualTo(Integer value) {
                    addCriterion("dept_id <>", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdGreaterThan(Integer value) {
                    addCriterion("dept_id >", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("dept_id >=", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdLessThan(Integer value) {
                    addCriterion("dept_id <", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
                    addCriterion("dept_id <=", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdLike(Integer value) {
                    addCriterion("dept_id like", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdNotLike(Integer value) {
                    addCriterion("dept_id not like", value, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdIn(List<Integer> values) {
                    addCriterion("dept_id in", values, "deptId");
                    return (Criteria) this;
                }

                public Criteria anddeptIdNotIn(List<Integer> values) {
                    addCriterion("dept_id not in", values, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdBetween(Integer value1, Integer value2) {
                    addCriterion("dept_id between", value1, value2, "deptId");
                    return (Criteria) this;
                }

                public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("dept_id not between", value1, value2, "deptId");
                    return (Criteria) this;
                }

                                                                                                        }
}
