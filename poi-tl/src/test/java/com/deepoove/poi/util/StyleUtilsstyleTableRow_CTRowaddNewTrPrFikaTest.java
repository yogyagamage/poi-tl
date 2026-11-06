package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableRow_CTRowaddNewTrPrFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewTrPr() throws Exception {
        // Create real document and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        
        // Get the first row from the table
        XWPFTableRow row = table.getRow(0);
        
        // Create a real RowStyle with required properties
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100);
        rowStyle.setHeightRule("exact");
        rowStyle.setRepeated(false);
        rowStyle.setBreakAcrossPage(true);
        
        // Execute the entry point method
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
