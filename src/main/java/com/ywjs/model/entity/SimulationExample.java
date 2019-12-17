package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimulationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SimulationExample() {
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

        public Criteria andSimulationidSimIsNull() {
            addCriterion("SIMULATIONID_SIM is null");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimIsNotNull() {
            addCriterion("SIMULATIONID_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimEqualTo(Long value) {
            addCriterion("SIMULATIONID_SIM =", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimNotEqualTo(Long value) {
            addCriterion("SIMULATIONID_SIM <>", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimGreaterThan(Long value) {
            addCriterion("SIMULATIONID_SIM >", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimGreaterThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_SIM >=", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimLessThan(Long value) {
            addCriterion("SIMULATIONID_SIM <", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimLessThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_SIM <=", value, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimIn(List<Long> values) {
            addCriterion("SIMULATIONID_SIM in", values, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimNotIn(List<Long> values) {
            addCriterion("SIMULATIONID_SIM not in", values, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_SIM between", value1, value2, "simulationidSim");
            return (Criteria) this;
        }

        public Criteria andSimulationidSimNotBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_SIM not between", value1, value2, "simulationidSim");
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

        public Criteria andSimulationnameSimIsNull() {
            addCriterion("SIMULATIONNAME_SIM is null");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimIsNotNull() {
            addCriterion("SIMULATIONNAME_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimEqualTo(String value) {
            addCriterion("SIMULATIONNAME_SIM =", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimNotEqualTo(String value) {
            addCriterion("SIMULATIONNAME_SIM <>", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimGreaterThan(String value) {
            addCriterion("SIMULATIONNAME_SIM >", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimGreaterThanOrEqualTo(String value) {
            addCriterion("SIMULATIONNAME_SIM >=", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimLessThan(String value) {
            addCriterion("SIMULATIONNAME_SIM <", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimLessThanOrEqualTo(String value) {
            addCriterion("SIMULATIONNAME_SIM <=", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimLike(String value) {
            addCriterion("SIMULATIONNAME_SIM like", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimNotLike(String value) {
            addCriterion("SIMULATIONNAME_SIM not like", value, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimIn(List<String> values) {
            addCriterion("SIMULATIONNAME_SIM in", values, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimNotIn(List<String> values) {
            addCriterion("SIMULATIONNAME_SIM not in", values, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimBetween(String value1, String value2) {
            addCriterion("SIMULATIONNAME_SIM between", value1, value2, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimulationnameSimNotBetween(String value1, String value2) {
            addCriterion("SIMULATIONNAME_SIM not between", value1, value2, "simulationnameSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimIsNull() {
            addCriterion("SIMSOURCE_SIM is null");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimIsNotNull() {
            addCriterion("SIMSOURCE_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimEqualTo(String value) {
            addCriterion("SIMSOURCE_SIM =", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimNotEqualTo(String value) {
            addCriterion("SIMSOURCE_SIM <>", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimGreaterThan(String value) {
            addCriterion("SIMSOURCE_SIM >", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimGreaterThanOrEqualTo(String value) {
            addCriterion("SIMSOURCE_SIM >=", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimLessThan(String value) {
            addCriterion("SIMSOURCE_SIM <", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimLessThanOrEqualTo(String value) {
            addCriterion("SIMSOURCE_SIM <=", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimLike(String value) {
            addCriterion("SIMSOURCE_SIM like", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimNotLike(String value) {
            addCriterion("SIMSOURCE_SIM not like", value, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimIn(List<String> values) {
            addCriterion("SIMSOURCE_SIM in", values, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimNotIn(List<String> values) {
            addCriterion("SIMSOURCE_SIM not in", values, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimBetween(String value1, String value2) {
            addCriterion("SIMSOURCE_SIM between", value1, value2, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimsourceSimNotBetween(String value1, String value2) {
            addCriterion("SIMSOURCE_SIM not between", value1, value2, "simsourceSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimIsNull() {
            addCriterion("SIMUSERNAME_SIM is null");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimIsNotNull() {
            addCriterion("SIMUSERNAME_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimEqualTo(String value) {
            addCriterion("SIMUSERNAME_SIM =", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimNotEqualTo(String value) {
            addCriterion("SIMUSERNAME_SIM <>", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimGreaterThan(String value) {
            addCriterion("SIMUSERNAME_SIM >", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimGreaterThanOrEqualTo(String value) {
            addCriterion("SIMUSERNAME_SIM >=", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimLessThan(String value) {
            addCriterion("SIMUSERNAME_SIM <", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimLessThanOrEqualTo(String value) {
            addCriterion("SIMUSERNAME_SIM <=", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimLike(String value) {
            addCriterion("SIMUSERNAME_SIM like", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimNotLike(String value) {
            addCriterion("SIMUSERNAME_SIM not like", value, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimIn(List<String> values) {
            addCriterion("SIMUSERNAME_SIM in", values, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimNotIn(List<String> values) {
            addCriterion("SIMUSERNAME_SIM not in", values, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimBetween(String value1, String value2) {
            addCriterion("SIMUSERNAME_SIM between", value1, value2, "simusernameSim");
            return (Criteria) this;
        }

        public Criteria andSimusernameSimNotBetween(String value1, String value2) {
            addCriterion("SIMUSERNAME_SIM not between", value1, value2, "simusernameSim");
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

        public Criteria andRemarkSimIsNull() {
            addCriterion("REMARK_SIM is null");
            return (Criteria) this;
        }

        public Criteria andRemarkSimIsNotNull() {
            addCriterion("REMARK_SIM is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkSimEqualTo(String value) {
            addCriterion("REMARK_SIM =", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimNotEqualTo(String value) {
            addCriterion("REMARK_SIM <>", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimGreaterThan(String value) {
            addCriterion("REMARK_SIM >", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK_SIM >=", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimLessThan(String value) {
            addCriterion("REMARK_SIM <", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimLessThanOrEqualTo(String value) {
            addCriterion("REMARK_SIM <=", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimLike(String value) {
            addCriterion("REMARK_SIM like", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimNotLike(String value) {
            addCriterion("REMARK_SIM not like", value, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimIn(List<String> values) {
            addCriterion("REMARK_SIM in", values, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimNotIn(List<String> values) {
            addCriterion("REMARK_SIM not in", values, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimBetween(String value1, String value2) {
            addCriterion("REMARK_SIM between", value1, value2, "remarkSim");
            return (Criteria) this;
        }

        public Criteria andRemarkSimNotBetween(String value1, String value2) {
            addCriterion("REMARK_SIM not between", value1, value2, "remarkSim");
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