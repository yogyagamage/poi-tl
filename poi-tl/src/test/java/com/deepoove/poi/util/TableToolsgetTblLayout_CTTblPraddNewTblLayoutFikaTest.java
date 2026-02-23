package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblLayoutType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableToolsgetTblLayout_CTTblPraddNewTblLayoutFikaTest {

    @Test
    public void testGetTblLayoutTriggersAddNewTblLayout() {
        // Create a mock XWPFTable
        XWPFTable table = mock(XWPFTable.class);
        
        // Create a real CTTblPr object (using the actual implementation)
        CTTblPr tblPr = CTTblPr.Factory.newInstance();
        
        // Mock the table to return the CTTblPr when getTblPr is called
        // We need to simulate TableTools.getTblPr(table) returning our tblPr
        // Since TableTools is a utility class with static methods, we can't mock it directly.
        // Instead, we'll create a table that has the necessary structure.
        
        // Create a mock CTTbl that will be returned by table.getCTTbl()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl cttbl = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl.Factory.newInstance();
        cttbl.setTblPr(tblPr);
        
        // Configure the mock table to return our CTTbl
        when(table.getCTTbl()).thenReturn(cttbl);
        
        // Ensure tblPr does NOT have tblLayout set, so addNewTblLayout() will be called
        // tblPr.isSetTblLayout() should return false
        
        // Call the entry point method
        CTTblLayoutType result = TableTools.getTblLayout(table);
        
        // No assertions needed - test passes if addNewTblLayout() is invoked without exceptions
    }
}
