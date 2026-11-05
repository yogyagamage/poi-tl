package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrgetWidowControlFikaTest {

    @Test
    public void testStylePprInvokesGetWidowControl() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Test paragraph");
        
        // Ensure paragraph has CTP with PPr
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create ParagraphStyle with widowControl set to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withWidowControl(true)
                .build();
        
        // Execute entry point - this should trigger pr.getWidowControl() 
        // when style.getWidowControl() is not null
        StyleUtils.stylePpr(paragraph, style);
        
        // Clean up
        document.close();
    }
}
