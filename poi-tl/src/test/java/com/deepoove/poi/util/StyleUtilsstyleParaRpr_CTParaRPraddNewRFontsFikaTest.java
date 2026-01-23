package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTParaRPraddNewRFontsFikaTest {

    @Test
    public void test() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        
        // Create mock CTPPr
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr mockCTPPr = 
            mockCTP.addNewPPr();
        
        // Create mock CTParaRPr
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr mockCTParaRPr = 
            mockCTPPr.addNewRPr();
        
        // Configure paragraph mock to return the CTP
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create Style with font family to trigger RFonts creation
        Style style = new Style();
        style.setFontFamily("Arial");
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
