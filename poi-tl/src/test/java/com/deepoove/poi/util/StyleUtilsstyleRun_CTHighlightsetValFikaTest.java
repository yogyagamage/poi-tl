package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.xwpf.XWPFHighlightColor;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleRun_CTHighlightsetValFikaTest {

    @Test
    public void testStyleRunInvokesCTHighlightSetVal() throws Exception {
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        
        // Create mock CTRPr using reflection since it's from XML beans
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr mockPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr.Factory.newInstance();
        
        // Mock the getCTR() method to return our mock CTRPr
        when(mockRun.getCTR()).thenReturn(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR.Factory.newInstance()
        );
        mockRun.getCTR().setRPr(mockPr);
        
        // Create Style with highlight color
        Style style = new Style();
        style.setHighlightColor(XWPFHighlightColor.YELLOW);
        
        // Call the entry point method
        StyleUtils.styleRun(mockRun, style);
    }
}
