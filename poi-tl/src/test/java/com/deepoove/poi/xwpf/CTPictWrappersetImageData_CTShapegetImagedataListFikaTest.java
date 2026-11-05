package com.deepoove.poi.xwpf;

import com.microsoft.schemas.vml.CTShape;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

public class CTPictWrappersetImageData_CTShapegetImagedataListFikaTest {

    @Test
    public void test() throws Exception {
        CTShape ctShape = CTShape.Factory.newInstance();
        Class<?> wrapperClass = Class.forName("com.deepoove.poi.xwpf.CTPictWrapper");

        Object wrapper = null;

        for (Constructor<?> constructor : wrapperClass.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].isAssignableFrom(CTShape.class)) {
                try {
                    constructor.setAccessible(true);
                    wrapper = constructor.newInstance(ctShape);
                    break;
                } catch (Exception ignored) {
                }
            }
        }

        if (wrapper == null) {
            for (Constructor<?> constructor : wrapperClass.getDeclaredConstructors()) {
                if (constructor.getParameterCount() == 0) {
                    try {
                        constructor.setAccessible(true);
                        wrapper = constructor.newInstance();
                        break;
                    } catch (Exception ignored) {
                    }
                }
            }
        }

        if (wrapper == null) {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Object unsafe = unsafeField.get(null);
            Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            wrapper = allocateInstance.invoke(unsafe, wrapperClass);
        }

        Class<?> currentClass = wrapperClass;
        while (currentClass != null) {
            for (Field field : currentClass.getDeclaredFields()) {
                if (CTShape.class.isAssignableFrom(field.getType())) {
                    try {
                        field.setAccessible(true);
                        field.set(wrapper, ctShape);
                    } catch (Exception ignored) {
                    }
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        Method setImageData = null;
        currentClass = wrapperClass;
        while (currentClass != null && setImageData == null) {
            try {
                setImageData = currentClass.getDeclaredMethod("setImageData", String.class);
            } catch (NoSuchMethodException ignored) {
                currentClass = currentClass.getSuperclass();
            }
        }

        setImageData.setAccessible(true);
        setImageData.invoke(wrapper, "rid");
    }
}
