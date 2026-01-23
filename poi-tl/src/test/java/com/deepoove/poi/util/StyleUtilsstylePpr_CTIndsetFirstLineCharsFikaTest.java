package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndsetFirstLineCharsFikaTest {

    @Test
    public void testStylePprInvokesSetFirstLineChars() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentFirstLineChars(2.5)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
