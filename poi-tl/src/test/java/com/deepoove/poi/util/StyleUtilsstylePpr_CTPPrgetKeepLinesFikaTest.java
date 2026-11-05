package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrgetKeepLinesFikaTest {

    @Test
    public void testStylePprToGetKeepLines() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with keepLines set to trigger the target method call
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications - just ensure the method chain executes
        document.close();
    }
}
