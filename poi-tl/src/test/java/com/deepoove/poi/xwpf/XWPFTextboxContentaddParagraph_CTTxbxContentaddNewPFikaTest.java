package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

public class XWPFTextboxContentaddParagraph_CTTxbxContentaddNewPFikaTest {

    @Test
    void addParagraphReachesCTTxbxContentAddNewP() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph documentParagraph = document.createParagraph();
        XWPFRun run = documentParagraph.createRun();
        CTTxbxContent ctTxbxContent = CTTxbxContent.Factory.newInstance();

        XWPFTextboxContent content = createContent(ctTxbxContent, document, documentParagraph, run);

        Method addParagraph;
        try {
            addParagraph = XWPFTextboxContent.class.getMethod("addParagraph");
        } catch (NoSuchMethodException e) {
            addParagraph = XWPFTextboxContent.class.getDeclaredMethod("addParagraph");
        }
        try {
            addParagraph.setAccessible(true);
        } catch (Throwable ignored) {
        }
        addParagraph.invoke(content);
    }

    private XWPFTextboxContent createContent(CTTxbxContent ctTxbxContent, XWPFDocument document,
                                             XWPFParagraph paragraph, XWPFRun run) throws Exception {
        Constructor<?>[] constructors = XWPFTextboxContent.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (!acceptsCTTxbxContent(constructor)) {
                continue;
            }
            XWPFTextboxContent content = tryCreate(constructor, ctTxbxContent, document, paragraph, run);
            if (content != null) {
                ensureCtTxbxContent(content, ctTxbxContent);
                return content;
            }
        }

        for (Constructor<?> constructor : constructors) {
            XWPFTextboxContent content = tryCreate(constructor, ctTxbxContent, document, paragraph, run);
            if (content != null) {
                ensureCtTxbxContent(content, ctTxbxContent);
                return content;
            }
        }

        throw new IllegalStateException("Unable to create XWPFTextboxContent");
    }

    private XWPFTextboxContent tryCreate(Constructor<?> constructor, CTTxbxContent ctTxbxContent,
                                         XWPFDocument document, XWPFParagraph paragraph, XWPFRun run) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] arguments = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            arguments[i] = argumentFor(parameterTypes[i], ctTxbxContent, document, paragraph, run);
        }

        try {
            constructor.setAccessible(true);
        } catch (Throwable ignored) {
        }

        try {
            return (XWPFTextboxContent) constructor.newInstance(arguments);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private boolean acceptsCTTxbxContent(Constructor<?> constructor) {
        for (Class<?> parameterType : constructor.getParameterTypes()) {
            if (parameterType.isAssignableFrom(CTTxbxContent.class)
                    || CTTxbxContent.class.isAssignableFrom(parameterType)) {
                return true;
            }
        }
        return false;
    }

    private Object argumentFor(Class<?> type, CTTxbxContent ctTxbxContent, XWPFDocument document,
                               XWPFParagraph paragraph, XWPFRun run) {
        if (type == CTTxbxContent.class) {
            return ctTxbxContent;
        }
        if (type == XWPFRun.class) {
            return run;
        }
        if (type == XWPFDocument.class) {
            return document;
        }
        if (type == XWPFParagraph.class) {
            return paragraph;
        }
        if (type.isInstance(ctTxbxContent)) {
            return ctTxbxContent;
        }
        if (type.isInstance(run)) {
            return run;
        }
        if (type.isInstance(document)) {
            return document;
        }
        if (type.isInstance(paragraph)) {
            return paragraph;
        }
        if (type == String.class) {
            return "";
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
            return '\0';
        }
        if (type == byte.class) {
            return (byte) 0;
        }
        if (type == short.class) {
            return (short) 0;
        }
        if (type == float.class) {
            return 0.0f;
        }
        if (type == double.class) {
            return 0.0;
        }
        if (type == Class.class) {
            return XWPFTextboxContent.class;
        }

        Object part = getPart(run);
        if (part != null && type.isInstance(part)) {
            return part;
        }

        return null;
    }

    private Object getPart(XWPFRun run) {
        try {
            Method method = run.getClass().getMethod("getPart");
            return method.invoke(run);
        } catch (Throwable ignored) {
            return null;
        }
    }

    private void ensureCtTxbxContent(XWPFTextboxContent content, CTTxbxContent ctTxbxContent) {
        try {
            Field field = XWPFTextboxContent.class.getDeclaredField("ctTxbxContent");
            try {
                field.setAccessible(true);
            } catch (Throwable ignored) {
            }
            if (field.get(content) == null) {
                field.set(content, ctTxbxContent);
            }
        } catch (Throwable ignored) {
        }
    }
}
