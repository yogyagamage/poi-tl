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

public class TableToolsborderTable_CTTblBordersisSetInsideVFikaTest {

    @Test
    public void testBorderTableInvokesIsSetInsideV() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 2);
        
        // Create table structure
        List<XWPFTableRow> rows = table.getRows();
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                cell.setText("test");
            }
        }
        
        // Use reflection to access the private static getTblPr method
        java.lang.reflect.Method getTblPrMethod = TableTools.class.getDeclaredMethod("getTblPr", XWPFTable.class);
        getTblPrMethod.setAccessible(true);
        CTTblPr tblPr = (CTTblPr) getTblPrMethod.invoke(null, table);
        
        // Ensure tblBorders exists and has insideV not set
        CTTblBorders tblBorders = tblPr.getTblBorders();
        if (tblBorders == null) {
            tblBorders = tblPr.addNewTblBorders();
        }
        
        // Remove insideV if it exists to ensure isSetInsideV() is called
        if (tblBorders.isSetInsideV()) {
            tblBorders.unsetInsideV();
        }
        
        // Call the method under test
        TableTools.borderTable(table, 8);
        
        document.close();
    }
}
