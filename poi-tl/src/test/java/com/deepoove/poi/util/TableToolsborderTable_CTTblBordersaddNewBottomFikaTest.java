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

public class TableToolsborderTable_CTTblBordersaddNewBottomFikaTest {

    @Test
    public void testBorderTableInvokesAddNewBottom() throws Exception {
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
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr == null) {
            tblPr = table.getCTTbl().addNewTblPr();
        }
        
        // Ensure CTTblBorders exists but bottom is not set
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        // Clear any existing bottom border to trigger addNewBottom()
        if (tblBorders.isSetBottom()) {
            tblBorders.unsetBottom();
        }
        
        // Invoke the method under test
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
