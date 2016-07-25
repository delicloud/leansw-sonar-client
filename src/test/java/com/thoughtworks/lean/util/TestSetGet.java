package com.thoughtworks.lean.util;


import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yongliuli on 16/7/18.
 */
public class TestSetGet {
    private static TestSetGet testSetGet = new TestSetGet();

    public static TestSetGet get() {
        return testSetGet;
    }

    public <T> void testClass(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T repo = clazz.newInstance();
        testObject(repo);
    }

    public <T> void testObject(T repo) {
        Field[] fields = repo.getClass().getDeclaredFields();
        for (Field field : Arrays.asList(fields)) {
            Method setMethod = ReflectionUtils.findMethod(repo.getClass(), "set" + StringUtils.capitalize(field.getName()), field.getType());
            if (setMethod == null) {
                continue;
            }

            Object setObj = EnhancedRandom.random(field.getType());
            ReflectionUtils.invokeMethod(setMethod, repo, setObj);


            Method getMethod = ReflectionUtils.findMethod(repo.getClass(), "get" + StringUtils.capitalize(field.getName()));
            if (getMethod == null) {
                continue;
            }
            Object getObj = ReflectionUtils.invokeMethod(getMethod, repo);
            Assert.assertEquals("field set-get error [[" + repo.getClass().getName() + "]] <<" + field.getName() + ">> ", setObj, getObj);

        }
    }

}
