package com.thoughtworks.lean.sonar.domain;

import com.google.common.base.Objects;

public class TestStepDto {

    private int id;
    private int scenarioId;
    private String name;
    private ResultType resultType;
    private int duration;

    public TestStepDto() {
    }

    public int getId() {
        return id;
    }

    public TestStepDto setId(int id) {
        this.id = id;
        return this;
    }

    public int getScenarioId() {
        return scenarioId;
    }

    public TestStepDto setScenarioId(int scenarioId) {
        this.scenarioId = scenarioId;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestStepDto setName(String name) {
        this.name = name;
        return this;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public TestStepDto setResultType(ResultType resultType) {
        this.resultType = resultType;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public TestStepDto setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestStepDto that = (TestStepDto) o;
        return id == that.id &&
                duration == that.duration &&
                Objects.equal(name, that.name) &&
                resultType == that.resultType;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, resultType, duration);
    }
}
