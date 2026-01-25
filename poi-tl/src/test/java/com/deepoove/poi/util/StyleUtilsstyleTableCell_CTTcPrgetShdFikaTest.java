package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableCell_CTTcPrgetShdFikaTest {

    @Test
    public void testStyleTableCell() throws Exception {
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        CellStyle cellStyle = Mockito.mock(CellStyle.class);
        
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr tcPr = 
            ctTc.addNewTcPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd shd = 
            tcPr.addNewShd();
        
        when(cell.getCTTc()).thenReturn(ctTc);
        when(cellStyle.getBackgroundColor()).thenReturn("FF0000");
        
        StyleUtils.styleTableCell(cell, cellStyle);
    }
}
