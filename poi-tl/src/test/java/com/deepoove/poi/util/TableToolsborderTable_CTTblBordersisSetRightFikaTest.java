package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.List;

public class TableToolsborderTable_CTTblBordersisSetRightFikaTest {

    @Test
    public void testBorderTableInvokesIsSetRight() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Create a minimal table structure
        XWPFTableRow row = table.getRow(0);
        if (row == null) {
            row = table.createRow();
        }
        XWPFTableCell cell = row.getCell(0);
        if (cell == null) {
            cell = row.createCell();
        }
        
        // Ensure the table has CTTblPr
        org.apache.xmlbeans.XmlObject xmlObject = table.getCTTbl();
        if (xmlObject instanceof org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl) {
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl ctTbl = 
                (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl) xmlObject;
            CTTblPr tblPr = ctTbl.getTblPr();
            if (tblPr == null) {
                tblPr = ctTbl.addNewTblPr();
            }
            
            // Ensure CTTblBorders exists with right border not set
            CTTblBorders tblBorders = tblPr.getTblBorders();
            if (tblBorders == null) {
                tblBorders = tblPr.addNewTblBorders();
            }
            
            // Clear right border to ensure isSetRight() returns false
            if (tblBorders.isSetRight()) {
                tblBorders.unsetRight();
            }
        }
        
        // Invoke the method under test
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
