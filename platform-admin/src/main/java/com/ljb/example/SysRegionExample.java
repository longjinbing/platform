package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 地区管理实体
 * 表名 sys_region
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-14 09:04:53
 */
public class SysRegionExample extends BaseExample {
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

                                                        public Criteria andParentIdIsNull() {
                    addCriterion("parent_id is null");
                    return (Criteria) this;
                }

                public Criteria andParentIdIsNotNull() {
                    addCriterion("parent_id is not null");
                    return (Criteria) this;
                }

                public Criteria andParentIdEqualTo(Integer value) {
                    addCriterion("parent_id =", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotEqualTo(Integer value) {
                    addCriterion("parent_id <>", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdGreaterThan(Integer value) {
                    addCriterion("parent_id >", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("parent_id >=", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLessThan(Integer value) {
                    addCriterion("parent_id <", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLessThanOrEqualTo(Integer value) {
                    addCriterion("parent_id <=", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdLike(Integer value) {
                    addCriterion("parent_id like", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotLike(Integer value) {
                    addCriterion("parent_id not like", value, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdIn(List<Integer> values) {
                    addCriterion("parent_id in", values, "parentId");
                    return (Criteria) this;
                }

                public Criteria andparentIdNotIn(List<Integer> values) {
                    addCriterion("parent_id not in", values, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdBetween(Integer value1, Integer value2) {
                    addCriterion("parent_id between", value1, value2, "parentId");
                    return (Criteria) this;
                }

                public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("parent_id not between", value1, value2, "parentId");
                    return (Criteria) this;
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

                                                public Criteria andAgencyIdIsNull() {
                    addCriterion("agency_id is null");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdIsNotNull() {
                    addCriterion("agency_id is not null");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdEqualTo(Integer value) {
                    addCriterion("agency_id =", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdNotEqualTo(Integer value) {
                    addCriterion("agency_id <>", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdGreaterThan(Integer value) {
                    addCriterion("agency_id >", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdGreaterThanOrEqualTo(Integer value) {
                    addCriterion("agency_id >=", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdLessThan(Integer value) {
                    addCriterion("agency_id <", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdLessThanOrEqualTo(Integer value) {
                    addCriterion("agency_id <=", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdLike(Integer value) {
                    addCriterion("agency_id like", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdNotLike(Integer value) {
                    addCriterion("agency_id not like", value, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdIn(List<Integer> values) {
                    addCriterion("agency_id in", values, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andagencyIdNotIn(List<Integer> values) {
                    addCriterion("agency_id not in", values, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdBetween(Integer value1, Integer value2) {
                    addCriterion("agency_id between", value1, value2, "agencyId");
                    return (Criteria) this;
                }

                public Criteria andAgencyIdNotBetween(Integer value1, Integer value2) {
                    addCriterion("agency_id not between", value1, value2, "agencyId");
                    return (Criteria) this;
                }

                        }
}
