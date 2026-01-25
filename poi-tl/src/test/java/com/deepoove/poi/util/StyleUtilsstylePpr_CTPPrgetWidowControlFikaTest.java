package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrgetWidowControlFikaTest {

    @Test
    public void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setWidowControl(true);
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
