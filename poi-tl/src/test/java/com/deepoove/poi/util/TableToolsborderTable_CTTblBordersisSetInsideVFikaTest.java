package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersisSetInsideVFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideV() throws Exception {
        // Create a real XWPFDocument and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Ensure the table has CTTblPr and CTTblBorders
        table.getCTTbl().addNewTblPr();
        
        // Call the entry point method - this will traverse the path
        // and eventually call CTTblBorders.isSetInsideV()
        TableTools.borderTable(table, 8);
        
        // Clean up
        document.close();
    }
}
