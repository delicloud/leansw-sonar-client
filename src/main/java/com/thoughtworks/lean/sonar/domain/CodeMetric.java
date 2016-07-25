package com.thoughtworks.lean.sonar.domain;

import com.google.common.collect.Maps;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Map;

public class CodeMetric {
    @Id
    private String id;
    private String key;
    private String name;
    private String scope;
    private String qualifier;
    private Date date;
    private Date creationDate;
    private String lname;
    private String version;
    private String description;
    private Map<String, Msr> msr = Maps.newHashMap();
    private Date pullDate;
    private String sonarUrl;

    public CodeMetric() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }


    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Msr> getMsr() {
        return msr;
    }

    public void setMsr(Map<String, Msr> msr) {
        this.msr = msr;
    }

    public Date getPullDate() {
        return pullDate;
    }

    public void setPullDate(Date pullDate) {
        this.pullDate = pullDate;
    }

    public String getSonarUrl() {
        return sonarUrl;
    }

    public void setSonarUrl(String sonarUrl) {
        this.sonarUrl = sonarUrl;
    }

}
