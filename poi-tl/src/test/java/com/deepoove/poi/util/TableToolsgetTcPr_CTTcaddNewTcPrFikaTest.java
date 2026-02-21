package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableToolsgetTcPr_CTTcaddNewTcPrFikaTest {

    @Test
    public void testGetTcPrInvokesAddNewTcPr() throws Exception {
        // Create a real document with a table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        XWPFTableCell cell = row.getCell(0);
        
        // Get the underlying CTTc object and ensure it doesn't have TcPr set
        CTTc ctTc = cell.getCTTc();
        if (ctTc.isSetTcPr()) {
            ctTc.unsetTcPr();
        }
        
        // Invoke the method under test - this should call addNewTcPr()
        TableTools.getTcPr(cell);
    }
}
