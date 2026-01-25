package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.apache.xmlbeans.XmlObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetLeftFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create a minimal XWPFDocument to get XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying CTP object
        CTP ctp = paragraph.getCTP();
        
        // Ensure PPr exists
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Ensure PBdr exists with Left border
        CTPBdr pBdr = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        CTBorder leftBorder = pBdr.addNewLeft();
        leftBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forString("single"));
        
        // This call should traverse the path and invoke CTPBdr.getLeft()
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
