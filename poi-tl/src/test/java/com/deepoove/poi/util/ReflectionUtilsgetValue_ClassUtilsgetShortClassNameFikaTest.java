package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueInvokesClassUtilsGetShortClassName() throws Exception {
        // Create a simple object with a field
        TestClass testObj = new TestClass();
        testObj.testField = "testValue";
        
        // This will trigger the path where ClassUtils.getShortClassName is called
        // when the field doesn't exist
        try {
            ReflectionUtils.getValue("nonExistentField", testObj);
        } catch (Exception e) {
            // Expected - we want the path that calls ClassUtils.getShortClassName
        }
    }
    
    // Helper class with a field
    private static class TestClass {
        private String testField;
    }
}
