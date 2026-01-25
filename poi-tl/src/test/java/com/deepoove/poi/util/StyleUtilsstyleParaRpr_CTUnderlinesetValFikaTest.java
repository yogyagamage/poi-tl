package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyleUtilsstyleParaRpr_CTUnderlinesetValFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        // Create a real XWPFDocument and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a Style with underline pattern to trigger the target method
        Style style = new Style();
        style.setUnderlinePatterns(UnderlinePatterns.SINGLE);
        style.setUnderlineColor("000000");
        style.setColor("FF0000");
        style.setItalic(true);
        style.setBold(true);
        style.setFontSize(12);
        style.setStrike(true);
        style.setFontFamily("Arial");
        style.setWesternFontFamily("Times New Roman");
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
        
        // Clean up
        document.close();
    }
}
