package com.ljb.example;

import java.util.List;
import com.ljb.utils.BaseExample;
import com.ljb.utils.GeneratedCriteria;

/**
 * 菜单管理实体
 * 表名 sys_menu
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-11 21:43:47
 */
public class SysMenuExample extends BaseExample {
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

                                                public Criteria andIconIsNull() {
                    addCriterion("icon is null");
                    return (Criteria) this;
                }

                public Criteria andIconIsNotNull() {
                    addCriterion("icon is not null");
                    return (Criteria) this;
                }

                public Criteria andIconEqualTo(String value) {
                    addCriterion("icon =", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconNotEqualTo(String value) {
                    addCriterion("icon <>", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconGreaterThan(String value) {
                    addCriterion("icon >", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconGreaterThanOrEqualTo(String value) {
                    addCriterion("icon >=", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconLessThan(String value) {
                    addCriterion("icon <", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconLessThanOrEqualTo(String value) {
                    addCriterion("icon <=", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconLike(String value) {
                    addCriterion("icon like", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconNotLike(String value) {
                    addCriterion("icon not like", value, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconIn(List<String> values) {
                    addCriterion("icon in", values, "icon");
                    return (Criteria) this;
                }

                public Criteria andiconNotIn(List<String> values) {
                    addCriterion("icon not in", values, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconBetween(String value1, String value2) {
                    addCriterion("icon between", value1, value2, "icon");
                    return (Criteria) this;
                }

                public Criteria andIconNotBetween(String value1, String value2) {
                    addCriterion("icon not between", value1, value2, "icon");
                    return (Criteria) this;
                }

                                                public Criteria andOrderNumIsNull() {
                    addCriterion("order_num is null");
                    return (Criteria) this;
                }

                public Criteria andOrderNumIsNotNull() {
                    addCriterion("order_num is not null");
                    return (Criteria) this;
                }

                public Criteria andOrderNumEqualTo(Integer value) {
                    addCriterion("order_num =", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotEqualTo(Integer value) {
                    addCriterion("order_num <>", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumGreaterThan(Integer value) {
                    addCriterion("order_num >", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
                    addCriterion("order_num >=", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLessThan(Integer value) {
                    addCriterion("order_num <", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
                    addCriterion("order_num <=", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumLike(Integer value) {
                    addCriterion("order_num like", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotLike(Integer value) {
                    addCriterion("order_num not like", value, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumIn(List<Integer> values) {
                    addCriterion("order_num in", values, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andorderNumNotIn(List<Integer> values) {
                    addCriterion("order_num not in", values, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumBetween(Integer value1, Integer value2) {
                    addCriterion("order_num between", value1, value2, "orderNum");
                    return (Criteria) this;
                }

                public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
                    addCriterion("order_num not between", value1, value2, "orderNum");
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
