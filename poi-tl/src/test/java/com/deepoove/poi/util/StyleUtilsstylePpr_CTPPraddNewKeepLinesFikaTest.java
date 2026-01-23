package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewKeepLinesFikaTest {

    @Test
    public void testStylePprInvokesAddNewKeepLines() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with keepLines set to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
