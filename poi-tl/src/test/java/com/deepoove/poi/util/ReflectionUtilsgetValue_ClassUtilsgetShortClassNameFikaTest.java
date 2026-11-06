package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueInvokesClassUtilsGetShortClassName() throws Exception {
        // Create a simple object with a field
        class TestObject {
            @SuppressWarnings("unused")
            private String testField = "testValue";
        }
        
        TestObject obj = new TestObject();
        
        // This will successfully get the field value
        ReflectionUtils.getValue("testField", obj);
        
        // Now create a scenario where the field doesn't exist
        // This will trigger the path that calls ClassUtils.getShortClassName
        try {
            ReflectionUtils.getValue("nonExistentField", obj);
        } catch (Exception e) {
            // Expected - the exception is thrown after ClassUtils.getShortClassName is called
        }
    }
}
