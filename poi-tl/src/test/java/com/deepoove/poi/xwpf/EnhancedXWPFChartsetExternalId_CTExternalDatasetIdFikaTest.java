package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class EnhancedXWPFChartsetExternalId_CTExternalDatasetIdFikaTest {

    @Test
    void testSetExternalId() throws Exception {
        Object target = createInstance(EnhancedXWPFChart.class);
        ensureChartSpace(target);

        try {
            Method getChartSpace = findMethod(target.getClass(), "getCTChartSpace");
            getChartSpace.invoke(target);
        } catch (Throwable ignored) {
        }

        ensureChartSpace(target);

        Method setExternalId = findMethod(target.getClass(), "setExternalId", String.class);
        setExternalId.invoke(target, "id");
    }

    private static Object createInstance(Class<?> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Arrays.sort(constructors, (a, b) -> Integer.compare(a.getParameterCount(), b.getParameterCount()));

        for (Constructor<?> constructor : constructors) {
            try {
                constructor.setAccessible(true);
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] arguments = new Object[parameterTypes.length];

                for (int i = 0; i < parameterTypes.length; i++) {
                    arguments[i] = createArgument(parameterTypes[i]);
                }

                Object instance = constructor.newInstance(arguments);
                if (instance != null) {
                    return instance;
                }
            } catch (Throwable ignored) {
            }
        }

        return allocateInstance(clazz);
    }

    private static Object createArgument(Class<?> type) throws Exception {
        if (type == String.class) {
            return "id";
        }

        if (type == CTChartSpace.class) {
            return CTChartSpace.Factory.newInstance();
        }

        if (type.isPrimitive()) {
            return primitiveDefault(type);
        }

        if (type.isArray()) {
            return Array.newInstance(type.getComponentType(), 0);
        }

        if (type.isEnum()) {
            Object[] constants = type.getEnumConstants();
            return constants != null && constants.length > 0 ? constants[0] : null;
        }

        if (type.isInterface() || Modifier.isAbstract(type.getModifiers())) {
            return null;
        }

        String name = type.getName();

        if (name.equals("org.apache.poi.xwpf.usermodel.XWPFChart")) {
            Object chart = createChartFromDocument();
            if (chart == null) {
                chart = createInstance(type);
            }
            ensureChartSpace(chart);
            return chart;
        }

        if (name.equals("org.apache.poi.xwpf.usermodel.XWPFDocument")
                || name.equals("org.apache.poi.xssf.usermodel.XSSFWorkbook")) {
            try {
                return type.getDeclaredConstructor().newInstance();
            } catch (Throwable ignored) {
                return null;
            }
        }

        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static Object createChartFromDocument() {
        try {
            Class<?> documentClass = Class.forName("org.apache.poi.xwpf.usermodel.XWPFDocument");
            Object document = documentClass.getDeclaredConstructor().newInstance();
            Class<?> chartClass = Class.forName("org.apache.poi.xwpf.usermodel.XWPFChart");

            for (Method method : documentClass.getMethods()) {
                if (method.getParameterCount() == 0 && chartClass.isAssignableFrom(method.getReturnType())) {
                    Object chart = method.invoke(document);
                    if (chart != null) {
                        return chart;
                    }
                }
            }
        } catch (Throwable ignored) {
        }

        return null;
    }

    private static Object primitiveDefault(Class<?> type) {
        if (type == boolean.class) {
            return false;
        }
        if (type == byte.class) {
            return (byte) 0;
        }
        if (type == short.class) {
            return (short) 0;
        }
        if (type == int.class) {
            return 0;
        }
        if (type == long.class) {
            return 0L;
        }
        if (type == float.class) {
            return 0.0f;
        }
        if (type == double.class) {
            return 0.0d;
        }
        if (type == char.class) {
            return 'a';
        }
        return null;
    }

    private static Object allocateInstance(Class<?> clazz) throws Exception {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Object unsafe = theUnsafe.get(null);

            Method allocateInstance = unsafe.getClass().getMethod("allocateInstance", Class.class);
            return allocateInstance.invoke(unsafe, clazz);
        } catch (Throwable ignored) {
            throw new Exception("Unable to create instance of " + clazz.getName());
        }
    }

    private static void ensureChartSpace(Object target) {
        if (target == null) {
            return;
        }

        Class<?> current = target.getClass();
        while (current != null) {
            for (Field field : current.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }

                try {
                    field.setAccessible(true);
                    Object value = field.get(target);
                    Class<?> type = field.getType();

                    if (value == null) {
                        if (type == CTChartSpace.class) {
                            field.set(target, CTChartSpace.Factory.newInstance());
                        } else if (type.getName().equals("org.apache.poi.xwpf.usermodel.XWPFChart")) {
                            Object chart = createChartFromDocument();
                            if (chart == null) {
                                chart = createInstance(type);
                            }
                            ensureChartSpace(chart);
                            field.set(target, chart);
                        } else if (type.getName().equals("org.openxmlformats.schemas.drawingml.x2006.chart.CTChart")) {
                            CTChartSpace space = CTChartSpace.Factory.newInstance();
                            Method addNewChart = space.getClass().getMethod("addNewChart");
                            Object chart = addNewChart.invoke(space);
                            field.set(target, chart);
                        }
                    } else if (type.getName().equals("org.apache.poi.xwpf.usermodel.XWPFChart")) {
                        ensureChartSpace(value);
                    }
                } catch (Throwable ignored) {
                }
            }

            current = current.getSuperclass();
        }
    }

    private static Method findMethod(Class<?> clazz, String name, Class<?>... parameterTypes) throws Exception {
        Class<?> current = clazz;

        while (current != null) {
            try {
                Method method = current.getDeclaredMethod(name, parameterTypes);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException ignored) {
            }

            current = current.getSuperclass();
        }

        return clazz.getMethod(name, parameterTypes);
    }
}
