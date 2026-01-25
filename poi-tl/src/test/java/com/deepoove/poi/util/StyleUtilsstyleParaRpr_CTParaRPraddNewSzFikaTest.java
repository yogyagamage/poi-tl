package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyleUtilsstyleParaRpr_CTParaRPraddNewSzFikaTest {

    @Test
    public void testStyleParaRprInvokesAddNewSz() throws Exception {
        // Create a real XWPFParagraph using the POI API
        org.apache.poi.xwpf.usermodel.XWPFDocument document = new org.apache.poi.xwpf.usermodel.XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a Style that will trigger the fontSize path
        Style style = Style.builder()
                .buildFontSize(12) // Non-zero font size to trigger addNewSz()
                .build();
        
        // Invoke the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
