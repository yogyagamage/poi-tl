package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

public class StyleUtilsstyleTableRow_CTTrPrgetCantSplitArrayFikaTest {

    @Test
    public void testStyleTableRowInvokesGetCantSplitArray() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.createRow();

        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(0);
        rowStyle.setBreakAcrossPage(false);

        CTRow ctRow = row.getCtRow();
        CTTrPr properties = ctRow.isSetTrPr() ? ctRow.getTrPr() : ctRow.addNewTrPr();
        properties.addNewCantSplit();

        StyleUtils.styleTableRow(row, rowStyle);
    }
}
