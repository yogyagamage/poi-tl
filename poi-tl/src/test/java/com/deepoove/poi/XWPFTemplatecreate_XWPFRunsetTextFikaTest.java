package com.deepoove.poi;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class XWPFTemplatecreate_XWPFRunsetTextFikaTest {
    @Test
    public void testCreate() {
        try {
            Method[][] methodArrays = {XWPFTemplate.class.getMethods(), XWPFTemplate.class.getDeclaredMethods()};
            for (Method[] methods : methodArrays) {
                for (Method method : methods) {
                    if (!"create".equals(method.getName())) {
                        continue;
                    }
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 2) {
                        continue;
                    }
                    String first = parameterTypes[0].getSimpleName();
                    String second = parameterTypes[1].getSimpleName();
                    if (!first.contains("DocumentRenderData") && !second.contains("Style")) {
                        continue;
                    }
                    Object[] arguments = new Object[parameterTypes.length];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        try {
                            arguments[i] = parameterTypes[i].getDeclaredConstructor().newInstance();
                        } catch (Throwable ignored) {
                            arguments[i] = null;
                        }
                    }
                    try {
                        method.setAccessible(true);
                        method.invoke(null, arguments);
                    } catch (Throwable ignored) {
                    }
                }
            }
        } catch (Throwable ignored) {
        }
    }
}
