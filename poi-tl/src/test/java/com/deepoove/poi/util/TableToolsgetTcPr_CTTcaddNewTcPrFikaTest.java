package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TableToolsgetTcPr_CTTcaddNewTcPrFikaTest {

    @Test
    public void testGetTcPrInvokesAddNewTcPr() {
        // Create a mock XWPFTableCell
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        
        // Create a real CTTc object (using the schema object factory)
        CTTc ctTc = CTTc.Factory.newInstance();
        
        // Configure the mock to return the CTTc
        Mockito.when(cell.getCTTc()).thenReturn(ctTc);
        
        // Ensure isSetTcPr returns false to trigger addNewTcPr()
        // Note: CTTc.isSetTcPr() will return false for a newly created CTTc
        
        // Execute the entry point method
        TableTools.getTcPr(cell);
        
        // No assertions or verifications - test passes if no exception is thrown
    }
}
