package com.deepoove.poi.xwpf;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

public class ParagraphContextcreateRun_XWPFFieldRungetCTFieldFikaTest {

    @Test
    void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        CTSimpleField ctSimpleField = CTSimpleField.Factory.newInstance();
        CTR ctr = CTR.Factory.newInstance();
        XWPFFieldRun fieldRun = new XWPFFieldRun(ctSimpleField, ctr, paragraph);

        Object context = createParagraphContext(document, paragraph, fieldRun, ctSimpleField, ctr);
        Method createRun = findCreateRunMethod();
        createRun.invoke(context, fieldRun, paragraph);
    }

    private Object createParagraphContext(XWPFDocument document, XWPFParagraph paragraph, XWPFFieldRun fieldRun,
                                          CTSimpleField ctSimpleField, CTR ctr) throws Exception {
        Class<?> clazz = ParagraphContext.class;
        List<Object> available = new ArrayList<>();
        available.add(document);
        available.add(paragraph);
        available.add(fieldRun);
        available.add(ctSimpleField);
        available.add(ctr);
        available.add(paragraph.getCTP());
        available.add("");
        available.add(new ArrayList<XWPFRun>());
        available.add(new HashMap<>());
        available.add(new HashSet<>());
        available.add(new ArrayList<>().iterator());
        available.add(Optional.empty());
        available.add(URI.create("http://example.com"));
        available.add(new File(""));
        available.add(Paths.get("."));
        available.add(Integer.valueOf(0));
        available.add(Boolean.FALSE);
        available.add(Character.valueOf(' '));
        available.add(ParagraphContext.class);
        available.add(ParagraphContext.class.getClassLoader());
        available.add(ParagraphContext.class.getPackage());
        available.add(new Exception());
        available.add(new RuntimeException());
        available.add(new Object[0]);
        available.add(new String[0]);
        available.add(new XWPFRun[0]);
        available.add(new XWPFFieldRun[0]);
        available.add(new IRunBody[0]);
        available.add(new XWPFParagraph[0]);
        available.add(new XWPFDocument[0]);
        available.add(new CTSimpleField[0]);
        available.add(new CTR[0]);
        available.add(new CTP[0]);
        available.add(new Class[0]);
        available.add(new Constructor[0]);
        available.add(new Method[0]);
        available.add(new java.lang.annotation.Annotation[0]);
        available.add(new Package[0]);
        available.add(new ClassLoader[0]);
        available.add(new Throwable[0]);
        available.add(new Exception[0]);
        available.add(new RuntimeException[0]);
        available.add(new java.io.IOException[0]);
        available.add(new File[0]);
        available.add(new URI[0]);
        available.add(new java.nio.file.Path[0]);
        available.add(new List[0]);
        available.add(new java.util.Set[0]);
        available.add(new java.util.Map[0]);
        available.add(new java.util.Collection[0]);
        available.add(new java.util.Iterator[0]);
        available.add(new Iterable[0]);
        available.add(new Optional[0]);
        available.add(new Number[0]);
        available.add(new Integer[0]);
        available.add(new Byte[0]);
        available.add(new Short[0]);
        available.add(new Long[0]);
        available.add(new Float[0]);
        available.add(new Double[0]);
        available.add(new Boolean[0]);
        available.add(new Character[0]);
        available.add(new byte[0]);
        available.add(new char[0]);
        available.add(new int[0]);
        available.add(new long[0]);
        available.add(new double[0]);
        available.add(new float[0]);
        available.add(new boolean[0]);
        available.add(new short[0]);

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] args = buildArguments(parameterTypes, available);
            try {
                constructor.setAccessible(true);
                return constructor.newInstance(args);
            } catch (Throwable ignored) {
            }

            Object[] nullArgs = buildNullArguments(parameterTypes);
            try {
                constructor.setAccessible(true);
                return constructor.newInstance(nullArgs);
            } catch (Throwable ignored) {
            }
        }

        throw new IllegalStateException("Unable to create ParagraphContext instance");
    }

    private Object[] buildArguments(Class<?>[] parameterTypes, List<Object> available) {
        Object[] args = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                args[i] = primitiveDefault(parameterTypes[i]);
            } else {
                args[i] = findCandidate(parameterTypes[i], available);
            }
        }
        return args;
    }

    private Object[] buildNullArguments(Class<?>[] parameterTypes) {
        Object[] args = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                args[i] = primitiveDefault(parameterTypes[i]);
            }
        }
        return args;
    }

    private Object findCandidate(Class<?> type, List<Object> available) {
        for (Object candidate : available) {
            if (candidate != null && type.isAssignableFrom(candidate.getClass())) {
                return candidate;
            }
        }
        if (type == Object.class) {
            return available.get(0);
        }
        return null;
    }

    private Object primitiveDefault(Class<?> type) {
        if (type == boolean.class) return false;
        if (type == byte.class) return (byte) 0;
        if (type == short.class) return (short) 0;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0f;
        if (type == double.class) return 0d;
        if (type == char.class) return '\0';
        return null;
    }

    private Method findCreateRunMethod() throws Exception {
        Class<?> clazz = ParagraphContext.class;
        Class<?> current = clazz;
        while (current != null) {
            for (Method method : current.getDeclaredMethods()) {
                if (method.getName().equals("createRun") && method.getParameterCount() == 2) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0] == XWPFRun.class && parameterTypes[1] == IRunBody.class) {
                        method.setAccessible(true);
                        return method;
                    }
                }
            }
            current = current.getSuperclass();
        }
        Method method = clazz.getMethod("createRun", XWPFRun.class, IRunBody.class);
        method.setAccessible(true);
        return method;
    }
}
