package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectAffiliatedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectAffiliatedExample() {
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

        public Criteria andProjectidProIsNull() {
            addCriterion("PROJECTID_PRO is null");
            return (Criteria) this;
        }

        public Criteria andProjectidProIsNotNull() {
            addCriterion("PROJECTID_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andProjectidProEqualTo(Long value) {
            addCriterion("PROJECTID_PRO =", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProNotEqualTo(Long value) {
            addCriterion("PROJECTID_PRO <>", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProGreaterThan(Long value) {
            addCriterion("PROJECTID_PRO >", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProGreaterThanOrEqualTo(Long value) {
            addCriterion("PROJECTID_PRO >=", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProLessThan(Long value) {
            addCriterion("PROJECTID_PRO <", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProLessThanOrEqualTo(Long value) {
            addCriterion("PROJECTID_PRO <=", value, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProIn(List<Long> values) {
            addCriterion("PROJECTID_PRO in", values, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProNotIn(List<Long> values) {
            addCriterion("PROJECTID_PRO not in", values, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProBetween(Long value1, Long value2) {
            addCriterion("PROJECTID_PRO between", value1, value2, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andProjectidProNotBetween(Long value1, Long value2) {
            addCriterion("PROJECTID_PRO not between", value1, value2, "projectidPro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffIsNull() {
            addCriterion("CREATEDATE_PROAFF is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffIsNotNull() {
            addCriterion("CREATEDATE_PROAFF is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffEqualTo(Date value) {
            addCriterion("CREATEDATE_PROAFF =", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffNotEqualTo(Date value) {
            addCriterion("CREATEDATE_PROAFF <>", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffGreaterThan(Date value) {
            addCriterion("CREATEDATE_PROAFF >", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_PROAFF >=", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffLessThan(Date value) {
            addCriterion("CREATEDATE_PROAFF <", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_PROAFF <=", value, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffIn(List<Date> values) {
            addCriterion("CREATEDATE_PROAFF in", values, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffNotIn(List<Date> values) {
            addCriterion("CREATEDATE_PROAFF not in", values, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_PROAFF between", value1, value2, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andCreatedateProaffNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_PROAFF not between", value1, value2, "createdateProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffIsNull() {
            addCriterion("PROUSERNAME_PROAFF is null");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffIsNotNull() {
            addCriterion("PROUSERNAME_PROAFF is not null");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffEqualTo(String value) {
            addCriterion("PROUSERNAME_PROAFF =", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffNotEqualTo(String value) {
            addCriterion("PROUSERNAME_PROAFF <>", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffGreaterThan(String value) {
            addCriterion("PROUSERNAME_PROAFF >", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffGreaterThanOrEqualTo(String value) {
            addCriterion("PROUSERNAME_PROAFF >=", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffLessThan(String value) {
            addCriterion("PROUSERNAME_PROAFF <", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffLessThanOrEqualTo(String value) {
            addCriterion("PROUSERNAME_PROAFF <=", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffLike(String value) {
            addCriterion("PROUSERNAME_PROAFF like", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffNotLike(String value) {
            addCriterion("PROUSERNAME_PROAFF not like", value, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffIn(List<String> values) {
            addCriterion("PROUSERNAME_PROAFF in", values, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffNotIn(List<String> values) {
            addCriterion("PROUSERNAME_PROAFF not in", values, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffBetween(String value1, String value2) {
            addCriterion("PROUSERNAME_PROAFF between", value1, value2, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andProusernameProaffNotBetween(String value1, String value2) {
            addCriterion("PROUSERNAME_PROAFF not between", value1, value2, "prousernameProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffIsNull() {
            addCriterion("REMARK_PROAFF is null");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffIsNotNull() {
            addCriterion("REMARK_PROAFF is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffEqualTo(String value) {
            addCriterion("REMARK_PROAFF =", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffNotEqualTo(String value) {
            addCriterion("REMARK_PROAFF <>", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffGreaterThan(String value) {
            addCriterion("REMARK_PROAFF >", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_PROAFF >=", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffLessThan(String value) {
            addCriterion("REMARK_PROAFF <", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffLessThanOrEqualTo(String value) {
            addCriterion("REMARK_PROAFF <=", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffLike(String value) {
            addCriterion("REMARK_PROAFF like", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffNotLike(String value) {
            addCriterion("REMARK_PROAFF not like", value, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffIn(List<String> values) {
            addCriterion("REMARK_PROAFF in", values, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffNotIn(List<String> values) {
            addCriterion("REMARK_PROAFF not in", values, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffBetween(String value1, String value2) {
            addCriterion("REMARK_PROAFF between", value1, value2, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andRemarkProaffNotBetween(String value1, String value2) {
            addCriterion("REMARK_PROAFF not between", value1, value2, "remarkProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffIsNull() {
            addCriterion("ISSAVE_PROAFF is null");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffIsNotNull() {
            addCriterion("ISSAVE_PROAFF is not null");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffEqualTo(Integer value) {
            addCriterion("ISSAVE_PROAFF =", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffNotEqualTo(Integer value) {
            addCriterion("ISSAVE_PROAFF <>", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffGreaterThan(Integer value) {
            addCriterion("ISSAVE_PROAFF >", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISSAVE_PROAFF >=", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffLessThan(Integer value) {
            addCriterion("ISSAVE_PROAFF <", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffLessThanOrEqualTo(Integer value) {
            addCriterion("ISSAVE_PROAFF <=", value, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffIn(List<Integer> values) {
            addCriterion("ISSAVE_PROAFF in", values, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffNotIn(List<Integer> values) {
            addCriterion("ISSAVE_PROAFF not in", values, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffBetween(Integer value1, Integer value2) {
            addCriterion("ISSAVE_PROAFF between", value1, value2, "issaveProaff");
            return (Criteria) this;
        }

        public Criteria andIssaveProaffNotBetween(Integer value1, Integer value2) {
            addCriterion("ISSAVE_PROAFF not between", value1, value2, "issaveProaff");
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