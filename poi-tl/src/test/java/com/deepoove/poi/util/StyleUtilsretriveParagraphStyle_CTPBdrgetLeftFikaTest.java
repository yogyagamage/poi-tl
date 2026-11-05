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

public class StyleUtilsretriveParagraphStyle_CTPBdrgetLeftFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetLeft() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying CTP object
        CTP ctp = paragraph.getCTP();
        
        // Ensure PPr exists
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create real border object and set it
        CTPBdr border = ppr.addNewPBdr();
        CTBorder leftBorder = border.addNewLeft();
        
        // Invoke the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
