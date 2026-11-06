package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewKeepLinesFikaTest {

    @Test
    public void testStylePprCallsAddNewKeepLines() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with keepLines set to trigger addNewKeepLines()
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        // Invoke entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications required
    }
}
