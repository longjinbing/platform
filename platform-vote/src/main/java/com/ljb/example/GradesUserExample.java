package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 班级用户实体
 * 表名 grades_user
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-16 17:25:42
 */
public class GradesUserExample extends BaseExample {
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

                                                public Criteria andGradesIdIsNull() {
                    addCriterion("grades_id is null");
                    return (Criteria) this;
                }

                public Criteria andGradesIdIsNotNull() {
                    addCriterion("grades_id is not null");
                    return (Criteria) this;
                }

                public Criteria andGradesIdEqualTo(Integer value) {
                    addCriterion("grades_id =", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdNotEqualTo(Integer value) {
                    addCriterion("grades_id <>", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdGreaterThan(Integer value) {
                    addCriterion("grades_id >", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("grades_id >=", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdLessThan(Integer value) {
                    addCriterion("grades_id <", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdLessThanOrEqualTo(Integer value) {
                    addCriterion("grades_id <=", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdLike(Integer value) {
                    addCriterion("grades_id like", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdNotLike(Integer value) {
                    addCriterion("grades_id not like", value, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdIn(List<Integer> values) {
                    addCriterion("grades_id in", values, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andgradesIdNotIn(List<Integer> values) {
                    addCriterion("grades_id not in", values, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdBetween(Integer value1, Integer value2) {
                    addCriterion("grades_id between", value1, value2, "gradesId");
                    return (Criteria) this;
                }

                public Criteria andGradesIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("grades_id not between", value1, value2, "gradesId");
                    return (Criteria) this;
                }

                                                                }
}
