package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBeforeFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBefore() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withSpacingBefore(12.0)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
