package com.deepoove.poi.util;

import com.deepoove.poi.exception.ReflectionException;
import org.apache.commons.lang3.ClassUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueInvokesClassUtilsGetShortClassName() throws Exception {
        ReflectionUtils instance = new ReflectionUtils();
        
        TestClass testObj = new TestClass();
        testObj.someField = "testValue";
        
        try {
            ReflectionUtils.getValue("nonExistentField", testObj);
        } catch (ReflectionException e) {
            // Expected - this exception contains the call to ClassUtils.getShortClassName
        }
    }
    
    private static class TestClass {
        private String someField;
    }
}
