package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetInsideVFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideV() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Create table borders structure to ensure isSetInsideV() is called
        table.getCTTbl().addNewTblPr().addNewTblBorders();
        
        TableTools.borderTable(table, 8);
    }
}
