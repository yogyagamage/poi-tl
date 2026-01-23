package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleParaRpr_CTParaRPrsizeOfRFontsArrayFikaTest {

    @Test
    public void testStyleParaRpr() {
        // Create a real XWPFParagraph using reflection to avoid NPE
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr mockPPr = 
            mockCTP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr mockParaRPr = 
            mockPPr.addNewRPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create a Style with font family to trigger the target method
        Style style = new Style();
        style.setFontFamily("Arial");
        
        // Execute the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
