package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RealtimeSimulationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealtimeSimulationExample() {
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

        public Criteria andSimulationidRealsimIsNull() {
            addCriterion("SIMULATIONID_REALSIM is null");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimIsNotNull() {
            addCriterion("SIMULATIONID_REALSIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIM =", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimNotEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIM <>", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimGreaterThan(Long value) {
            addCriterion("SIMULATIONID_REALSIM >", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimGreaterThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIM >=", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimLessThan(Long value) {
            addCriterion("SIMULATIONID_REALSIM <", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimLessThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIM <=", value, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimIn(List<Long> values) {
            addCriterion("SIMULATIONID_REALSIM in", values, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimNotIn(List<Long> values) {
            addCriterion("SIMULATIONID_REALSIM not in", values, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_REALSIM between", value1, value2, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimNotBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_REALSIM not between", value1, value2, "simulationidRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimIsNull() {
            addCriterion("SIMULATIONNAME_REALSIM is null");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimIsNotNull() {
            addCriterion("SIMULATIONNAME_REALSIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimEqualTo(String value) {
            addCriterion("SIMULATIONNAME_REALSIM =", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimNotEqualTo(String value) {
            addCriterion("SIMULATIONNAME_REALSIM <>", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimGreaterThan(String value) {
            addCriterion("SIMULATIONNAME_REALSIM >", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimGreaterThanOrEqualTo(String value) {
            addCriterion("SIMULATIONNAME_REALSIM >=", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimLessThan(String value) {
            addCriterion("SIMULATIONNAME_REALSIM <", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimLessThanOrEqualTo(String value) {
            addCriterion("SIMULATIONNAME_REALSIM <=", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimLike(String value) {
            addCriterion("SIMULATIONNAME_REALSIM like", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimNotLike(String value) {
            addCriterion("SIMULATIONNAME_REALSIM not like", value, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimIn(List<String> values) {
            addCriterion("SIMULATIONNAME_REALSIM in", values, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimNotIn(List<String> values) {
            addCriterion("SIMULATIONNAME_REALSIM not in", values, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimBetween(String value1, String value2) {
            addCriterion("SIMULATIONNAME_REALSIM between", value1, value2, "simulationnameRealsim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameRealsimNotBetween(String value1, String value2) {
            addCriterion("SIMULATIONNAME_REALSIM not between", value1, value2, "simulationnameRealsim");
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

        public Criteria andCreatedateRealsimIsNull() {
            addCriterion("CREATEDATE_REALSIM is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimIsNotNull() {
            addCriterion("CREATEDATE_REALSIM is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimEqualTo(Date value) {
            addCriterion("CREATEDATE_REALSIM =", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimNotEqualTo(Date value) {
            addCriterion("CREATEDATE_REALSIM <>", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimGreaterThan(Date value) {
            addCriterion("CREATEDATE_REALSIM >", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_REALSIM >=", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimLessThan(Date value) {
            addCriterion("CREATEDATE_REALSIM <", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimLessThanOrEqualTo(Date value) {
            addCriterion("CREATEDATE_REALSIM <=", value, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimIn(List<Date> values) {
            addCriterion("CREATEDATE_REALSIM in", values, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimNotIn(List<Date> values) {
            addCriterion("CREATEDATE_REALSIM not in", values, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_REALSIM between", value1, value2, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andCreatedateRealsimNotBetween(Date value1, Date value2) {
            addCriterion("CREATEDATE_REALSIM not between", value1, value2, "createdateRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimIsNull() {
            addCriterion("REMARK_REALSIM is null");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimIsNotNull() {
            addCriterion("REMARK_REALSIM is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimEqualTo(String value) {
            addCriterion("REMARK_REALSIM =", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimNotEqualTo(String value) {
            addCriterion("REMARK_REALSIM <>", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimGreaterThan(String value) {
            addCriterion("REMARK_REALSIM >", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_REALSIM >=", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimLessThan(String value) {
            addCriterion("REMARK_REALSIM <", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimLessThanOrEqualTo(String value) {
            addCriterion("REMARK_REALSIM <=", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimLike(String value) {
            addCriterion("REMARK_REALSIM like", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimNotLike(String value) {
            addCriterion("REMARK_REALSIM not like", value, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimIn(List<String> values) {
            addCriterion("REMARK_REALSIM in", values, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimNotIn(List<String> values) {
            addCriterion("REMARK_REALSIM not in", values, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimBetween(String value1, String value2) {
            addCriterion("REMARK_REALSIM between", value1, value2, "remarkRealsim");
            return (Criteria) this;
        }

        public Criteria andRemarkRealsimNotBetween(String value1, String value2) {
            addCriterion("REMARK_REALSIM not between", value1, value2, "remarkRealsim");
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