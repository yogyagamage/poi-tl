package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;

public class StyleUtilsstylePpr_CTPPraddNewShdFikaTest {

    @Test
    public void testStylePprInvokesAddNewShd() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withBackgroundColor("FF0000")
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
