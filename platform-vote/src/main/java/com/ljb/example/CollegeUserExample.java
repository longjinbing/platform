package com.ljb.example;

import java.util.Date;
import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 学院教师实体
 * 表名 college_user
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-18 21:49:00
 */
public class CollegeUserExample extends BaseExample {
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

                                                                    public Criteria andCreataTimeIsNull() {
                    addCriterion("creata_time is null");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeIsNotNull() {
                    addCriterion("creata_time is not null");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeEqualTo(Date value) {
                    addCriterion("creata_time =", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeNotEqualTo(Date value) {
                    addCriterion("creata_time <>", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeGreaterThan(Date value) {
                    addCriterion("creata_time >", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeGreaterThanOrEqualTo(Date value) {
                    addCriterion("creata_time >=", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeLessThan(Date value) {
                    addCriterion("creata_time <", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeLessThanOrEqualTo(Date value) {
                    addCriterion("creata_time <=", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeLike(Date value) {
                    addCriterion("creata_time like", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeNotLike(Date value) {
                    addCriterion("creata_time not like", value, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeIn(List<Date> values) {
                    addCriterion("creata_time in", values, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andcreataTimeNotIn(List<Date> values) {
                    addCriterion("creata_time not in", values, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeBetween(Date value1, Date value2) {
                    addCriterion("creata_time between", value1, value2, "creataTime");
                    return (Criteria) this;
                }

                public Criteria andCreataTimeNotBetween(Date value1, Date value2) {
                    addCriterion("creata_time not between", value1, value2, "creataTime");
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
