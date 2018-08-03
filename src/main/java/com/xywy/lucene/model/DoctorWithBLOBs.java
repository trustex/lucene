package com.xywy.lucene.model;

public class DoctorWithBLOBs extends Doctor {
    private String goodat;

    private String info;

    private String url;

    public String getGoodat() {
        return goodat;
    }

    public void setGoodat(String goodat) {
        this.goodat = goodat == null ? null : goodat.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}