package com.xywy.lucene.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DoctorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DoctorExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("pinyin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("pinyin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Short value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Short value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Short value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Short value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Short value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Short value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Short> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Short> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Short value1, Short value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Short value1, Short value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andDocimageIsNull() {
            addCriterion("docimage is null");
            return (Criteria) this;
        }

        public Criteria andDocimageIsNotNull() {
            addCriterion("docimage is not null");
            return (Criteria) this;
        }

        public Criteria andDocimageEqualTo(String value) {
            addCriterion("docimage =", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageNotEqualTo(String value) {
            addCriterion("docimage <>", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageGreaterThan(String value) {
            addCriterion("docimage >", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageGreaterThanOrEqualTo(String value) {
            addCriterion("docimage >=", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageLessThan(String value) {
            addCriterion("docimage <", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageLessThanOrEqualTo(String value) {
            addCriterion("docimage <=", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageLike(String value) {
            addCriterion("docimage like", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageNotLike(String value) {
            addCriterion("docimage not like", value, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageIn(List<String> values) {
            addCriterion("docimage in", values, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageNotIn(List<String> values) {
            addCriterion("docimage not in", values, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageBetween(String value1, String value2) {
            addCriterion("docimage between", value1, value2, "docimage");
            return (Criteria) this;
        }

        public Criteria andDocimageNotBetween(String value1, String value2) {
            addCriterion("docimage not between", value1, value2, "docimage");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(Short value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(Short value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(Short value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(Short value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(Short value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(Short value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<Short> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<Short> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(Short value1, Short value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(Short value1, Short value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(Short value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(Short value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(Short value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(Short value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(Short value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(Short value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<Short> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<Short> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(Short value1, Short value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(Short value1, Short value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andTeachIsNull() {
            addCriterion("teach is null");
            return (Criteria) this;
        }

        public Criteria andTeachIsNotNull() {
            addCriterion("teach is not null");
            return (Criteria) this;
        }

        public Criteria andTeachEqualTo(Short value) {
            addCriterion("teach =", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachNotEqualTo(Short value) {
            addCriterion("teach <>", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachGreaterThan(Short value) {
            addCriterion("teach >", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachGreaterThanOrEqualTo(Short value) {
            addCriterion("teach >=", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachLessThan(Short value) {
            addCriterion("teach <", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachLessThanOrEqualTo(Short value) {
            addCriterion("teach <=", value, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachIn(List<Short> values) {
            addCriterion("teach in", values, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachNotIn(List<Short> values) {
            addCriterion("teach not in", values, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachBetween(Short value1, Short value2) {
            addCriterion("teach between", value1, value2, "teach");
            return (Criteria) this;
        }

        public Criteria andTeachNotBetween(Short value1, Short value2) {
            addCriterion("teach not between", value1, value2, "teach");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("mobilephone is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("mobilephone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(String value) {
            addCriterion("mobilephone =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(String value) {
            addCriterion("mobilephone <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(String value) {
            addCriterion("mobilephone >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobilephone >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(String value) {
            addCriterion("mobilephone <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("mobilephone <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLike(String value) {
            addCriterion("mobilephone like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotLike(String value) {
            addCriterion("mobilephone not like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<String> values) {
            addCriterion("mobilephone in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<String> values) {
            addCriterion("mobilephone not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(String value1, String value2) {
            addCriterion("mobilephone between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(String value1, String value2) {
            addCriterion("mobilephone not between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPubIsNull() {
            addCriterion("pub is null");
            return (Criteria) this;
        }

        public Criteria andPubIsNotNull() {
            addCriterion("pub is not null");
            return (Criteria) this;
        }

        public Criteria andPubEqualTo(Short value) {
            addCriterion("pub =", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubNotEqualTo(Short value) {
            addCriterion("pub <>", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubGreaterThan(Short value) {
            addCriterion("pub >", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubGreaterThanOrEqualTo(Short value) {
            addCriterion("pub >=", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubLessThan(Short value) {
            addCriterion("pub <", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubLessThanOrEqualTo(Short value) {
            addCriterion("pub <=", value, "pub");
            return (Criteria) this;
        }

        public Criteria andPubIn(List<Short> values) {
            addCriterion("pub in", values, "pub");
            return (Criteria) this;
        }

        public Criteria andPubNotIn(List<Short> values) {
            addCriterion("pub not in", values, "pub");
            return (Criteria) this;
        }

        public Criteria andPubBetween(Short value1, Short value2) {
            addCriterion("pub between", value1, value2, "pub");
            return (Criteria) this;
        }

        public Criteria andPubNotBetween(Short value1, Short value2) {
            addCriterion("pub not between", value1, value2, "pub");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andUuidexpertIsNull() {
            addCriterion("uuidExpert is null");
            return (Criteria) this;
        }

        public Criteria andUuidexpertIsNotNull() {
            addCriterion("uuidExpert is not null");
            return (Criteria) this;
        }

        public Criteria andUuidexpertEqualTo(Integer value) {
            addCriterion("uuidExpert =", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertNotEqualTo(Integer value) {
            addCriterion("uuidExpert <>", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertGreaterThan(Integer value) {
            addCriterion("uuidExpert >", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertGreaterThanOrEqualTo(Integer value) {
            addCriterion("uuidExpert >=", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertLessThan(Integer value) {
            addCriterion("uuidExpert <", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertLessThanOrEqualTo(Integer value) {
            addCriterion("uuidExpert <=", value, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertIn(List<Integer> values) {
            addCriterion("uuidExpert in", values, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertNotIn(List<Integer> values) {
            addCriterion("uuidExpert not in", values, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertBetween(Integer value1, Integer value2) {
            addCriterion("uuidExpert between", value1, value2, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andUuidexpertNotBetween(Integer value1, Integer value2) {
            addCriterion("uuidExpert not between", value1, value2, "uuidexpert");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Integer value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Integer value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Integer value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Integer value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Integer> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Integer> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Integer value1, Integer value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andScheduletimesIsNull() {
            addCriterion("scheduletimes is null");
            return (Criteria) this;
        }

        public Criteria andScheduletimesIsNotNull() {
            addCriterion("scheduletimes is not null");
            return (Criteria) this;
        }

        public Criteria andScheduletimesEqualTo(Integer value) {
            addCriterion("scheduletimes =", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesNotEqualTo(Integer value) {
            addCriterion("scheduletimes <>", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesGreaterThan(Integer value) {
            addCriterion("scheduletimes >", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("scheduletimes >=", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesLessThan(Integer value) {
            addCriterion("scheduletimes <", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesLessThanOrEqualTo(Integer value) {
            addCriterion("scheduletimes <=", value, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesIn(List<Integer> values) {
            addCriterion("scheduletimes in", values, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesNotIn(List<Integer> values) {
            addCriterion("scheduletimes not in", values, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesBetween(Integer value1, Integer value2) {
            addCriterion("scheduletimes between", value1, value2, "scheduletimes");
            return (Criteria) this;
        }

        public Criteria andScheduletimesNotBetween(Integer value1, Integer value2) {
            addCriterion("scheduletimes not between", value1, value2, "scheduletimes");
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