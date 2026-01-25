package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTFontssetHAnsiFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP and set up paragraph.getCTP()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create Style with font family to trigger CTFonts.setHAnsi call
        Style style = new Style();
        style.setFontFamily("Arial");
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
