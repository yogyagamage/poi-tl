package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TableToolsgetTcPr_CTTcisSetTcPrFikaTest {

    @Test
    public void testGetTcPrInvokesIsSetTcPr() throws Exception {
        // Create mock for XWPFTableCell
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        
        // Create real CTTc object (from third-party library)
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        
        // Configure the mock to return the real CTTc
        when(cell.getCTTc()).thenReturn(ctTc);
        
        // Execute the entry point method - this will trigger the third-party method
        TableTools.getTcPr(cell);
    }
}
