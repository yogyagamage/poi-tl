package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdrisSetBottomFikaTest {

    @Test
    public void testStylePprInvokesCTPBdrIsSetBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
            .withBottomBorder(BorderStyle.builder().build())
            .build();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
