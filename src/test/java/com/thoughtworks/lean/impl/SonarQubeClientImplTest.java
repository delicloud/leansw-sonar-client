package com.thoughtworks.lean.impl;

import com.google.common.collect.Lists;
import com.thoughtworks.lean.sonar.SonarQubeClient;
import com.thoughtworks.lean.sonar.domain.CodeMetric;
import com.thoughtworks.lean.sonar.domain.SonarQubeProjectResponse;
import com.thoughtworks.lean.sonar.domain.TestReportDto;
import com.thoughtworks.lean.sonar.impl.SonarQubeClientImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.util.ReflectionUtils.findField;


@RunWith(MockitoJUnitRunner.class)
public class SonarQubeClientImplTest {

    public static final String SONAR_HOST = "http://sonar-server:9000";
    private SonarQubeClient sonarQubeClient;

    @Before
    public void setUp() throws Exception {
        sonarQubeClient = new SonarQubeClientImpl(SONAR_HOST);
        RestTemplate restTemplate = getField("restTemplate");
        String isMockServer = System.getProperty("mock.server", "false");
        if (isMockServer.equals("true")) {
            MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
            //Sample
            mockServer.expect(requestTo("/hotels/42")).andExpect(method(HttpMethod.GET))
                    .andRespond(withSuccess("{ \"id\" : \"42\", \"name\" : \"Holiday Inn\"}", MediaType.APPLICATION_JSON));
        }

    }

    private void setField(String fieldName, Object o) {
        Field field = findField(SonarQubeClient.class, fieldName);
        field.setAccessible(true);
        ReflectionUtils.setField(field, sonarQubeClient, o);
    }

    private <T> T getField(String fieldName) {
        Field field = findField(SonarQubeClientImpl.class, fieldName);
        field.setAccessible(true);
        return (T) ReflectionUtils.getField(field, sonarQubeClient);
    }

    @Test
    @Ignore
    public void should_GetProjectMetrics() throws Exception {
        //when
        final CodeMetric metrics = sonarQubeClient.getProjectMetrics("cd-metrics-ui");
        //then
        assertThat(metrics, is(notNullValue()));
    }


    @Test
    @Ignore
    public void should_get_projects() throws Exception {
        //when
        final List<SonarQubeProjectResponse> projects = sonarQubeClient.getSonarProjects();
        //then
        assertThat(projects.size(), is(greaterThan(1)));
    }

    @Test
    public void should_get_project_test_report() {
        final TestReportDto report = sonarQubeClient.getTestReport("code-metrics");
        assertNotNull(report);
    }

    @Ignore
    @Test
    public void should_get_project_test_report_by_build() {
        final TestReportDto report = sonarQubeClient.getTestReportByBuild("junit-sample-for-test-pyramid", "11");
        assertNotNull(report);
    }

    @Ignore
    @Test
    public void should_get_team_test_reports() {

        final List<TestReportDto> reportDtos = sonarQubeClient.getTestReports(Arrays.asList("cucumber-sample-for-test-pyramid", "123456"));
        assertNotNull(reportDtos);
        assertFalse(reportDtos.stream().allMatch(testReportDto -> testReportDto == null));
    }

    @Ignore
    @Test
    public void should_get_projects_test_reports() {
        final List<TestReportDto> reportDtos = sonarQubeClient.getTestReports(Lists.newArrayList("identity-server", "cd-cdmtrics"));
        assertEquals(2, reportDtos.size());
    }

}
