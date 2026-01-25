package com.deepoove.poi.exception;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.ClassUtils;

public class ReflectionExceptionmethod_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testEntryPoint() {
        String name = "testMethod";
        Class<?> clazz = String.class;
        Exception e = new RuntimeException("Test exception");
        
        ReflectionException exception = new ReflectionException(name, clazz, e);
    }
}
