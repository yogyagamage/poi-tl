package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetHangingFikaTest {

    @Test
    public void testStylePprInvokesIsSetHanging() throws Exception {
        // Create real XWPFParagraph with real backing objects
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with hanging indent to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentHangingChars(2.0)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions or verifications - test passes if no exceptions
    }
}
