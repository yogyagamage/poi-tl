package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class TableToolswidthTable_CTTblPrgetTblWFikaTest {

    @Test
    public void testWidthTableInvokesGetTblW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 2);
        
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell1 = row.getCell(0);
        XWPFTableCell cell2 = row.getCell(1);
        
        float[] colWidths = new float[]{5.0f, 5.0f};
        
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
