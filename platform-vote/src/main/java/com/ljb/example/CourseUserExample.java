package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 课程学生实体
 * 表名 course_user
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-16 17:25:42
 */
public class CourseUserExample extends BaseExample {
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

                                                public Criteria andCourseIdIsNull() {
                    addCriterion("course_id is null");
                    return (Criteria) this;
                }

                public Criteria andCourseIdIsNotNull() {
                    addCriterion("course_id is not null");
                    return (Criteria) this;
                }

                public Criteria andCourseIdEqualTo(Integer value) {
                    addCriterion("course_id =", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdNotEqualTo(Integer value) {
                    addCriterion("course_id <>", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdGreaterThan(Integer value) {
                    addCriterion("course_id >", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("course_id >=", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdLessThan(Integer value) {
                    addCriterion("course_id <", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
                    addCriterion("course_id <=", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdLike(Integer value) {
                    addCriterion("course_id like", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdNotLike(Integer value) {
                    addCriterion("course_id not like", value, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdIn(List<Integer> values) {
                    addCriterion("course_id in", values, "courseId");
                    return (Criteria) this;
                }

                public Criteria andcourseIdNotIn(List<Integer> values) {
                    addCriterion("course_id not in", values, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdBetween(Integer value1, Integer value2) {
                    addCriterion("course_id between", value1, value2, "courseId");
                    return (Criteria) this;
                }

                public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("course_id not between", value1, value2, "courseId");
                    return (Criteria) this;
                }

                                                                }
}
