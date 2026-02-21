package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class TableToolswidthTable_CTTblWidthsetWFikaTest {

    @Test
    public void testWidthTableInvokesSetW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 2);
        
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell1 = row.getCell(0);
        cell1.setText("Test1");
        XWPFTableCell cell2 = row.getCell(1);
        cell2.setText("Test2");
        
        float[] colWidths = new float[]{5.0f, 10.0f};
        
        TableTools.widthTable(table, colWidths);
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.write(out);
        document.close();
    }
}
