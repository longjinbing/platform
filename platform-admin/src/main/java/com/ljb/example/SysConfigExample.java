package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 系统配置实体
 * 表名 sys_config
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-14 09:04:53
 */
public class SysConfigExample extends BaseExample {
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

                                                        public Criteria andItemIsNull() {
                    addCriterion("item is null");
                    return (Criteria) this;
                }

                public Criteria andItemIsNotNull() {
                    addCriterion("item is not null");
                    return (Criteria) this;
                }

                public Criteria andItemEqualTo(String value) {
                    addCriterion("item =", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemNotEqualTo(String value) {
                    addCriterion("item <>", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemGreaterThan(String value) {
                    addCriterion("item >", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemGreaterThanOrEqualTo(String value) {
                    addCriterion("item >=", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemLessThan(String value) {
                    addCriterion("item <", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemLessThanOrEqualTo(String value) {
                    addCriterion("item <=", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemLike(String value) {
                    addCriterion("item like", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemNotLike(String value) {
                    addCriterion("item not like", value, "item");
                    return (Criteria) this;
                }

                public Criteria andItemIn(List<String> values) {
                    addCriterion("item in", values, "item");
                    return (Criteria) this;
                }

                public Criteria anditemNotIn(List<String> values) {
                    addCriterion("item not in", values, "item");
                    return (Criteria) this;
                }

                public Criteria andItemBetween(String value1, String value2) {
                    addCriterion("item between", value1, value2, "item");
                    return (Criteria) this;
                }

                public Criteria andItemNotBetween(String value1, String value2) {
                    addCriterion("item not between", value1, value2, "item");
                    return (Criteria) this;
                }

                                                public Criteria andValueIsNull() {
                    addCriterion("value is null");
                    return (Criteria) this;
                }

                public Criteria andValueIsNotNull() {
                    addCriterion("value is not null");
                    return (Criteria) this;
                }

                public Criteria andValueEqualTo(String value) {
                    addCriterion("value =", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueNotEqualTo(String value) {
                    addCriterion("value <>", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueGreaterThan(String value) {
                    addCriterion("value >", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueGreaterThanOrEqualTo(String value) {
                    addCriterion("value >=", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueLessThan(String value) {
                    addCriterion("value <", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueLessThanOrEqualTo(String value) {
                    addCriterion("value <=", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueLike(String value) {
                    addCriterion("value like", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueNotLike(String value) {
                    addCriterion("value not like", value, "value");
                    return (Criteria) this;
                }

                public Criteria andValueIn(List<String> values) {
                    addCriterion("value in", values, "value");
                    return (Criteria) this;
                }

                public Criteria andvalueNotIn(List<String> values) {
                    addCriterion("value not in", values, "value");
                    return (Criteria) this;
                }

                public Criteria andValueBetween(String value1, String value2) {
                    addCriterion("value between", value1, value2, "value");
                    return (Criteria) this;
                }

                public Criteria andValueNotBetween(String value1, String value2) {
                    addCriterion("value not between", value1, value2, "value");
                    return (Criteria) this;
                }

                                                public Criteria andStatusIsNull() {
                    addCriterion("status is null");
                    return (Criteria) this;
                }

                public Criteria andStatusIsNotNull() {
                    addCriterion("status is not null");
                    return (Criteria) this;
                }

                public Criteria andStatusEqualTo(Integer value) {
                    addCriterion("status =", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusNotEqualTo(Integer value) {
                    addCriterion("status <>", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusGreaterThan(Integer value) {
                    addCriterion("status >", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
                    addCriterion("status >=", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusLessThan(Integer value) {
                    addCriterion("status <", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusLessThanOrEqualTo(Integer value) {
                    addCriterion("status <=", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusLike(Integer value) {
                    addCriterion("status like", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusNotLike(Integer value) {
                    addCriterion("status not like", value, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusIn(List<Integer> values) {
                    addCriterion("status in", values, "status");
                    return (Criteria) this;
                }

                public Criteria andstatusNotIn(List<Integer> values) {
                    addCriterion("status not in", values, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusBetween(Integer value1, Integer value2) {
                    addCriterion("status between", value1, value2, "status");
                    return (Criteria) this;
                }

                public Criteria andStatusNotBetween(Integer value1, Integer value2) {
                    addCriterion("status not between", value1, value2, "status");
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
