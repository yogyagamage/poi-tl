package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewKeepLinesFikaTest {

    @Test
    public void test() throws Exception {
        StyleUtils instance = new StyleUtils();
        
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
