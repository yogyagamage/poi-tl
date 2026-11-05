package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.RowStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

public class StyleUtilsstyleTableRow_CTTrPrsizeOfCantSplitArrayFikaTest {

    @Test
    public void testStyleTableRow() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        RowStyle rowStyle = new RowStyle();
        rowStyle.setBreakAcrossPage(false);
        
        StyleUtils.styleTableRow(row, rowStyle);
        
        document.close();
    }
}
