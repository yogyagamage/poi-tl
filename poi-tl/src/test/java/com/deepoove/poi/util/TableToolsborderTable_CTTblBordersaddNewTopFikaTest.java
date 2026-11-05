package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;

public class TableToolsborderTable_CTTblBordersaddNewTopFikaTest {

    @Test
    public void testBorderTable() throws Exception {
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFTable table = document.createTable();
            TableTools.borderTable(table, 1);
        }
    }
}
