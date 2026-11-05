package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class TableToolssetWidth_CTTblLayoutTypesetTypeFikaTest {

    @Test
    public void testSetWidthInvokesCTTblLayoutTypeSetType() throws Exception {
        // Create a real XWPFDocument and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(2, 3);
        
        // Set up table rows and cells
        List<XWPFTableRow> rows = table.getRows();
        for (XWPFTableRow row : rows) {
            for (int i = 0; i < row.getTableCells().size(); i++) {
                row.getCell(i).setWidth("100");
            }
        }
        
        // Create column widths array
        int[] colWidths = new int[]{100, 200, 300};
        
        // Call the entry point method
        TableTools.setWidth(table, "1000", colWidths);
        
        // The call above should trigger the chain that eventually calls:
        // CTTblLayoutType.setType(STTblLayoutType.FIXED)
        // No assertions needed as per requirements
    }
}
