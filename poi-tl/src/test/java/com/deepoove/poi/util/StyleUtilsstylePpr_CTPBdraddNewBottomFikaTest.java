package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.junit.jupiter.api.Test;

public class StyleUtilsstylePpr_CTPBdraddNewBottomFikaTest {

    @Test
    public void testStyleParagraphToCTPBdrAddNewBottom() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create ParagraphStyle with bottom border to trigger CTPBdr.addNewBottom()
        ParagraphStyle style = ParagraphStyle.builder()
                .withBottomBorder(new BorderStyle())
                .build();
        
        // Invoke entry point method
        StyleUtils.styleParagraph(paragraph, style);
    }
}
