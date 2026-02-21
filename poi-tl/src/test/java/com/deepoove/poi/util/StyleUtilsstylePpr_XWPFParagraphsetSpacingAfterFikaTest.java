package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingAfterFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingAfter() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withSpacingAfter(12.0)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
