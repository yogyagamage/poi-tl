package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleParaRpr_CTFontssetCsFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        // Create a real XWPFParagraph with mocked internal structure
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create the CTP object and its hierarchy
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr pPr = ctp.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr paraRPr = pPr.addNewRPr();
        
        // Mock paragraph to return the CTP
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Create a Style with font family to trigger the CTFonts.setCs() call
        Style style = new Style();
        style.setFontFamily("Arial");
        
        // Execute the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
