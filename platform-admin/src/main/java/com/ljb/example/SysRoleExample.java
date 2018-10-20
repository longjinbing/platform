package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 角色管理实体
 * 表名 sys_role
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysRoleExample extends BaseExample {
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

                                                        public Criteria andNameIsNull() {
                    addCriterion("name is null");
                    return (Criteria) this;
                }

                public Criteria andNameIsNotNull() {
                    addCriterion("name is not null");
                    return (Criteria) this;
                }

                public Criteria andNameEqualTo(String value) {
                    addCriterion("name =", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotEqualTo(String value) {
                    addCriterion("name <>", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameGreaterThan(String value) {
                    addCriterion("name >", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameGreaterThanOrEqualTo(String value) {
                    addCriterion("name >=", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLessThan(String value) {
                    addCriterion("name <", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLessThanOrEqualTo(String value) {
                    addCriterion("name <=", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLike(String value) {
                    addCriterion("name like", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotLike(String value) {
                    addCriterion("name not like", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameIn(List<String> values) {
                    addCriterion("name in", values, "name");
                    return (Criteria) this;
                }

                public Criteria andnameNotIn(List<String> values) {
                    addCriterion("name not in", values, "name");
                    return (Criteria) this;
                }

                public Criteria andNameBetween(String value1, String value2) {
                    addCriterion("name between", value1, value2, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotBetween(String value1, String value2) {
                    addCriterion("name not between", value1, value2, "name");
                    return (Criteria) this;
                }

                                                public Criteria andRemarkIsNull() {
                    addCriterion("remark is null");
                    return (Criteria) this;
                }

                public Criteria andRemarkIsNotNull() {
                    addCriterion("remark is not null");
                    return (Criteria) this;
                }

                public Criteria andRemarkEqualTo(String value) {
                    addCriterion("remark =", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkNotEqualTo(String value) {
                    addCriterion("remark <>", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkGreaterThan(String value) {
                    addCriterion("remark >", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkGreaterThanOrEqualTo(String value) {
                    addCriterion("remark >=", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkLessThan(String value) {
                    addCriterion("remark <", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkLessThanOrEqualTo(String value) {
                    addCriterion("remark <=", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkLike(String value) {
                    addCriterion("remark like", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkNotLike(String value) {
                    addCriterion("remark not like", value, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkIn(List<String> values) {
                    addCriterion("remark in", values, "remark");
                    return (Criteria) this;
                }

                public Criteria andremarkNotIn(List<String> values) {
                    addCriterion("remark not in", values, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkBetween(String value1, String value2) {
                    addCriterion("remark between", value1, value2, "remark");
                    return (Criteria) this;
                }

                public Criteria andRemarkNotBetween(String value1, String value2) {
                    addCriterion("remark not between", value1, value2, "remark");
                    return (Criteria) this;
                }

                                                                                                                                public Criteria andDescriptionIsNull() {
                    addCriterion("description is null");
                    return (Criteria) this;
                }

                public Criteria andDescriptionIsNotNull() {
                    addCriterion("description is not null");
                    return (Criteria) this;
                }

                public Criteria andDescriptionEqualTo(String value) {
                    addCriterion("description =", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionNotEqualTo(String value) {
                    addCriterion("description <>", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionGreaterThan(String value) {
                    addCriterion("description >", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
                    addCriterion("description >=", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionLessThan(String value) {
                    addCriterion("description <", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionLessThanOrEqualTo(String value) {
                    addCriterion("description <=", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionLike(String value) {
                    addCriterion("description like", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionNotLike(String value) {
                    addCriterion("description not like", value, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionIn(List<String> values) {
                    addCriterion("description in", values, "description");
                    return (Criteria) this;
                }

                public Criteria anddescriptionNotIn(List<String> values) {
                    addCriterion("description not in", values, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionBetween(String value1, String value2) {
                    addCriterion("description between", value1, value2, "description");
                    return (Criteria) this;
                }

                public Criteria andDescriptionNotBetween(String value1, String value2) {
                    addCriterion("description not between", value1, value2, "description");
                    return (Criteria) this;
                }

                                                public Criteria andIsDeleteIsNull() {
                    addCriterion("is_delete is null");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteIsNotNull() {
                    addCriterion("is_delete is not null");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteEqualTo(Integer value) {
                    addCriterion("is_delete =", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotEqualTo(Integer value) {
                    addCriterion("is_delete <>", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteGreaterThan(Integer value) {
                    addCriterion("is_delete >", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
                    addCriterion("is_delete >=", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLessThan(Integer value) {
                    addCriterion("is_delete <", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
                    addCriterion("is_delete <=", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLike(Integer value) {
                    addCriterion("is_delete like", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotLike(Integer value) {
                    addCriterion("is_delete not like", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteIn(List<Integer> values) {
                    addCriterion("is_delete in", values, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andisDeleteNotIn(List<Integer> values) {
                    addCriterion("is_delete not in", values, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
                    addCriterion("is_delete between", value1, value2, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
                    addCriterion("is_delete not between", value1, value2, "isDelete");
                    return (Criteria) this;
                }

                        }
}
