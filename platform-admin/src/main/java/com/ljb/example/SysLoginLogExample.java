package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 系统日志实体
 * 表名 sys_login_log
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-15 16:51:52
 */
public class SysLoginLogExample extends BaseExample {
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

                                                                                                                                public Criteria andDeviceIsNull() {
                    addCriterion("device is null");
                    return (Criteria) this;
                }

                public Criteria andDeviceIsNotNull() {
                    addCriterion("device is not null");
                    return (Criteria) this;
                }

                public Criteria andDeviceEqualTo(String value) {
                    addCriterion("device =", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceNotEqualTo(String value) {
                    addCriterion("device <>", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceGreaterThan(String value) {
                    addCriterion("device >", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceGreaterThanOrEqualTo(String value) {
                    addCriterion("device >=", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceLessThan(String value) {
                    addCriterion("device <", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceLessThanOrEqualTo(String value) {
                    addCriterion("device <=", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceLike(String value) {
                    addCriterion("device like", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceNotLike(String value) {
                    addCriterion("device not like", value, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceIn(List<String> values) {
                    addCriterion("device in", values, "device");
                    return (Criteria) this;
                }

                public Criteria anddeviceNotIn(List<String> values) {
                    addCriterion("device not in", values, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceBetween(String value1, String value2) {
                    addCriterion("device between", value1, value2, "device");
                    return (Criteria) this;
                }

                public Criteria andDeviceNotBetween(String value1, String value2) {
                    addCriterion("device not between", value1, value2, "device");
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

                                                public Criteria andResultIsNull() {
                    addCriterion("result is null");
                    return (Criteria) this;
                }

                public Criteria andResultIsNotNull() {
                    addCriterion("result is not null");
                    return (Criteria) this;
                }

                public Criteria andResultEqualTo(String value) {
                    addCriterion("result =", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultNotEqualTo(String value) {
                    addCriterion("result <>", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultGreaterThan(String value) {
                    addCriterion("result >", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultGreaterThanOrEqualTo(String value) {
                    addCriterion("result >=", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultLessThan(String value) {
                    addCriterion("result <", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultLessThanOrEqualTo(String value) {
                    addCriterion("result <=", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultLike(String value) {
                    addCriterion("result like", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultNotLike(String value) {
                    addCriterion("result not like", value, "result");
                    return (Criteria) this;
                }

                public Criteria andResultIn(List<String> values) {
                    addCriterion("result in", values, "result");
                    return (Criteria) this;
                }

                public Criteria andresultNotIn(List<String> values) {
                    addCriterion("result not in", values, "result");
                    return (Criteria) this;
                }

                public Criteria andResultBetween(String value1, String value2) {
                    addCriterion("result between", value1, value2, "result");
                    return (Criteria) this;
                }

                public Criteria andResultNotBetween(String value1, String value2) {
                    addCriterion("result not between", value1, value2, "result");
                    return (Criteria) this;
                }

                        }
}
