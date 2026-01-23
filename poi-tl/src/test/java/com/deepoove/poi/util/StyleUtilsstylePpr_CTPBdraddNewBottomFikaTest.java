package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdraddNewBottomFikaTest {

    @Test
    public void testStylePprInvokesAddNewBottom() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
            .withBottomBorder(BorderStyle.builder().build())
            .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
