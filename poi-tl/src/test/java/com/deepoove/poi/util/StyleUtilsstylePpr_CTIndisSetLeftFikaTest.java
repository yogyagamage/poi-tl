package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetLeftFikaTest {

    @Test
    public void testStylePprInvokesCTIndIsSetLeft() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with indentLeftChars to trigger the path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(2.5)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
