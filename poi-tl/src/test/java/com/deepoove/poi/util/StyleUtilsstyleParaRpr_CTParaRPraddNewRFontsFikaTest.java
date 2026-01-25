package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTParaRPraddNewRFontsFikaTest {

    @Test
    public void testStyleParaRprInvokesAddNewRFonts() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create mock CTP and set up paragraph to return it
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create Style with font family to trigger RFonts creation
        Style style = new Style();
        style.setFontFamily("Arial");
        style.setWesternFontFamily("Times New Roman");
        style.setFontSize(12);
        style.setColor("000000");
        style.setBold(true);
        style.setItalic(false);
        style.setStrike(false);
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
