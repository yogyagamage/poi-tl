package com.deepoove.poi.exception;

import org.junit.jupiter.api.Test;

public class ReflectionExceptionmethod_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testEntryPoint() {
        String message = "testMethod";
        Class<?> clazz = String.class;
        Exception cause = new RuntimeException("Test cause");
        
        new ReflectionException(message, clazz, cause);
    }
}
