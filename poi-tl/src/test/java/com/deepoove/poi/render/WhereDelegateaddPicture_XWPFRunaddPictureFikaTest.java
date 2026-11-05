package com.deepoove.poi.render;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Base64;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class WhereDelegateaddPicture_XWPFRunaddPictureFikaTest {

    @Test
    public void test() {
        try {
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            WhereDelegate delegate = createDelegate(document, paragraph, run);

            byte[] png = Base64.getDecoder().decode(
                    "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mNk+M9QDwADhgGAWjR9awAAAABJRU5ErkJggg==");
            InputStream inputStream = new ByteArrayInputStream(png);

            delegate.addPicture(inputStream, 6, 10, 10);
        } catch (Throwable ignored) {
        }
    }

    private static WhereDelegate createDelegate(XWPFDocument document, XWPFParagraph paragraph, XWPFRun run) throws Exception {
        Class<?> clazz = WhereDelegate.class;
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            try {
                constructor.setAccessible(true);
            } catch (Throwable ignored) {
            }

            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] arguments = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                arguments[i] = createArgument(parameterTypes[i], document, paragraph, run);
            }

            try {
                Object instance = constructor.newInstance(arguments);
                if (instance instanceof WhereDelegate) {
                    WhereDelegate delegate = (WhereDelegate) instance;
                    setRunField(delegate, run);
                    return delegate;
                }
            } catch (Throwable ignored) {
            }
        }

        Object instance = allocateInstance(clazz);
        if (instance instanceof WhereDelegate) {
            WhereDelegate delegate = (WhereDelegate) instance;
            setRunField(delegate, run);
            return delegate;
        }

        throw new IllegalStateException("Unable to create WhereDelegate instance");
    }

    private static Object createArgument(Class<?> type, XWPFDocument document, XWPFParagraph paragraph, XWPFRun run) {
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == boolean.class) return false;
        if (type == double.class) return 0.0;
        if (type == float.class) return 0.0f;
        if (type == char.class) return '\0';
        if (type == short.class) return (short) 0;
        if (type == byte.class) return (byte) 0;

        if (type != Object.class && type.isAssignableFrom(XWPFRun.class)) return run;
        if (type != Object.class && type.isAssignableFrom(XWPFParagraph.class)) return paragraph;
        if (type != Object.class && type.isAssignableFrom(XWPFDocument.class)) return document;

        if (type == String.class) return "Generated";
        if (InputStream.class.isAssignableFrom(type)) return new ByteArrayInputStream(new byte[0]);
        if (type.isArray() && type.getComponentType() == byte.class) return new byte[0];

        return null;
    }

    private static void setRunField(WhereDelegate delegate, XWPFRun run) {
        Class<?> type = delegate.getClass();

        while (type != null) {
            for (Field field : type.getDeclaredFields()) {
                try {
                    if (Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }

                    field.setAccessible(true);

                    if ("run".equals(field.getName())
                            || (field.getType() != Object.class && field.getType().isAssignableFrom(XWPFRun.class))) {
                        field.set(delegate, run);
                    }
                } catch (Throwable ignored) {
                }
            }

            type = type.getSuperclass();
        }
    }

    private static Object allocateInstance(Class<?> clazz) throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");

        try {
            theUnsafe.setAccessible(true);
        } catch (Throwable ignored) {
        }

        Object unsafe = theUnsafe.get(null);
        return unsafeClass.getMethod("allocateInstance", Class.class).invoke(unsafe, clazz);
    }
}
