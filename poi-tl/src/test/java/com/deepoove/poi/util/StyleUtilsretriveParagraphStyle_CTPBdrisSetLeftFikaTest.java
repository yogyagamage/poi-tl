package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrisSetLeftFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrIsSetLeft() throws Exception {
        // Create a real XWPFDocument to get real XWPFParagraph objects
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Ensure the paragraph has CTP with PPr and PBdr
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create and set PBdr to ensure isSetPBdr() returns true
        CTPBdr pBdr = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        
        // Add left border to ensure isSetLeft() returns true
        pBdr.addNewLeft();
        
        // Call the entry point method - this should traverse to CTPBdr.isSetLeft()
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // Clean up
        document.close();
    }
}
