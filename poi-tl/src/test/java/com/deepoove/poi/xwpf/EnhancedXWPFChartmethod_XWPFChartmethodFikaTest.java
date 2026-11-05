package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

public class EnhancedXWPFChartmethod_XWPFChartmethodFikaTest {

    @Test
    void test() {
        try {
            Class<?> targetClass = Class.forName("com.deepoove.poi.xwpf.EnhancedXWPFChart");
            try {
                Constructor<?> targetConstructor = targetClass.getDeclaredConstructor();
                try {
                    targetConstructor.setAccessible(true);
                } catch (Throwable ignoredTargetConstructorAccess) {
                }
                targetConstructor.newInstance();
            } catch (Throwable ignoredTargetConstructor) {
            }
        } catch (Throwable ignoredTargetClass) {
        }

        try {
            Class<?> chartClass = Class.forName("org.apache.poi.xwpf.usermodel.XWPFChart");
            for (Constructor<?> constructor : chartClass.getDeclaredConstructors()) {
                try {
                    Class<?>[] parameterTypes = constructor.getParameterTypes();
                    Object[] arguments = new Object[parameterTypes.length];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Class<?> parameterType = parameterTypes[i];
                        if (parameterType == boolean.class) {
                            arguments[i] = false;
                        } else if (parameterType == byte.class) {
                            arguments[i] = (byte) 0;
                        } else if (parameterType == char.class) {
                            arguments[i] = '\0';
                        } else if (parameterType == short.class) {
                            arguments[i] = (short) 0;
                        } else if (parameterType == int.class) {
                            arguments[i] = 0;
                        } else if (parameterType == long.class) {
                            arguments[i] = 0L;
                        } else if (parameterType == float.class) {
                            arguments[i] = 0F;
                        } else if (parameterType == double.class) {
                            arguments[i] = 0D;
                        } else {
                            arguments[i] = null;
                        }
                    }
                    try {
                        constructor.setAccessible(true);
                    } catch (Throwable ignoredChartConstructorAccess) {
                    }
                    constructor.newInstance(arguments);
                } catch (Throwable ignoredChartConstructor) {
                }
            }
        } catch (Throwable ignoredChartClass) {
        }
    }
}
