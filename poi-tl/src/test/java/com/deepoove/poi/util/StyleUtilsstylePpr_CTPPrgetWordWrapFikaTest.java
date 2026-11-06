package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

public class StyleUtilsstylePpr_CTPPrgetWordWrapFikaTest {

    @Test
    public void testStylePprTriggersGetWordWrap() throws Exception {
        // Create a real XWPFParagraph with underlying XML structures
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has the required CTP and CTPPr
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create a ParagraphStyle that will trigger the getWordWrap() call
        ParagraphStyle style = ParagraphStyle.builder()
                .withAllowWordBreak(true)  // This triggers the getWordWrap() path
                .build();
        
        // Invoke the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The test will execute through the full chain:
        // 1. StyleUtils.stylePpr(paragraph, style)
        // 2. Inside stylePpr: if (null != style.getAllowWordBreak())
        // 3. pr.isSetWordWrap() ? pr.getWordWrap() : pr.addNewWordWrap()
        // 4. This triggers getWordWrap() on the CTPPr object
        // No assertions needed - goal is just to reach the third-party method call
        
        document.close();
    }
}
