package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.data.style.RowStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;

public class StyleUtilsstyleTableRow_CTTrPrgetTblHeaderArrayFikaTest {

    @Test
    public void testStyleTableRow() throws Exception {
        XWPFTableRow row = Mockito.mock(XWPFTableRow.class);
        RowStyle rowStyle = new RowStyle();
        rowStyle.setRepeated(true);
        
        CTRow ctRow = CTRow.Factory.newInstance();
        CTTrPr trPr = ctRow.addNewTrPr();
        trPr.addNewTblHeader();
        
        Mockito.when(row.getCtRow()).thenReturn(ctRow);
        
        StyleUtils.styleTableRow(row, rowStyle);
    }
}
