package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import java.math.BigInteger;

public class TableToolsborderTable_CTTblBordersisSetBottomFikaTest {

    @Test
    public void testBorderTableInvokesIsSetBottom() throws Exception {
        // Create a real XWPFDocument and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Ensure the table has CTTblPr with CTTblBorders
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr == null) {
            tblPr = table.getCTTbl().addNewTblPr();
        }
        
        // Ensure CTTblBorders exists but bottom is not set
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        // Clear any existing bottom border to ensure isSetBottom() returns false
        if (tblBorders.isSetBottom()) {
            tblBorders.unsetBottom();
        }
        
        // Invoke the entry point method
        TableTools.borderTable(table, 8);
    }
}
