package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;

public class TableToolsgetTblLayout_CTTblPrisSetTblLayoutFikaTest {
    @Test
    void testGetTblLayout() {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        if (table.getCTTbl().getTblPr() == null) {
            table.getCTTbl().addNewTblPr();
        }
        TableTools.getTblLayout(table);
    }
}
