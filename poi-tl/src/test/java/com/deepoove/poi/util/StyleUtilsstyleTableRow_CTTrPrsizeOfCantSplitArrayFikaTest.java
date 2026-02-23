package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleTableRow_CTTrPrsizeOfCantSplitArrayFikaTest {

    @Test
    public void testStyleTableRowInvokesSizeOfCantSplitArray() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        RowStyle rowStyle = new RowStyle();
        rowStyle.setBreakAcrossPage(false);
        
        StyleUtils.styleTableRow(row, rowStyle);
        
        document.close();
    }
}
