package com.thoughtworks.lean.sonar.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CodeMetricResponse {

    private int id;
    private String key;
    private String name;
    private String scope;
    private String qualifier;
    private Date date;
    private Date creationDate;
    private String lname;
    private String version;
    private String description;
    private List<Msr> msr = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return creationDate;
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

    public List<Msr> getMsr() {
        return msr;
    }

    public void setMsr(List<Msr> msr) {
        this.msr = msr;
    }

}
