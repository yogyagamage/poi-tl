package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;

public class TableToolssetWidth_XWPFTablesetWidthFikaTest {

    @Test
    public void testSetWidth() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);

        try {
            TableTools.setWidth(table, "100", new int[0]);
        } catch (Throwable ignored) {
        }
    }
}
