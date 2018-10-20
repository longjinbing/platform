package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 系统用户实体
 * 表名 sys_user
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-17 17:42:28
 */
public class SysUserExample extends BaseExample {
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

                                                        public Criteria andUsernameIsNull() {
                    addCriterion("username is null");
                    return (Criteria) this;
                }

                public Criteria andUsernameIsNotNull() {
                    addCriterion("username is not null");
                    return (Criteria) this;
                }

                public Criteria andUsernameEqualTo(String value) {
                    addCriterion("username =", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameNotEqualTo(String value) {
                    addCriterion("username <>", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameGreaterThan(String value) {
                    addCriterion("username >", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameGreaterThanOrEqualTo(String value) {
                    addCriterion("username >=", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameLessThan(String value) {
                    addCriterion("username <", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameLessThanOrEqualTo(String value) {
                    addCriterion("username <=", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameLike(String value) {
                    addCriterion("username like", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameNotLike(String value) {
                    addCriterion("username not like", value, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameIn(List<String> values) {
                    addCriterion("username in", values, "username");
                    return (Criteria) this;
                }

                public Criteria andusernameNotIn(List<String> values) {
                    addCriterion("username not in", values, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameBetween(String value1, String value2) {
                    addCriterion("username between", value1, value2, "username");
                    return (Criteria) this;
                }

                public Criteria andUsernameNotBetween(String value1, String value2) {
                    addCriterion("username not between", value1, value2, "username");
                    return (Criteria) this;
                }

                                                public Criteria andPasswordIsNull() {
                    addCriterion("password is null");
                    return (Criteria) this;
                }

                public Criteria andPasswordIsNotNull() {
                    addCriterion("password is not null");
                    return (Criteria) this;
                }

                public Criteria andPasswordEqualTo(String value) {
                    addCriterion("password =", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordNotEqualTo(String value) {
                    addCriterion("password <>", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordGreaterThan(String value) {
                    addCriterion("password >", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordGreaterThanOrEqualTo(String value) {
                    addCriterion("password >=", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordLessThan(String value) {
                    addCriterion("password <", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordLessThanOrEqualTo(String value) {
                    addCriterion("password <=", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordLike(String value) {
                    addCriterion("password like", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordNotLike(String value) {
                    addCriterion("password not like", value, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordIn(List<String> values) {
                    addCriterion("password in", values, "password");
                    return (Criteria) this;
                }

                public Criteria andpasswordNotIn(List<String> values) {
                    addCriterion("password not in", values, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordBetween(String value1, String value2) {
                    addCriterion("password between", value1, value2, "password");
                    return (Criteria) this;
                }

                public Criteria andPasswordNotBetween(String value1, String value2) {
                    addCriterion("password not between", value1, value2, "password");
                    return (Criteria) this;
                }

                                                public Criteria andEmailIsNull() {
                    addCriterion("email is null");
                    return (Criteria) this;
                }

                public Criteria andEmailIsNotNull() {
                    addCriterion("email is not null");
                    return (Criteria) this;
                }

                public Criteria andEmailEqualTo(String value) {
                    addCriterion("email =", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailNotEqualTo(String value) {
                    addCriterion("email <>", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailGreaterThan(String value) {
                    addCriterion("email >", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailGreaterThanOrEqualTo(String value) {
                    addCriterion("email >=", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailLessThan(String value) {
                    addCriterion("email <", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailLessThanOrEqualTo(String value) {
                    addCriterion("email <=", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailLike(String value) {
                    addCriterion("email like", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailNotLike(String value) {
                    addCriterion("email not like", value, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailIn(List<String> values) {
                    addCriterion("email in", values, "email");
                    return (Criteria) this;
                }

                public Criteria andemailNotIn(List<String> values) {
                    addCriterion("email not in", values, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailBetween(String value1, String value2) {
                    addCriterion("email between", value1, value2, "email");
                    return (Criteria) this;
                }

                public Criteria andEmailNotBetween(String value1, String value2) {
                    addCriterion("email not between", value1, value2, "email");
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

                                                                                                                                public Criteria andIsDeleteIsNull() {
                    addCriterion("is_delete is null");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteIsNotNull() {
                    addCriterion("is_delete is not null");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteEqualTo(Integer value) {
                    addCriterion("is_delete =", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotEqualTo(Integer value) {
                    addCriterion("is_delete <>", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteGreaterThan(Integer value) {
                    addCriterion("is_delete >", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
                    addCriterion("is_delete >=", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLessThan(Integer value) {
                    addCriterion("is_delete <", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
                    addCriterion("is_delete <=", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteLike(Integer value) {
                    addCriterion("is_delete like", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotLike(Integer value) {
                    addCriterion("is_delete not like", value, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteIn(List<Integer> values) {
                    addCriterion("is_delete in", values, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andisDeleteNotIn(List<Integer> values) {
                    addCriterion("is_delete not in", values, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
                    addCriterion("is_delete between", value1, value2, "isDelete");
                    return (Criteria) this;
                }

                public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
                    addCriterion("is_delete not between", value1, value2, "isDelete");
                    return (Criteria) this;
                }

                                                public Criteria andNumberIsNull() {
                    addCriterion("number is null");
                    return (Criteria) this;
                }

                public Criteria andNumberIsNotNull() {
                    addCriterion("number is not null");
                    return (Criteria) this;
                }

                public Criteria andNumberEqualTo(String value) {
                    addCriterion("number =", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotEqualTo(String value) {
                    addCriterion("number <>", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberGreaterThan(String value) {
                    addCriterion("number >", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberGreaterThanOrEqualTo(String value) {
                    addCriterion("number >=", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLessThan(String value) {
                    addCriterion("number <", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLessThanOrEqualTo(String value) {
                    addCriterion("number <=", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLike(String value) {
                    addCriterion("number like", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotLike(String value) {
                    addCriterion("number not like", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberIn(List<String> values) {
                    addCriterion("number in", values, "number");
                    return (Criteria) this;
                }

                public Criteria andnumberNotIn(List<String> values) {
                    addCriterion("number not in", values, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberBetween(String value1, String value2) {
                    addCriterion("number between", value1, value2, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotBetween(String value1, String value2) {
                    addCriterion("number not between", value1, value2, "number");
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

                        }
}
