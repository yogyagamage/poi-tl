package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleTableRow_CTRowaddNewTrPrFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewTrPr() throws Exception {
        // Create a real document and table to get a real XWPFTableRow
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        // Create a RowStyle that will trigger the path to addNewTrPr()
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100); // Non-zero height ensures we go into the height setting block
        
        // This should invoke CTRow.addNewTrPr() when ctRow.isSetTrPr() returns false
        StyleUtils.styleTableRow(row, rowStyle);
        
        // Clean up
        document.close();
    }
}
