package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleTableRow_CTTrPraddNewCantSplitFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewCantSplit() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        RowStyle rowStyle = new RowStyle();
        rowStyle.setBreakAcrossPage(false);
        
        StyleUtils.styleTableRow(row, rowStyle);
        
        document.close();
    }
}
