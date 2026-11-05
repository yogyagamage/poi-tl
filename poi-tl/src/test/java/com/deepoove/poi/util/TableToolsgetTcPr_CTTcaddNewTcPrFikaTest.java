package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TableToolsgetTcPr_CTTcaddNewTcPrFikaTest {

    @Test
    public void testGetTcPrInvokesAddNewTcPr() throws Exception {
        // Create mock for XWPFTableCell
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        
        // Create real CTTc object that will be returned by cell.getCTTc()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        
        // Configure mock to return the real CTTc object
        Mockito.when(cell.getCTTc()).thenReturn(ctTc);
        
        // Configure CTTc to NOT have TcPr set (so addNewTcPr() will be called)
        // The real CTTc object starts without TcPr set by default
        
        // Execute the entry point method - this should trigger addNewTcPr()
        TableTools.getTcPr(cell);
    }
}
