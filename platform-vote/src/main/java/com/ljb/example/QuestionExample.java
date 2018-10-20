package com.ljb.example;

import java.math.BigDecimal;
import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 评价问题实体
 * 表名 question
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-18 16:27:57
 */
public class QuestionExample extends BaseExample {
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

                                                        public Criteria andContentIsNull() {
                    addCriterion("content is null");
                    return (Criteria) this;
                }

                public Criteria andContentIsNotNull() {
                    addCriterion("content is not null");
                    return (Criteria) this;
                }

                public Criteria andContentEqualTo(String value) {
                    addCriterion("content =", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentNotEqualTo(String value) {
                    addCriterion("content <>", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentGreaterThan(String value) {
                    addCriterion("content >", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentGreaterThanOrEqualTo(String value) {
                    addCriterion("content >=", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentLessThan(String value) {
                    addCriterion("content <", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentLessThanOrEqualTo(String value) {
                    addCriterion("content <=", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentLike(String value) {
                    addCriterion("content like", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentNotLike(String value) {
                    addCriterion("content not like", value, "content");
                    return (Criteria) this;
                }

                public Criteria andContentIn(List<String> values) {
                    addCriterion("content in", values, "content");
                    return (Criteria) this;
                }

                public Criteria andcontentNotIn(List<String> values) {
                    addCriterion("content not in", values, "content");
                    return (Criteria) this;
                }

                public Criteria andContentBetween(String value1, String value2) {
                    addCriterion("content between", value1, value2, "content");
                    return (Criteria) this;
                }

                public Criteria andContentNotBetween(String value1, String value2) {
                    addCriterion("content not between", value1, value2, "content");
                    return (Criteria) this;
                }

                                                public Criteria andProportionIsNull() {
                    addCriterion("proportion is null");
                    return (Criteria) this;
                }

                public Criteria andProportionIsNotNull() {
                    addCriterion("proportion is not null");
                    return (Criteria) this;
                }

                public Criteria andProportionEqualTo(BigDecimal value) {
                    addCriterion("proportion =", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionNotEqualTo(BigDecimal value) {
                    addCriterion("proportion <>", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionGreaterThan(BigDecimal value) {
                    addCriterion("proportion >", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionGreaterThanOrEqualTo(BigDecimal value) {
                    addCriterion("proportion >=", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionLessThan(BigDecimal value) {
                    addCriterion("proportion <", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionLessThanOrEqualTo(BigDecimal value) {
                    addCriterion("proportion <=", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionLike(BigDecimal value) {
                    addCriterion("proportion like", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionNotLike(BigDecimal value) {
                    addCriterion("proportion not like", value, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionIn(List<BigDecimal> values) {
                    addCriterion("proportion in", values, "proportion");
                    return (Criteria) this;
                }

                public Criteria andproportionNotIn(List<BigDecimal> values) {
                    addCriterion("proportion not in", values, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionBetween(BigDecimal value1, BigDecimal value2) {
                    addCriterion("proportion between", value1, value2, "proportion");
                    return (Criteria) this;
                }

                public Criteria andProportionNotBetween(BigDecimal value1, BigDecimal value2) {
                    addCriterion("proportion not between", value1, value2, "proportion");
                    return (Criteria) this;
                }

                                                                                        public Criteria andOptionaIsNull() {
                    addCriterion("optionA is null");
                    return (Criteria) this;
                }

                public Criteria andOptionaIsNotNull() {
                    addCriterion("optionA is not null");
                    return (Criteria) this;
                }

                public Criteria andOptionaEqualTo(String value) {
                    addCriterion("optionA =", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaNotEqualTo(String value) {
                    addCriterion("optionA <>", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaGreaterThan(String value) {
                    addCriterion("optionA >", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaGreaterThanOrEqualTo(String value) {
                    addCriterion("optionA >=", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaLessThan(String value) {
                    addCriterion("optionA <", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaLessThanOrEqualTo(String value) {
                    addCriterion("optionA <=", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaLike(String value) {
                    addCriterion("optionA like", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaNotLike(String value) {
                    addCriterion("optionA not like", value, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaIn(List<String> values) {
                    addCriterion("optionA in", values, "optiona");
                    return (Criteria) this;
                }

                public Criteria andoptionaNotIn(List<String> values) {
                    addCriterion("optionA not in", values, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaBetween(String value1, String value2) {
                    addCriterion("optionA between", value1, value2, "optiona");
                    return (Criteria) this;
                }

                public Criteria andOptionaNotBetween(String value1, String value2) {
                    addCriterion("optionA not between", value1, value2, "optiona");
                    return (Criteria) this;
                }

                                                public Criteria andOptionbIsNull() {
                    addCriterion("optionB is null");
                    return (Criteria) this;
                }

                public Criteria andOptionbIsNotNull() {
                    addCriterion("optionB is not null");
                    return (Criteria) this;
                }

                public Criteria andOptionbEqualTo(String value) {
                    addCriterion("optionB =", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbNotEqualTo(String value) {
                    addCriterion("optionB <>", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbGreaterThan(String value) {
                    addCriterion("optionB >", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbGreaterThanOrEqualTo(String value) {
                    addCriterion("optionB >=", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbLessThan(String value) {
                    addCriterion("optionB <", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbLessThanOrEqualTo(String value) {
                    addCriterion("optionB <=", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbLike(String value) {
                    addCriterion("optionB like", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbNotLike(String value) {
                    addCriterion("optionB not like", value, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbIn(List<String> values) {
                    addCriterion("optionB in", values, "optionb");
                    return (Criteria) this;
                }

                public Criteria andoptionbNotIn(List<String> values) {
                    addCriterion("optionB not in", values, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbBetween(String value1, String value2) {
                    addCriterion("optionB between", value1, value2, "optionb");
                    return (Criteria) this;
                }

                public Criteria andOptionbNotBetween(String value1, String value2) {
                    addCriterion("optionB not between", value1, value2, "optionb");
                    return (Criteria) this;
                }

                                                public Criteria andOptioncIsNull() {
                    addCriterion("optionC is null");
                    return (Criteria) this;
                }

                public Criteria andOptioncIsNotNull() {
                    addCriterion("optionC is not null");
                    return (Criteria) this;
                }

                public Criteria andOptioncEqualTo(String value) {
                    addCriterion("optionC =", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncNotEqualTo(String value) {
                    addCriterion("optionC <>", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncGreaterThan(String value) {
                    addCriterion("optionC >", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncGreaterThanOrEqualTo(String value) {
                    addCriterion("optionC >=", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncLessThan(String value) {
                    addCriterion("optionC <", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncLessThanOrEqualTo(String value) {
                    addCriterion("optionC <=", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncLike(String value) {
                    addCriterion("optionC like", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncNotLike(String value) {
                    addCriterion("optionC not like", value, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncIn(List<String> values) {
                    addCriterion("optionC in", values, "optionc");
                    return (Criteria) this;
                }

                public Criteria andoptioncNotIn(List<String> values) {
                    addCriterion("optionC not in", values, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncBetween(String value1, String value2) {
                    addCriterion("optionC between", value1, value2, "optionc");
                    return (Criteria) this;
                }

                public Criteria andOptioncNotBetween(String value1, String value2) {
                    addCriterion("optionC not between", value1, value2, "optionc");
                    return (Criteria) this;
                }

                                                public Criteria andOptiondIsNull() {
                    addCriterion("optionD is null");
                    return (Criteria) this;
                }

                public Criteria andOptiondIsNotNull() {
                    addCriterion("optionD is not null");
                    return (Criteria) this;
                }

                public Criteria andOptiondEqualTo(String value) {
                    addCriterion("optionD =", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondNotEqualTo(String value) {
                    addCriterion("optionD <>", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondGreaterThan(String value) {
                    addCriterion("optionD >", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondGreaterThanOrEqualTo(String value) {
                    addCriterion("optionD >=", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondLessThan(String value) {
                    addCriterion("optionD <", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondLessThanOrEqualTo(String value) {
                    addCriterion("optionD <=", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondLike(String value) {
                    addCriterion("optionD like", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondNotLike(String value) {
                    addCriterion("optionD not like", value, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondIn(List<String> values) {
                    addCriterion("optionD in", values, "optiond");
                    return (Criteria) this;
                }

                public Criteria andoptiondNotIn(List<String> values) {
                    addCriterion("optionD not in", values, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondBetween(String value1, String value2) {
                    addCriterion("optionD between", value1, value2, "optiond");
                    return (Criteria) this;
                }

                public Criteria andOptiondNotBetween(String value1, String value2) {
                    addCriterion("optionD not between", value1, value2, "optiond");
                    return (Criteria) this;
                }

                                                public Criteria andOptioneIsNull() {
                    addCriterion("optionE is null");
                    return (Criteria) this;
                }

                public Criteria andOptioneIsNotNull() {
                    addCriterion("optionE is not null");
                    return (Criteria) this;
                }

                public Criteria andOptioneEqualTo(String value) {
                    addCriterion("optionE =", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneNotEqualTo(String value) {
                    addCriterion("optionE <>", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneGreaterThan(String value) {
                    addCriterion("optionE >", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneGreaterThanOrEqualTo(String value) {
                    addCriterion("optionE >=", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneLessThan(String value) {
                    addCriterion("optionE <", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneLessThanOrEqualTo(String value) {
                    addCriterion("optionE <=", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneLike(String value) {
                    addCriterion("optionE like", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneNotLike(String value) {
                    addCriterion("optionE not like", value, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneIn(List<String> values) {
                    addCriterion("optionE in", values, "optione");
                    return (Criteria) this;
                }

                public Criteria andoptioneNotIn(List<String> values) {
                    addCriterion("optionE not in", values, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneBetween(String value1, String value2) {
                    addCriterion("optionE between", value1, value2, "optione");
                    return (Criteria) this;
                }

                public Criteria andOptioneNotBetween(String value1, String value2) {
                    addCriterion("optionE not between", value1, value2, "optione");
                    return (Criteria) this;
                }

                                                public Criteria andTypeIsNull() {
                    addCriterion("type is null");
                    return (Criteria) this;
                }

                public Criteria andTypeIsNotNull() {
                    addCriterion("type is not null");
                    return (Criteria) this;
                }

                public Criteria andTypeEqualTo(Integer value) {
                    addCriterion("type =", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotEqualTo(Integer value) {
                    addCriterion("type <>", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeGreaterThan(Integer value) {
                    addCriterion("type >", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
                    addCriterion("type >=", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLessThan(Integer value) {
                    addCriterion("type <", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLessThanOrEqualTo(Integer value) {
                    addCriterion("type <=", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLike(Integer value) {
                    addCriterion("type like", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotLike(Integer value) {
                    addCriterion("type not like", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeIn(List<Integer> values) {
                    addCriterion("type in", values, "type");
                    return (Criteria) this;
                }

                public Criteria andtypeNotIn(List<Integer> values) {
                    addCriterion("type not in", values, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeBetween(Integer value1, Integer value2) {
                    addCriterion("type between", value1, value2, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotBetween(Integer value1, Integer value2) {
                    addCriterion("type not between", value1, value2, "type");
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

                        }
}
