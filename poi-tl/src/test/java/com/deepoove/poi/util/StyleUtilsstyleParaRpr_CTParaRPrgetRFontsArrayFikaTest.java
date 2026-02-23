package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleParaRpr_CTParaRPrgetRFontsArrayFikaTest {

    @Test
    public void test() throws Exception {
        // Create a real XWPFParagraph mock since we need to control its behavior
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP object chain
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr pPr = ctp.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr paraRPr = pPr.addNewRPr();
        
        // Make paragraph return our CTP
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Create a real Style with font family to trigger getRFontsArray call
        Style style = Style.builder()
            .buildFontFamily("Arial")
            .build();
        
        // Execute the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
