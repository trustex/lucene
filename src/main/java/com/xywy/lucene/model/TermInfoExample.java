package com.xywy.lucene.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TermInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TermInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTermContentIsNull() {
            addCriterion("term_content is null");
            return (Criteria) this;
        }

        public Criteria andTermContentIsNotNull() {
            addCriterion("term_content is not null");
            return (Criteria) this;
        }

        public Criteria andTermContentEqualTo(String value) {
            addCriterion("term_content =", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentNotEqualTo(String value) {
            addCriterion("term_content <>", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentGreaterThan(String value) {
            addCriterion("term_content >", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentGreaterThanOrEqualTo(String value) {
            addCriterion("term_content >=", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentLessThan(String value) {
            addCriterion("term_content <", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentLessThanOrEqualTo(String value) {
            addCriterion("term_content <=", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentLike(String value) {
            addCriterion("term_content like", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentNotLike(String value) {
            addCriterion("term_content not like", value, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentIn(List<String> values) {
            addCriterion("term_content in", values, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentNotIn(List<String> values) {
            addCriterion("term_content not in", values, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentBetween(String value1, String value2) {
            addCriterion("term_content between", value1, value2, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermContentNotBetween(String value1, String value2) {
            addCriterion("term_content not between", value1, value2, "termContent");
            return (Criteria) this;
        }

        public Criteria andTermTypeIsNull() {
            addCriterion("term_type is null");
            return (Criteria) this;
        }

        public Criteria andTermTypeIsNotNull() {
            addCriterion("term_type is not null");
            return (Criteria) this;
        }

        public Criteria andTermTypeEqualTo(String value) {
            addCriterion("term_type =", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotEqualTo(String value) {
            addCriterion("term_type <>", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeGreaterThan(String value) {
            addCriterion("term_type >", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeGreaterThanOrEqualTo(String value) {
            addCriterion("term_type >=", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeLessThan(String value) {
            addCriterion("term_type <", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeLessThanOrEqualTo(String value) {
            addCriterion("term_type <=", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeLike(String value) {
            addCriterion("term_type like", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotLike(String value) {
            addCriterion("term_type not like", value, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeIn(List<String> values) {
            addCriterion("term_type in", values, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotIn(List<String> values) {
            addCriterion("term_type not in", values, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeBetween(String value1, String value2) {
            addCriterion("term_type between", value1, value2, "termType");
            return (Criteria) this;
        }

        public Criteria andTermTypeNotBetween(String value1, String value2) {
            addCriterion("term_type not between", value1, value2, "termType");
            return (Criteria) this;
        }

        public Criteria andTermNatureIsNull() {
            addCriterion("term_nature is null");
            return (Criteria) this;
        }

        public Criteria andTermNatureIsNotNull() {
            addCriterion("term_nature is not null");
            return (Criteria) this;
        }

        public Criteria andTermNatureEqualTo(String value) {
            addCriterion("term_nature =", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureNotEqualTo(String value) {
            addCriterion("term_nature <>", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureGreaterThan(String value) {
            addCriterion("term_nature >", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureGreaterThanOrEqualTo(String value) {
            addCriterion("term_nature >=", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureLessThan(String value) {
            addCriterion("term_nature <", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureLessThanOrEqualTo(String value) {
            addCriterion("term_nature <=", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureLike(String value) {
            addCriterion("term_nature like", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureNotLike(String value) {
            addCriterion("term_nature not like", value, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureIn(List<String> values) {
            addCriterion("term_nature in", values, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureNotIn(List<String> values) {
            addCriterion("term_nature not in", values, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureBetween(String value1, String value2) {
            addCriterion("term_nature between", value1, value2, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermNatureNotBetween(String value1, String value2) {
            addCriterion("term_nature not between", value1, value2, "termNature");
            return (Criteria) this;
        }

        public Criteria andTermBoostIsNull() {
            addCriterion("term_boost is null");
            return (Criteria) this;
        }

        public Criteria andTermBoostIsNotNull() {
            addCriterion("term_boost is not null");
            return (Criteria) this;
        }

        public Criteria andTermBoostEqualTo(Long value) {
            addCriterion("term_boost =", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostNotEqualTo(Long value) {
            addCriterion("term_boost <>", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostGreaterThan(Long value) {
            addCriterion("term_boost >", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostGreaterThanOrEqualTo(Long value) {
            addCriterion("term_boost >=", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostLessThan(Long value) {
            addCriterion("term_boost <", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostLessThanOrEqualTo(Long value) {
            addCriterion("term_boost <=", value, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostIn(List<Long> values) {
            addCriterion("term_boost in", values, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostNotIn(List<Long> values) {
            addCriterion("term_boost not in", values, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostBetween(Long value1, Long value2) {
            addCriterion("term_boost between", value1, value2, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermBoostNotBetween(Long value1, Long value2) {
            addCriterion("term_boost not between", value1, value2, "termBoost");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyIsNull() {
            addCriterion("term_frequency is null");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyIsNotNull() {
            addCriterion("term_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyEqualTo(Integer value) {
            addCriterion("term_frequency =", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyNotEqualTo(Integer value) {
            addCriterion("term_frequency <>", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyGreaterThan(Integer value) {
            addCriterion("term_frequency >", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("term_frequency >=", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyLessThan(Integer value) {
            addCriterion("term_frequency <", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("term_frequency <=", value, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyIn(List<Integer> values) {
            addCriterion("term_frequency in", values, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyNotIn(List<Integer> values) {
            addCriterion("term_frequency not in", values, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("term_frequency between", value1, value2, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andTermFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("term_frequency not between", value1, value2, "termFrequency");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNull() {
            addCriterion("operate_date is null");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNotNull() {
            addCriterion("operate_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDateEqualTo(Date value) {
            addCriterion("operate_date =", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotEqualTo(Date value) {
            addCriterion("operate_date <>", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThan(Date value) {
            addCriterion("operate_date >", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("operate_date >=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThan(Date value) {
            addCriterion("operate_date <", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThanOrEqualTo(Date value) {
            addCriterion("operate_date <=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateIn(List<Date> values) {
            addCriterion("operate_date in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotIn(List<Date> values) {
            addCriterion("operate_date not in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateBetween(Date value1, Date value2) {
            addCriterion("operate_date between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotBetween(Date value1, Date value2) {
            addCriterion("operate_date not between", value1, value2, "operateDate");
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