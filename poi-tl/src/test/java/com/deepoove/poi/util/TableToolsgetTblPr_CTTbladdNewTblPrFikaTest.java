package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TableToolsgetTblPr_CTTbladdNewTblPrFikaTest {

    @Test
    public void testGetTblLayoutInvokesAddNewTblPr() throws Exception {
        // Create a mock XWPFTable that will trigger the addNewTblPr() call
        XWPFTable mockTable = Mockito.mock(XWPFTable.class);
        
        // Create a real CTTbl object that will be returned by getCTTbl()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl realCttbl = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance();
        
        // Configure the mock to return the real CTTbl
        Mockito.when(mockTable.getCTTbl()).thenReturn(realCttbl);
        
        // Execute the entry point method - this should trigger the full call chain
        TableTools.getTblLayout(mockTable);
    }
}
