package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 角色菜单实体
 * 表名 sys_role_menu
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysRoleMenuExample extends BaseExample {
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

                                                public Criteria andMenuIdIsNull() {
                    addCriterion("menu_id is null");
                    return (Criteria) this;
                }

                public Criteria andMenuIdIsNotNull() {
                    addCriterion("menu_id is not null");
                    return (Criteria) this;
                }

                public Criteria andMenuIdEqualTo(Integer value) {
                    addCriterion("menu_id =", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdNotEqualTo(Integer value) {
                    addCriterion("menu_id <>", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdGreaterThan(Integer value) {
                    addCriterion("menu_id >", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("menu_id >=", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdLessThan(Integer value) {
                    addCriterion("menu_id <", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
                    addCriterion("menu_id <=", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdLike(Integer value) {
                    addCriterion("menu_id like", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdNotLike(Integer value) {
                    addCriterion("menu_id not like", value, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdIn(List<Integer> values) {
                    addCriterion("menu_id in", values, "menuId");
                    return (Criteria) this;
                }

                public Criteria andmenuIdNotIn(List<Integer> values) {
                    addCriterion("menu_id not in", values, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdBetween(Integer value1, Integer value2) {
                    addCriterion("menu_id between", value1, value2, "menuId");
                    return (Criteria) this;
                }

                public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("menu_id not between", value1, value2, "menuId");
                    return (Criteria) this;
                }

                                                                                                        }
}
