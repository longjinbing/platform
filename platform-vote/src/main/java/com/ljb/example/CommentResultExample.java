package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 评价结果实体
 * 表名 comment_result
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-18 17:18:42
 */
public class CommentResultExample extends BaseExample {
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

                                                public Criteria andAnswerIsNull() {
                    addCriterion("answer is null");
                    return (Criteria) this;
                }

                public Criteria andAnswerIsNotNull() {
                    addCriterion("answer is not null");
                    return (Criteria) this;
                }

                public Criteria andAnswerEqualTo(String value) {
                    addCriterion("answer =", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerNotEqualTo(String value) {
                    addCriterion("answer <>", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerGreaterThan(String value) {
                    addCriterion("answer >", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerGreaterThanOrEqualTo(String value) {
                    addCriterion("answer >=", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerLessThan(String value) {
                    addCriterion("answer <", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerLessThanOrEqualTo(String value) {
                    addCriterion("answer <=", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerLike(String value) {
                    addCriterion("answer like", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerNotLike(String value) {
                    addCriterion("answer not like", value, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerIn(List<String> values) {
                    addCriterion("answer in", values, "answer");
                    return (Criteria) this;
                }

                public Criteria andanswerNotIn(List<String> values) {
                    addCriterion("answer not in", values, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerBetween(String value1, String value2) {
                    addCriterion("answer between", value1, value2, "answer");
                    return (Criteria) this;
                }

                public Criteria andAnswerNotBetween(String value1, String value2) {
                    addCriterion("answer not between", value1, value2, "answer");
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

                        }
}
