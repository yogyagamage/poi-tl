package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBetweenFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBetween() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withSpacing(12.5)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
