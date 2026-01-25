package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndsetLeftCharsFikaTest {

    @Test
    public void testStylePprInvokesSetLeftChars() throws Exception {
        // Create a real XWPFDocument to ensure paragraph has proper context
        XWPFDocument document = new XWPFDocument();
        
        // Create a real paragraph within the document
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with indentLeftChars to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(2.0)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // Close the document to release resources
        document.close();
    }
}
