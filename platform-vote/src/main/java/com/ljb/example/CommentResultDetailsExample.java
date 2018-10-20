package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 评价结果明细实体
 * 表名 comment_result_details
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-19 17:15:20
 */
public class CommentResultDetailsExample extends BaseExample {
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

                                                public Criteria andCommentResultIdIsNull() {
                    addCriterion("comment_result_id is null");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdIsNotNull() {
                    addCriterion("comment_result_id is not null");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdEqualTo(Integer value) {
                    addCriterion("comment_result_id =", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdNotEqualTo(Integer value) {
                    addCriterion("comment_result_id <>", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdGreaterThan(Integer value) {
                    addCriterion("comment_result_id >", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("comment_result_id >=", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdLessThan(Integer value) {
                    addCriterion("comment_result_id <", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdLessThanOrEqualTo(Integer value) {
                    addCriterion("comment_result_id <=", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdLike(Integer value) {
                    addCriterion("comment_result_id like", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdNotLike(Integer value) {
                    addCriterion("comment_result_id not like", value, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdIn(List<Integer> values) {
                    addCriterion("comment_result_id in", values, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andcommentResultIdNotIn(List<Integer> values) {
                    addCriterion("comment_result_id not in", values, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdBetween(Integer value1, Integer value2) {
                    addCriterion("comment_result_id between", value1, value2, "commentResultId");
                    return (Criteria) this;
                }

                public Criteria andCommentResultIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("comment_result_id not between", value1, value2, "commentResultId");
                    return (Criteria) this;
                }

                                                public Criteria andA1IsNull() {
                    addCriterion("a1 is null");
                    return (Criteria) this;
                }

                public Criteria andA1IsNotNull() {
                    addCriterion("a1 is not null");
                    return (Criteria) this;
                }

                public Criteria andA1EqualTo(String value) {
                    addCriterion("a1 =", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1NotEqualTo(String value) {
                    addCriterion("a1 <>", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1GreaterThan(String value) {
                    addCriterion("a1 >", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1GreaterThanOrEqualTo(String value) {
                    addCriterion("a1 >=", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1LessThan(String value) {
                    addCriterion("a1 <", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1LessThanOrEqualTo(String value) {
                    addCriterion("a1 <=", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1Like(String value) {
                    addCriterion("a1 like", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1NotLike(String value) {
                    addCriterion("a1 not like", value, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1In(List<String> values) {
                    addCriterion("a1 in", values, "a1");
                    return (Criteria) this;
                }

                public Criteria anda1NotIn(List<String> values) {
                    addCriterion("a1 not in", values, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1Between(String value1, String value2) {
                    addCriterion("a1 between", value1, value2, "a1");
                    return (Criteria) this;
                }

                public Criteria andA1NotBetween(String value1, String value2) {
                    addCriterion("a1 not between", value1, value2, "a1");
                    return (Criteria) this;
                }

                                                public Criteria andA2IsNull() {
                    addCriterion("a2 is null");
                    return (Criteria) this;
                }

                public Criteria andA2IsNotNull() {
                    addCriterion("a2 is not null");
                    return (Criteria) this;
                }

                public Criteria andA2EqualTo(String value) {
                    addCriterion("a2 =", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2NotEqualTo(String value) {
                    addCriterion("a2 <>", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2GreaterThan(String value) {
                    addCriterion("a2 >", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2GreaterThanOrEqualTo(String value) {
                    addCriterion("a2 >=", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2LessThan(String value) {
                    addCriterion("a2 <", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2LessThanOrEqualTo(String value) {
                    addCriterion("a2 <=", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2Like(String value) {
                    addCriterion("a2 like", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2NotLike(String value) {
                    addCriterion("a2 not like", value, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2In(List<String> values) {
                    addCriterion("a2 in", values, "a2");
                    return (Criteria) this;
                }

                public Criteria anda2NotIn(List<String> values) {
                    addCriterion("a2 not in", values, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2Between(String value1, String value2) {
                    addCriterion("a2 between", value1, value2, "a2");
                    return (Criteria) this;
                }

                public Criteria andA2NotBetween(String value1, String value2) {
                    addCriterion("a2 not between", value1, value2, "a2");
                    return (Criteria) this;
                }

                                                public Criteria andA3IsNull() {
                    addCriterion("a3 is null");
                    return (Criteria) this;
                }

                public Criteria andA3IsNotNull() {
                    addCriterion("a3 is not null");
                    return (Criteria) this;
                }

                public Criteria andA3EqualTo(String value) {
                    addCriterion("a3 =", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3NotEqualTo(String value) {
                    addCriterion("a3 <>", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3GreaterThan(String value) {
                    addCriterion("a3 >", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3GreaterThanOrEqualTo(String value) {
                    addCriterion("a3 >=", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3LessThan(String value) {
                    addCriterion("a3 <", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3LessThanOrEqualTo(String value) {
                    addCriterion("a3 <=", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3Like(String value) {
                    addCriterion("a3 like", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3NotLike(String value) {
                    addCriterion("a3 not like", value, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3In(List<String> values) {
                    addCriterion("a3 in", values, "a3");
                    return (Criteria) this;
                }

                public Criteria anda3NotIn(List<String> values) {
                    addCriterion("a3 not in", values, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3Between(String value1, String value2) {
                    addCriterion("a3 between", value1, value2, "a3");
                    return (Criteria) this;
                }

                public Criteria andA3NotBetween(String value1, String value2) {
                    addCriterion("a3 not between", value1, value2, "a3");
                    return (Criteria) this;
                }

                                                public Criteria andA4IsNull() {
                    addCriterion("a4 is null");
                    return (Criteria) this;
                }

                public Criteria andA4IsNotNull() {
                    addCriterion("a4 is not null");
                    return (Criteria) this;
                }

                public Criteria andA4EqualTo(String value) {
                    addCriterion("a4 =", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4NotEqualTo(String value) {
                    addCriterion("a4 <>", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4GreaterThan(String value) {
                    addCriterion("a4 >", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4GreaterThanOrEqualTo(String value) {
                    addCriterion("a4 >=", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4LessThan(String value) {
                    addCriterion("a4 <", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4LessThanOrEqualTo(String value) {
                    addCriterion("a4 <=", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4Like(String value) {
                    addCriterion("a4 like", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4NotLike(String value) {
                    addCriterion("a4 not like", value, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4In(List<String> values) {
                    addCriterion("a4 in", values, "a4");
                    return (Criteria) this;
                }

                public Criteria anda4NotIn(List<String> values) {
                    addCriterion("a4 not in", values, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4Between(String value1, String value2) {
                    addCriterion("a4 between", value1, value2, "a4");
                    return (Criteria) this;
                }

                public Criteria andA4NotBetween(String value1, String value2) {
                    addCriterion("a4 not between", value1, value2, "a4");
                    return (Criteria) this;
                }

                                                public Criteria andA5IsNull() {
                    addCriterion("a5 is null");
                    return (Criteria) this;
                }

                public Criteria andA5IsNotNull() {
                    addCriterion("a5 is not null");
                    return (Criteria) this;
                }

                public Criteria andA5EqualTo(String value) {
                    addCriterion("a5 =", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5NotEqualTo(String value) {
                    addCriterion("a5 <>", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5GreaterThan(String value) {
                    addCriterion("a5 >", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5GreaterThanOrEqualTo(String value) {
                    addCriterion("a5 >=", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5LessThan(String value) {
                    addCriterion("a5 <", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5LessThanOrEqualTo(String value) {
                    addCriterion("a5 <=", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5Like(String value) {
                    addCriterion("a5 like", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5NotLike(String value) {
                    addCriterion("a5 not like", value, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5In(List<String> values) {
                    addCriterion("a5 in", values, "a5");
                    return (Criteria) this;
                }

                public Criteria anda5NotIn(List<String> values) {
                    addCriterion("a5 not in", values, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5Between(String value1, String value2) {
                    addCriterion("a5 between", value1, value2, "a5");
                    return (Criteria) this;
                }

                public Criteria andA5NotBetween(String value1, String value2) {
                    addCriterion("a5 not between", value1, value2, "a5");
                    return (Criteria) this;
                }

                                                public Criteria andA6IsNull() {
                    addCriterion("a6 is null");
                    return (Criteria) this;
                }

                public Criteria andA6IsNotNull() {
                    addCriterion("a6 is not null");
                    return (Criteria) this;
                }

                public Criteria andA6EqualTo(String value) {
                    addCriterion("a6 =", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6NotEqualTo(String value) {
                    addCriterion("a6 <>", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6GreaterThan(String value) {
                    addCriterion("a6 >", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6GreaterThanOrEqualTo(String value) {
                    addCriterion("a6 >=", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6LessThan(String value) {
                    addCriterion("a6 <", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6LessThanOrEqualTo(String value) {
                    addCriterion("a6 <=", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6Like(String value) {
                    addCriterion("a6 like", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6NotLike(String value) {
                    addCriterion("a6 not like", value, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6In(List<String> values) {
                    addCriterion("a6 in", values, "a6");
                    return (Criteria) this;
                }

                public Criteria anda6NotIn(List<String> values) {
                    addCriterion("a6 not in", values, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6Between(String value1, String value2) {
                    addCriterion("a6 between", value1, value2, "a6");
                    return (Criteria) this;
                }

                public Criteria andA6NotBetween(String value1, String value2) {
                    addCriterion("a6 not between", value1, value2, "a6");
                    return (Criteria) this;
                }

                                                public Criteria andA7IsNull() {
                    addCriterion("a7 is null");
                    return (Criteria) this;
                }

                public Criteria andA7IsNotNull() {
                    addCriterion("a7 is not null");
                    return (Criteria) this;
                }

                public Criteria andA7EqualTo(String value) {
                    addCriterion("a7 =", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7NotEqualTo(String value) {
                    addCriterion("a7 <>", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7GreaterThan(String value) {
                    addCriterion("a7 >", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7GreaterThanOrEqualTo(String value) {
                    addCriterion("a7 >=", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7LessThan(String value) {
                    addCriterion("a7 <", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7LessThanOrEqualTo(String value) {
                    addCriterion("a7 <=", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7Like(String value) {
                    addCriterion("a7 like", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7NotLike(String value) {
                    addCriterion("a7 not like", value, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7In(List<String> values) {
                    addCriterion("a7 in", values, "a7");
                    return (Criteria) this;
                }

                public Criteria anda7NotIn(List<String> values) {
                    addCriterion("a7 not in", values, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7Between(String value1, String value2) {
                    addCriterion("a7 between", value1, value2, "a7");
                    return (Criteria) this;
                }

                public Criteria andA7NotBetween(String value1, String value2) {
                    addCriterion("a7 not between", value1, value2, "a7");
                    return (Criteria) this;
                }

                                                public Criteria andA8IsNull() {
                    addCriterion("a8 is null");
                    return (Criteria) this;
                }

                public Criteria andA8IsNotNull() {
                    addCriterion("a8 is not null");
                    return (Criteria) this;
                }

                public Criteria andA8EqualTo(String value) {
                    addCriterion("a8 =", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8NotEqualTo(String value) {
                    addCriterion("a8 <>", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8GreaterThan(String value) {
                    addCriterion("a8 >", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8GreaterThanOrEqualTo(String value) {
                    addCriterion("a8 >=", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8LessThan(String value) {
                    addCriterion("a8 <", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8LessThanOrEqualTo(String value) {
                    addCriterion("a8 <=", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8Like(String value) {
                    addCriterion("a8 like", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8NotLike(String value) {
                    addCriterion("a8 not like", value, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8In(List<String> values) {
                    addCriterion("a8 in", values, "a8");
                    return (Criteria) this;
                }

                public Criteria anda8NotIn(List<String> values) {
                    addCriterion("a8 not in", values, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8Between(String value1, String value2) {
                    addCriterion("a8 between", value1, value2, "a8");
                    return (Criteria) this;
                }

                public Criteria andA8NotBetween(String value1, String value2) {
                    addCriterion("a8 not between", value1, value2, "a8");
                    return (Criteria) this;
                }

                                                public Criteria andA9IsNull() {
                    addCriterion("a9 is null");
                    return (Criteria) this;
                }

                public Criteria andA9IsNotNull() {
                    addCriterion("a9 is not null");
                    return (Criteria) this;
                }

                public Criteria andA9EqualTo(String value) {
                    addCriterion("a9 =", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9NotEqualTo(String value) {
                    addCriterion("a9 <>", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9GreaterThan(String value) {
                    addCriterion("a9 >", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9GreaterThanOrEqualTo(String value) {
                    addCriterion("a9 >=", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9LessThan(String value) {
                    addCriterion("a9 <", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9LessThanOrEqualTo(String value) {
                    addCriterion("a9 <=", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9Like(String value) {
                    addCriterion("a9 like", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9NotLike(String value) {
                    addCriterion("a9 not like", value, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9In(List<String> values) {
                    addCriterion("a9 in", values, "a9");
                    return (Criteria) this;
                }

                public Criteria anda9NotIn(List<String> values) {
                    addCriterion("a9 not in", values, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9Between(String value1, String value2) {
                    addCriterion("a9 between", value1, value2, "a9");
                    return (Criteria) this;
                }

                public Criteria andA9NotBetween(String value1, String value2) {
                    addCriterion("a9 not between", value1, value2, "a9");
                    return (Criteria) this;
                }

                                                public Criteria andA10IsNull() {
                    addCriterion("a10 is null");
                    return (Criteria) this;
                }

                public Criteria andA10IsNotNull() {
                    addCriterion("a10 is not null");
                    return (Criteria) this;
                }

                public Criteria andA10EqualTo(String value) {
                    addCriterion("a10 =", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10NotEqualTo(String value) {
                    addCriterion("a10 <>", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10GreaterThan(String value) {
                    addCriterion("a10 >", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10GreaterThanOrEqualTo(String value) {
                    addCriterion("a10 >=", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10LessThan(String value) {
                    addCriterion("a10 <", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10LessThanOrEqualTo(String value) {
                    addCriterion("a10 <=", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10Like(String value) {
                    addCriterion("a10 like", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10NotLike(String value) {
                    addCriterion("a10 not like", value, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10In(List<String> values) {
                    addCriterion("a10 in", values, "a10");
                    return (Criteria) this;
                }

                public Criteria anda10NotIn(List<String> values) {
                    addCriterion("a10 not in", values, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10Between(String value1, String value2) {
                    addCriterion("a10 between", value1, value2, "a10");
                    return (Criteria) this;
                }

                public Criteria andA10NotBetween(String value1, String value2) {
                    addCriterion("a10 not between", value1, value2, "a10");
                    return (Criteria) this;
                }

                                                public Criteria andA11IsNull() {
                    addCriterion("a11 is null");
                    return (Criteria) this;
                }

                public Criteria andA11IsNotNull() {
                    addCriterion("a11 is not null");
                    return (Criteria) this;
                }

                public Criteria andA11EqualTo(String value) {
                    addCriterion("a11 =", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11NotEqualTo(String value) {
                    addCriterion("a11 <>", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11GreaterThan(String value) {
                    addCriterion("a11 >", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11GreaterThanOrEqualTo(String value) {
                    addCriterion("a11 >=", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11LessThan(String value) {
                    addCriterion("a11 <", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11LessThanOrEqualTo(String value) {
                    addCriterion("a11 <=", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11Like(String value) {
                    addCriterion("a11 like", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11NotLike(String value) {
                    addCriterion("a11 not like", value, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11In(List<String> values) {
                    addCriterion("a11 in", values, "a11");
                    return (Criteria) this;
                }

                public Criteria anda11NotIn(List<String> values) {
                    addCriterion("a11 not in", values, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11Between(String value1, String value2) {
                    addCriterion("a11 between", value1, value2, "a11");
                    return (Criteria) this;
                }

                public Criteria andA11NotBetween(String value1, String value2) {
                    addCriterion("a11 not between", value1, value2, "a11");
                    return (Criteria) this;
                }

                                                public Criteria andA12IsNull() {
                    addCriterion("a12 is null");
                    return (Criteria) this;
                }

                public Criteria andA12IsNotNull() {
                    addCriterion("a12 is not null");
                    return (Criteria) this;
                }

                public Criteria andA12EqualTo(String value) {
                    addCriterion("a12 =", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12NotEqualTo(String value) {
                    addCriterion("a12 <>", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12GreaterThan(String value) {
                    addCriterion("a12 >", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12GreaterThanOrEqualTo(String value) {
                    addCriterion("a12 >=", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12LessThan(String value) {
                    addCriterion("a12 <", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12LessThanOrEqualTo(String value) {
                    addCriterion("a12 <=", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12Like(String value) {
                    addCriterion("a12 like", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12NotLike(String value) {
                    addCriterion("a12 not like", value, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12In(List<String> values) {
                    addCriterion("a12 in", values, "a12");
                    return (Criteria) this;
                }

                public Criteria anda12NotIn(List<String> values) {
                    addCriterion("a12 not in", values, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12Between(String value1, String value2) {
                    addCriterion("a12 between", value1, value2, "a12");
                    return (Criteria) this;
                }

                public Criteria andA12NotBetween(String value1, String value2) {
                    addCriterion("a12 not between", value1, value2, "a12");
                    return (Criteria) this;
                }

                                                public Criteria andA13IsNull() {
                    addCriterion("a13 is null");
                    return (Criteria) this;
                }

                public Criteria andA13IsNotNull() {
                    addCriterion("a13 is not null");
                    return (Criteria) this;
                }

                public Criteria andA13EqualTo(String value) {
                    addCriterion("a13 =", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13NotEqualTo(String value) {
                    addCriterion("a13 <>", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13GreaterThan(String value) {
                    addCriterion("a13 >", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13GreaterThanOrEqualTo(String value) {
                    addCriterion("a13 >=", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13LessThan(String value) {
                    addCriterion("a13 <", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13LessThanOrEqualTo(String value) {
                    addCriterion("a13 <=", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13Like(String value) {
                    addCriterion("a13 like", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13NotLike(String value) {
                    addCriterion("a13 not like", value, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13In(List<String> values) {
                    addCriterion("a13 in", values, "a13");
                    return (Criteria) this;
                }

                public Criteria anda13NotIn(List<String> values) {
                    addCriterion("a13 not in", values, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13Between(String value1, String value2) {
                    addCriterion("a13 between", value1, value2, "a13");
                    return (Criteria) this;
                }

                public Criteria andA13NotBetween(String value1, String value2) {
                    addCriterion("a13 not between", value1, value2, "a13");
                    return (Criteria) this;
                }

                                                public Criteria andA14IsNull() {
                    addCriterion("a14 is null");
                    return (Criteria) this;
                }

                public Criteria andA14IsNotNull() {
                    addCriterion("a14 is not null");
                    return (Criteria) this;
                }

                public Criteria andA14EqualTo(String value) {
                    addCriterion("a14 =", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14NotEqualTo(String value) {
                    addCriterion("a14 <>", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14GreaterThan(String value) {
                    addCriterion("a14 >", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14GreaterThanOrEqualTo(String value) {
                    addCriterion("a14 >=", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14LessThan(String value) {
                    addCriterion("a14 <", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14LessThanOrEqualTo(String value) {
                    addCriterion("a14 <=", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14Like(String value) {
                    addCriterion("a14 like", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14NotLike(String value) {
                    addCriterion("a14 not like", value, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14In(List<String> values) {
                    addCriterion("a14 in", values, "a14");
                    return (Criteria) this;
                }

                public Criteria anda14NotIn(List<String> values) {
                    addCriterion("a14 not in", values, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14Between(String value1, String value2) {
                    addCriterion("a14 between", value1, value2, "a14");
                    return (Criteria) this;
                }

                public Criteria andA14NotBetween(String value1, String value2) {
                    addCriterion("a14 not between", value1, value2, "a14");
                    return (Criteria) this;
                }

                                                public Criteria andA15IsNull() {
                    addCriterion("a15 is null");
                    return (Criteria) this;
                }

                public Criteria andA15IsNotNull() {
                    addCriterion("a15 is not null");
                    return (Criteria) this;
                }

                public Criteria andA15EqualTo(String value) {
                    addCriterion("a15 =", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15NotEqualTo(String value) {
                    addCriterion("a15 <>", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15GreaterThan(String value) {
                    addCriterion("a15 >", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15GreaterThanOrEqualTo(String value) {
                    addCriterion("a15 >=", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15LessThan(String value) {
                    addCriterion("a15 <", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15LessThanOrEqualTo(String value) {
                    addCriterion("a15 <=", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15Like(String value) {
                    addCriterion("a15 like", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15NotLike(String value) {
                    addCriterion("a15 not like", value, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15In(List<String> values) {
                    addCriterion("a15 in", values, "a15");
                    return (Criteria) this;
                }

                public Criteria anda15NotIn(List<String> values) {
                    addCriterion("a15 not in", values, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15Between(String value1, String value2) {
                    addCriterion("a15 between", value1, value2, "a15");
                    return (Criteria) this;
                }

                public Criteria andA15NotBetween(String value1, String value2) {
                    addCriterion("a15 not between", value1, value2, "a15");
                    return (Criteria) this;
                }

                                                public Criteria andA16IsNull() {
                    addCriterion("a16 is null");
                    return (Criteria) this;
                }

                public Criteria andA16IsNotNull() {
                    addCriterion("a16 is not null");
                    return (Criteria) this;
                }

                public Criteria andA16EqualTo(String value) {
                    addCriterion("a16 =", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16NotEqualTo(String value) {
                    addCriterion("a16 <>", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16GreaterThan(String value) {
                    addCriterion("a16 >", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16GreaterThanOrEqualTo(String value) {
                    addCriterion("a16 >=", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16LessThan(String value) {
                    addCriterion("a16 <", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16LessThanOrEqualTo(String value) {
                    addCriterion("a16 <=", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16Like(String value) {
                    addCriterion("a16 like", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16NotLike(String value) {
                    addCriterion("a16 not like", value, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16In(List<String> values) {
                    addCriterion("a16 in", values, "a16");
                    return (Criteria) this;
                }

                public Criteria anda16NotIn(List<String> values) {
                    addCriterion("a16 not in", values, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16Between(String value1, String value2) {
                    addCriterion("a16 between", value1, value2, "a16");
                    return (Criteria) this;
                }

                public Criteria andA16NotBetween(String value1, String value2) {
                    addCriterion("a16 not between", value1, value2, "a16");
                    return (Criteria) this;
                }

                                                public Criteria andA17IsNull() {
                    addCriterion("a17 is null");
                    return (Criteria) this;
                }

                public Criteria andA17IsNotNull() {
                    addCriterion("a17 is not null");
                    return (Criteria) this;
                }

                public Criteria andA17EqualTo(String value) {
                    addCriterion("a17 =", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17NotEqualTo(String value) {
                    addCriterion("a17 <>", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17GreaterThan(String value) {
                    addCriterion("a17 >", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17GreaterThanOrEqualTo(String value) {
                    addCriterion("a17 >=", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17LessThan(String value) {
                    addCriterion("a17 <", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17LessThanOrEqualTo(String value) {
                    addCriterion("a17 <=", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17Like(String value) {
                    addCriterion("a17 like", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17NotLike(String value) {
                    addCriterion("a17 not like", value, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17In(List<String> values) {
                    addCriterion("a17 in", values, "a17");
                    return (Criteria) this;
                }

                public Criteria anda17NotIn(List<String> values) {
                    addCriterion("a17 not in", values, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17Between(String value1, String value2) {
                    addCriterion("a17 between", value1, value2, "a17");
                    return (Criteria) this;
                }

                public Criteria andA17NotBetween(String value1, String value2) {
                    addCriterion("a17 not between", value1, value2, "a17");
                    return (Criteria) this;
                }

                                                public Criteria andA18IsNull() {
                    addCriterion("a18 is null");
                    return (Criteria) this;
                }

                public Criteria andA18IsNotNull() {
                    addCriterion("a18 is not null");
                    return (Criteria) this;
                }

                public Criteria andA18EqualTo(String value) {
                    addCriterion("a18 =", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18NotEqualTo(String value) {
                    addCriterion("a18 <>", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18GreaterThan(String value) {
                    addCriterion("a18 >", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18GreaterThanOrEqualTo(String value) {
                    addCriterion("a18 >=", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18LessThan(String value) {
                    addCriterion("a18 <", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18LessThanOrEqualTo(String value) {
                    addCriterion("a18 <=", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18Like(String value) {
                    addCriterion("a18 like", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18NotLike(String value) {
                    addCriterion("a18 not like", value, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18In(List<String> values) {
                    addCriterion("a18 in", values, "a18");
                    return (Criteria) this;
                }

                public Criteria anda18NotIn(List<String> values) {
                    addCriterion("a18 not in", values, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18Between(String value1, String value2) {
                    addCriterion("a18 between", value1, value2, "a18");
                    return (Criteria) this;
                }

                public Criteria andA18NotBetween(String value1, String value2) {
                    addCriterion("a18 not between", value1, value2, "a18");
                    return (Criteria) this;
                }

                                                public Criteria andA19IsNull() {
                    addCriterion("a19 is null");
                    return (Criteria) this;
                }

                public Criteria andA19IsNotNull() {
                    addCriterion("a19 is not null");
                    return (Criteria) this;
                }

                public Criteria andA19EqualTo(String value) {
                    addCriterion("a19 =", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19NotEqualTo(String value) {
                    addCriterion("a19 <>", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19GreaterThan(String value) {
                    addCriterion("a19 >", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19GreaterThanOrEqualTo(String value) {
                    addCriterion("a19 >=", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19LessThan(String value) {
                    addCriterion("a19 <", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19LessThanOrEqualTo(String value) {
                    addCriterion("a19 <=", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19Like(String value) {
                    addCriterion("a19 like", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19NotLike(String value) {
                    addCriterion("a19 not like", value, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19In(List<String> values) {
                    addCriterion("a19 in", values, "a19");
                    return (Criteria) this;
                }

                public Criteria anda19NotIn(List<String> values) {
                    addCriterion("a19 not in", values, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19Between(String value1, String value2) {
                    addCriterion("a19 between", value1, value2, "a19");
                    return (Criteria) this;
                }

                public Criteria andA19NotBetween(String value1, String value2) {
                    addCriterion("a19 not between", value1, value2, "a19");
                    return (Criteria) this;
                }

                                                public Criteria andA20IsNull() {
                    addCriterion("a20 is null");
                    return (Criteria) this;
                }

                public Criteria andA20IsNotNull() {
                    addCriterion("a20 is not null");
                    return (Criteria) this;
                }

                public Criteria andA20EqualTo(String value) {
                    addCriterion("a20 =", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20NotEqualTo(String value) {
                    addCriterion("a20 <>", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20GreaterThan(String value) {
                    addCriterion("a20 >", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20GreaterThanOrEqualTo(String value) {
                    addCriterion("a20 >=", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20LessThan(String value) {
                    addCriterion("a20 <", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20LessThanOrEqualTo(String value) {
                    addCriterion("a20 <=", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20Like(String value) {
                    addCriterion("a20 like", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20NotLike(String value) {
                    addCriterion("a20 not like", value, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20In(List<String> values) {
                    addCriterion("a20 in", values, "a20");
                    return (Criteria) this;
                }

                public Criteria anda20NotIn(List<String> values) {
                    addCriterion("a20 not in", values, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20Between(String value1, String value2) {
                    addCriterion("a20 between", value1, value2, "a20");
                    return (Criteria) this;
                }

                public Criteria andA20NotBetween(String value1, String value2) {
                    addCriterion("a20 not between", value1, value2, "a20");
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
