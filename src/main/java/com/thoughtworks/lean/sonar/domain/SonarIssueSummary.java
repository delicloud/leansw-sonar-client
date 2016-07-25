package com.thoughtworks.lean.sonar.domain;

public class SonarIssueSummary {
    private String severity;
    private Integer count;

    public SonarIssueSummary() {
    }

    public SonarIssueSummary(String severity, Integer count) {
        this.severity = severity;
        this.count = count;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
