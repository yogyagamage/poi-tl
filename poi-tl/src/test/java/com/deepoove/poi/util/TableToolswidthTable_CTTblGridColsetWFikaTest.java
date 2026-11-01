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
    public void testWidthTable() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 3);
        
        float[] colWidths = new float[] { 2.5f, 3.0f, 4.5f };
        
        TableTools.widthTable(table, colWidths);
        
        document.close();
    }
}
