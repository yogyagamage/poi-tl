package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    private static class TestClass {
        private String testField = "testValue";
    }

    @Test
    public void testGetValue() throws Exception {
        TestClass testObj = new TestClass();
        
        // This will invoke ClassUtils.getShortClassName when the field is not found
        try {
            ReflectionUtils.getValue("nonExistentField", testObj);
        } catch (Exception e) {
            // Expected - we want the exception path that calls ClassUtils.getShortClassName
        }
    }
}
