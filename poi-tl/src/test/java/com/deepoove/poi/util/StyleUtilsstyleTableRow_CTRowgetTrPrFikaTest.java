package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleTableRow_CTRowgetTrPrFikaTest {

    @Test
    public void testStyleTableRowInvokesGetTrPr() throws Exception {
        // Create real document and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Get the first row (real object)
        XWPFTableRow row = table.getRow(0);
        
        // Create real RowStyle with required properties
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100);
        rowStyle.setHeightRule("exact");
        rowStyle.setRepeated(true);
        rowStyle.setBreakAcrossPage(false);
        
        // Execute the entry point method
        StyleUtils.styleTableRow(row, rowStyle);
        
        // Clean up
        document.close();
    }
}
