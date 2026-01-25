package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import java.lang.reflect.Method;

public class TableToolsborderTable_CTTblBordersisSetInsideHFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideH() throws Exception {
        // Create a real XWPFTable using reflection since constructor is not public
        XWPFTable table = createXWPFTableWithTblPr();
        
        // Call the entry point method
        TableTools.borderTable(table, 8);
    }
    
    private XWPFTable createXWPFTableWithTblPr() throws Exception {
        // Create table using XWPFDocument
        org.apache.poi.xwpf.usermodel.XWPFDocument document = 
            new org.apache.poi.xwpf.usermodel.XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Ensure CTTblPr exists
        Method getTblPrMethod = TableTools.class.getDeclaredMethod("getTblPr", XWPFTable.class);
        getTblPrMethod.setAccessible(true);
        CTTblPr tblPr = (CTTblPr) getTblPrMethod.invoke(null, table);
        
        // Ensure CTTblBorders exists but doesn't have insideH set
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        // Remove insideH if it exists to ensure isSetInsideH() is called
        if (tblBorders.isSetInsideH()) {
            tblBorders.unsetInsideH();
        }
        
        return table;
    }
}
