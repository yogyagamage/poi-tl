package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrgetKeepLinesFikaTest {

    @Test
    public void testStylePprToGetKeepLines() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
