package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBetweenFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBetween() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with spacing set to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withSpacing(12.5)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
