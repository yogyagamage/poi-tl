package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetRightFikaTest {

    @Test
    public void testStylePprInvokesCTIndIsSetRight() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with indentRightChars to trigger the path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentRightChars(2.0)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
