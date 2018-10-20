package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 课程评价实体
 * 表名 course_comment
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-18 13:08:12
 */
public class CourseCommentExample extends BaseExample {
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

                                                public Criteria andCommentIdIsNull() {
                    addCriterion("comment_id is null");
                    return (Criteria) this;
                }

                public Criteria andCommentIdIsNotNull() {
                    addCriterion("comment_id is not null");
                    return (Criteria) this;
                }

                public Criteria andCommentIdEqualTo(Integer value) {
                    addCriterion("comment_id =", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdNotEqualTo(Integer value) {
                    addCriterion("comment_id <>", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdGreaterThan(Integer value) {
                    addCriterion("comment_id >", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("comment_id >=", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdLessThan(Integer value) {
                    addCriterion("comment_id <", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
                    addCriterion("comment_id <=", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdLike(Integer value) {
                    addCriterion("comment_id like", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdNotLike(Integer value) {
                    addCriterion("comment_id not like", value, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdIn(List<Integer> values) {
                    addCriterion("comment_id in", values, "commentId");
                    return (Criteria) this;
                }

                public Criteria andcommentIdNotIn(List<Integer> values) {
                    addCriterion("comment_id not in", values, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdBetween(Integer value1, Integer value2) {
                    addCriterion("comment_id between", value1, value2, "commentId");
                    return (Criteria) this;
                }

                public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("comment_id not between", value1, value2, "commentId");
                    return (Criteria) this;
                }

                                                                }
}
