package com.deepoove.poi.exception;

import org.junit.jupiter.api.Test;

public class ReflectionExceptionmethod_ClassUtilsgetShortClassNameFikaTest {

    @Test
    public void test() {
        new ReflectionException("name", String.class, new RuntimeException("cause"));
    }
}
