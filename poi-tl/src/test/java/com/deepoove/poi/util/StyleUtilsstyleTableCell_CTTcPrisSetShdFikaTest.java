package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import com.deepoove.poi.data.style.CellStyle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleTableCell_CTTcPrisSetShdFikaTest {

    @Test
    public void testStyleTableCell() throws Exception {
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr tcPr = 
            ctTc.addNewTcPr();
        
        Mockito.when(cell.getCTTc()).thenReturn(ctTc);
        
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        StyleUtils.styleTableCell(cell, cellStyle);
    }
}
