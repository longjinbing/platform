package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 用户角色实体
 * 表名 sys_user_role
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysUserRoleExample extends BaseExample {
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

                                                        public Criteria andUserIdIsNull() {
                    addCriterion("user_id is null");
                    return (Criteria) this;
                }

                public Criteria andUserIdIsNotNull() {
                    addCriterion("user_id is not null");
                    return (Criteria) this;
                }

                public Criteria andUserIdEqualTo(Integer value) {
                    addCriterion("user_id =", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdNotEqualTo(Integer value) {
                    addCriterion("user_id <>", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdGreaterThan(Integer value) {
                    addCriterion("user_id >", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("user_id >=", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdLessThan(Integer value) {
                    addCriterion("user_id <", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdLessThanOrEqualTo(Integer value) {
                    addCriterion("user_id <=", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdLike(Integer value) {
                    addCriterion("user_id like", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdNotLike(Integer value) {
                    addCriterion("user_id not like", value, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdIn(List<Integer> values) {
                    addCriterion("user_id in", values, "userId");
                    return (Criteria) this;
                }

                public Criteria anduserIdNotIn(List<Integer> values) {
                    addCriterion("user_id not in", values, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdBetween(Integer value1, Integer value2) {
                    addCriterion("user_id between", value1, value2, "userId");
                    return (Criteria) this;
                }

                public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("user_id not between", value1, value2, "userId");
                    return (Criteria) this;
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

                                                                                                        }
}
