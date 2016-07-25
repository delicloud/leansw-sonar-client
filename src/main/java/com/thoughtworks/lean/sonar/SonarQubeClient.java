package com.thoughtworks.lean.sonar;


import com.thoughtworks.lean.sonar.domain.CodeMetric;
import com.thoughtworks.lean.sonar.domain.SonarQubeProjectResponse;
import com.thoughtworks.lean.sonar.domain.TestReportDto;

import java.util.List;

public interface SonarQubeClient {

    CodeMetric getProjectMetrics(String projectName);

    List<SonarQubeProjectResponse> getSonarProjects();

    TestReportDto getTestReport(String projectName);

    List<TestReportDto> getTestReports(List<String> projectNames);

    TestReportDto getTestReportByBuild(String projectName, String buildNo);
}
