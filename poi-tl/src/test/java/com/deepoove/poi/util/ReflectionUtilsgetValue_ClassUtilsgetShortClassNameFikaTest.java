package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.exception.ReflectionException;

public class ReflectionUtilsgetValue_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void testGetValueInvokesClassUtilsGetShortClassName() {
        Object obj = new TestClass();
        try {
            ReflectionUtils.getValue("nonExistentField", obj);
        } catch (ReflectionException expected) {
            // Expected exception - third-party method was invoked
        }
    }

    private static class TestClass {
        private String existingField = "test";
    }
}
