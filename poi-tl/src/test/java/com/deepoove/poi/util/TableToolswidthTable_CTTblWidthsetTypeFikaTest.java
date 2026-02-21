package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.util.List;

public class TableToolswidthTable_CTTblWidthsetTypeFikaTest {

    @Test
    public void testWidthTable() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 2);
        
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell1 = row.getCell(0);
        XWPFTableCell cell2 = row.getCell(1);
        
        cell1.setText("Test1");
        cell2.setText("Test2");
        
        float[] colWidths = new float[]{5.0f, 5.0f};
        
        TableTools.widthTable(table, colWidths);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        document.close();
    }
}
