package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetRightFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetRight() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying CTP object
        CTP ctp = paragraph.getCTP();
        
        // Ensure PPr exists
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create and set PBdr
        CTPBdr pBdr = ppr.addNewPBdr();
        
        // Create and set right border to ensure ct.isSetRight() returns true
        CTBorder rightBorder = pBdr.addNewRight();
        rightBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        // This will invoke the chain: retriveParagraphStyle -> ct.getRight()
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // Clean up
        document.close();
    }
}
