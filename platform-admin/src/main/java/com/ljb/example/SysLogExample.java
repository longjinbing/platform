package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 系统日志实体
 * 表名 sys_log
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-15 20:02:00
 */
public class SysLogExample extends BaseExample {
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

                                                        public Criteria andOperationIsNull() {
                    addCriterion("operation is null");
                    return (Criteria) this;
                }

                public Criteria andOperationIsNotNull() {
                    addCriterion("operation is not null");
                    return (Criteria) this;
                }

                public Criteria andOperationEqualTo(String value) {
                    addCriterion("operation =", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationNotEqualTo(String value) {
                    addCriterion("operation <>", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationGreaterThan(String value) {
                    addCriterion("operation >", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationGreaterThanOrEqualTo(String value) {
                    addCriterion("operation >=", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationLessThan(String value) {
                    addCriterion("operation <", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationLessThanOrEqualTo(String value) {
                    addCriterion("operation <=", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationLike(String value) {
                    addCriterion("operation like", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationNotLike(String value) {
                    addCriterion("operation not like", value, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationIn(List<String> values) {
                    addCriterion("operation in", values, "operation");
                    return (Criteria) this;
                }

                public Criteria andoperationNotIn(List<String> values) {
                    addCriterion("operation not in", values, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationBetween(String value1, String value2) {
                    addCriterion("operation between", value1, value2, "operation");
                    return (Criteria) this;
                }

                public Criteria andOperationNotBetween(String value1, String value2) {
                    addCriterion("operation not between", value1, value2, "operation");
                    return (Criteria) this;
                }

                                                public Criteria andMethodIsNull() {
                    addCriterion("method is null");
                    return (Criteria) this;
                }

                public Criteria andMethodIsNotNull() {
                    addCriterion("method is not null");
                    return (Criteria) this;
                }

                public Criteria andMethodEqualTo(String value) {
                    addCriterion("method =", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodNotEqualTo(String value) {
                    addCriterion("method <>", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodGreaterThan(String value) {
                    addCriterion("method >", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodGreaterThanOrEqualTo(String value) {
                    addCriterion("method >=", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodLessThan(String value) {
                    addCriterion("method <", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodLessThanOrEqualTo(String value) {
                    addCriterion("method <=", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodLike(String value) {
                    addCriterion("method like", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodNotLike(String value) {
                    addCriterion("method not like", value, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodIn(List<String> values) {
                    addCriterion("method in", values, "method");
                    return (Criteria) this;
                }

                public Criteria andmethodNotIn(List<String> values) {
                    addCriterion("method not in", values, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodBetween(String value1, String value2) {
                    addCriterion("method between", value1, value2, "method");
                    return (Criteria) this;
                }

                public Criteria andMethodNotBetween(String value1, String value2) {
                    addCriterion("method not between", value1, value2, "method");
                    return (Criteria) this;
                }

                                                public Criteria andParamsIsNull() {
                    addCriterion("params is null");
                    return (Criteria) this;
                }

                public Criteria andParamsIsNotNull() {
                    addCriterion("params is not null");
                    return (Criteria) this;
                }

                public Criteria andParamsEqualTo(String value) {
                    addCriterion("params =", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsNotEqualTo(String value) {
                    addCriterion("params <>", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsGreaterThan(String value) {
                    addCriterion("params >", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsGreaterThanOrEqualTo(String value) {
                    addCriterion("params >=", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsLessThan(String value) {
                    addCriterion("params <", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsLessThanOrEqualTo(String value) {
                    addCriterion("params <=", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsLike(String value) {
                    addCriterion("params like", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsNotLike(String value) {
                    addCriterion("params not like", value, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsIn(List<String> values) {
                    addCriterion("params in", values, "params");
                    return (Criteria) this;
                }

                public Criteria andparamsNotIn(List<String> values) {
                    addCriterion("params not in", values, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsBetween(String value1, String value2) {
                    addCriterion("params between", value1, value2, "params");
                    return (Criteria) this;
                }

                public Criteria andParamsNotBetween(String value1, String value2) {
                    addCriterion("params not between", value1, value2, "params");
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

                                                                                                                                public Criteria andUrlIsNull() {
                    addCriterion("url is null");
                    return (Criteria) this;
                }

                public Criteria andUrlIsNotNull() {
                    addCriterion("url is not null");
                    return (Criteria) this;
                }

                public Criteria andUrlEqualTo(String value) {
                    addCriterion("url =", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlNotEqualTo(String value) {
                    addCriterion("url <>", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlGreaterThan(String value) {
                    addCriterion("url >", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlGreaterThanOrEqualTo(String value) {
                    addCriterion("url >=", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlLessThan(String value) {
                    addCriterion("url <", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlLessThanOrEqualTo(String value) {
                    addCriterion("url <=", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlLike(String value) {
                    addCriterion("url like", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlNotLike(String value) {
                    addCriterion("url not like", value, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlIn(List<String> values) {
                    addCriterion("url in", values, "url");
                    return (Criteria) this;
                }

                public Criteria andurlNotIn(List<String> values) {
                    addCriterion("url not in", values, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlBetween(String value1, String value2) {
                    addCriterion("url between", value1, value2, "url");
                    return (Criteria) this;
                }

                public Criteria andUrlNotBetween(String value1, String value2) {
                    addCriterion("url not between", value1, value2, "url");
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

                                                public Criteria andLevelIsNull() {
                    addCriterion("level is null");
                    return (Criteria) this;
                }

                public Criteria andLevelIsNotNull() {
                    addCriterion("level is not null");
                    return (Criteria) this;
                }

                public Criteria andLevelEqualTo(Integer value) {
                    addCriterion("level =", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelNotEqualTo(Integer value) {
                    addCriterion("level <>", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelGreaterThan(Integer value) {
                    addCriterion("level >", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
                    addCriterion("level >=", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelLessThan(Integer value) {
                    addCriterion("level <", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelLessThanOrEqualTo(Integer value) {
                    addCriterion("level <=", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelLike(Integer value) {
                    addCriterion("level like", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelNotLike(Integer value) {
                    addCriterion("level not like", value, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelIn(List<Integer> values) {
                    addCriterion("level in", values, "level");
                    return (Criteria) this;
                }

                public Criteria andlevelNotIn(List<Integer> values) {
                    addCriterion("level not in", values, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelBetween(Integer value1, Integer value2) {
                    addCriterion("level between", value1, value2, "level");
                    return (Criteria) this;
                }

                public Criteria andLevelNotBetween(Integer value1, Integer value2) {
                    addCriterion("level not between", value1, value2, "level");
                    return (Criteria) this;
                }

                                                public Criteria andErrorStackIsNull() {
                    addCriterion("error_stack is null");
                    return (Criteria) this;
                }

                public Criteria andErrorStackIsNotNull() {
                    addCriterion("error_stack is not null");
                    return (Criteria) this;
                }

                public Criteria andErrorStackEqualTo(String value) {
                    addCriterion("error_stack =", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackNotEqualTo(String value) {
                    addCriterion("error_stack <>", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackGreaterThan(String value) {
                    addCriterion("error_stack >", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackGreaterThanOrEqualTo(String value) {
                    addCriterion("error_stack >=", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackLessThan(String value) {
                    addCriterion("error_stack <", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackLessThanOrEqualTo(String value) {
                    addCriterion("error_stack <=", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackLike(String value) {
                    addCriterion("error_stack like", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackNotLike(String value) {
                    addCriterion("error_stack not like", value, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackIn(List<String> values) {
                    addCriterion("error_stack in", values, "errorStack");
                    return (Criteria) this;
                }

                public Criteria anderrorStackNotIn(List<String> values) {
                    addCriterion("error_stack not in", values, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackBetween(String value1, String value2) {
                    addCriterion("error_stack between", value1, value2, "errorStack");
                    return (Criteria) this;
                }

                public Criteria andErrorStackNotBetween(String value1, String value2) {
                    addCriterion("error_stack not between", value1, value2, "errorStack");
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
