package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andOperaidOperaIsNull() {
            addCriterion("OPERAID_OPERA is null");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaIsNotNull() {
            addCriterion("OPERAID_OPERA is not null");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaEqualTo(Long value) {
            addCriterion("OPERAID_OPERA =", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaNotEqualTo(Long value) {
            addCriterion("OPERAID_OPERA <>", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaGreaterThan(Long value) {
            addCriterion("OPERAID_OPERA >", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaGreaterThanOrEqualTo(Long value) {
            addCriterion("OPERAID_OPERA >=", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaLessThan(Long value) {
            addCriterion("OPERAID_OPERA <", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaLessThanOrEqualTo(Long value) {
            addCriterion("OPERAID_OPERA <=", value, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaIn(List<Long> values) {
            addCriterion("OPERAID_OPERA in", values, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaNotIn(List<Long> values) {
            addCriterion("OPERAID_OPERA not in", values, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaBetween(Long value1, Long value2) {
            addCriterion("OPERAID_OPERA between", value1, value2, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperaidOperaNotBetween(Long value1, Long value2) {
            addCriterion("OPERAID_OPERA not between", value1, value2, "operaidOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaIsNull() {
            addCriterion("OPERANAME_OPERA is null");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaIsNotNull() {
            addCriterion("OPERANAME_OPERA is not null");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaEqualTo(String value) {
            addCriterion("OPERANAME_OPERA =", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaNotEqualTo(String value) {
            addCriterion("OPERANAME_OPERA <>", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaGreaterThan(String value) {
            addCriterion("OPERANAME_OPERA >", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaGreaterThanOrEqualTo(String value) {
            addCriterion("OPERANAME_OPERA >=", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaLessThan(String value) {
            addCriterion("OPERANAME_OPERA <", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaLessThanOrEqualTo(String value) {
            addCriterion("OPERANAME_OPERA <=", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaLike(String value) {
            addCriterion("OPERANAME_OPERA like", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaNotLike(String value) {
            addCriterion("OPERANAME_OPERA not like", value, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaIn(List<String> values) {
            addCriterion("OPERANAME_OPERA in", values, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaNotIn(List<String> values) {
            addCriterion("OPERANAME_OPERA not in", values, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaBetween(String value1, String value2) {
            addCriterion("OPERANAME_OPERA between", value1, value2, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andOperanameOperaNotBetween(String value1, String value2) {
            addCriterion("OPERANAME_OPERA not between", value1, value2, "operanameOpera");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffIsNull() {
            addCriterion("PROJECTID_PROAFF is null");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffIsNotNull() {
            addCriterion("PROJECTID_PROAFF is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffEqualTo(Long value) {
            addCriterion("PROJECTID_PROAFF =", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotEqualTo(Long value) {
            addCriterion("PROJECTID_PROAFF <>", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffGreaterThan(Long value) {
            addCriterion("PROJECTID_PROAFF >", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffGreaterThanOrEqualTo(Long value) {
            addCriterion("PROJECTID_PROAFF >=", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffLessThan(Long value) {
            addCriterion("PROJECTID_PROAFF <", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffLessThanOrEqualTo(Long value) {
            addCriterion("PROJECTID_PROAFF <=", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffIn(List<Long> values) {
            addCriterion("PROJECTID_PROAFF in", values, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotIn(List<Long> values) {
            addCriterion("PROJECTID_PROAFF not in", values, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffBetween(Long value1, Long value2) {
            addCriterion("PROJECTID_PROAFF between", value1, value2, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotBetween(Long value1, Long value2) {
            addCriterion("PROJECTID_PROAFF not between", value1, value2, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaIsNull() {
            addCriterion("OPERAUSERNAME_OPERA is null");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaIsNotNull() {
            addCriterion("OPERAUSERNAME_OPERA is not null");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaEqualTo(String value) {
            addCriterion("OPERAUSERNAME_OPERA =", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaNotEqualTo(String value) {
            addCriterion("OPERAUSERNAME_OPERA <>", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaGreaterThan(String value) {
            addCriterion("OPERAUSERNAME_OPERA >", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaGreaterThanOrEqualTo(String value) {
            addCriterion("OPERAUSERNAME_OPERA >=", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaLessThan(String value) {
            addCriterion("OPERAUSERNAME_OPERA <", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaLessThanOrEqualTo(String value) {
            addCriterion("OPERAUSERNAME_OPERA <=", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaLike(String value) {
            addCriterion("OPERAUSERNAME_OPERA like", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaNotLike(String value) {
            addCriterion("OPERAUSERNAME_OPERA not like", value, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaIn(List<String> values) {
            addCriterion("OPERAUSERNAME_OPERA in", values, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaNotIn(List<String> values) {
            addCriterion("OPERAUSERNAME_OPERA not in", values, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaBetween(String value1, String value2) {
            addCriterion("OPERAUSERNAME_OPERA between", value1, value2, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andOperausernameOperaNotBetween(String value1, String value2) {
            addCriterion("OPERAUSERNAME_OPERA not between", value1, value2, "operausernameOpera");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimIsNull() {
            addCriterion("CREATEDATE_SIM is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimIsNotNull() {
            addCriterion("CREATEDATE_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimEqualTo(Date value) {
            addCriterion("CREATEDATE_SIM =", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimNotEqualTo(Date value) {
            addCriterion("CREATEDATE_SIM <>", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimGreaterThan(Date value) {
            addCriterion("CREATEDATE_SIM >", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_SIM >=", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimLessThan(Date value) {
            addCriterion("CREATEDATE_SIM <", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_SIM <=", value, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimIn(List<Date> values) {
            addCriterion("CREATEDATE_SIM in", values, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimNotIn(List<Date> values) {
            addCriterion("CREATEDATE_SIM not in", values, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_SIM between", value1, value2, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andCreatedateSimNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_SIM not between", value1, value2, "createdateSim");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaIsNull() {
            addCriterion("REMARK_OPERA is null");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaIsNotNull() {
            addCriterion("REMARK_OPERA is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaEqualTo(String value) {
            addCriterion("REMARK_OPERA =", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaNotEqualTo(String value) {
            addCriterion("REMARK_OPERA <>", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaGreaterThan(String value) {
            addCriterion("REMARK_OPERA >", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_OPERA >=", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaLessThan(String value) {
            addCriterion("REMARK_OPERA <", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaLessThanOrEqualTo(String value) {
            addCriterion("REMARK_OPERA <=", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaLike(String value) {
            addCriterion("REMARK_OPERA like", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaNotLike(String value) {
            addCriterion("REMARK_OPERA not like", value, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaIn(List<String> values) {
            addCriterion("REMARK_OPERA in", values, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaNotIn(List<String> values) {
            addCriterion("REMARK_OPERA not in", values, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaBetween(String value1, String value2) {
            addCriterion("REMARK_OPERA between", value1, value2, "remarkOpera");
            return (Criteria) this;
        }

        public Criteria andRemarkOperaNotBetween(String value1, String value2) {
            addCriterion("REMARK_OPERA not between", value1, value2, "remarkOpera");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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