package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleParaRpr_CTParaRPrgetSzArrayFikaTest {

    @Test
    public void testStyleParaRprTriggersGetSzArray() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = new Style();
        style.setFontSize(12);
        style.setFontFamily("Arial");
        style.setColor("000000");
        style.setBold(true);
        style.setItalic(false);
        style.setStrike(false);
        style.setUnderlinePatterns(null);
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
