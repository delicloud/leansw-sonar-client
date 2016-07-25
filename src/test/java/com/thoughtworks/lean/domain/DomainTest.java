package com.thoughtworks.lean.domain;

import com.thoughtworks.lean.sonar.domain.*;
import com.thoughtworks.lean.util.TestSetGet;
import org.junit.Test;

/**
 * Created by yongliuli on 7/25/16.
 */
public class DomainTest {

    @Test
    public void testCodeMetric() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(CodeMetric.class);
    }

    @Test
    public void testCodeMetricResponse() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(CodeMetricResponse.class);
    }

    @Test
    public void testMsr() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(Msr.class);
    }

    @Test
    public void testSonarIssue() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(SonarIssue.class);
    }

    @Test
    public void testSonarIssueSummary() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(SonarIssueSummary.class);
    }

    @Test
    public void testSonarQubeProjectResponse() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(SonarQubeProjectResponse.class);
    }

    @Test
    public void testTestFeatureDto() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(TestFeatureDto.class);
    }

    @Test
    public void testTestReportDto() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(TestReportDto.class);
    }


    @Test
    public void testTestScenarioDto() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(TestScenarioDto.class);
    }

    @Test
    public void testTestStepDto() throws InstantiationException, IllegalAccessException {
        TestSetGet.get().testClass(TestStepDto.class);
    }

}
