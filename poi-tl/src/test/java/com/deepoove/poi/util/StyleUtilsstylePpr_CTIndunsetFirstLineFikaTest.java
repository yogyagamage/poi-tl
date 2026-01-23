package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetFirstLineFikaTest {

    @Test
    public void testStylePprInvokesUnsetFirstLine() throws Exception {
        // Create real XWPFParagraph with real backing objects
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure paragraph has CTP with PPr and Ind
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTInd indent = ppr.isSetInd() ? ppr.getInd() : ppr.addNewInd();
        
        // Set FirstLine to ensure unsetFirstLine() will be called
        indent.setFirstLine(BigInteger.valueOf(100));
        
        // Create ParagraphStyle with indentFirstLineChars to trigger the path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentFirstLineChars(10.0)
                .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // No assertions - test passes if unsetFirstLine() is invoked without exceptions
    }
}
