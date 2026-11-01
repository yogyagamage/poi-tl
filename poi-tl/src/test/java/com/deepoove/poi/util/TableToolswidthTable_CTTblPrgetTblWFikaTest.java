package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class TableToolswidthTable_CTTblPrgetTblWFikaTest {

    @Test
    public void testWidthTableInvokesGetTblW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        XWPFTableRow row = table.getRow(0);
        row.createCell();
        row.createCell();
        
        float[] colWidths = new float[]{2.5f, 3.5f};
        
        TableTools.widthTable(table, colWidths);
        
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        if (tblPr != null) {
            CTTblWidth tblW = tblPr.getTblW();
        }
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.write(out);
        out.close();
        document.close();
    }
}
