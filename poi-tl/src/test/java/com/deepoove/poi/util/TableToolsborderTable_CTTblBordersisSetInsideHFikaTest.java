package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;

import java.math.BigInteger;
import java.io.ByteArrayOutputStream;

public class TableToolsborderTable_CTTblBordersisSetInsideHFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideH() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        // Create table structure with cells
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                cell.setText("Test");
            }
        }
        
        // Call the method under test
        TableTools.borderTable(table, 8);
        
        // Clean up
        document.close();
    }
}
