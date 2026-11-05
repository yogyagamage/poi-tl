package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TableToolswidthTable_CTTblPrisSetTblWFikaTest {

    @Test
    public void testWidthTableInvokesIsSetTblW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Create at least one row and cell to avoid NPEs
        XWPFTableRow row = table.getRow(0);
        if (row == null) {
            row = table.createRow();
        }
        XWPFTableCell cell = row.getCell(0);
        if (cell == null) {
            cell = row.createCell();
        }
        
        float[] colWidths = new float[]{1.5f, 2.5f};
        
        // This will invoke TableTools.widthTable which calls tblPr.isSetTblW()
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
