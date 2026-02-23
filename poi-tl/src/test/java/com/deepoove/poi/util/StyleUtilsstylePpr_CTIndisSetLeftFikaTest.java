package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetLeftFikaTest {

    @Test
    public void testStylePprInvokesIsSetLeft() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
            .withIndentLeftChars(2.0)
            .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
