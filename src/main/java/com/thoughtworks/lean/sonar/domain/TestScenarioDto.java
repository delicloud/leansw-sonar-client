package com.thoughtworks.lean.sonar.domain;

import com.google.common.base.Objects;
import org.hamcrest.Matchers;

import java.util.List;

import static ch.lambdaj.collection.LambdaCollections.with;

public class TestScenarioDto {
    private int id;
    private int featureId;

    private String name;
    private ResultType resultType;
    private int duration;
    private List<TestStepDto> testSteps;

    public TestScenarioDto() {
    }

    public int getId() {
        return id;
    }

    public TestScenarioDto setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestScenarioDto setName(String name) {
        this.name = name;
        return this;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public TestScenarioDto setResultType(ResultType resultType) {
        this.resultType = resultType;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public TestScenarioDto setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public List<TestStepDto> getTestSteps() {
        return testSteps;
    }

    public TestScenarioDto setTestSteps(List<TestStepDto> testSteps) {
        this.testSteps = testSteps;
        return this;
    }

    public List<TestStepDto> getStepsByResultType(ResultType type) {
        return with(this.getTestSteps()).clone()
                .retain(Matchers.hasProperty("resultType", Matchers.equalTo(type)));
    }

    public int getFeatureId() {
        return featureId;
    }

    public TestScenarioDto setFeatureId(int featureId) {
        this.featureId = featureId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestScenarioDto that = (TestScenarioDto) o;
        return id == that.id &&
                featureId == that.featureId &&
                duration == that.duration &&
                Objects.equal(name, that.name) &&
                resultType == that.resultType;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, featureId, name, resultType, duration);
    }
}
