package com.deepoove.poi.util;

import com.deepoove.poi.data.style.CellStyle;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleTableCell_CTTcPrgetShdFikaTest {

    @Test
    public void testStyleTableCell() throws Exception {
        // Create mock cell
        XWPFTableCell cell = Mockito.mock(XWPFTableCell.class);
        
        // Create real CTTc object using reflection since it's a generated XML bean
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc ctTc = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc.Factory.newInstance();
        
        // Create real CTTcPr object
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr ctTcPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr.Factory.newInstance();
        
        // Add the CTTcPr to CTTc
        ctTc.setTcPr(ctTcPr);
        
        // Create real CTShd object
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd ctShd = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd.Factory.newInstance();
        
        // Set the shd on ctTcPr
        ctTcPr.setShd(ctShd);
        
        // Configure mock to return the CTTc
        when(cell.getCTTc()).thenReturn(ctTc);
        
        // Create CellStyle with background color to trigger the path
        CellStyle cellStyle = new CellStyle();
        cellStyle.setBackgroundColor("FF0000");
        
        // Execute the entry point method
        StyleUtils.styleTableCell(cell, cellStyle);
        
        // The third-party method getShd() will be invoked during execution
        // No assertions needed as per requirements
    }
}
