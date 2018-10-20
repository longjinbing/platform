package com.ljb.example;

import java.util.Date;
import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 用户票据实体
 * 表名 token
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-15 17:20:47
 */
public class TokenExample extends BaseExample {
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

                                                        public Criteria andExpireTimeIsNull() {
                    addCriterion("expire_time is null");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeIsNotNull() {
                    addCriterion("expire_time is not null");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeEqualTo(Date value) {
                    addCriterion("expire_time =", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeNotEqualTo(Date value) {
                    addCriterion("expire_time <>", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeGreaterThan(Date value) {
                    addCriterion("expire_time >", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
                    addCriterion("expire_time >=", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeLessThan(Date value) {
                    addCriterion("expire_time <", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
                    addCriterion("expire_time <=", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeLike(Date value) {
                    addCriterion("expire_time like", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeNotLike(Date value) {
                    addCriterion("expire_time not like", value, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeIn(List<Date> values) {
                    addCriterion("expire_time in", values, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andexpireTimeNotIn(List<Date> values) {
                    addCriterion("expire_time not in", values, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeBetween(Date value1, Date value2) {
                    addCriterion("expire_time between", value1, value2, "expireTime");
                    return (Criteria) this;
                }

                public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
                    addCriterion("expire_time not between", value1, value2, "expireTime");
                    return (Criteria) this;
                }

                                                                    public Criteria andTicketIsNull() {
                    addCriterion("ticket is null");
                    return (Criteria) this;
                }

                public Criteria andTicketIsNotNull() {
                    addCriterion("ticket is not null");
                    return (Criteria) this;
                }

                public Criteria andTicketEqualTo(String value) {
                    addCriterion("ticket =", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketNotEqualTo(String value) {
                    addCriterion("ticket <>", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketGreaterThan(String value) {
                    addCriterion("ticket >", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketGreaterThanOrEqualTo(String value) {
                    addCriterion("ticket >=", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketLessThan(String value) {
                    addCriterion("ticket <", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketLessThanOrEqualTo(String value) {
                    addCriterion("ticket <=", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketLike(String value) {
                    addCriterion("ticket like", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketNotLike(String value) {
                    addCriterion("ticket not like", value, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketIn(List<String> values) {
                    addCriterion("ticket in", values, "ticket");
                    return (Criteria) this;
                }

                public Criteria andticketNotIn(List<String> values) {
                    addCriterion("ticket not in", values, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketBetween(String value1, String value2) {
                    addCriterion("ticket between", value1, value2, "ticket");
                    return (Criteria) this;
                }

                public Criteria andTicketNotBetween(String value1, String value2) {
                    addCriterion("ticket not between", value1, value2, "ticket");
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

                                                public Criteria andIpIsNull() {
                    addCriterion("ip is null");
                    return (Criteria) this;
                }

                public Criteria andIpIsNotNull() {
                    addCriterion("ip is not null");
                    return (Criteria) this;
                }

                public Criteria andIpEqualTo(String value) {
                    addCriterion("ip =", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpNotEqualTo(String value) {
                    addCriterion("ip <>", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpGreaterThan(String value) {
                    addCriterion("ip >", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpGreaterThanOrEqualTo(String value) {
                    addCriterion("ip >=", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpLessThan(String value) {
                    addCriterion("ip <", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpLessThanOrEqualTo(String value) {
                    addCriterion("ip <=", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpLike(String value) {
                    addCriterion("ip like", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpNotLike(String value) {
                    addCriterion("ip not like", value, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpIn(List<String> values) {
                    addCriterion("ip in", values, "ip");
                    return (Criteria) this;
                }

                public Criteria andipNotIn(List<String> values) {
                    addCriterion("ip not in", values, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpBetween(String value1, String value2) {
                    addCriterion("ip between", value1, value2, "ip");
                    return (Criteria) this;
                }

                public Criteria andIpNotBetween(String value1, String value2) {
                    addCriterion("ip not between", value1, value2, "ip");
                    return (Criteria) this;
                }

                                                public Criteria andPrincipleIsNull() {
                    addCriterion("principle is null");
                    return (Criteria) this;
                }

                public Criteria andPrincipleIsNotNull() {
                    addCriterion("principle is not null");
                    return (Criteria) this;
                }

                public Criteria andPrincipleEqualTo(String value) {
                    addCriterion("principle =", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleNotEqualTo(String value) {
                    addCriterion("principle <>", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleGreaterThan(String value) {
                    addCriterion("principle >", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleGreaterThanOrEqualTo(String value) {
                    addCriterion("principle >=", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleLessThan(String value) {
                    addCriterion("principle <", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleLessThanOrEqualTo(String value) {
                    addCriterion("principle <=", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleLike(String value) {
                    addCriterion("principle like", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleNotLike(String value) {
                    addCriterion("principle not like", value, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleIn(List<String> values) {
                    addCriterion("principle in", values, "principle");
                    return (Criteria) this;
                }

                public Criteria andprincipleNotIn(List<String> values) {
                    addCriterion("principle not in", values, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleBetween(String value1, String value2) {
                    addCriterion("principle between", value1, value2, "principle");
                    return (Criteria) this;
                }

                public Criteria andPrincipleNotBetween(String value1, String value2) {
                    addCriterion("principle not between", value1, value2, "principle");
                    return (Criteria) this;
                }

                        }
}
