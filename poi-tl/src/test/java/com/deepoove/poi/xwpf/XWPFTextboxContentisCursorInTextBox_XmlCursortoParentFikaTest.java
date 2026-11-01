package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;

public class XWPFTextboxContentisCursorInTextBox_XmlCursortoParentFikaTest {

    @Test
    public void testIsCursorInTextBoxInvokesXmlCursorToParent() throws Exception {
        XmlObject xmlObject = XmlObject.Factory.parse("<root><child/></root>");
        XmlCursor cursor = xmlObject.newCursor();
        cursor.toFirstChild();
        cursor.toFirstChild();

        Object instance = null;
        Constructor<?>[] constructors = XWPFTextboxContent.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            try {
                constructor.setAccessible(true);
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
                        arguments[i] = 0.0f;
                    } else if (parameterType == double.class) {
                        arguments[i] = 0.0d;
                    } else if (parameterType.isArray()) {
                        arguments[i] = java.lang.reflect.Array.newInstance(parameterType.getComponentType(), 0);
                    } else {
                        arguments[i] = null;
                    }
                }
                instance = constructor.newInstance(arguments);
                break;
            } catch (Throwable ignored) {
            }
        }

        if (instance == null) {
            try {
                Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
                Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
                theUnsafeField.setAccessible(true);
                Object unsafe = theUnsafeField.get(null);
                Method allocateInstance = unsafeClass.getDeclaredMethod("allocateInstance", Class.class);
                instance = allocateInstance.invoke(unsafe, XWPFTextboxContent.class);
            } catch (Throwable ignored) {
            }
        }

        if (instance == null) {
            try {
                Class<?> reflectionFactoryClass = Class.forName("sun.reflect.ReflectionFactory");
                Method getReflectionFactory = reflectionFactoryClass.getMethod("getReflectionFactory");
                Object reflectionFactory = getReflectionFactory.invoke(null);
                Method newConstructorForSerialization = reflectionFactoryClass.getMethod(
                        "newConstructorForSerialization", Class.class, Constructor.class);
                Constructor<?> objectConstructor = Object.class.getDeclaredConstructor();
                Constructor<?> serializationConstructor = (Constructor<?>) newConstructorForSerialization.invoke(
                        reflectionFactory, XWPFTextboxContent.class, objectConstructor);
                serializationConstructor.setAccessible(true);
                instance = serializationConstructor.newInstance();
            } catch (Throwable ignored) {
            }
        }

        Method method = XWPFTextboxContent.class.getDeclaredMethod("isCursorInTextBox", XmlCursor.class);
        method.setAccessible(true);
        method.invoke(instance, cursor);
    }
}
