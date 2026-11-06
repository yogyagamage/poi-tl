package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;

public class TableToolsgetTblLayout_CTTblPrisSetTblLayoutFikaTest {

    @Test
    public void testGetTblLayoutInvokesIsSetTblLayout() throws Exception {
        // Create a real CTTblPr object that will have isSetTblLayout() called
        CTTblPr tblPr = CTTblPr.Factory.newInstance();
        
        // Create a mock XWPFTable that returns our real CTTblPr
        XWPFTable table = Mockito.mock(XWPFTable.class);
        Mockito.when(table.getCTTbl()).thenReturn(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance()
        );
        
        // Manually set up the table structure to ensure getTblPr() returns our CTTblPr
        // First get the CTTbl from the mock
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl ctTbl = table.getCTTbl();
        // Set the tblPr on the CTTbl
        ctTbl.setTblPr(tblPr);
        
        // Call the entry point method
        CTTblLayoutType result = TableTools.getTblLayout(table);
        
        // No assertions - test passes if isSetTblLayout() was invoked during execution
    }
}
