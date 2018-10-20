package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 短信日志实体
 * 表名 sys_sms_log
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-14 09:05:13
 */
public class SysSmsLogExample extends BaseExample {
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

                                                public Criteria andMobileIsNull() {
                    addCriterion("mobile is null");
                    return (Criteria) this;
                }

                public Criteria andMobileIsNotNull() {
                    addCriterion("mobile is not null");
                    return (Criteria) this;
                }

                public Criteria andMobileEqualTo(String value) {
                    addCriterion("mobile =", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileNotEqualTo(String value) {
                    addCriterion("mobile <>", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileGreaterThan(String value) {
                    addCriterion("mobile >", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileGreaterThanOrEqualTo(String value) {
                    addCriterion("mobile >=", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileLessThan(String value) {
                    addCriterion("mobile <", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileLessThanOrEqualTo(String value) {
                    addCriterion("mobile <=", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileLike(String value) {
                    addCriterion("mobile like", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileNotLike(String value) {
                    addCriterion("mobile not like", value, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileIn(List<String> values) {
                    addCriterion("mobile in", values, "mobile");
                    return (Criteria) this;
                }

                public Criteria andmobileNotIn(List<String> values) {
                    addCriterion("mobile not in", values, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileBetween(String value1, String value2) {
                    addCriterion("mobile between", value1, value2, "mobile");
                    return (Criteria) this;
                }

                public Criteria andMobileNotBetween(String value1, String value2) {
                    addCriterion("mobile not between", value1, value2, "mobile");
                    return (Criteria) this;
                }

                                                                    public Criteria andSignIsNull() {
                    addCriterion("sign is null");
                    return (Criteria) this;
                }

                public Criteria andSignIsNotNull() {
                    addCriterion("sign is not null");
                    return (Criteria) this;
                }

                public Criteria andSignEqualTo(String value) {
                    addCriterion("sign =", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignNotEqualTo(String value) {
                    addCriterion("sign <>", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignGreaterThan(String value) {
                    addCriterion("sign >", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignGreaterThanOrEqualTo(String value) {
                    addCriterion("sign >=", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignLessThan(String value) {
                    addCriterion("sign <", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignLessThanOrEqualTo(String value) {
                    addCriterion("sign <=", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignLike(String value) {
                    addCriterion("sign like", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignNotLike(String value) {
                    addCriterion("sign not like", value, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignIn(List<String> values) {
                    addCriterion("sign in", values, "sign");
                    return (Criteria) this;
                }

                public Criteria andsignNotIn(List<String> values) {
                    addCriterion("sign not in", values, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignBetween(String value1, String value2) {
                    addCriterion("sign between", value1, value2, "sign");
                    return (Criteria) this;
                }

                public Criteria andSignNotBetween(String value1, String value2) {
                    addCriterion("sign not between", value1, value2, "sign");
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

                public Criteria andTypeEqualTo(String value) {
                    addCriterion("type =", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotEqualTo(String value) {
                    addCriterion("type <>", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeGreaterThan(String value) {
                    addCriterion("type >", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeGreaterThanOrEqualTo(String value) {
                    addCriterion("type >=", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLessThan(String value) {
                    addCriterion("type <", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLessThanOrEqualTo(String value) {
                    addCriterion("type <=", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeLike(String value) {
                    addCriterion("type like", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotLike(String value) {
                    addCriterion("type not like", value, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeIn(List<String> values) {
                    addCriterion("type in", values, "type");
                    return (Criteria) this;
                }

                public Criteria andtypeNotIn(List<String> values) {
                    addCriterion("type not in", values, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeBetween(String value1, String value2) {
                    addCriterion("type between", value1, value2, "type");
                    return (Criteria) this;
                }

                public Criteria andTypeNotBetween(String value1, String value2) {
                    addCriterion("type not between", value1, value2, "type");
                    return (Criteria) this;
                }

                                                public Criteria andExtnoIsNull() {
                    addCriterion("extno is null");
                    return (Criteria) this;
                }

                public Criteria andExtnoIsNotNull() {
                    addCriterion("extno is not null");
                    return (Criteria) this;
                }

                public Criteria andExtnoEqualTo(String value) {
                    addCriterion("extno =", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoNotEqualTo(String value) {
                    addCriterion("extno <>", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoGreaterThan(String value) {
                    addCriterion("extno >", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoGreaterThanOrEqualTo(String value) {
                    addCriterion("extno >=", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoLessThan(String value) {
                    addCriterion("extno <", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoLessThanOrEqualTo(String value) {
                    addCriterion("extno <=", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoLike(String value) {
                    addCriterion("extno like", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoNotLike(String value) {
                    addCriterion("extno not like", value, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoIn(List<String> values) {
                    addCriterion("extno in", values, "extno");
                    return (Criteria) this;
                }

                public Criteria andextnoNotIn(List<String> values) {
                    addCriterion("extno not in", values, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoBetween(String value1, String value2) {
                    addCriterion("extno between", value1, value2, "extno");
                    return (Criteria) this;
                }

                public Criteria andExtnoNotBetween(String value1, String value2) {
                    addCriterion("extno not between", value1, value2, "extno");
                    return (Criteria) this;
                }

                                                public Criteria andSendStatusIsNull() {
                    addCriterion("send_status is null");
                    return (Criteria) this;
                }

                public Criteria andSendStatusIsNotNull() {
                    addCriterion("send_status is not null");
                    return (Criteria) this;
                }

                public Criteria andSendStatusEqualTo(Integer value) {
                    addCriterion("send_status =", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusNotEqualTo(Integer value) {
                    addCriterion("send_status <>", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusGreaterThan(Integer value) {
                    addCriterion("send_status >", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
                    addCriterion("send_status >=", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusLessThan(Integer value) {
                    addCriterion("send_status <", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
                    addCriterion("send_status <=", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusLike(Integer value) {
                    addCriterion("send_status like", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusNotLike(Integer value) {
                    addCriterion("send_status not like", value, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusIn(List<Integer> values) {
                    addCriterion("send_status in", values, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andsendStatusNotIn(List<Integer> values) {
                    addCriterion("send_status not in", values, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusBetween(Integer value1, Integer value2) {
                    addCriterion("send_status between", value1, value2, "sendStatus");
                    return (Criteria) this;
                }

                public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
                    addCriterion("send_status not between", value1, value2, "sendStatus");
                    return (Criteria) this;
                }

                                                public Criteria andSendIdIsNull() {
                    addCriterion("send_id is null");
                    return (Criteria) this;
                }

                public Criteria andSendIdIsNotNull() {
                    addCriterion("send_id is not null");
                    return (Criteria) this;
                }

                public Criteria andSendIdEqualTo(String value) {
                    addCriterion("send_id =", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdNotEqualTo(String value) {
                    addCriterion("send_id <>", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdGreaterThan(String value) {
                    addCriterion("send_id >", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdGreaterThanOrEqualTo(String value) {
                    addCriterion("send_id >=", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdLessThan(String value) {
                    addCriterion("send_id <", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdLessThanOrEqualTo(String value) {
                    addCriterion("send_id <=", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdLike(String value) {
                    addCriterion("send_id like", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdNotLike(String value) {
                    addCriterion("send_id not like", value, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdIn(List<String> values) {
                    addCriterion("send_id in", values, "sendId");
                    return (Criteria) this;
                }

                public Criteria andsendIdNotIn(List<String> values) {
                    addCriterion("send_id not in", values, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdBetween(String value1, String value2) {
                    addCriterion("send_id between", value1, value2, "sendId");
                    return (Criteria) this;
                }

                public Criteria andSendIdNotBetween(String value1, String value2) {
                    addCriterion("send_id not between", value1, value2, "sendId");
                    return (Criteria) this;
                }

                                                public Criteria andInvalidNumIsNull() {
                    addCriterion("invalid_num is null");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumIsNotNull() {
                    addCriterion("invalid_num is not null");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumEqualTo(Integer value) {
                    addCriterion("invalid_num =", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumNotEqualTo(Integer value) {
                    addCriterion("invalid_num <>", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumGreaterThan(Integer value) {
                    addCriterion("invalid_num >", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumGreaterThanOrEqualTo(Integer value) {
                    addCriterion("invalid_num >=", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumLessThan(Integer value) {
                    addCriterion("invalid_num <", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumLessThanOrEqualTo(Integer value) {
                    addCriterion("invalid_num <=", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumLike(Integer value) {
                    addCriterion("invalid_num like", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumNotLike(Integer value) {
                    addCriterion("invalid_num not like", value, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumIn(List<Integer> values) {
                    addCriterion("invalid_num in", values, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andinvalidNumNotIn(List<Integer> values) {
                    addCriterion("invalid_num not in", values, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumBetween(Integer value1, Integer value2) {
                    addCriterion("invalid_num between", value1, value2, "invalidNum");
                    return (Criteria) this;
                }

                public Criteria andInvalidNumNotBetween(Integer value1, Integer value2) {
                    addCriterion("invalid_num not between", value1, value2, "invalidNum");
                    return (Criteria) this;
                }

                                                public Criteria andSuccessNumIsNull() {
                    addCriterion("success_num is null");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumIsNotNull() {
                    addCriterion("success_num is not null");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumEqualTo(Integer value) {
                    addCriterion("success_num =", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumNotEqualTo(Integer value) {
                    addCriterion("success_num <>", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumGreaterThan(Integer value) {
                    addCriterion("success_num >", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumGreaterThanOrEqualTo(Integer value) {
                    addCriterion("success_num >=", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumLessThan(Integer value) {
                    addCriterion("success_num <", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumLessThanOrEqualTo(Integer value) {
                    addCriterion("success_num <=", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumLike(Integer value) {
                    addCriterion("success_num like", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumNotLike(Integer value) {
                    addCriterion("success_num not like", value, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumIn(List<Integer> values) {
                    addCriterion("success_num in", values, "successNum");
                    return (Criteria) this;
                }

                public Criteria andsuccessNumNotIn(List<Integer> values) {
                    addCriterion("success_num not in", values, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumBetween(Integer value1, Integer value2) {
                    addCriterion("success_num between", value1, value2, "successNum");
                    return (Criteria) this;
                }

                public Criteria andSuccessNumNotBetween(Integer value1, Integer value2) {
                    addCriterion("success_num not between", value1, value2, "successNum");
                    return (Criteria) this;
                }

                                                public Criteria andBlackNumIsNull() {
                    addCriterion("black_num is null");
                    return (Criteria) this;
                }

                public Criteria andBlackNumIsNotNull() {
                    addCriterion("black_num is not null");
                    return (Criteria) this;
                }

                public Criteria andBlackNumEqualTo(Integer value) {
                    addCriterion("black_num =", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumNotEqualTo(Integer value) {
                    addCriterion("black_num <>", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumGreaterThan(Integer value) {
                    addCriterion("black_num >", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumGreaterThanOrEqualTo(Integer value) {
                    addCriterion("black_num >=", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumLessThan(Integer value) {
                    addCriterion("black_num <", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumLessThanOrEqualTo(Integer value) {
                    addCriterion("black_num <=", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumLike(Integer value) {
                    addCriterion("black_num like", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumNotLike(Integer value) {
                    addCriterion("black_num not like", value, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumIn(List<Integer> values) {
                    addCriterion("black_num in", values, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andblackNumNotIn(List<Integer> values) {
                    addCriterion("black_num not in", values, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumBetween(Integer value1, Integer value2) {
                    addCriterion("black_num between", value1, value2, "blackNum");
                    return (Criteria) this;
                }

                public Criteria andBlackNumNotBetween(Integer value1, Integer value2) {
                    addCriterion("black_num not between", value1, value2, "blackNum");
                    return (Criteria) this;
                }

                                                public Criteria andReturnMsgIsNull() {
                    addCriterion("return_msg is null");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgIsNotNull() {
                    addCriterion("return_msg is not null");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgEqualTo(String value) {
                    addCriterion("return_msg =", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgNotEqualTo(String value) {
                    addCriterion("return_msg <>", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgGreaterThan(String value) {
                    addCriterion("return_msg >", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgGreaterThanOrEqualTo(String value) {
                    addCriterion("return_msg >=", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgLessThan(String value) {
                    addCriterion("return_msg <", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgLessThanOrEqualTo(String value) {
                    addCriterion("return_msg <=", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgLike(String value) {
                    addCriterion("return_msg like", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgNotLike(String value) {
                    addCriterion("return_msg not like", value, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgIn(List<String> values) {
                    addCriterion("return_msg in", values, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andreturnMsgNotIn(List<String> values) {
                    addCriterion("return_msg not in", values, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgBetween(String value1, String value2) {
                    addCriterion("return_msg between", value1, value2, "returnMsg");
                    return (Criteria) this;
                }

                public Criteria andReturnMsgNotBetween(String value1, String value2) {
                    addCriterion("return_msg not between", value1, value2, "returnMsg");
                    return (Criteria) this;
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

                        }
}
