package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 课程管理实体
 * 表名 course
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-17 16:42:53
 */
public class CourseExample extends BaseExample {
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

                                                                                        public Criteria andYearIsNull() {
                    addCriterion("year is null");
                    return (Criteria) this;
                }

                public Criteria andYearIsNotNull() {
                    addCriterion("year is not null");
                    return (Criteria) this;
                }

                public Criteria andYearEqualTo(Integer value) {
                    addCriterion("year =", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearNotEqualTo(Integer value) {
                    addCriterion("year <>", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearGreaterThan(Integer value) {
                    addCriterion("year >", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearGreaterThanOrEqualTo(Integer value) {
                    addCriterion("year >=", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearLessThan(Integer value) {
                    addCriterion("year <", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearLessThanOrEqualTo(Integer value) {
                    addCriterion("year <=", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearLike(Integer value) {
                    addCriterion("year like", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearNotLike(Integer value) {
                    addCriterion("year not like", value, "year");
                    return (Criteria) this;
                }

                public Criteria andYearIn(List<Integer> values) {
                    addCriterion("year in", values, "year");
                    return (Criteria) this;
                }

                public Criteria andyearNotIn(List<Integer> values) {
                    addCriterion("year not in", values, "year");
                    return (Criteria) this;
                }

                public Criteria andYearBetween(Integer value1, Integer value2) {
                    addCriterion("year between", value1, value2, "year");
                    return (Criteria) this;
                }

                public Criteria andYearNotBetween(Integer value1, Integer value2) {
                    addCriterion("year not between", value1, value2, "year");
                    return (Criteria) this;
                }

                                                public Criteria andCourseCatogryIdIsNull() {
                    addCriterion("course_catogry_id is null");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdIsNotNull() {
                    addCriterion("course_catogry_id is not null");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdEqualTo(Integer value) {
                    addCriterion("course_catogry_id =", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdNotEqualTo(Integer value) {
                    addCriterion("course_catogry_id <>", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdGreaterThan(Integer value) {
                    addCriterion("course_catogry_id >", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("course_catogry_id >=", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdLessThan(Integer value) {
                    addCriterion("course_catogry_id <", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdLessThanOrEqualTo(Integer value) {
                    addCriterion("course_catogry_id <=", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdLike(Integer value) {
                    addCriterion("course_catogry_id like", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdNotLike(Integer value) {
                    addCriterion("course_catogry_id not like", value, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdIn(List<Integer> values) {
                    addCriterion("course_catogry_id in", values, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andcourseCatogryIdNotIn(List<Integer> values) {
                    addCriterion("course_catogry_id not in", values, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdBetween(Integer value1, Integer value2) {
                    addCriterion("course_catogry_id between", value1, value2, "courseCatogryId");
                    return (Criteria) this;
                }

                public Criteria andCourseCatogryIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("course_catogry_id not between", value1, value2, "courseCatogryId");
                    return (Criteria) this;
                }

                                                public Criteria andTermIsNull() {
                    addCriterion("term is null");
                    return (Criteria) this;
                }

                public Criteria andTermIsNotNull() {
                    addCriterion("term is not null");
                    return (Criteria) this;
                }

                public Criteria andTermEqualTo(Integer value) {
                    addCriterion("term =", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermNotEqualTo(Integer value) {
                    addCriterion("term <>", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermGreaterThan(Integer value) {
                    addCriterion("term >", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermGreaterThanOrEqualTo(Integer value) {
                    addCriterion("term >=", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermLessThan(Integer value) {
                    addCriterion("term <", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermLessThanOrEqualTo(Integer value) {
                    addCriterion("term <=", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermLike(Integer value) {
                    addCriterion("term like", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermNotLike(Integer value) {
                    addCriterion("term not like", value, "term");
                    return (Criteria) this;
                }

                public Criteria andTermIn(List<Integer> values) {
                    addCriterion("term in", values, "term");
                    return (Criteria) this;
                }

                public Criteria andtermNotIn(List<Integer> values) {
                    addCriterion("term not in", values, "term");
                    return (Criteria) this;
                }

                public Criteria andTermBetween(Integer value1, Integer value2) {
                    addCriterion("term between", value1, value2, "term");
                    return (Criteria) this;
                }

                public Criteria andTermNotBetween(Integer value1, Integer value2) {
                    addCriterion("term not between", value1, value2, "term");
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

                                                public Criteria andNumberIsNull() {
                    addCriterion("number is null");
                    return (Criteria) this;
                }

                public Criteria andNumberIsNotNull() {
                    addCriterion("number is not null");
                    return (Criteria) this;
                }

                public Criteria andNumberEqualTo(Integer value) {
                    addCriterion("number =", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotEqualTo(Integer value) {
                    addCriterion("number <>", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberGreaterThan(Integer value) {
                    addCriterion("number >", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
                    addCriterion("number >=", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLessThan(Integer value) {
                    addCriterion("number <", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLessThanOrEqualTo(Integer value) {
                    addCriterion("number <=", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberLike(Integer value) {
                    addCriterion("number like", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotLike(Integer value) {
                    addCriterion("number not like", value, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberIn(List<Integer> values) {
                    addCriterion("number in", values, "number");
                    return (Criteria) this;
                }

                public Criteria andnumberNotIn(List<Integer> values) {
                    addCriterion("number not in", values, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberBetween(Integer value1, Integer value2) {
                    addCriterion("number between", value1, value2, "number");
                    return (Criteria) this;
                }

                public Criteria andNumberNotBetween(Integer value1, Integer value2) {
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

                                                public Criteria andCollegeIdIsNull() {
                    addCriterion("college_id is null");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdIsNotNull() {
                    addCriterion("college_id is not null");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdEqualTo(Integer value) {
                    addCriterion("college_id =", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdNotEqualTo(Integer value) {
                    addCriterion("college_id <>", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdGreaterThan(Integer value) {
                    addCriterion("college_id >", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("college_id >=", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdLessThan(Integer value) {
                    addCriterion("college_id <", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
                    addCriterion("college_id <=", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdLike(Integer value) {
                    addCriterion("college_id like", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdNotLike(Integer value) {
                    addCriterion("college_id not like", value, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdIn(List<Integer> values) {
                    addCriterion("college_id in", values, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andcollegeIdNotIn(List<Integer> values) {
                    addCriterion("college_id not in", values, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
                    addCriterion("college_id between", value1, value2, "collegeId");
                    return (Criteria) this;
                }

                public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("college_id not between", value1, value2, "collegeId");
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
