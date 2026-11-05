package com.deepoove.poi.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleTableRow_CTTrPrsizeOfTblHeaderArrayFikaTest {

    @Test
    public void testStyleTableRow() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        XWPFTableRow row = table.getRow(0);

        Class<?> styleUtilsClass = Class.forName("com.deepoove.poi.util.StyleUtils");
        Method styleTableRow = findStyleTableRowMethod(styleUtilsClass);
        if (styleTableRow == null) {
            throw new IllegalStateException("styleTableRow method not found");
        }

        Class<?> rowStyleClass = styleTableRow.getParameterTypes()[1];
        Object rowStyle = createRowStyle(rowStyleClass);

        styleTableRow.setAccessible(true);
        if (Modifier.isStatic(styleTableRow.getModifiers())) {
            styleTableRow.invoke(null, row, rowStyle);
        } else {
            Constructor<?> constructor = styleUtilsClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            styleTableRow.invoke(constructor.newInstance(), row, rowStyle);
        }
    }

    private static Method findStyleTableRowMethod(Class<?> clazz) {
        Method fallback = null;
        Class<?> current = clazz;
        while (current != null) {
            for (Method method : current.getDeclaredMethods()) {
                if ("styleTableRow".equals(method.getName()) && method.getParameterCount() == 2) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0].isAssignableFrom(XWPFTableRow.class)) {
                        if (parameterTypes[1].getName().contains("RowStyle")) {
                            return method;
                        }
                        if (fallback == null) {
                            fallback = method;
                        }
                    }
                }
            }
            current = current.getSuperclass();
        }
        return fallback;
    }

    private static Object createRowStyle(Class<?> clazz) throws Exception {
        Object rowStyle = null;
        boolean repeated = false;

        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            rowStyle = constructor.newInstance();
            repeated = trySetRepeated(rowStyle, clazz);
        } catch (Exception ignored) {
            rowStyle = null;
        }

        if (!repeated) {
            Object builder = invokeNoArgFactory(clazz, "newBuilder");
            if (builder != null) {
                try {
                    Class<?> builderClass = builder.getClass();
                    boolean builderRepeated = trySetRepeated(builder, builderClass);
                    Method build = findNoArgMethod(builderClass, "build");
                    if (build != null) {
                        build.setAccessible(true);
                        Object built = build.invoke(builder);
                        if (built != null) {
                            if (!builderRepeated) {
                                builderRepeated = trySetRepeated(built, built.getClass());
                            }
                            rowStyle = built;
                            repeated = builderRepeated;
                        }
                    }
                } catch (Exception ignored) {
                }
            }
        }

        if (!repeated) {
            Object created = invokeNoArgFactory(clazz, "create");
            if (created != null) {
                repeated = trySetRepeated(created, created.getClass());
                if (repeated) {
                    rowStyle = created;
                }
            }
        }

        if (!repeated) {
            throw new IllegalStateException("Unable to configure repeated row style");
        }

        return rowStyle;
    }

    private static Object invokeNoArgFactory(Class<?> clazz, String methodName) {
        Method method = findNoArgMethod(clazz, methodName);
        if (method == null) {
            return null;
        }

        try {
            method.setAccessible(true);
            if (Modifier.isStatic(method.getModifiers())) {
                return method.invoke(null);
            }

            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return method.invoke(constructor.newInstance());
        } catch (Exception ignored) {
            return null;
        }
    }

    private static Method findNoArgMethod(Class<?> clazz, String methodName) {
        Class<?> current = clazz;
        while (current != null) {
            for (Method method : current.getDeclaredMethods()) {
                if (methodName.equals(method.getName()) && method.getParameterCount() == 0) {
                    return method;
                }
            }
            current = current.getSuperclass();
        }
        return null;
    }

    private static boolean trySetRepeated(Object target, Class<?> clazz) {
        Class<?> current = clazz;
        while (current != null) {
            for (Method method : current.getDeclaredMethods()) {
                if (method.getParameterCount() == 1) {
                    Class<?> parameterType = method.getParameterTypes()[0];
                    String name = method.getName();
                    if ((parameterType == boolean.class || parameterType == Boolean.class)
                            && ("setRepeated".equals(name) || "repeated".equals(name) || "withRepeated".equals(name))) {
                        try {
                            method.setAccessible(true);
                            method.invoke(target, true);
                            return true;
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
            current = current.getSuperclass();
        }

        current = clazz;
        while (current != null) {
            for (Field field : current.getDeclaredFields()) {
                String name = field.getName();
                if ("repeated".equals(name) || "isRepeated".equals(name)) {
                    try {
                        field.setAccessible(true);
                        field.set(target, true);
                        return true;
                    } catch (Exception ignored) {
                    }
                }
            }
            current = current.getSuperclass();
        }

        return false;
    }
}
