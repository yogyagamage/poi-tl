package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersisSetLeftFikaTest {

    @Test
    public void testBorderTableInvokesIsSetLeft() throws Exception {
        // Create a real XWPFDocument and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Create table borders structure if not present
        if (table.getCTTbl().getTblPr() == null) {
            table.getCTTbl().addNewTblPr();
        }
        if (table.getCTTbl().getTblPr().getTblBorders() == null) {
            table.getCTTbl().getTblPr().addNewTblBorders();
        }
        
        // This will invoke the full chain including CTTblBorders.isSetLeft()
        TableTools.borderTable(table, 8);
        
        // Clean up
        document.close();
    }
}
