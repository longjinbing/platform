package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 部门管理实体
 * 表名 sys_dept
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysDeptExample extends BaseExample {
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

                                                        public Criteria andParentIdIsNull() {
                    addCriterion("parent_id is null");
                    return (Criteria) this;
                }

                public Criteria andParentIdIsNotNull() {
                    addCriterion("parent_id is not null");
                    return (Criteria) this;
                }

                public Criteria andParentIdEqualTo(Integer value) {
                    addCriterion("parent_id =", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotEqualTo(Integer value) {
                    addCriterion("parent_id <>", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdGreaterThan(Integer value) {
                    addCriterion("parent_id >", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("parent_id >=", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLessThan(Integer value) {
                    addCriterion("parent_id <", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLessThanOrEqualTo(Integer value) {
                    addCriterion("parent_id <=", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLike(Integer value) {
                    addCriterion("parent_id like", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotLike(Integer value) {
                    addCriterion("parent_id not like", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdIn(List<Integer> values) {
                    addCriterion("parent_id in", values, "parentId");
                    return (Criteria) this;
                }

                public Criteria andparentIdNotIn(List<Integer> values) {
                    addCriterion("parent_id not in", values, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdBetween(Integer value1, Integer value2) {
                    addCriterion("parent_id between", value1, value2, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("parent_id not between", value1, value2, "parentId");
                    return (Criteria) this;
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

                                                public Criteria andOrderNumIsNull() {
                    addCriterion("order_num is null");
                    return (Criteria) this;
                }

                public Criteria andOrderNumIsNotNull() {
                    addCriterion("order_num is not null");
                    return (Criteria) this;
                }

                public Criteria andOrderNumEqualTo(Integer value) {
                    addCriterion("order_num =", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotEqualTo(Integer value) {
                    addCriterion("order_num <>", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumGreaterThan(Integer value) {
                    addCriterion("order_num >", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
                    addCriterion("order_num >=", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLessThan(Integer value) {
                    addCriterion("order_num <", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
                    addCriterion("order_num <=", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLike(Integer value) {
                    addCriterion("order_num like", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotLike(Integer value) {
                    addCriterion("order_num not like", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumIn(List<Integer> values) {
                    addCriterion("order_num in", values, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andorderNumNotIn(List<Integer> values) {
                    addCriterion("order_num not in", values, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumBetween(Integer value1, Integer value2) {
                    addCriterion("order_num between", value1, value2, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
                    addCriterion("order_num not between", value1, value2, "orderNum");
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
