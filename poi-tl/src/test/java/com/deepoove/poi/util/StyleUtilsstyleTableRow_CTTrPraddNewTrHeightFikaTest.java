package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import com.deepoove.poi.data.style.RowStyle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleTableRow_CTTrPraddNewTrHeightFikaTest {

    @Test
    public void testStyleTableRowTriggersAddNewTrHeight() throws Exception {
        // Create mock row that will return a real CTTrPr with addNewTrHeight()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow ctRow = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr ctTrPr = ctRow.addNewTrPr();
        
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        Mockito.when(row.getCtRow()).thenReturn(ctRow);
        Mockito.when(row.getHeight()).thenReturn(0);
        
        // Create RowStyle with height to trigger the addNewTrHeight() call
        RowStyle rowStyle = new RowStyle();
        rowStyle.setHeight(100);
        rowStyle.setHeightRule("exact");
        
        // Execute the entry point method
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
