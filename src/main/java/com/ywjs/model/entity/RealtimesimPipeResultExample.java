package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.List;

public class RealtimesimPipeResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealtimesimPipeResultExample() {
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

        public Criteria andSimulationidRealsimallIsNull() {
            addCriterion("SIMULATIONID_REALSIMALL is null");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallIsNotNull() {
            addCriterion("SIMULATIONID_REALSIMALL is not null");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL =", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallNotEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL <>", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallGreaterThan(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL >", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallGreaterThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL >=", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallLessThan(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL <", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallLessThanOrEqualTo(Long value) {
            addCriterion("SIMULATIONID_REALSIMALL <=", value, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallIn(List<Long> values) {
            addCriterion("SIMULATIONID_REALSIMALL in", values, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallNotIn(List<Long> values) {
            addCriterion("SIMULATIONID_REALSIMALL not in", values, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_REALSIMALL between", value1, value2, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andSimulationidRealsimallNotBetween(Long value1, Long value2) {
            addCriterion("SIMULATIONID_REALSIMALL not between", value1, value2, "simulationidRealsimall");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesIsNull() {
            addCriterion("PIPENAME_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesIsNotNull() {
            addCriterion("PIPENAME_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesEqualTo(String value) {
            addCriterion("PIPENAME_SIMPIPERES =", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesNotEqualTo(String value) {
            addCriterion("PIPENAME_SIMPIPERES <>", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesGreaterThan(String value) {
            addCriterion("PIPENAME_SIMPIPERES >", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesGreaterThanOrEqualTo(String value) {
            addCriterion("PIPENAME_SIMPIPERES >=", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesLessThan(String value) {
            addCriterion("PIPENAME_SIMPIPERES <", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesLessThanOrEqualTo(String value) {
            addCriterion("PIPENAME_SIMPIPERES <=", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesLike(String value) {
            addCriterion("PIPENAME_SIMPIPERES like", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesNotLike(String value) {
            addCriterion("PIPENAME_SIMPIPERES not like", value, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesIn(List<String> values) {
            addCriterion("PIPENAME_SIMPIPERES in", values, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesNotIn(List<String> values) {
            addCriterion("PIPENAME_SIMPIPERES not in", values, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesBetween(String value1, String value2) {
            addCriterion("PIPENAME_SIMPIPERES between", value1, value2, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipenameSimpiperesNotBetween(String value1, String value2) {
            addCriterion("PIPENAME_SIMPIPERES not between", value1, value2, "pipenameSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesIsNull() {
            addCriterion("PIPEID_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesIsNotNull() {
            addCriterion("PIPEID_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesEqualTo(String value) {
            addCriterion("PIPEID_SIMPIPERES =", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesNotEqualTo(String value) {
            addCriterion("PIPEID_SIMPIPERES <>", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesGreaterThan(String value) {
            addCriterion("PIPEID_SIMPIPERES >", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesGreaterThanOrEqualTo(String value) {
            addCriterion("PIPEID_SIMPIPERES >=", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesLessThan(String value) {
            addCriterion("PIPEID_SIMPIPERES <", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesLessThanOrEqualTo(String value) {
            addCriterion("PIPEID_SIMPIPERES <=", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesLike(String value) {
            addCriterion("PIPEID_SIMPIPERES like", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesNotLike(String value) {
            addCriterion("PIPEID_SIMPIPERES not like", value, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesIn(List<String> values) {
            addCriterion("PIPEID_SIMPIPERES in", values, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesNotIn(List<String> values) {
            addCriterion("PIPEID_SIMPIPERES not in", values, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesBetween(String value1, String value2) {
            addCriterion("PIPEID_SIMPIPERES between", value1, value2, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPipeidSimpiperesNotBetween(String value1, String value2) {
            addCriterion("PIPEID_SIMPIPERES not between", value1, value2, "pipeidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesIsNull() {
            addCriterion("MILEAGE_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesIsNotNull() {
            addCriterion("MILEAGE_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesEqualTo(Double value) {
            addCriterion("MILEAGE_SIMPIPERES =", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesNotEqualTo(Double value) {
            addCriterion("MILEAGE_SIMPIPERES <>", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesGreaterThan(Double value) {
            addCriterion("MILEAGE_SIMPIPERES >", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("MILEAGE_SIMPIPERES >=", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesLessThan(Double value) {
            addCriterion("MILEAGE_SIMPIPERES <", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("MILEAGE_SIMPIPERES <=", value, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesIn(List<Double> values) {
            addCriterion("MILEAGE_SIMPIPERES in", values, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesNotIn(List<Double> values) {
            addCriterion("MILEAGE_SIMPIPERES not in", values, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesBetween(Double value1, Double value2) {
            addCriterion("MILEAGE_SIMPIPERES between", value1, value2, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andMileageSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("MILEAGE_SIMPIPERES not between", value1, value2, "mileageSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesIsNull() {
            addCriterion("ELEVATION_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesIsNotNull() {
            addCriterion("ELEVATION_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesEqualTo(Double value) {
            addCriterion("ELEVATION_SIMPIPERES =", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesNotEqualTo(Double value) {
            addCriterion("ELEVATION_SIMPIPERES <>", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesGreaterThan(Double value) {
            addCriterion("ELEVATION_SIMPIPERES >", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("ELEVATION_SIMPIPERES >=", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesLessThan(Double value) {
            addCriterion("ELEVATION_SIMPIPERES <", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("ELEVATION_SIMPIPERES <=", value, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesIn(List<Double> values) {
            addCriterion("ELEVATION_SIMPIPERES in", values, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesNotIn(List<Double> values) {
            addCriterion("ELEVATION_SIMPIPERES not in", values, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesBetween(Double value1, Double value2) {
            addCriterion("ELEVATION_SIMPIPERES between", value1, value2, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andElevationSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("ELEVATION_SIMPIPERES not between", value1, value2, "elevationSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesIsNull() {
            addCriterion("TEMPERATURE_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesIsNotNull() {
            addCriterion("TEMPERATURE_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesEqualTo(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES =", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesNotEqualTo(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES <>", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesGreaterThan(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES >", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES >=", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesLessThan(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES <", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("TEMPERATURE_SIMPIPERES <=", value, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesIn(List<Double> values) {
            addCriterion("TEMPERATURE_SIMPIPERES in", values, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesNotIn(List<Double> values) {
            addCriterion("TEMPERATURE_SIMPIPERES not in", values, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesBetween(Double value1, Double value2) {
            addCriterion("TEMPERATURE_SIMPIPERES between", value1, value2, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andTemperatureSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("TEMPERATURE_SIMPIPERES not between", value1, value2, "temperatureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesIsNull() {
            addCriterion("PRESSURE_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesIsNotNull() {
            addCriterion("PRESSURE_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesEqualTo(Double value) {
            addCriterion("PRESSURE_SIMPIPERES =", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesNotEqualTo(Double value) {
            addCriterion("PRESSURE_SIMPIPERES <>", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesGreaterThan(Double value) {
            addCriterion("PRESSURE_SIMPIPERES >", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("PRESSURE_SIMPIPERES >=", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesLessThan(Double value) {
            addCriterion("PRESSURE_SIMPIPERES <", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("PRESSURE_SIMPIPERES <=", value, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesIn(List<Double> values) {
            addCriterion("PRESSURE_SIMPIPERES in", values, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesNotIn(List<Double> values) {
            addCriterion("PRESSURE_SIMPIPERES not in", values, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesBetween(Double value1, Double value2) {
            addCriterion("PRESSURE_SIMPIPERES between", value1, value2, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andPressureSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("PRESSURE_SIMPIPERES not between", value1, value2, "pressureSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesIsNull() {
            addCriterion("FLOW_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesIsNotNull() {
            addCriterion("FLOW_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesEqualTo(Double value) {
            addCriterion("FLOW_SIMPIPERES =", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesNotEqualTo(Double value) {
            addCriterion("FLOW_SIMPIPERES <>", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesGreaterThan(Double value) {
            addCriterion("FLOW_SIMPIPERES >", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("FLOW_SIMPIPERES >=", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesLessThan(Double value) {
            addCriterion("FLOW_SIMPIPERES <", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("FLOW_SIMPIPERES <=", value, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesIn(List<Double> values) {
            addCriterion("FLOW_SIMPIPERES in", values, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesNotIn(List<Double> values) {
            addCriterion("FLOW_SIMPIPERES not in", values, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesBetween(Double value1, Double value2) {
            addCriterion("FLOW_SIMPIPERES between", value1, value2, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andFlowSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("FLOW_SIMPIPERES not between", value1, value2, "flowSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesIsNull() {
            addCriterion("LIQUID_SIMPIPERES is null");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesIsNotNull() {
            addCriterion("LIQUID_SIMPIPERES is not null");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesEqualTo(Double value) {
            addCriterion("LIQUID_SIMPIPERES =", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesNotEqualTo(Double value) {
            addCriterion("LIQUID_SIMPIPERES <>", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesGreaterThan(Double value) {
            addCriterion("LIQUID_SIMPIPERES >", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesGreaterThanOrEqualTo(Double value) {
            addCriterion("LIQUID_SIMPIPERES >=", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesLessThan(Double value) {
            addCriterion("LIQUID_SIMPIPERES <", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesLessThanOrEqualTo(Double value) {
            addCriterion("LIQUID_SIMPIPERES <=", value, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesIn(List<Double> values) {
            addCriterion("LIQUID_SIMPIPERES in", values, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesNotIn(List<Double> values) {
            addCriterion("LIQUID_SIMPIPERES not in", values, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesBetween(Double value1, Double value2) {
            addCriterion("LIQUID_SIMPIPERES between", value1, value2, "liquidSimpiperes");
            return (Criteria) this;
        }

        public Criteria andLiquidSimpiperesNotBetween(Double value1, Double value2) {
            addCriterion("LIQUID_SIMPIPERES not between", value1, value2, "liquidSimpiperes");
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