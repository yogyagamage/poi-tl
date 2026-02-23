package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleTableRow_CTRowisSetTrPrFikaTest {

    @Test
    public void testStyleTableRowInvokesIsSetTrPr() throws Exception {
        // Create a real document and table to get a real XWPFTableRow
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        // Create a real RowStyle with some properties to ensure the method executes
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100);
        rowStyle.setHeightRule("exact");
        rowStyle.setRepeated(true);
        rowStyle.setBreakAcrossPage(false);
        
        // This will invoke StyleUtils.styleTableRow which will call CTRow.isSetTrPr()
        StyleUtils.styleTableRow(row, rowStyle);
        
        // Clean up
        document.close();
    }
}
