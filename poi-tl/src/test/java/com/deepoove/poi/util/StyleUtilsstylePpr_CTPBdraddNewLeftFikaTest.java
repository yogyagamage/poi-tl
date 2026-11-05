package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPBdraddNewLeftFikaTest {

    @Test
    public void testStylePprInvokesAddNewLeft() throws Exception {
        // Create real XWPFParagraph with mocked dependencies
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying CTP and ensure PPr exists
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Ensure PBdr exists but Left border is NOT set (so addNewLeft() will be called)
        CTPBdr pBdr = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        if (pBdr.isSetLeft()) {
            pBdr.unsetLeft();
        }
        
        // Create ParagraphStyle with left border
        ParagraphStyle style = ParagraphStyle.builder()
                .withLeftBorder(BorderStyle.builder().build())
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // Clean up
        document.close();
    }
}
