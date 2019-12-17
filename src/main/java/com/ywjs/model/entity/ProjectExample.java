package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectnameProIsNull() {
            addCriterion("PROJECTNAME_PRO is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameProIsNotNull() {
            addCriterion("PROJECTNAME_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameProEqualTo(String value) {
            addCriterion("PROJECTNAME_PRO =", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProNotEqualTo(String value) {
            addCriterion("PROJECTNAME_PRO <>", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProGreaterThan(String value) {
            addCriterion("PROJECTNAME_PRO >", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTNAME_PRO >=", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProLessThan(String value) {
            addCriterion("PROJECTNAME_PRO <", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProLessThanOrEqualTo(String value) {
            addCriterion("PROJECTNAME_PRO <=", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProLike(String value) {
            addCriterion("PROJECTNAME_PRO like", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProNotLike(String value) {
            addCriterion("PROJECTNAME_PRO not like", value, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProIn(List<String> values) {
            addCriterion("PROJECTNAME_PRO in", values, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProNotIn(List<String> values) {
            addCriterion("PROJECTNAME_PRO not in", values, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProBetween(String value1, String value2) {
            addCriterion("PROJECTNAME_PRO between", value1, value2, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andProjectnameProNotBetween(String value1, String value2) {
            addCriterion("PROJECTNAME_PRO not between", value1, value2, "projectnamePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProIsNull() {
            addCriterion("CREATEDATE_PRO is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateProIsNotNull() {
            addCriterion("CREATEDATE_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateProEqualTo(Date value) {
            addCriterion("CREATEDATE_PRO =", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProNotEqualTo(Date value) {
            addCriterion("CREATEDATE_PRO <>", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProGreaterThan(Date value) {
            addCriterion("CREATEDATE_PRO >", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_PRO >=", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProLessThan(Date value) {
            addCriterion("CREATEDATE_PRO <", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_PRO <=", value, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProIn(List<Date> values) {
            addCriterion("CREATEDATE_PRO in", values, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProNotIn(List<Date> values) {
            addCriterion("CREATEDATE_PRO not in", values, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_PRO between", value1, value2, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andCreatedateProNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_PRO not between", value1, value2, "createdatePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProIsNull() {
            addCriterion("PROUSERNAME_PRO is null");
            return (Criteria) this;
        }

        public Criteria andProusernameProIsNotNull() {
            addCriterion("PROUSERNAME_PRO is not null");
            return (Criteria) this;
        }

        public Criteria andProusernameProEqualTo(String value) {
            addCriterion("PROUSERNAME_PRO =", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProNotEqualTo(String value) {
            addCriterion("PROUSERNAME_PRO <>", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProGreaterThan(String value) {
            addCriterion("PROUSERNAME_PRO >", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProGreaterThanOrEqualTo(String value) {
            addCriterion("PROUSERNAME_PRO >=", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProLessThan(String value) {
            addCriterion("PROUSERNAME_PRO <", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProLessThanOrEqualTo(String value) {
            addCriterion("PROUSERNAME_PRO <=", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProLike(String value) {
            addCriterion("PROUSERNAME_PRO like", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProNotLike(String value) {
            addCriterion("PROUSERNAME_PRO not like", value, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProIn(List<String> values) {
            addCriterion("PROUSERNAME_PRO in", values, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProNotIn(List<String> values) {
            addCriterion("PROUSERNAME_PRO not in", values, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProBetween(String value1, String value2) {
            addCriterion("PROUSERNAME_PRO between", value1, value2, "prousernamePro");
            return (Criteria) this;
        }

        public Criteria andProusernameProNotBetween(String value1, String value2) {
            addCriterion("PROUSERNAME_PRO not between", value1, value2, "prousernamePro");
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