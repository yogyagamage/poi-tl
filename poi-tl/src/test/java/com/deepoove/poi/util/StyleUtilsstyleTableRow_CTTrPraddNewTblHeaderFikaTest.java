package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleTableRow_CTTrPraddNewTblHeaderFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewTblHeader() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(1, 1);
        XWPFTableRow row = table.getRow(0);
        
        RowStyle rowStyle = new RowStyle();
        rowStyle.setRepeated(true);
        
        StyleUtils.styleTableRow(row, rowStyle);
        
        document.close();
    }
}
