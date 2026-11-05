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
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100);
        rowStyle.setHeightRule("exact");
        rowStyle.setRepeated(true);
        rowStyle.setBreakAcrossPage(false);
        
        StyleUtils.styleTableRow(row, rowStyle);
        
        document.close();
    }
}
