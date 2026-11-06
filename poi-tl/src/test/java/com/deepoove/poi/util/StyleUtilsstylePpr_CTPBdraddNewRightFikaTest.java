package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdraddNewRightFikaTest {

    @Test
    public void testStylePprInvokesAddNewRight() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withRightBorder(BorderStyle.builder().build())
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
