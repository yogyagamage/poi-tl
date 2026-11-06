package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetInsideHFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideH() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Ensure table has CTTblPr and CTTblBorders
        table.getCTTbl().addNewTblPr().addNewTblBorders();
        
        // This will execute the full chain and invoke CTTblBorders.isSetInsideH()
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
