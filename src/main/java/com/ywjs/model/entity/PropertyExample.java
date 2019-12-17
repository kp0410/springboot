package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.List;

public class PropertyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public PropertyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPropertyidProIsNull() {
            addCriterion("PROPERTYID_PRO is null");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIsNotNull() {
            addCriterion("PROPERTYID_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyidProEqualTo(Long value) {
            addCriterion("PROPERTYID_PRO =", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotEqualTo(Long value) {
            addCriterion("PROPERTYID_PRO <>", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThan(Long value) {
            addCriterion("PROPERTYID_PRO >", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThanOrEqualTo(Long value) {
            addCriterion("PROPERTYID_PRO >=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThan(Long value) {
            addCriterion("PROPERTYID_PRO <", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThanOrEqualTo(Long value) {
            addCriterion("PROPERTYID_PRO <=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIn(List<Long> values) {
            addCriterion("PROPERTYID_PRO in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotIn(List<Long> values) {
            addCriterion("PROPERTYID_PRO not in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProBetween(Long value1, Long value2) {
            addCriterion("PROPERTYID_PRO between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotBetween(Long value1, Long value2) {
            addCriterion("PROPERTYID_PRO not between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProIsNull() {
            addCriterion("PROPERTYCNNAME_PRO is null");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProIsNotNull() {
            addCriterion("PROPERTYCNNAME_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProEqualTo(String value) {
            addCriterion("PROPERTYCNNAME_PRO =", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProNotEqualTo(String value) {
            addCriterion("PROPERTYCNNAME_PRO <>", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProGreaterThan(String value) {
            addCriterion("PROPERTYCNNAME_PRO >", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTYCNNAME_PRO >=", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProLessThan(String value) {
            addCriterion("PROPERTYCNNAME_PRO <", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProLessThanOrEqualTo(String value) {
            addCriterion("PROPERTYCNNAME_PRO <=", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProLike(String value) {
            addCriterion("PROPERTYCNNAME_PRO like", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProNotLike(String value) {
            addCriterion("PROPERTYCNNAME_PRO not like", value, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProIn(List<String> values) {
            addCriterion("PROPERTYCNNAME_PRO in", values, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProNotIn(List<String> values) {
            addCriterion("PROPERTYCNNAME_PRO not in", values, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProBetween(String value1, String value2) {
            addCriterion("PROPERTYCNNAME_PRO between", value1, value2, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertycnnameProNotBetween(String value1, String value2) {
            addCriterion("PROPERTYCNNAME_PRO not between", value1, value2, "propertycnnamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProIsNull() {
            addCriterion("PROPERTYNAME_PRO is null");
            return (Criteria) this;
        }

        public Criteria andPropertynameProIsNotNull() {
            addCriterion("PROPERTYNAME_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andPropertynameProEqualTo(String value) {
            addCriterion("PROPERTYNAME_PRO =", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProNotEqualTo(String value) {
            addCriterion("PROPERTYNAME_PRO <>", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProGreaterThan(String value) {
            addCriterion("PROPERTYNAME_PRO >", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTYNAME_PRO >=", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProLessThan(String value) {
            addCriterion("PROPERTYNAME_PRO <", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProLessThanOrEqualTo(String value) {
            addCriterion("PROPERTYNAME_PRO <=", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProLike(String value) {
            addCriterion("PROPERTYNAME_PRO like", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProNotLike(String value) {
            addCriterion("PROPERTYNAME_PRO not like", value, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProIn(List<String> values) {
            addCriterion("PROPERTYNAME_PRO in", values, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProNotIn(List<String> values) {
            addCriterion("PROPERTYNAME_PRO not in", values, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProBetween(String value1, String value2) {
            addCriterion("PROPERTYNAME_PRO between", value1, value2, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertynameProNotBetween(String value1, String value2) {
            addCriterion("PROPERTYNAME_PRO not between", value1, value2, "propertynamePro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProIsNull() {
            addCriterion("PROPERTYUNIT_PRO is null");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProIsNotNull() {
            addCriterion("PROPERTYUNIT_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProEqualTo(String value) {
            addCriterion("PROPERTYUNIT_PRO =", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProNotEqualTo(String value) {
            addCriterion("PROPERTYUNIT_PRO <>", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProGreaterThan(String value) {
            addCriterion("PROPERTYUNIT_PRO >", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTYUNIT_PRO >=", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProLessThan(String value) {
            addCriterion("PROPERTYUNIT_PRO <", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProLessThanOrEqualTo(String value) {
            addCriterion("PROPERTYUNIT_PRO <=", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProLike(String value) {
            addCriterion("PROPERTYUNIT_PRO like", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProNotLike(String value) {
            addCriterion("PROPERTYUNIT_PRO not like", value, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProIn(List<String> values) {
            addCriterion("PROPERTYUNIT_PRO in", values, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProNotIn(List<String> values) {
            addCriterion("PROPERTYUNIT_PRO not in", values, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProBetween(String value1, String value2) {
            addCriterion("PROPERTYUNIT_PRO between", value1, value2, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andPropertyunitProNotBetween(String value1, String value2) {
            addCriterion("PROPERTYUNIT_PRO not between", value1, value2, "propertyunitPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProIsNull() {
            addCriterion("PRODEFVAL_PRO is null");
            return (Criteria) this;
        }

        public Criteria andProdefvalProIsNotNull() {
            addCriterion("PRODEFVAL_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andProdefvalProEqualTo(String value) {
            addCriterion("PRODEFVAL_PRO =", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProNotEqualTo(String value) {
            addCriterion("PRODEFVAL_PRO <>", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProGreaterThan(String value) {
            addCriterion("PRODEFVAL_PRO >", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProGreaterThanOrEqualTo(String value) {
            addCriterion("PRODEFVAL_PRO >=", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProLessThan(String value) {
            addCriterion("PRODEFVAL_PRO <", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProLessThanOrEqualTo(String value) {
            addCriterion("PRODEFVAL_PRO <=", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProLike(String value) {
            addCriterion("PRODEFVAL_PRO like", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProNotLike(String value) {
            addCriterion("PRODEFVAL_PRO not like", value, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProIn(List<String> values) {
            addCriterion("PRODEFVAL_PRO in", values, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProNotIn(List<String> values) {
            addCriterion("PRODEFVAL_PRO not in", values, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProBetween(String value1, String value2) {
            addCriterion("PRODEFVAL_PRO between", value1, value2, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andProdefvalProNotBetween(String value1, String value2) {
            addCriterion("PRODEFVAL_PRO not between", value1, value2, "prodefvalPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProIsNull() {
            addCriterion("REMARK_PRO is null");
            return (Criteria) this;
        }

        public Criteria andRemarkProIsNotNull() {
            addCriterion("REMARK_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkProEqualTo(String value) {
            addCriterion("REMARK_PRO =", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProNotEqualTo(String value) {
            addCriterion("REMARK_PRO <>", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProGreaterThan(String value) {
            addCriterion("REMARK_PRO >", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_PRO >=", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProLessThan(String value) {
            addCriterion("REMARK_PRO <", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProLessThanOrEqualTo(String value) {
            addCriterion("REMARK_PRO <=", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProLike(String value) {
            addCriterion("REMARK_PRO like", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProNotLike(String value) {
            addCriterion("REMARK_PRO not like", value, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProIn(List<String> values) {
            addCriterion("REMARK_PRO in", values, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProNotIn(List<String> values) {
            addCriterion("REMARK_PRO not in", values, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProBetween(String value1, String value2) {
            addCriterion("REMARK_PRO between", value1, value2, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andRemarkProNotBetween(String value1, String value2) {
            addCriterion("REMARK_PRO not between", value1, value2, "remarkPro");
            return (Criteria) this;
        }

        public Criteria andEditableProIsNull() {
            addCriterion("EDITABLE_PRO is null");
            return (Criteria) this;
        }

        public Criteria andEditableProIsNotNull() {
            addCriterion("EDITABLE_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andEditableProEqualTo(Long value) {
            addCriterion("EDITABLE_PRO =", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProNotEqualTo(Long value) {
            addCriterion("EDITABLE_PRO <>", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProGreaterThan(Long value) {
            addCriterion("EDITABLE_PRO >", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProGreaterThanOrEqualTo(Long value) {
            addCriterion("EDITABLE_PRO >=", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProLessThan(Long value) {
            addCriterion("EDITABLE_PRO <", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProLessThanOrEqualTo(Long value) {
            addCriterion("EDITABLE_PRO <=", value, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProIn(List<Long> values) {
            addCriterion("EDITABLE_PRO in", values, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProNotIn(List<Long> values) {
            addCriterion("EDITABLE_PRO not in", values, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProBetween(Long value1, Long value2) {
            addCriterion("EDITABLE_PRO between", value1, value2, "editablePro");
            return (Criteria) this;
        }

        public Criteria andEditableProNotBetween(Long value1, Long value2) {
            addCriterion("EDITABLE_PRO not between", value1, value2, "editablePro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProIsNull() {
            addCriterion("OPENDILAOG_PRO is null");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProIsNotNull() {
            addCriterion("OPENDILAOG_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProEqualTo(Long value) {
            addCriterion("OPENDILAOG_PRO =", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProNotEqualTo(Long value) {
            addCriterion("OPENDILAOG_PRO <>", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProGreaterThan(Long value) {
            addCriterion("OPENDILAOG_PRO >", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProGreaterThanOrEqualTo(Long value) {
            addCriterion("OPENDILAOG_PRO >=", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProLessThan(Long value) {
            addCriterion("OPENDILAOG_PRO <", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProLessThanOrEqualTo(Long value) {
            addCriterion("OPENDILAOG_PRO <=", value, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProIn(List<Long> values) {
            addCriterion("OPENDILAOG_PRO in", values, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProNotIn(List<Long> values) {
            addCriterion("OPENDILAOG_PRO not in", values, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProBetween(Long value1, Long value2) {
            addCriterion("OPENDILAOG_PRO between", value1, value2, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andOpendilaogProNotBetween(Long value1, Long value2) {
            addCriterion("OPENDILAOG_PRO not between", value1, value2, "opendilaogPro");
            return (Criteria) this;
        }

        public Criteria andShowProIsNull() {
            addCriterion("SHOW_PRO is null");
            return (Criteria) this;
        }

        public Criteria andShowProIsNotNull() {
            addCriterion("SHOW_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andShowProEqualTo(Long value) {
            addCriterion("SHOW_PRO =", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProNotEqualTo(Long value) {
            addCriterion("SHOW_PRO <>", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProGreaterThan(Long value) {
            addCriterion("SHOW_PRO >", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProGreaterThanOrEqualTo(Long value) {
            addCriterion("SHOW_PRO >=", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProLessThan(Long value) {
            addCriterion("SHOW_PRO <", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProLessThanOrEqualTo(Long value) {
            addCriterion("SHOW_PRO <=", value, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProIn(List<Long> values) {
            addCriterion("SHOW_PRO in", values, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProNotIn(List<Long> values) {
            addCriterion("SHOW_PRO not in", values, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProBetween(Long value1, Long value2) {
            addCriterion("SHOW_PRO between", value1, value2, "showPro");
            return (Criteria) this;
        }

        public Criteria andShowProNotBetween(Long value1, Long value2) {
            addCriterion("SHOW_PRO not between", value1, value2, "showPro");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 13 14:08:31 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_TBL
     *
     * @mbggenerated Wed Nov 13 14:08:31 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}