package com.thoughtworks.lean.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.github.fge.jackson.JacksonUtils;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.google.common.base.Charsets.UTF_8;

public class JSONUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtil.class.getSimpleName());

  public static <T> T fileToJsonJSON(String string) throws IOException {
    return parseJSON(Resources.toString(JSONUtil.class.getResource(string), UTF_8));
  }

  public static <T> T parseJSON(String string) throws IOException {
    return JacksonUtils.newMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(string, new TypeReference<T>() {
    });
  }

  public static <T> T fileToJsonJSON(String string, Class<T> tTypeReference) throws IOException {
    return parseJSON(Resources.toString(JSONUtil.class.getResource(string), UTF_8), tTypeReference);
  }


  public static <T extends Object> T parseJSON(String string, Class<T> tClass) throws IOException {
    return JacksonUtils.newMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(string, tClass);
  }

  public static <T> T fileToJsonJSON(String string, TypeReference<T> tTypeReference) throws IOException {
    return parseJSON(Resources.toString(JSONUtil.class.getResource(string), UTF_8), tTypeReference);
  }


  public static <T extends Object> T parseJSON(String string, TypeReference<T> tTypeReference) throws IOException {
    return JacksonUtils.newMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(string, tTypeReference);
  }


}
