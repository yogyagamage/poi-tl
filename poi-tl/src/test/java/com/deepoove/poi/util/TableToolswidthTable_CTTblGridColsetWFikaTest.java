package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.List;

public class TableToolswidthTable_CTTblGridColsetWFikaTest {

    @Test
    public void testWidthTableInvokesSetW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        XWPFTableRow row = table.getRow(0);
        row.createCell();
        row.createCell();
        
        float[] colWidths = new float[] { 2.5f, 3.5f };
        
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
