package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TableToolsgetTcPr_CTTcaddNewTcPrFikaTest {

    @Test
    public void testGetTcPrInvokesAddNewTcPr() throws Exception {
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        
        when(cell.getCTTc()).thenReturn(ctTc);
        
        TableTools.getTcPr(cell);
    }
}
