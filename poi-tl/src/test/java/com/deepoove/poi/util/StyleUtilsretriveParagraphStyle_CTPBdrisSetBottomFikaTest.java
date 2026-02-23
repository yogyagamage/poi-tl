package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_CTPBdrisSetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesIsSetBottom() throws Exception {
        // Create a real document with a paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying CTP object
        CTP ctp = paragraph.getCTP();
        
        // Ensure PPr exists
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Ensure PBdr exists and has bottom border set
        CTPBdr pBdr = ppr.isSetPBdr() ? ppr.getPBdr() : ppr.addNewPBdr();
        pBdr.addNewBottom();
        
        // This will trigger the call chain: retriveParagraphStyle -> ct.isSetBottom()
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // Clean up
        document.close();
    }
}
