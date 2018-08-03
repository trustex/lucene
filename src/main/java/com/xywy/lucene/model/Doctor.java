package com.xywy.lucene.model;

import java.util.Date;

public class Doctor {
    private Integer id;

    private String name;

    private String pinyin;

    private Short sex;

    private Date birthday;

    private String docimage;

    private Short title;

    private Short department;

    private Short teach;

    private String mobilephone;

    private String email;

    private Short pub;

    private Double weight;

    private Integer uuidexpert;

    private String source;

    private Integer updatetime;

    private Integer scheduletimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDocimage() {
        return docimage;
    }

    public void setDocimage(String docimage) {
        this.docimage = docimage == null ? null : docimage.trim();
    }

    public Short getTitle() {
        return title;
    }

    public void setTitle(Short title) {
        this.title = title;
    }

    public Short getDepartment() {
        return department;
    }

    public void setDepartment(Short department) {
        this.department = department;
    }

    public Short getTeach() {
        return teach;
    }

    public void setTeach(Short teach) {
        this.teach = teach;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getPub() {
        return pub;
    }

    public void setPub(Short pub) {
        this.pub = pub;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getUuidexpert() {
        return uuidexpert;
    }

    public void setUuidexpert(Integer uuidexpert) {
        this.uuidexpert = uuidexpert;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getScheduletimes() {
        return scheduletimes;
    }

    public void setScheduletimes(Integer scheduletimes) {
        this.scheduletimes = scheduletimes;
    }
}