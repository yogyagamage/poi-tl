package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StyleUtilsstyleTableRow_CTTrPrsizeOfCantSplitArrayFikaTest {

    @Test
    public void testStyleTableRowReachesSizeOfCantSplitArray() throws Exception {
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFTable table = document.createTable(1, 1);
            XWPFTableRow row = table.getRow(0);

            RowStyle rowStyle = new RowStyle();
            boolean breakAcrossPageSet = false;

            for (Method method : rowStyle.getClass().getMethods()) {
                if (method.getName().equals("setBreakAcrossPage")
                        && method.getParameterCount() == 1
                        && (method.getParameterTypes()[0] == boolean.class || method.getParameterTypes()[0] == Boolean.class)) {
                    try {
                        method.setAccessible(true);
                        method.invoke(rowStyle, false);
                        breakAcrossPageSet = true;
                        break;
                    } catch (Throwable ignored) {
                    }
                }
            }

            if (!breakAcrossPageSet) {
                Class<?> current = rowStyle.getClass();
                while (current != null && !breakAcrossPageSet) {
                    try {
                        Field field = current.getDeclaredField("breakAcrossPage");
                        field.setAccessible(true);
                        if (field.getType() == boolean.class) {
                            field.set(rowStyle, false);
                        } else if (field.getType() == Boolean.class) {
                            field.set(rowStyle, Boolean.FALSE);
                        }
                        breakAcrossPageSet = true;
                    } catch (Throwable ignored) {
                    }
                    current = current.getSuperclass();
                }
            }

            StyleUtils.styleTableRow(row, rowStyle);
        }
    }
}
