package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;

public class TableToolsgetTcPr_CTTcisSetTcPrFikaTest {

    @Test
    void testGetTcPr() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        XWPFTableCell cell = table.getRow(0).getCell(0);
        TableTools.getTcPr(cell);
        document.close();
    }
}
