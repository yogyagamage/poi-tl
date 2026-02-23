package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_STHexColorgetStringValueFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesSTHexColorGetStringValue() throws Exception {
        // Create a minimal Word document with a paragraph containing shading
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Get the underlying XML objects
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Add shading with fill color to trigger the target method call
        CTShd shd = ppr.addNewShd();
        shd.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd.CLEAR);
        shd.setFill("FF0000"); // This will create an STHexColor object
        
        // Execute the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
        
        // Clean up
        document.close();
    }
}
