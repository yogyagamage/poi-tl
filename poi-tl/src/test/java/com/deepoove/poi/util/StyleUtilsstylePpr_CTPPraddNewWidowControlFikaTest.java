package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;

public class StyleUtilsstylePpr_CTPPraddNewWidowControlFikaTest {

    @Test
    public void testStylePprInvokesAddNewWidowControl() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withWidowControl(true)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
