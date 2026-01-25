package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableRow_CTTrPraddNewTrHeightFikaTest {

    @Test
    public void testStyleTableRow() throws Exception {
        RowStyle rowStyle = Mockito.mock(RowStyle.class);
        when(rowStyle.getHeight()).thenReturn(100);
        when(rowStyle.getHeightRule()).thenReturn("exact");
        when(rowStyle.isRepeated()).thenReturn(false);
        when(rowStyle.isBreakAcrossPage()).thenReturn(false);

        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow ctRow = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr ctTrPr = 
            ctRow.addNewTrPr();
        
        when(row.getCtRow()).thenReturn(ctRow);
        
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
