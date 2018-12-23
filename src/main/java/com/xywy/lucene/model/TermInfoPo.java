package com.xywy.lucene.model;

import java.util.List;

public class TermInfoPo {
    private int key;
    private String value;
    private List<TermInfo> termInfoList;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TermInfo> getTermInfoList() {
        return termInfoList;
    }

    public void setTermInfoList(List<TermInfo> termInfoList) {
        this.termInfoList = termInfoList;
    }
}
