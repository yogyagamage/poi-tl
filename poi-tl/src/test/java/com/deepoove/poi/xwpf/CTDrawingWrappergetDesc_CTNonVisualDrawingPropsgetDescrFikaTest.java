package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CTDrawingWrappergetDesc_CTNonVisualDrawingPropsgetDescrFikaTest {

    @Test
    public void testGetDesc() throws Exception {
        Class<?> wrapperClass = Class.forName("com.deepoove.poi.xwpf.CTDrawingWrapper");
        CTNonVisualDrawingProps docPr = CTNonVisualDrawingProps.Factory.newInstance();

        Object wrapper = null;

        for (Constructor<?> ctor : wrapperClass.getDeclaredConstructors()) {
            if (ctor.getParameterCount() == 1) {
                Class<?> paramType = ctor.getParameterTypes()[0];
                if (CTNonVisualDrawingProps.class.isAssignableFrom(paramType) || hasSetDocPrMethod(paramType)) {
                    Object arg = createArgument(paramType, docPr);
                    if (arg != null) {
                        try {
                            ctor.setAccessible(true);
                            wrapper = ctor.newInstance(arg);
                            break;
                        } catch (Throwable ignored) {
                        }
                    }
                }
            }
        }

        if (wrapper == null) {
            for (Constructor<?> ctor : wrapperClass.getDeclaredConstructors()) {
                if (ctor.getParameterCount() == 1) {
                    Object arg = createArgument(ctor.getParameterTypes()[0], docPr);
                    if (arg != null) {
                        try {
                            ctor.setAccessible(true);
                            wrapper = ctor.newInstance(arg);
                            break;
                        } catch (Throwable ignored) {
                        }
                    }
                }
            }
        }

        if (wrapper == null) {
            for (Method method : wrapperClass.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers())
                        && wrapperClass.isAssignableFrom(method.getReturnType())
                        && method.getParameterCount() == 1) {
                    Class<?> paramType = method.getParameterTypes()[0];
                    if (CTNonVisualDrawingProps.class.isAssignableFrom(paramType) || hasSetDocPrMethod(paramType)) {
                        Object arg = createArgument(paramType, docPr);
                        if (arg != null) {
                            try {
                                method.setAccessible(true);
                                wrapper = method.invoke(null, arg);
                                break;
                            } catch (Throwable ignored) {
                            }
                        }
                    }
                }
            }
        }

        if (wrapper == null) {
            for (Method method : wrapperClass.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers())
                        && wrapperClass.isAssignableFrom(method.getReturnType())
                        && method.getParameterCount() == 1) {
                    Object arg = createArgument(method.getParameterTypes()[0], docPr);
                    if (arg != null) {
                        try {
                            method.setAccessible(true);
                            wrapper = method.invoke(null, arg);
                            break;
                        } catch (Throwable ignored) {
                        }
                    }
                }
            }
        }

        if (wrapper == null) {
            try {
                Constructor<?> ctor = wrapperClass.getDeclaredConstructor();
                ctor.setAccessible(true);
                wrapper = ctor.newInstance();
            } catch (Throwable ignored) {
            }
        }

        if (wrapper == null) {
            for (Constructor<?> ctor : wrapperClass.getDeclaredConstructors()) {
                try {
                    Class<?>[] params = ctor.getParameterTypes();
                    Object[] args = new Object[params.length];
                    for (int i = 0; i < params.length; i++) {
                        args[i] = defaultArgument(params[i]);
                    }
                    ctor.setAccessible(true);
                    wrapper = ctor.newInstance(args);
                    break;
                } catch (Throwable ignored) {
                }
            }
        }

        if (wrapper == null) {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                Object unsafe = theUnsafe.get(null);
                Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
                wrapper = allocateInstance.invoke(unsafe, wrapperClass);
            } catch (Throwable ignored) {
            }
        }

        Field docPrField = null;
        Class<?> current = wrapperClass;
        while (current != null && docPrField == null) {
            try {
                docPrField = current.getDeclaredField("docPr");
            } catch (NoSuchFieldException ignored) {
            }
            current = current.getSuperclass();
        }

        if (docPrField != null && wrapper != null) {
            docPrField.setAccessible(true);
            try {
                docPrField.set(wrapper, docPr);
            } catch (Throwable ignored) {
            }
        }

        Method getDesc = null;
        current = wrapperClass;
        while (current != null && getDesc == null) {
            try {
                getDesc = current.getDeclaredMethod("getDesc");
            } catch (NoSuchMethodException ignored) {
            }
            current = current.getSuperclass();
        }

        getDesc.invoke(wrapper);
    }

    private static Object createArgument(Class<?> type, CTNonVisualDrawingProps docPr) {
        if (CTNonVisualDrawingProps.class.isAssignableFrom(type)) {
            return docPr;
        }
        if (type == String.class) {
            return "test";
        }
        if (type == int.class) {
            return 0;
        }
        if (type == long.class) {
            return 0L;
        }
        if (type == boolean.class) {
            return false;
        }
        if (type == char.class) {
            return ' ';
        }
        if (type == double.class) {
            return 0d;
        }
        if (type == float.class) {
            return 0f;
        }
        if (type == byte.class) {
            return (byte) 0;
        }
        if (type == short.class) {
            return (short) 0;
        }
        try {
            Field factoryField = type.getField("Factory");
            Object factory = factoryField.get(null);
            Method newInstance = factory.getClass().getMethod("newInstance");
            Object arg = newInstance.invoke(factory);
            if (arg != null) {
                try {
                    Method setDocPr = type.getMethod("setDocPr", CTNonVisualDrawingProps.class);
                    setDocPr.invoke(arg, docPr);
                } catch (Throwable ignored) {
                }
            }
            return arg;
        } catch (Throwable ignored) {
            return null;
        }
    }

    private static boolean hasSetDocPrMethod(Class<?> type) {
        try {
            type.getMethod("setDocPr", CTNonVisualDrawingProps.class);
            return true;
        } catch (Throwable ignored) {
            return false;
        }
    }

    private static Object defaultArgument(Class<?> type) {
        if (type == int.class) {
            return 0;
        }
        if (type == long.class) {
            return 0L;
        }
        if (type == boolean.class) {
            return false;
        }
        if (type == char.class) {
            return ' ';
        }
        if (type == double.class) {
            return 0d;
        }
        if (type == float.class) {
            return 0f;
        }
        if (type == byte.class) {
            return (byte) 0;
        }
        if (type == short.class) {
            return (short) 0;
        }
        return null;
    }
}
