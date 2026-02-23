package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrisSetKeepLinesFikaTest {

    @Test
    public void testStylePprTriggersIsSetKeepLines() throws Exception {
        // Create real XWPFParagraph with real CTP and CTPPr
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure CTPPr exists
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create ParagraphStyle with keepLines set to trigger the target path
        ParagraphStyle style = ParagraphStyle.builder()
                .withKeepLines(true)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The third-party method isSetKeepLines() will be invoked inside stylePpr
        // when checking if pr.isSetKeepLines() before calling pr.getKeepLines()
    }
}
