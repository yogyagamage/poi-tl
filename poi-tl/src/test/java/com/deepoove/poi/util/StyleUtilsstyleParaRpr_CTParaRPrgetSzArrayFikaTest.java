package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

import java.math.BigDecimal;

public class StyleUtilsstyleParaRpr_CTParaRPrgetSzArrayFikaTest {

    @Test
    public void testStyleParaRprPathToGetSzArray() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create Style with font size to trigger the getSzArray path
        Style style = Style.builder()
                .buildFontSize(12)
                .build();
        
        // This will traverse through:
        // 1. StyleUtils.styleParaRpr(XWPFParagraph, Style)
        // 2. StyleUtils.styleParaRpr(CTParaRPr, Style)
        // 3. CTParaRPr.getSzArray(0) when pr.sizeOfSzArray() > 0
        StyleUtils.styleParaRpr(paragraph, style);
        
        // Clean up
        document.close();
    }
}
