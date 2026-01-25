package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTFontssetAsciiFikaTest {

    @Test
    public void testStyleParaRprInvokesCTFontsSetAscii() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create mock CTP and set up paragraph.getCTP()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create Style with font family to trigger CTFonts.setAscii call
        Style style = new Style();
        style.setFontFamily("Arial");
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
