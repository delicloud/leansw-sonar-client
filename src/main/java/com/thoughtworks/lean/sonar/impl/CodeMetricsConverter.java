package com.thoughtworks.lean.sonar.impl;



import com.thoughtworks.lean.sonar.domain.CodeMetric;
import com.thoughtworks.lean.sonar.domain.CodeMetricResponse;
import com.thoughtworks.lean.sonar.domain.Msr;
import org.joda.time.LocalDate;
import org.springframework.beans.BeanUtils;

import java.util.Map;

import static com.google.common.collect.FluentIterable.from;

/**
 * Created by yongliuli on 16/7/18.
 */
public class CodeMetricsConverter {
  public CodeMetric mapToCodeMetric(CodeMetricResponse[] metrics, String host) {
    //
    if (metrics == null || metrics.length == 0) {
      return null;
    }
    final CodeMetricResponse metric = metrics[0];
    final CodeMetric codeMetric = new CodeMetric();
    BeanUtils.copyProperties(metric, codeMetric);
    //
    codeMetric.setMsr(mapMsr(metric));
    codeMetric.setPullDate(LocalDate.now().toDate());
    codeMetric.setSonarUrl(host);
    return codeMetric;
  }

  private Map<String, Msr> mapMsr(CodeMetricResponse metric) {
    return from(metric.getMsr()).uniqueIndex(Msr::getKey);
  }

}
