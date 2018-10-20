package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 学院管理实体
 * 表名 college
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-16 21:39:18
 */
public class CollegeExample extends BaseExample {
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

                                                        public Criteria andNameIsNull() {
                    addCriterion("name is null");
                    return (Criteria) this;
                }

                public Criteria andNameIsNotNull() {
                    addCriterion("name is not null");
                    return (Criteria) this;
                }

                public Criteria andNameEqualTo(String value) {
                    addCriterion("name =", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotEqualTo(String value) {
                    addCriterion("name <>", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameGreaterThan(String value) {
                    addCriterion("name >", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameGreaterThanOrEqualTo(String value) {
                    addCriterion("name >=", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLessThan(String value) {
                    addCriterion("name <", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLessThanOrEqualTo(String value) {
                    addCriterion("name <=", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameLike(String value) {
                    addCriterion("name like", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotLike(String value) {
                    addCriterion("name not like", value, "name");
                    return (Criteria) this;
                }

                public Criteria andNameIn(List<String> values) {
                    addCriterion("name in", values, "name");
                    return (Criteria) this;
                }

                public Criteria andnameNotIn(List<String> values) {
                    addCriterion("name not in", values, "name");
                    return (Criteria) this;
                }

                public Criteria andNameBetween(String value1, String value2) {
                    addCriterion("name between", value1, value2, "name");
                    return (Criteria) this;
                }

                public Criteria andNameNotBetween(String value1, String value2) {
                    addCriterion("name not between", value1, value2, "name");
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

                                                                                        public Criteria andUniverityIdIsNull() {
                    addCriterion("univerity_id is null");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdIsNotNull() {
                    addCriterion("univerity_id is not null");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdEqualTo(Integer value) {
                    addCriterion("univerity_id =", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdNotEqualTo(Integer value) {
                    addCriterion("univerity_id <>", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdGreaterThan(Integer value) {
                    addCriterion("univerity_id >", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("univerity_id >=", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdLessThan(Integer value) {
                    addCriterion("univerity_id <", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdLessThanOrEqualTo(Integer value) {
                    addCriterion("univerity_id <=", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdLike(Integer value) {
                    addCriterion("univerity_id like", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdNotLike(Integer value) {
                    addCriterion("univerity_id not like", value, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdIn(List<Integer> values) {
                    addCriterion("univerity_id in", values, "univerityId");
                    return (Criteria) this;
                }

                public Criteria anduniverityIdNotIn(List<Integer> values) {
                    addCriterion("univerity_id not in", values, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdBetween(Integer value1, Integer value2) {
                    addCriterion("univerity_id between", value1, value2, "univerityId");
                    return (Criteria) this;
                }

                public Criteria andUniverityIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("univerity_id not between", value1, value2, "univerityId");
                    return (Criteria) this;
                }

                                                public Criteria andContactsIsNull() {
                    addCriterion("contacts is null");
                    return (Criteria) this;
                }

                public Criteria andContactsIsNotNull() {
                    addCriterion("contacts is not null");
                    return (Criteria) this;
                }

                public Criteria andContactsEqualTo(String value) {
                    addCriterion("contacts =", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsNotEqualTo(String value) {
                    addCriterion("contacts <>", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsGreaterThan(String value) {
                    addCriterion("contacts >", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsGreaterThanOrEqualTo(String value) {
                    addCriterion("contacts >=", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsLessThan(String value) {
                    addCriterion("contacts <", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsLessThanOrEqualTo(String value) {
                    addCriterion("contacts <=", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsLike(String value) {
                    addCriterion("contacts like", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsNotLike(String value) {
                    addCriterion("contacts not like", value, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsIn(List<String> values) {
                    addCriterion("contacts in", values, "contacts");
                    return (Criteria) this;
                }

                public Criteria andcontactsNotIn(List<String> values) {
                    addCriterion("contacts not in", values, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsBetween(String value1, String value2) {
                    addCriterion("contacts between", value1, value2, "contacts");
                    return (Criteria) this;
                }

                public Criteria andContactsNotBetween(String value1, String value2) {
                    addCriterion("contacts not between", value1, value2, "contacts");
                    return (Criteria) this;
                }

                                                public Criteria andPhoneIsNull() {
                    addCriterion("phone is null");
                    return (Criteria) this;
                }

                public Criteria andPhoneIsNotNull() {
                    addCriterion("phone is not null");
                    return (Criteria) this;
                }

                public Criteria andPhoneEqualTo(String value) {
                    addCriterion("phone =", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneNotEqualTo(String value) {
                    addCriterion("phone <>", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneGreaterThan(String value) {
                    addCriterion("phone >", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneGreaterThanOrEqualTo(String value) {
                    addCriterion("phone >=", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneLessThan(String value) {
                    addCriterion("phone <", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneLessThanOrEqualTo(String value) {
                    addCriterion("phone <=", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneLike(String value) {
                    addCriterion("phone like", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneNotLike(String value) {
                    addCriterion("phone not like", value, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneIn(List<String> values) {
                    addCriterion("phone in", values, "phone");
                    return (Criteria) this;
                }

                public Criteria andphoneNotIn(List<String> values) {
                    addCriterion("phone not in", values, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneBetween(String value1, String value2) {
                    addCriterion("phone between", value1, value2, "phone");
                    return (Criteria) this;
                }

                public Criteria andPhoneNotBetween(String value1, String value2) {
                    addCriterion("phone not between", value1, value2, "phone");
                    return (Criteria) this;
                }

                        }
}
