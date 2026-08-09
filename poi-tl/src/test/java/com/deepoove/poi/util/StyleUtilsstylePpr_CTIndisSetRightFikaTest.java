package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetRightFikaTest {

    @Test
    public void testStyleParagraphToCTIndIsSetRight() {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with indentRightChars to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentRightChars(2.0)
                .build();
        
        // Execute the entry point method
        StyleUtils.styleParagraph(paragraph, style);
    }
}
