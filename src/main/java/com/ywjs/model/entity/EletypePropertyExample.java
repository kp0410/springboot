package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.List;

public class EletypePropertyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public EletypePropertyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
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
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
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

        public Criteria andEleproidEleproIsNull() {
            addCriterion("ELEPROID_ELEPRO is null");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproIsNotNull() {
            addCriterion("ELEPROID_ELEPRO is not null");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproEqualTo(Integer value) {
            addCriterion("ELEPROID_ELEPRO =", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproNotEqualTo(Integer value) {
            addCriterion("ELEPROID_ELEPRO <>", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproGreaterThan(Integer value) {
            addCriterion("ELEPROID_ELEPRO >", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproGreaterThanOrEqualTo(Integer value) {
            addCriterion("ELEPROID_ELEPRO >=", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproLessThan(Integer value) {
            addCriterion("ELEPROID_ELEPRO <", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproLessThanOrEqualTo(Integer value) {
            addCriterion("ELEPROID_ELEPRO <=", value, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproIn(List<Integer> values) {
            addCriterion("ELEPROID_ELEPRO in", values, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproNotIn(List<Integer> values) {
            addCriterion("ELEPROID_ELEPRO not in", values, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproBetween(Integer value1, Integer value2) {
            addCriterion("ELEPROID_ELEPRO between", value1, value2, "eleproidElepro");
            return (Criteria) this;
        }

        public Criteria andEleproidEleproNotBetween(Integer value1, Integer value2) {
            addCriterion("ELEPROID_ELEPRO not between", value1, value2, "eleproidElepro");
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

        public Criteria andEletypeEleproIsNull() {
            addCriterion("ELETYPE_ELEPRO is null");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproIsNotNull() {
            addCriterion("ELETYPE_ELEPRO is not null");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproEqualTo(String value) {
            addCriterion("ELETYPE_ELEPRO =", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproNotEqualTo(String value) {
            addCriterion("ELETYPE_ELEPRO <>", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproGreaterThan(String value) {
            addCriterion("ELETYPE_ELEPRO >", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproGreaterThanOrEqualTo(String value) {
            addCriterion("ELETYPE_ELEPRO >=", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproLessThan(String value) {
            addCriterion("ELETYPE_ELEPRO <", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproLessThanOrEqualTo(String value) {
            addCriterion("ELETYPE_ELEPRO <=", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproLike(String value) {
            addCriterion("ELETYPE_ELEPRO like", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproNotLike(String value) {
            addCriterion("ELETYPE_ELEPRO not like", value, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproIn(List<String> values) {
            addCriterion("ELETYPE_ELEPRO in", values, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproNotIn(List<String> values) {
            addCriterion("ELETYPE_ELEPRO not in", values, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproBetween(String value1, String value2) {
            addCriterion("ELETYPE_ELEPRO between", value1, value2, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeEleproNotBetween(String value1, String value2) {
            addCriterion("ELETYPE_ELEPRO not between", value1, value2, "eletypeElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproIsNull() {
            addCriterion("ELETYPE_NUMBER_ELEPRO is null");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproIsNotNull() {
            addCriterion("ELETYPE_NUMBER_ELEPRO is not null");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproEqualTo(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO =", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproNotEqualTo(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO <>", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproGreaterThan(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO >", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproGreaterThanOrEqualTo(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO >=", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproLessThan(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO <", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproLessThanOrEqualTo(Integer value) {
            addCriterion("ELETYPE_NUMBER_ELEPRO <=", value, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproIn(List<Integer> values) {
            addCriterion("ELETYPE_NUMBER_ELEPRO in", values, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproNotIn(List<Integer> values) {
            addCriterion("ELETYPE_NUMBER_ELEPRO not in", values, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproBetween(Integer value1, Integer value2) {
            addCriterion("ELETYPE_NUMBER_ELEPRO between", value1, value2, "eletypeNumberElepro");
            return (Criteria) this;
        }

        public Criteria andEletypeNumberEleproNotBetween(Integer value1, Integer value2) {
            addCriterion("ELETYPE_NUMBER_ELEPRO not between", value1, value2, "eletypeNumberElepro");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated do_not_delete_during_merge Tue Nov 12 19:05:36 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ELETYPE_PROPERTY_TBL
     *
     * @mbggenerated Tue Nov 12 19:05:36 CST 2019
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