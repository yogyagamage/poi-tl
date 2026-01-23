package com.deepoove.poi.util;

import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableRow_CTTrPraddNewTblHeaderFikaTest {

    @Test
    public void testStyleTableRowInvokesAddNewTblHeader() throws Exception {
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        RowStyle rowStyle = Mockito.mock(RowStyle.class);
        
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow ctRow = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr ctTrPr = 
            ctRow.addNewTrPr();
        
        when(row.getCtRow()).thenReturn(ctRow);
        when(rowStyle.isRepeated()).thenReturn(true);
        
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
