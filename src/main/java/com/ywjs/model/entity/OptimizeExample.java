package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OptimizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptimizeExample() {
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

        public Criteria andOptimidOptimIsNull() {
            addCriterion("OPTIMID_OPTIM is null");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimIsNotNull() {
            addCriterion("OPTIMID_OPTIM is not null");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimEqualTo(String value) {
            addCriterion("OPTIMID_OPTIM =", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimNotEqualTo(String value) {
            addCriterion("OPTIMID_OPTIM <>", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimGreaterThan(String value) {
            addCriterion("OPTIMID_OPTIM >", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIMID_OPTIM >=", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimLessThan(String value) {
            addCriterion("OPTIMID_OPTIM <", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimLessThanOrEqualTo(String value) {
            addCriterion("OPTIMID_OPTIM <=", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimLike(String value) {
            addCriterion("OPTIMID_OPTIM like", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimNotLike(String value) {
            addCriterion("OPTIMID_OPTIM not like", value, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimIn(List<String> values) {
            addCriterion("OPTIMID_OPTIM in", values, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimNotIn(List<String> values) {
            addCriterion("OPTIMID_OPTIM not in", values, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimBetween(String value1, String value2) {
            addCriterion("OPTIMID_OPTIM between", value1, value2, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimidOptimNotBetween(String value1, String value2) {
            addCriterion("OPTIMID_OPTIM not between", value1, value2, "optimidOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimIsNull() {
            addCriterion("OPTIMNAME_OPTIM is null");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimIsNotNull() {
            addCriterion("OPTIMNAME_OPTIM is not null");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimEqualTo(String value) {
            addCriterion("OPTIMNAME_OPTIM =", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimNotEqualTo(String value) {
            addCriterion("OPTIMNAME_OPTIM <>", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimGreaterThan(String value) {
            addCriterion("OPTIMNAME_OPTIM >", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIMNAME_OPTIM >=", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimLessThan(String value) {
            addCriterion("OPTIMNAME_OPTIM <", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimLessThanOrEqualTo(String value) {
            addCriterion("OPTIMNAME_OPTIM <=", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimLike(String value) {
            addCriterion("OPTIMNAME_OPTIM like", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimNotLike(String value) {
            addCriterion("OPTIMNAME_OPTIM not like", value, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimIn(List<String> values) {
            addCriterion("OPTIMNAME_OPTIM in", values, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimNotIn(List<String> values) {
            addCriterion("OPTIMNAME_OPTIM not in", values, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimBetween(String value1, String value2) {
            addCriterion("OPTIMNAME_OPTIM between", value1, value2, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimnameOptimNotBetween(String value1, String value2) {
            addCriterion("OPTIMNAME_OPTIM not between", value1, value2, "optimnameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimIsNull() {
            addCriterion("OPTIMUSERNAME_OPTIM is null");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimIsNotNull() {
            addCriterion("OPTIMUSERNAME_OPTIM is not null");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimEqualTo(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM =", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimNotEqualTo(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM <>", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimGreaterThan(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM >", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM >=", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimLessThan(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM <", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimLessThanOrEqualTo(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM <=", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimLike(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM like", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimNotLike(String value) {
            addCriterion("OPTIMUSERNAME_OPTIM not like", value, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimIn(List<String> values) {
            addCriterion("OPTIMUSERNAME_OPTIM in", values, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimNotIn(List<String> values) {
            addCriterion("OPTIMUSERNAME_OPTIM not in", values, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimBetween(String value1, String value2) {
            addCriterion("OPTIMUSERNAME_OPTIM between", value1, value2, "optimusernameOptim");
            return (Criteria) this;
        }

        public Criteria andOptimusernameOptimNotBetween(String value1, String value2) {
            addCriterion("OPTIMUSERNAME_OPTIM not between", value1, value2, "optimusernameOptim");
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

        public Criteria andWorkidWorkNotEqualTo(Long value) {
            addCriterion("WORKID_WORK <>", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkGreaterThan(Long value) {
            addCriterion("WORKID_WORK >", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkGreaterThanOrEqualTo(Long value) {
            addCriterion("WORKID_WORK >=", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkLessThan(Long value) {
            addCriterion("WORKID_WORK <", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkLessThanOrEqualTo(Long value) {
            addCriterion("WORKID_WORK <=", value, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkIn(List<Long> values) {
            addCriterion("WORKID_WORK in", values, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkNotIn(List<Long> values) {
            addCriterion("WORKID_WORK not in", values, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkBetween(Long value1, Long value2) {
            addCriterion("WORKID_WORK between", value1, value2, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidWorkNotBetween(Long value1, Long value2) {
            addCriterion("WORKID_WORK not between", value1, value2, "workidWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkIsNull() {
            addCriterion("WORKIDEND_WORK is null");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkIsNotNull() {
            addCriterion("WORKIDEND_WORK is not null");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkEqualTo(Long value) {
            addCriterion("WORKIDEND_WORK =", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkNotEqualTo(Long value) {
            addCriterion("WORKIDEND_WORK <>", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkGreaterThan(Long value) {
            addCriterion("WORKIDEND_WORK >", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkGreaterThanOrEqualTo(Long value) {
            addCriterion("WORKIDEND_WORK >=", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkLessThan(Long value) {
            addCriterion("WORKIDEND_WORK <", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkLessThanOrEqualTo(Long value) {
            addCriterion("WORKIDEND_WORK <=", value, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkIn(List<Long> values) {
            addCriterion("WORKIDEND_WORK in", values, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkNotIn(List<Long> values) {
            addCriterion("WORKIDEND_WORK not in", values, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkBetween(Long value1, Long value2) {
            addCriterion("WORKIDEND_WORK between", value1, value2, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andWorkidendWorkNotBetween(Long value1, Long value2) {
            addCriterion("WORKIDEND_WORK not between", value1, value2, "workidendWork");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimIsNull() {
            addCriterion("CREATEDATE_OPTIM is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimIsNotNull() {
            addCriterion("CREATEDATE_OPTIM is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimEqualTo(Date value) {
            addCriterion("CREATEDATE_OPTIM =", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimNotEqualTo(Date value) {
            addCriterion("CREATEDATE_OPTIM <>", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimGreaterThan(Date value) {
            addCriterion("CREATEDATE_OPTIM >", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_OPTIM >=", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimLessThan(Date value) {
            addCriterion("CREATEDATE_OPTIM <", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_OPTIM <=", value, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimIn(List<Date> values) {
            addCriterion("CREATEDATE_OPTIM in", values, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimNotIn(List<Date> values) {
            addCriterion("CREATEDATE_OPTIM not in", values, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_OPTIM between", value1, value2, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andCreatedateOptimNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_OPTIM not between", value1, value2, "createdateOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimIsNull() {
            addCriterion("REMARK_OPTIM is null");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimIsNotNull() {
            addCriterion("REMARK_OPTIM is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimEqualTo(String value) {
            addCriterion("REMARK_OPTIM =", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimNotEqualTo(String value) {
            addCriterion("REMARK_OPTIM <>", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimGreaterThan(String value) {
            addCriterion("REMARK_OPTIM >", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_OPTIM >=", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimLessThan(String value) {
            addCriterion("REMARK_OPTIM <", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimLessThanOrEqualTo(String value) {
            addCriterion("REMARK_OPTIM <=", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimLike(String value) {
            addCriterion("REMARK_OPTIM like", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimNotLike(String value) {
            addCriterion("REMARK_OPTIM not like", value, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimIn(List<String> values) {
            addCriterion("REMARK_OPTIM in", values, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimNotIn(List<String> values) {
            addCriterion("REMARK_OPTIM not in", values, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimBetween(String value1, String value2) {
            addCriterion("REMARK_OPTIM between", value1, value2, "remarkOptim");
            return (Criteria) this;
        }

        public Criteria andRemarkOptimNotBetween(String value1, String value2) {
            addCriterion("REMARK_OPTIM not between", value1, value2, "remarkOptim");
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