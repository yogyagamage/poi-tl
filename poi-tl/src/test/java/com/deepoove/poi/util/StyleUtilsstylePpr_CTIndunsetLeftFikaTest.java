package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetLeftFikaTest {

    @Test
    public void testStylePprInvokesUnsetLeft() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a ParagraphStyle with indentLeftChars set to trigger the unsetLeft() call
        ParagraphStyle style = new ParagraphStyle();
        style.setIndentLeftChars(1.5); // Non-null value will trigger the code path
        
        // Get the CTPPr and ensure it has an ind with left set to trigger unsetLeft
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = paragraph.getCTP();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ppr = ctp.isSetPPr() ? 
            ctp.getPPr() : ctp.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd indent = ppr.isSetInd() ? 
            ppr.getInd() : ppr.addNewInd();
        
        // Set left value to ensure isSetLeft() returns true and triggers unsetLeft()
        indent.setLeft(BigInteger.valueOf(720)); // Any non-null value
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The method call above should trigger indent.unsetLeft() internally
        // No assertions or verifications needed as per requirements
    }
}
