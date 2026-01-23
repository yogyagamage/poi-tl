package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetFirstLineFikaTest {

    @Test
    public void testStylePprInvokesIsSetFirstLine() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
            .withIndentFirstLineChars(2.0)
            .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
