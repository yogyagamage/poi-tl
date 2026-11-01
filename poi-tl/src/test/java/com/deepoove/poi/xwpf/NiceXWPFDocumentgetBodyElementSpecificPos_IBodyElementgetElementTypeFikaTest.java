package com.deepoove.poi.xwpf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentgetBodyElementSpecificPos_IBodyElementgetElementTypeFikaTest {

    @Test
    public void test() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        List<IBodyElement> bodyElements = new ArrayList<>();
        bodyElements.add(paragraph);

        Class<?> clazz = NiceXWPFDocument.class;
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField("bodyElements");
                field.setAccessible(true);
                field.set(document, bodyElements);
            } catch (NoSuchFieldException ignored) {
            } catch (Exception ignored) {
            }
            clazz = clazz.getSuperclass();
        }

        clazz = NiceXWPFDocument.class;
        Method method = null;
        while (clazz != null && method == null) {
            try {
                method = clazz.getDeclaredMethod("getBodyElementSpecificPos", int.class, List.class);
            } catch (NoSuchMethodException ignored) {
            }
            clazz = clazz.getSuperclass();
        }

        method.setAccessible(true);
        method.invoke(document, 0, bodyElements);
    }
}
