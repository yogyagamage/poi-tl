package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewWordWrapFikaTest {

    @Test
    public void testStylePprInvokesAddNewWordWrap() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withAllowWordBreak(true)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
