package com.deepoove.poi.render.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DocumentProcessorobtainTextboxes_CollectionUtilsisEmptyFikaTest {

    @Test
    public void testObtainTextboxesInvokesCollectionUtilsIsEmpty() throws Exception {
        Class<?> clazz = loadDocumentProcessorClass();
        Object instance = instantiate(clazz);

        Method method = findDeclaredMethod(clazz, "obtainTextboxes", List.class);
        method.setAccessible(true);
        method.invoke(instance, Collections.emptyList());
    }

    private static Class<?> loadDocumentProcessorClass() throws Exception {
        String className = "com.deepoove.poi.render.processor.DocumentProcessor";

        try {
            return Class.forName(className, false, Thread.currentThread().getContextClassLoader());
        } catch (Throwable ignored) {
        }

        try {
            return Class.forName(className, false, DocumentProcessorobtainTextboxes_CollectionUtilsisEmptyFikaTest.class.getClassLoader());
        } catch (Throwable ignored) {
        }

        try {
            return Class.forName(className, false, ClassLoader.getSystemClassLoader());
        } catch (Throwable ignored) {
        }

        return Class.forName(className);
    }

    private static Object instantiate(Class<?> clazz) throws Exception {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Throwable ignored) {
        }

        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            Object unsafe = theUnsafeField.get(null);
            Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            return allocateInstance.invoke(unsafe, clazz);
        } catch (Throwable ignored) {
        }

        try {
            Class<?> unsafeClass = Class.forName("jdk.internal.misc.Unsafe");
            Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            Object unsafe = theUnsafeField.get(null);
            Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            return allocateInstance.invoke(unsafe, clazz);
        } catch (Throwable ignored) {
        }

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] arguments = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                arguments[i] = defaultValue(parameterTypes[i]);
            }

            try {
                return constructor.newInstance(arguments);
            } catch (Throwable ignored) {
            }
        }

        throw new IllegalStateException("Unable to instantiate " + clazz.getName());
    }

    private static Method findDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) throws Exception {
        Class<?> current = clazz;

        while (current != null) {
            try {
                return current.getDeclaredMethod(name, parameterTypes);
            } catch (NoSuchMethodException ignored) {
            }

            current = current.getSuperclass();
        }

        throw new NoSuchMethodException(name + " not found in " + clazz.getName());
    }

    private static Object defaultValue(Class<?> type) {
        if (!type.isPrimitive()) {
            return null;
        }

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
            return 0F;
        }

        if (type == double.class) {
            return 0D;
        }

        if (type == char.class) {
            return (char) 0;
        }

        return null;
    }
}
