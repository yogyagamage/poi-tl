package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class TableToolswidthTable_CTTblWidthsetWFikaTest {

    @Test
    public void testWidthTableInvokesCTTblWidthSetW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 3);
        
        XWPFTableRow row = table.getRow(0);
        row.getCell(0).setText("Cell1");
        row.getCell(1).setText("Cell2");
        row.getCell(2).setText("Cell3");
        
        float[] colWidths = new float[] { 2.5f, 3.0f, 2.0f };
        
        TableTools.widthTable(table, colWidths);
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        document.close();
    }
}
