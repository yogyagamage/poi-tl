package com.deepoove.poi.exception;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ReflectionExceptionmethod_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testEntryPointToThirdPartyMethod() {
        // Create real parameters for the constructor
        String name = "testMethod";
        Class<?> clazz = String.class;
        Exception cause = new RuntimeException("Test cause");
        
        // Instantiate ReflectionException which will invoke ClassUtils.getShortClassName
        new ReflectionException(name, clazz, cause);
    }
}
