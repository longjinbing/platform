package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 评价问题关联实体
 * 表名 comment_question
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-18 16:12:32
 */
public class CommentQuestionExample extends BaseExample {
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

                                                        public Criteria andQuestionIdIsNull() {
                    addCriterion("question_id is null");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdIsNotNull() {
                    addCriterion("question_id is not null");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdEqualTo(Integer value) {
                    addCriterion("question_id =", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdNotEqualTo(Integer value) {
                    addCriterion("question_id <>", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdGreaterThan(Integer value) {
                    addCriterion("question_id >", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("question_id >=", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdLessThan(Integer value) {
                    addCriterion("question_id <", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
                    addCriterion("question_id <=", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdLike(Integer value) {
                    addCriterion("question_id like", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdNotLike(Integer value) {
                    addCriterion("question_id not like", value, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdIn(List<Integer> values) {
                    addCriterion("question_id in", values, "questionId");
                    return (Criteria) this;
                }

                public Criteria andquestionIdNotIn(List<Integer> values) {
                    addCriterion("question_id not in", values, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
                    addCriterion("question_id between", value1, value2, "questionId");
                    return (Criteria) this;
                }

                public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("question_id not between", value1, value2, "questionId");
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
