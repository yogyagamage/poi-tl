package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetLeftFikaTest {

    @Test
    public void testStylePprInvokesCTIndUnsetLeft() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has CTP with PPr and Ind
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTInd indent = ppr.isSetInd() ? ppr.getInd() : ppr.addNewInd();
        
        // Set left attribute so that unsetLeft() will be called
        indent.setLeft(BigInteger.valueOf(1000));
        
        // Create ParagraphStyle with indentLeftChars to trigger the path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(5.0)
                .build();
        
        // Execute the entry point method
        StyleUtils.stylePpr(paragraph, style);
    }
}
