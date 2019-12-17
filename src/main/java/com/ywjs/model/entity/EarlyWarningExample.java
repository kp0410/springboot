package com.ywjs.model.entity;

import java.util.ArrayList;
import java.util.List;

public class EarlyWarningExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EarlyWarningExample() {
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

        public Criteria andEarwaridEarwarIsNull() {
            addCriterion("EARWARID_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarIsNotNull() {
            addCriterion("EARWARID_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarEqualTo(Long value) {
            addCriterion("EARWARID_EARWAR =", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarNotEqualTo(Long value) {
            addCriterion("EARWARID_EARWAR <>", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarGreaterThan(Long value) {
            addCriterion("EARWARID_EARWAR >", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarGreaterThanOrEqualTo(Long value) {
            addCriterion("EARWARID_EARWAR >=", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarLessThan(Long value) {
            addCriterion("EARWARID_EARWAR <", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarLessThanOrEqualTo(Long value) {
            addCriterion("EARWARID_EARWAR <=", value, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarIn(List<Long> values) {
            addCriterion("EARWARID_EARWAR in", values, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarNotIn(List<Long> values) {
            addCriterion("EARWARID_EARWAR not in", values, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarBetween(Long value1, Long value2) {
            addCriterion("EARWARID_EARWAR between", value1, value2, "earwaridEarwar");
            return (Criteria) this;
        }

        public Criteria andEarwaridEarwarNotBetween(Long value1, Long value2) {
            addCriterion("EARWARID_EARWAR not between", value1, value2, "earwaridEarwar");
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

        public Criteria andProjectidProaffEqualTo(String value) {
            addCriterion("PROJECTID_PROAFF =", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotEqualTo(String value) {
            addCriterion("PROJECTID_PROAFF <>", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffGreaterThan(String value) {
            addCriterion("PROJECTID_PROAFF >", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffGreaterThanOrEqualTo(String value) {
            addCriterion("PROJECTID_PROAFF >=", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffLessThan(String value) {
            addCriterion("PROJECTID_PROAFF <", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffLessThanOrEqualTo(String value) {
            addCriterion("PROJECTID_PROAFF <=", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffLike(String value) {
            addCriterion("PROJECTID_PROAFF like", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotLike(String value) {
            addCriterion("PROJECTID_PROAFF not like", value, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffIn(List<String> values) {
            addCriterion("PROJECTID_PROAFF in", values, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotIn(List<String> values) {
            addCriterion("PROJECTID_PROAFF not in", values, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffBetween(String value1, String value2) {
            addCriterion("PROJECTID_PROAFF between", value1, value2, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andProjectidProaffNotBetween(String value1, String value2) {
            addCriterion("PROJECTID_PROAFF not between", value1, value2, "projectidProaff");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarIsNull() {
            addCriterion("LAYERID_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarIsNotNull() {
            addCriterion("LAYERID_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarEqualTo(String value) {
            addCriterion("LAYERID_EARWAR =", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarNotEqualTo(String value) {
            addCriterion("LAYERID_EARWAR <>", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarGreaterThan(String value) {
            addCriterion("LAYERID_EARWAR >", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarGreaterThanOrEqualTo(String value) {
            addCriterion("LAYERID_EARWAR >=", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarLessThan(String value) {
            addCriterion("LAYERID_EARWAR <", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarLessThanOrEqualTo(String value) {
            addCriterion("LAYERID_EARWAR <=", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarLike(String value) {
            addCriterion("LAYERID_EARWAR like", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarNotLike(String value) {
            addCriterion("LAYERID_EARWAR not like", value, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarIn(List<String> values) {
            addCriterion("LAYERID_EARWAR in", values, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarNotIn(List<String> values) {
            addCriterion("LAYERID_EARWAR not in", values, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarBetween(String value1, String value2) {
            addCriterion("LAYERID_EARWAR between", value1, value2, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andLayeridEarwarNotBetween(String value1, String value2) {
            addCriterion("LAYERID_EARWAR not between", value1, value2, "layeridEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarIsNull() {
            addCriterion("ELEMENTREALNAME_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarIsNotNull() {
            addCriterion("ELEMENTREALNAME_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR =", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarNotEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR <>", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarGreaterThan(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR >", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarGreaterThanOrEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR >=", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarLessThan(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR <", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarLessThanOrEqualTo(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR <=", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarLike(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR like", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarNotLike(String value) {
            addCriterion("ELEMENTREALNAME_EARWAR not like", value, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarIn(List<String> values) {
            addCriterion("ELEMENTREALNAME_EARWAR in", values, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarNotIn(List<String> values) {
            addCriterion("ELEMENTREALNAME_EARWAR not in", values, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarBetween(String value1, String value2) {
            addCriterion("ELEMENTREALNAME_EARWAR between", value1, value2, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andElementrealnameEarwarNotBetween(String value1, String value2) {
            addCriterion("ELEMENTREALNAME_EARWAR not between", value1, value2, "elementrealnameEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarIsNull() {
            addCriterion("EXPERIENCE_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarIsNotNull() {
            addCriterion("EXPERIENCE_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarEqualTo(String value) {
            addCriterion("EXPERIENCE_EARWAR =", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarNotEqualTo(String value) {
            addCriterion("EXPERIENCE_EARWAR <>", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarGreaterThan(String value) {
            addCriterion("EXPERIENCE_EARWAR >", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarGreaterThanOrEqualTo(String value) {
            addCriterion("EXPERIENCE_EARWAR >=", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarLessThan(String value) {
            addCriterion("EXPERIENCE_EARWAR <", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarLessThanOrEqualTo(String value) {
            addCriterion("EXPERIENCE_EARWAR <=", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarLike(String value) {
            addCriterion("EXPERIENCE_EARWAR like", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarNotLike(String value) {
            addCriterion("EXPERIENCE_EARWAR not like", value, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarIn(List<String> values) {
            addCriterion("EXPERIENCE_EARWAR in", values, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarNotIn(List<String> values) {
            addCriterion("EXPERIENCE_EARWAR not in", values, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarBetween(String value1, String value2) {
            addCriterion("EXPERIENCE_EARWAR between", value1, value2, "experienceEarwar");
            return (Criteria) this;
        }

        public Criteria andExperienceEarwarNotBetween(String value1, String value2) {
            addCriterion("EXPERIENCE_EARWAR not between", value1, value2, "experienceEarwar");
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

        public Criteria andPropertyidProEqualTo(String value) {
            addCriterion("PROPERTYID_PRO =", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotEqualTo(String value) {
            addCriterion("PROPERTYID_PRO <>", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThan(String value) {
            addCriterion("PROPERTYID_PRO >", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProGreaterThanOrEqualTo(String value) {
            addCriterion("PROPERTYID_PRO >=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThan(String value) {
            addCriterion("PROPERTYID_PRO <", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLessThanOrEqualTo(String value) {
            addCriterion("PROPERTYID_PRO <=", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProLike(String value) {
            addCriterion("PROPERTYID_PRO like", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotLike(String value) {
            addCriterion("PROPERTYID_PRO not like", value, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProIn(List<String> values) {
            addCriterion("PROPERTYID_PRO in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotIn(List<String> values) {
            addCriterion("PROPERTYID_PRO not in", values, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProBetween(String value1, String value2) {
            addCriterion("PROPERTYID_PRO between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andPropertyidProNotBetween(String value1, String value2) {
            addCriterion("PROPERTYID_PRO not between", value1, value2, "propertyidPro");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarIsNull() {
            addCriterion("SETTING_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarIsNotNull() {
            addCriterion("SETTING_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarEqualTo(Integer value) {
            addCriterion("SETTING_EARWAR =", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarNotEqualTo(Integer value) {
            addCriterion("SETTING_EARWAR <>", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarGreaterThan(Integer value) {
            addCriterion("SETTING_EARWAR >", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarGreaterThanOrEqualTo(Integer value) {
            addCriterion("SETTING_EARWAR >=", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarLessThan(Integer value) {
            addCriterion("SETTING_EARWAR <", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarLessThanOrEqualTo(Integer value) {
            addCriterion("SETTING_EARWAR <=", value, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarIn(List<Integer> values) {
            addCriterion("SETTING_EARWAR in", values, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarNotIn(List<Integer> values) {
            addCriterion("SETTING_EARWAR not in", values, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarBetween(Integer value1, Integer value2) {
            addCriterion("SETTING_EARWAR between", value1, value2, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andSettingEarwarNotBetween(Integer value1, Integer value2) {
            addCriterion("SETTING_EARWAR not between", value1, value2, "settingEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarIsNull() {
            addCriterion("CRITICALLOW_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarIsNotNull() {
            addCriterion("CRITICALLOW_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarEqualTo(Integer value) {
            addCriterion("CRITICALLOW_EARWAR =", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarNotEqualTo(Integer value) {
            addCriterion("CRITICALLOW_EARWAR <>", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarGreaterThan(Integer value) {
            addCriterion("CRITICALLOW_EARWAR >", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarGreaterThanOrEqualTo(Integer value) {
            addCriterion("CRITICALLOW_EARWAR >=", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarLessThan(Integer value) {
            addCriterion("CRITICALLOW_EARWAR <", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarLessThanOrEqualTo(Integer value) {
            addCriterion("CRITICALLOW_EARWAR <=", value, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarIn(List<Integer> values) {
            addCriterion("CRITICALLOW_EARWAR in", values, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarNotIn(List<Integer> values) {
            addCriterion("CRITICALLOW_EARWAR not in", values, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarBetween(Integer value1, Integer value2) {
            addCriterion("CRITICALLOW_EARWAR between", value1, value2, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticallowEarwarNotBetween(Integer value1, Integer value2) {
            addCriterion("CRITICALLOW_EARWAR not between", value1, value2, "criticallowEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarIsNull() {
            addCriterion("CRITICALHIGH_EARWAR is null");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarIsNotNull() {
            addCriterion("CRITICALHIGH_EARWAR is not null");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarEqualTo(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR =", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarNotEqualTo(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR <>", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarGreaterThan(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR >", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarGreaterThanOrEqualTo(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR >=", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarLessThan(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR <", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarLessThanOrEqualTo(Integer value) {
            addCriterion("CRITICALHIGH_EARWAR <=", value, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarIn(List<Integer> values) {
            addCriterion("CRITICALHIGH_EARWAR in", values, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarNotIn(List<Integer> values) {
            addCriterion("CRITICALHIGH_EARWAR not in", values, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarBetween(Integer value1, Integer value2) {
            addCriterion("CRITICALHIGH_EARWAR between", value1, value2, "criticalhighEarwar");
            return (Criteria) this;
        }

        public Criteria andCriticalhighEarwarNotBetween(Integer value1, Integer value2) {
            addCriterion("CRITICALHIGH_EARWAR not between", value1, value2, "criticalhighEarwar");
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