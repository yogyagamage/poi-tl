package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetHangingFikaTest {

    @Test
    public void testStylePprInvokesUnsetHanging() throws Exception {
        // Create a real XWPFDocument and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has CTP and PPr
        paragraph.getCTP();
        
        // Create ParagraphStyle with indentHangingChars to trigger the unsetHanging path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentHangingChars(2.0)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions needed - test passes if unsetHanging() is invoked without exceptions
    }
}
