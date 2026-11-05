package com.deepoove.poi.plugin.toc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class TOCRenderPolicyrender_XWPFFieldRungetCTFieldFikaTest {

    @Test
    public void testRender() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        Class<?> runTemplateClass = Class.forName("com.deepoove.poi.template.run.RunTemplate");
        Object runTemplate = instantiateRunTemplate(runTemplateClass, run);

        Class<?> policyClass = Class.forName("com.deepoove.poi.plugin.toc.TOCRenderPolicy");
        Object policy = instantiateClass(policyClass);

        Method renderMethod = findRenderMethod(policyClass, runTemplate);
        renderMethod.setAccessible(true);
        renderMethod.invoke(policy, runTemplate, null, null);
    }

    private static Object instantiateRunTemplate(Class<?> clazz, XWPFRun run) throws Exception {
        Constructor<?> selected = null;
        int selectedRunIndex = -1;
        int bestScore = -1;

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int runIndex = -1;
            int stringIndex = -1;
            boolean exactRunIndex = false;

            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i] == XWPFRun.class) {
                    runIndex = i;
                    exactRunIndex = true;
                } else if (!exactRunIndex && parameterTypes[i].isAssignableFrom(XWPFRun.class)) {
                    runIndex = i;
                }

                if (parameterTypes[i] == String.class) {
                    stringIndex = i;
                }
            }

            if (runIndex == -1) {
                continue;
            }

            int score = 0;
            if (stringIndex != -1) {
                score += 3;
            }
            if (parameterTypes.length == 2) {
                score += 2;
            }
            if (parameterTypes.length == 3) {
                score += 1;
            }
            if (parameterTypes.length == 1) {
                score += 1;
            }

            if (score > bestScore) {
                bestScore = score;
                selected = constructor;
                selectedRunIndex = runIndex;
            }
        }

        if (selected != null) {
            selected.setAccessible(true);
            Object[] args = createDefaultArguments(selected.getParameterTypes());
            args[selectedRunIndex] = run;

            try {
                return selected.newInstance(args);
            } catch (Throwable ignored) {
            }
        }

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            Object[] args = createDefaultArguments(constructor.getParameterTypes());

            try {
                Object instance = constructor.newInstance(args);
                setField(instance, "run", run);
                return instance;
            } catch (Throwable ignored) {
            }
        }

        throw new IllegalStateException("Unable to create RunTemplate");
    }

    private static Object instantiateClass(Class<?> clazz) throws Exception {
        try {
            Constructor<?> noArg = clazz.getDeclaredConstructor();
            noArg.setAccessible(true);
            return noArg.newInstance();
        } catch (NoSuchMethodException ignored) {
        } catch (Throwable ignored) {
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        Constructor<?> best = null;
        int bestParameterCount = Integer.MAX_VALUE;

        for (Constructor<?> constructor : constructors) {
            int parameterCount = constructor.getParameterTypes().length;
            if (best == null || parameterCount < bestParameterCount) {
                best = constructor;
                bestParameterCount = parameterCount;
            }
        }

        if (best != null) {
            best.setAccessible(true);
            Object[] args = createDefaultArguments(best.getParameterTypes());

            try {
                return best.newInstance(args);
            } catch (Throwable ignored) {
            }
        }

        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            Object[] args = createDefaultArguments(constructor.getParameterTypes());

            try {
                return constructor.newInstance(args);
            } catch (Throwable ignored) {
            }
        }

        throw new IllegalStateException("Unable to create policy");
    }

    private static Method findRenderMethod(Class<?> clazz, Object runTemplate) {
        Method[] methods = clazz.getMethods();
        Method fallback = null;

        for (Method method : methods) {
            if (!"render".equals(method.getName()) || method.getParameterCount() != 3) {
                continue;
            }

            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes[0].isInstance(runTemplate)) {
                return method;
            }

            if (fallback == null) {
                fallback = method;
            }
        }

        if (fallback != null) {
            return fallback;
        }

        methods = clazz.getDeclaredMethods();
        fallback = null;

        for (Method method : methods) {
            if (!"render".equals(method.getName()) || method.getParameterCount() != 3) {
                continue;
            }

            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes[0].isInstance(runTemplate)) {
                return method;
            }

            if (fallback == null) {
                fallback = method;
            }
        }

        if (fallback != null) {
            return fallback;
        }

        throw new IllegalStateException("Unable to find render method");
    }

    private static Object[] createDefaultArguments(Class<?>[] parameterTypes) {
        Object[] args = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            args[i] = defaultValue(parameterTypes[i]);
        }

        return args;
    }

    private static Object defaultValue(Class<?> type) {
        if (type == String.class) {
            return "TOC";
        }
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
            return 0f;
        }
        if (type == double.class) {
            return 0d;
        }
        if (type == char.class) {
            return '\0';
        }
        if (type == Boolean.class) {
            return Boolean.FALSE;
        }
        if (type == Byte.class) {
            return (byte) 0;
        }
        if (type == Short.class) {
            return (short) 0;
        }
        if (type == Integer.class) {
            return 0;
        }
        if (type == Long.class) {
            return 0L;
        }
        if (type == Float.class) {
            return 0f;
        }
        if (type == Double.class) {
            return 0d;
        }
        if (type == Character.class) {
            return '\0';
        }
        if (type.isEnum()) {
            Object[] constants = type.getEnumConstants();
            if (constants != null && constants.length > 0) {
                return constants[0];
            }
        }
        return null;
    }

    private static void setField(Object target, String fieldName, Object value) {
        Class<?> current = target.getClass();

        while (current != null) {
            try {
                Field field = current.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(target, value);
                return;
            } catch (Throwable ignored) {
            }

            current = current.getSuperclass();
        }
    }
}
