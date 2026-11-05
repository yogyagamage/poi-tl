package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;

class XWPFStructuredDocumentTagContentcreateRun_XWPFRunmethodFikaTest {

    @Test
    void testCreateRun() throws Exception {
        CTSdtContentRun sdtContentRun = CTSdtContentRun.Factory.newInstance();

        Object paragraph = null;
        try {
            XWPFDocument document = new XWPFDocument();
            paragraph = document.createParagraph();
        } catch (Throwable ignored) {
        }

        Class<?> sdtRunClass = null;
        Object sdtRun = null;
        try {
            sdtRunClass = Class.forName("org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun");
            Class<?> factoryClass = Class.forName(sdtRunClass.getName() + "$Factory");
            sdtRun = factoryClass.getMethod("newInstance").invoke(null);
        } catch (Throwable ignored) {
        }

        Class<?> parentClass = null;
        Object parent = null;
        try {
            parentClass = Class.forName("com.deepoove.poi.xwpf.XWPFStructuredDocumentTag");
            parent = instantiate(parentClass, sdtRun, sdtRunClass, paragraph, XWPFParagraph.class, true);
        } catch (Throwable ignored) {
        }

        XWPFStructuredDocumentTagContent content = (XWPFStructuredDocumentTagContent) instantiate(
                XWPFStructuredDocumentTagContent.class,
                sdtContentRun,
                CTSdtContentRun.class,
                parent,
                parentClass,
                false);

        fillNullFields(content, sdtContentRun, CTSdtContentRun.class, parent, parentClass);

        content.createRun();
    }

    private static Object instantiate(Class<?> targetClass, Object primary, Class<?> primaryType, Object secondary, Class<?> secondaryType, boolean requirePrimary) {
        Constructor<?>[] constructors = targetClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (hasAssignable(constructor.getParameterTypes(), primaryType)) {
                try {
                    constructor.setAccessible(true);
                    Object instance = constructor.newInstance(buildArgs(constructor.getParameterTypes(), primary, primaryType, secondary, secondaryType));
                    if (instance != null) {
                        return instance;
                    }
                } catch (Throwable ignored) {
                }
            }
        }

        if (requirePrimary) {
            return null;
        }

        for (Constructor<?> constructor : constructors) {
            try {
                constructor.setAccessible(true);
                Object instance = constructor.newInstance(buildArgs(constructor.getParameterTypes(), primary, primaryType, secondary, secondaryType));
                if (instance != null) {
                    return instance;
                }
            } catch (Throwable ignored) {
            }
        }

        return null;
    }

    private static boolean hasAssignable(Class<?>[] types, Class<?> sourceType) {
        if (sourceType == null) {
            return false;
        }
        for (Class<?> type : types) {
            if (canAssign(type, sourceType)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canAssign(Class<?> type, Class<?> sourceType) {
        return sourceType != null && type != Object.class && type.isAssignableFrom(sourceType);
    }

    private static Object[] buildArgs(Class<?>[] paramTypes, Object primary, Class<?> primaryType, Object secondary, Class<?> secondaryType) {
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> type = paramTypes[i];
            if (canAssign(type, primaryType)) {
                args[i] = primary;
            } else if (canAssign(type, secondaryType)) {
                args[i] = secondary;
            } else if (type != Object.class && (type.isAssignableFrom(List.class) || type.isAssignableFrom(Collection.class) || type.isAssignableFrom(ArrayList.class))) {
                args[i] = new ArrayList<>();
            } else if (type == String.class) {
                args[i] = "";
            } else {
                args[i] = defaultValue(type);
            }
        }
        return args;
    }

    private static Object defaultValue(Class<?> type) {
        if (type == boolean.class) {
            return Boolean.FALSE;
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
            return '\0';
        }
        return null;
    }

    private static void fillNullFields(Object instance, Object primary, Class<?> primaryType, Object secondary, Class<?> secondaryType) {
        if (instance == null) {
            return;
        }
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            try {
                field.setAccessible(true);
                if (field.get(instance) != null) {
                    continue;
                }
                Class<?> type = field.getType();
                if ("sdtContentRun".equals(field.getName()) || canAssign(type, primaryType)) {
                    setField(field, instance, primary);
                } else if (type != Object.class && (type.isAssignableFrom(List.class) || type.isAssignableFrom(Collection.class) || type.isAssignableFrom(ArrayList.class))) {
                    setField(field, instance, new ArrayList<>());
                } else if (secondaryType != null && ("parent".equals(field.getName()) || canAssign(type, secondaryType))) {
                    setField(field, instance, secondary);
                }
            } catch (Throwable ignored) {
            }
        }
    }

    private static void setField(Field field, Object instance, Object value) {
        try {
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Throwable ignored) {
        }
    }
}
