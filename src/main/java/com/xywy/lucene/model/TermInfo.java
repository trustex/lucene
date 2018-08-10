package com.xywy.lucene.model;

import java.util.Date;

public class TermInfo {
    private Integer id;

    private String termContent;

    private String termType;

    private String termNature;

    private Long termBoost;

    private Integer termFrequency;

    private Date operateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermContent() {
        return termContent;
    }

    public void setTermContent(String termContent) {
        this.termContent = termContent == null ? null : termContent.trim();
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType == null ? null : termType.trim();
    }

    public String getTermNature() {
        return termNature;
    }

    public void setTermNature(String termNature) {
        this.termNature = termNature == null ? null : termNature.trim();
    }

    public Long getTermBoost() {
        return termBoost;
    }

    public void setTermBoost(Long termBoost) {
        this.termBoost = termBoost;
    }

    public Integer getTermFrequency() {
        return termFrequency;
    }

    public void setTermFrequency(Integer termFrequency) {
        this.termFrequency = termFrequency;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    @Override
    public String toString() {
        return "TermInfo{" +
                "id=" + id +
                ", termContent='" + termContent + '\'' +
                ", termType='" + termType + '\'' +
                ", termNature='" + termNature + '\'' +
                ", termBoost=" + termBoost +
                ", termFrequency=" + termFrequency +
                ", operateDate=" + operateDate +
                '}';
    }
}