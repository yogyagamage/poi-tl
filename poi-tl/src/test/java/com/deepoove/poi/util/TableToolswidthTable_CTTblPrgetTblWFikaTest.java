package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.math.BigInteger;

public class TableToolswidthTable_CTTblPrgetTblWFikaTest {

    @Test
    public void testWidthTableCallsGetTblW() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 2);
        
        float[] colWidths = new float[]{5.0f, 5.0f};
        
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
