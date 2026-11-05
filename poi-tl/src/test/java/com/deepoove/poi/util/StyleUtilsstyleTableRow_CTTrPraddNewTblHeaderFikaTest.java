package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

public class StyleUtilsstyleTableRow_CTTrPraddNewTblHeaderFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewTblHeader() throws Exception {
        RowStyle rowStyle = Mockito.mock(RowStyle.class);
        Mockito.when(rowStyle.isRepeated()).thenReturn(true);
        Mockito.when(rowStyle.getHeight()).thenReturn(0);
        Mockito.when(rowStyle.isBreakAcrossPage()).thenReturn(true);
        
        CTRow ctRow = CTRow.Factory.newInstance();
        CTTrPr trPr = ctRow.addNewTrPr();
        
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        Mockito.when(row.getCtRow()).thenReturn(ctRow);
        
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
