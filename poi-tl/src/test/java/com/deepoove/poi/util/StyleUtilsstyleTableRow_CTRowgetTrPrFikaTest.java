package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleTableRow_CTRowgetTrPrFikaTest {

    @Test
    public void styleTableRowShouldInvokeGetTrPr() {
        XWPFDocument document = new XWPFDocument();
        XWPFTableRow row = document.createTable(1, 1).getRow(0);
        row.getCtRow().addNewTrPr();

        RowStyle rowStyle = new RowStyle();

        StyleUtils.styleTableRow(row, rowStyle);
    }
}
