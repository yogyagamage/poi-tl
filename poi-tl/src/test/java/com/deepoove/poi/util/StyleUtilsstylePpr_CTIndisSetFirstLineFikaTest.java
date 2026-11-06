package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetFirstLineFikaTest {

    @Test
    public void testStylePprInvokesIsSetFirstLine() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with indentFirstLineChars to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentFirstLineChars(2.0)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications - test passes if no exceptions
    }
}
