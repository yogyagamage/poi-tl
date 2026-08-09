package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

public class StyleUtilsstylePpr_CTPPrgetKeepLinesFikaTest {

    @Test
    public void testStylePprInvokesGetKeepLines() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with keepLines set to trigger the target call
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        // Invoke entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The call chain will reach CTPPr.getKeepLines() when style.getKeepLines() is not null
        // No assertions needed
    }
}
