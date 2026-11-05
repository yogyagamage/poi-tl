package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleTableRow_CTOnOffsetValFikaTest {

    @Test
    public void testStyleTableRowInvokesCTOnOffsetVal() throws Exception {
        // Create real document and table
        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable();
        XWPFTableRow row = table.getRow(0);
        
        // Create RowStyle with repeated = true to trigger the target path
        RowStyle rowStyle = new RowStyle();
        rowStyle.setRepeated(true);
        
        // Execute the entry point method
        StyleUtils.styleTableRow(row, rowStyle);
        
        // No assertions or verifications - just ensure the method chain executes
    }
}
