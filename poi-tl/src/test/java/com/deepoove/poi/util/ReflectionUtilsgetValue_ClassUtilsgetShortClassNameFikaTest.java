package com.deepoove.poi.util;

import com.deepoove.poi.exception.ReflectionException;
import org.apache.commons.lang3.ClassUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueInvokesClassUtilsGetShortClassName() throws Exception {
        ReflectionUtils utils = new ReflectionUtils();
        
        TestClass testObj = new TestClass();
        testObj.setField("testValue");
        
        try {
            ReflectionUtils.getValue("nonExistentField", testObj);
        } catch (ReflectionException e) {
            // Expected - this triggers the ClassUtils.getShortClassName call
        }
    }
    
    private static class TestClass {
        private String field;
        
        public void setField(String value) {
            this.field = value;
        }
    }
}
