package com.thoughtworks.lean.sonar.domain;

public class Msr {

    private String key;
    private double val;
    private String frmt_val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public String getFrmt_val() {
        return frmt_val;
    }

    public void setFrmt_val(String frmt_val) {
        this.frmt_val = frmt_val;
    }

}
