package com.deepoove.poi.xwpf;

import java.lang.reflect.Constructor;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

public class ParagraphContextcreateRun_XWPFFieldRunmethodFikaTest {

    @Test
    void createRunReachesXWPFFieldRunConstructor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        XWPFRun normalRun = paragraph.createRun();
        String sampleText = "x";
        normalRun.setText(sampleText);

        CTSimpleField field = CTSimpleField.Factory.newInstance();
        CTR ctr = normalRun.getCTR();
        XWPFFieldRun fieldRun = new XWPFFieldRun(field, ctr, paragraph);

        ParagraphContext context = null;
        for (Constructor<?> constructor : ParagraphContext.class.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] arguments = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> type = parameterTypes[i];

                if (type == boolean.class) {
                    arguments[i] = false;
                } else if (type == byte.class) {
                    arguments[i] = (byte) 0;
                } else if (type == short.class) {
                    arguments[i] = (short) 0;
                } else if (type == int.class) {
                    arguments[i] = 0;
                } else if (type == long.class) {
                    arguments[i] = 0L;
                } else if (type == float.class) {
                    arguments[i] = 0.0f;
                } else if (type == double.class) {
                    arguments[i] = 0.0d;
                } else if (type == char.class) {
                    arguments[i] = '\0';
                } else if (type == XWPFParagraph.class) {
                    arguments[i] = paragraph;
                } else if (type == XWPFDocument.class) {
                    arguments[i] = document;
                } else if (type == XWPFFieldRun.class) {
                    arguments[i] = fieldRun;
                } else if (type == XWPFRun.class) {
                    arguments[i] = normalRun;
                } else if (type == CTSimpleField.class) {
                    arguments[i] = field;
                } else if (type == CTR.class) {
                    arguments[i] = ctr;
                } else if (type == CTP.class) {
                    arguments[i] = paragraph.getCTP();
                } else if (type == String.class) {
                    arguments[i] = sampleText;
                } else if (type.isInstance(paragraph)) {
                    arguments[i] = paragraph;
                } else if (type.isInstance(document)) {
                    arguments[i] = document;
                } else if (type.isInstance(normalRun)) {
                    arguments[i] = normalRun;
                } else if (type.isInstance(fieldRun)) {
                    arguments[i] = fieldRun;
                } else if (type.isInstance(field)) {
                    arguments[i] = field;
                } else if (type.isInstance(ctr)) {
                    arguments[i] = ctr;
                } else if (type.isInstance(paragraph.getCTP())) {
                    arguments[i] = paragraph.getCTP();
                } else if (type.isInstance(sampleText)) {
                    arguments[i] = sampleText;
                } else {
                    arguments[i] = null;
                }
            }

            try {
                context = (ParagraphContext) constructor.newInstance(arguments);
                break;
            } catch (Exception e) {
                try {
                    constructor.setAccessible(true);
                    context = (ParagraphContext) constructor.newInstance(arguments);
                    break;
                } catch (Exception ignored) {
                }
            }
        }

        context.createRun(fieldRun, paragraph);
    }
}
