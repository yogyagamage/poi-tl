package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.junit.jupiter.api.Test;

public class StyleUtilsstylePpr_CTPBdrisSetTopFikaTest {

    @Test
    public void testStylePprInvokesCTPBdrIsSetTop() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withTopBorder(BorderStyle.builder().build())
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
