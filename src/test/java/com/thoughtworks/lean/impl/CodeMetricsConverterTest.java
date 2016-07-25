package com.thoughtworks.lean.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.thoughtworks.lean.sonar.domain.CodeMetric;
import com.thoughtworks.lean.sonar.domain.CodeMetricResponse;
import com.thoughtworks.lean.sonar.impl.CodeMetricsConverter;
import com.thoughtworks.lean.util.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by yongliuli on 16/7/18.
 */
public class CodeMetricsConverterTest {
  CodeMetricsConverter codeMetricsConverter = new CodeMetricsConverter();

  @Before
  public void setup() {

  }

  @Test
  public void should_return_null() {
    assertNull(codeMetricsConverter.mapToCodeMetric(null, null));
    assertNull(codeMetricsConverter.mapToCodeMetric(new CodeMetricResponse[]{}, null));
  }

  @Test
  public void should_have_name() throws IOException {
    CodeMetricResponse[] codeMetricResponses = JSONUtil.fileToJsonJSON("/cd_metrics_test.json", new TypeReference<CodeMetricResponse[]>() {
    });
    CodeMetric codeMetric = codeMetricsConverter.mapToCodeMetric(codeMetricResponses, "sonar-host");
    assertEquals(codeMetric.getName(), "cd-metrics-ui");
    assertEquals(codeMetric.getSonarUrl(), "sonar-host");
    assertNotNull(codeMetric.getPullDate());
    assertNotNull(codeMetric.getMsr().get("ncloc"));

  }
}
