package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBetweenFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBetween() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withSpacing(1.5)
                .withSpacingRule(LineSpacingRule.AUTO)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
