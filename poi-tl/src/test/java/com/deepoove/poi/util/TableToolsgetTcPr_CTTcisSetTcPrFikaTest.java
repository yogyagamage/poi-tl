package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class TableToolsgetTcPr_CTTcisSetTcPrFikaTest {

    @Test
    public void testGetTcPr() throws Exception {
        // Create a real document with a table containing a cell
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        // Ensure the cell has CTTc structure
        CTTc ctTc = cell.getCTTc();
        
        // This will invoke CTTc.isSetTcPr() inside the method
        CTTcPr result = TableTools.getTcPr(cell);
    }
}
