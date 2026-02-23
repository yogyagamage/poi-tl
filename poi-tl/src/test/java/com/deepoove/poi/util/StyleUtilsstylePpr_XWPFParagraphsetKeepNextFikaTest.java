package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetKeepNextFikaTest {

    @Test
    public void testStylePprInvokesSetKeepNext() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with keepNext set to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepNext(true)
                .build();
        
        // Invoke entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications required
        document.close();
    }
}
