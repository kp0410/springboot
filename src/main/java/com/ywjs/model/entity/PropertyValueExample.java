package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.List;

public class PropertyValueExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public PropertyValueExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
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
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
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

        public Criteria andProvalueidProvalIsNull() {
            addCriterion("PROVALUEID_PROVAL is null");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalIsNotNull() {
            addCriterion("PROVALUEID_PROVAL is not null");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalEqualTo(Integer value) {
            addCriterion("PROVALUEID_PROVAL =", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalNotEqualTo(Integer value) {
            addCriterion("PROVALUEID_PROVAL <>", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalGreaterThan(Integer value) {
            addCriterion("PROVALUEID_PROVAL >", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVALUEID_PROVAL >=", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalLessThan(Integer value) {
            addCriterion("PROVALUEID_PROVAL <", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalLessThanOrEqualTo(Integer value) {
            addCriterion("PROVALUEID_PROVAL <=", value, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalIn(List<Integer> values) {
            addCriterion("PROVALUEID_PROVAL in", values, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalNotIn(List<Integer> values) {
            addCriterion("PROVALUEID_PROVAL not in", values, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalBetween(Integer value1, Integer value2) {
            addCriterion("PROVALUEID_PROVAL between", value1, value2, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andProvalueidProvalNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVALUEID_PROVAL not between", value1, value2, "provalueidProval");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkIsNull() {
            addCriterion("WORKID_WORK is null");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkIsNotNull() {
            addCriterion("WORKID_WORK is not null");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkEqualTo(Long value) {
            addCriterion("WORKID_WORK =", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkNotEqualTo(Integer value) {
            addCriterion("WORKID_WORK <>", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkGreaterThan(Integer value) {
            addCriterion("WORKID_WORK >", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORKID_WORK >=", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkLessThan(Integer value) {
            addCriterion("WORKID_WORK <", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkLessThanOrEqualTo(Integer value) {
            addCriterion("WORKID_WORK <=", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkIn(List<Integer> values) {
            addCriterion("WORKID_WORK in", values, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkNotIn(List<Integer> values) {
            addCriterion("WORKID_WORK not in", values, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkBetween(Integer value1, Integer value2) {
            addCriterion("WORKID_WORK between", value1, value2, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkNotBetween(Integer value1, Integer value2) {
            addCriterion("WORKID_WORK not between", value1, value2, "workidWork");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIsNull() {
            addCriterion("PROPERTYID_PRO is null");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIsNotNull() {
            addCriterion("PROPERTYID_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyidProEqualTo(Integer value) {
            addCriterion("PROPERTYID_PRO =", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotEqualTo(Integer value) {
            addCriterion("PROPERTYID_PRO <>", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThan(Integer value) {
            addCriterion("PROPERTYID_PRO >", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROPERTYID_PRO >=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThan(Integer value) {
            addCriterion("PROPERTYID_PRO <", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThanOrEqualTo(Integer value) {
            addCriterion("PROPERTYID_PRO <=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIn(List<Integer> values) {
            addCriterion("PROPERTYID_PRO in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotIn(List<Integer> values) {
            addCriterion("PROPERTYID_PRO not in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTYID_PRO between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTYID_PRO not between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleIsNull() {
            addCriterion("ELEMENTREALNAME_ELE is null");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleIsNotNull() {
            addCriterion("ELEMENTREALNAME_ELE is not null");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_ELE =", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleNotEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_ELE <>", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleGreaterThan(String value) {
            addCriterion("ELEMENTREALNAME_ELE >", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleGreaterThanOrEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_ELE >=", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleLessThan(String value) {
            addCriterion("ELEMENTREALNAME_ELE <", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleLessThanOrEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_ELE <=", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleLike(String value) {
            addCriterion("ELEMENTREALNAME_ELE like", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleNotLike(String value) {
            addCriterion("ELEMENTREALNAME_ELE not like", value, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleIn(List<String> values) {
            addCriterion("ELEMENTREALNAME_ELE in", values, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleNotIn(List<String> values) {
            addCriterion("ELEMENTREALNAME_ELE not in", values, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleBetween(String value1, String value2) {
            addCriterion("ELEMENTREALNAME_ELE between", value1, value2, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEleNotBetween(String value1, String value2) {
            addCriterion("ELEMENTREALNAME_ELE not between", value1, value2, "elementrealnameEle");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalIsNull() {
            addCriterion("PROVALUE_PROVAL is null");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalIsNotNull() {
            addCriterion("PROVALUE_PROVAL is not null");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalEqualTo(String value) {
            addCriterion("PROVALUE_PROVAL =", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalNotEqualTo(String value) {
            addCriterion("PROVALUE_PROVAL <>", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalGreaterThan(String value) {
            addCriterion("PROVALUE_PROVAL >", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalGreaterThanOrEqualTo(String value) {
            addCriterion("PROVALUE_PROVAL >=", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalLessThan(String value) {
            addCriterion("PROVALUE_PROVAL <", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalLessThanOrEqualTo(String value) {
            addCriterion("PROVALUE_PROVAL <=", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalLike(String value) {
            addCriterion("PROVALUE_PROVAL like", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalNotLike(String value) {
            addCriterion("PROVALUE_PROVAL not like", value, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalIn(List<String> values) {
            addCriterion("PROVALUE_PROVAL in", values, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalNotIn(List<String> values) {
            addCriterion("PROVALUE_PROVAL not in", values, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalBetween(String value1, String value2) {
            addCriterion("PROVALUE_PROVAL between", value1, value2, "provalueProval");
            return (Criteria) this;
        }

        public Criteria andProvalueProvalNotBetween(String value1, String value2) {
            addCriterion("PROVALUE_PROVAL not between", value1, value2, "provalueProval");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated do_not_delete_during_merge Sat Nov 16 17:38:31 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table PROPERTY_VALUE_TBL
     *
     * @mbggenerated Sat Nov 16 17:38:31 CST 2019
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