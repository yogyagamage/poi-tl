package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndsetLeftCharsFikaTest {

    @Test
    public void testStylePprInvokesSetLeftChars() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with indentLeftChars to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(2.0)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
}
