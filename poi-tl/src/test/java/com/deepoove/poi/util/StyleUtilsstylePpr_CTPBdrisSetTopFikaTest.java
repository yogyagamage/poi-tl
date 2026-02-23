package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdrisSetTopFikaTest {

    @Test
    public void testStylePprInvokesCTPBdrIsSetTop() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure paragraph has CTP with PPr
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create paragraph style with top border to trigger the path
        ParagraphStyle style = ParagraphStyle.builder()
                .withTopBorder(BorderStyle.builder().build())
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions - test passes if no exceptions are thrown
    }
}
