package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleRun_XWPFRunsetVerticalAlignmentFikaTest {

    @Test
    public void testStyleRunInvokesSetVerticalAlignment() {
        // Create a real Style object
        Style style = new Style();
        style.setVertAlign("baseline");
        
        // Create a mock XWPFRun that will return a non-null CTR when getCTR() is called
        XWPFRun run = Mockito.mock(XWPFRun.class);
        
        // Mock the getCTR() method to return a mock CTR object
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR ctr = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR.class);
        Mockito.when(run.getCTR()).thenReturn(ctr);
        
        // Mock the isSetRPr() method to return false so that getRPr() returns null
        Mockito.when(ctr.isSetRPr()).thenReturn(false);
        
        // Call the entry point method
        StyleUtils.styleRun(run, style);
    }
}
