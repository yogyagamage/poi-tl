package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersisSetTopFikaTest {

    @Test
    public void testBorderTableInvokesIsSetTop() throws Exception {
        // Create a real XWPFDocument and XWPFTable
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Ensure the table has CTTblPr and CTTblBorders
        table.getCTTbl().addNewTblPr().addNewTblBorders();
        
        // Call the entry point method - this will invoke CTTblBorders.isSetTop()
        TableTools.borderTable(table, 8);
        
        // Clean up
        document.close();
    }
}
