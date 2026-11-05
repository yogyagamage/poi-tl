package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueTriggersClassUtilsGetShortClassName() throws Exception {
        // Create a test object with a field that doesn't exist
        TestObject obj = new TestObject();
        
        // This will trigger the path: getValue -> findField returns null -> 
        // ReflectionException constructor -> ClassUtils.getShortClassName
        try {
            ReflectionUtils.getValue("nonExistentField", obj);
        } catch (Exception e) {
            // Exception expected - we don't need to assert anything
        }
    }
    
    // Simple test class with a field
    private static class TestObject {
        private String existingField = "test";
    }
}
