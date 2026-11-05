package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;

public class TableToolssetWidth_XWPFTableRowgetCellFikaTest {

    @Test
    public void testSetWidth() {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        TableTools.setWidth(table, "1000", new int[]{1000});
    }
}
