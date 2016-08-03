package com.thoughtworks.lean.sonar.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.thoughtworks.lean.sonar.SonarQubeClient;
import com.thoughtworks.lean.sonar.domain.CodeMetric;
import com.thoughtworks.lean.sonar.domain.CodeMetricResponse;
import com.thoughtworks.lean.sonar.domain.SonarQubeProjectResponse;
import com.thoughtworks.lean.sonar.domain.TestReportDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class SonarQubeClientImpl implements SonarQubeClient {


    private static final Logger LOGGER = LoggerFactory.getLogger(SonarQubeClientImpl.class);

    public static final String METRICS_REQUEST_URL = "%s/api/resources?format=json&resource=%s&metrics=%s";
    public static final String RESOURCES_REQUEST_URL = "%s/api/resources";
    public static final String LATEST_TESTREPORT_REQUEST_URL = "%s/api/lean/testreport/latest?project=%s";
    public static final String TESTREPORT_REQUEST_URL = "%s/api/lean/testreport?project=%s&build=%s";

    private static final String[] METRICS_KEYS =
            new String[]{"ncloc", "files", "functions", "sqale_index", "violations",
                    "blocker_violations", "critical_violations", "major_violations",
                    "minor_violations", "info_violations", "coverage", "line_coverage",
                    "branch_coverage", "tests", "skipped_tests", "test_errors", "test_failures",
                    "test_success_density", "test_execution_time", "lean_testpyramid_unittests",
                    "lean_testpyramid_functionaltests", "lean_testpyramid_integrationtests"};

    private String host;

    private RestTemplate restTemplate;


    private CodeMetricsConverter codeMetricsConverter = new CodeMetricsConverter();

    public SonarQubeClientImpl(String host) {
        this.host = host;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<TestReportDto> getTestReports(List<String> projectNames) {
        return projectNames.stream()
                .map(this::getTestReportDto).filter(testReportDto -> testReportDto != null)
                .collect(Collectors.toList());
    }


    @Override
    public CodeMetric getProjectMetrics(String projectName) {
        final String url = String.format(METRICS_REQUEST_URL, host, projectName, Joiner.on(",").join(METRICS_KEYS));
        final CodeMetricResponse[] metricsResponse = restTemplate.getForObject(url, CodeMetricResponse[].class);
        return codeMetricsConverter.mapToCodeMetric(metricsResponse, host);
    }

    @Override
    public List<SonarQubeProjectResponse> getSonarProjects() {
        final String url = String.format(RESOURCES_REQUEST_URL, host);
        return Lists.newArrayList(restTemplate.getForObject(url, SonarQubeProjectResponse[].class));
    }

    @Override
    public TestReportDto getTestReport(String projectName) {
        final String url = String.format(LATEST_TESTREPORT_REQUEST_URL, host, projectName);
        return restTemplate.getForObject(url, TestReportDto.class);
    }

    @Override
    public TestReportDto getTestReportByBuild(String projectName, String buildNo) {
        final String url = String.format(TESTREPORT_REQUEST_URL, host, projectName, buildNo);
        return restTemplate.getForObject(url, TestReportDto.class);
    }

    private TestReportDto getTestReportDto(String pipelineName) {
        try {
            return getTestReport(pipelineName);
        } catch (RestClientException e) {
            LOGGER.warn("pipeline {} aggregated test report dosenot exist!", pipelineName);
            return null;
        }
    }

}
