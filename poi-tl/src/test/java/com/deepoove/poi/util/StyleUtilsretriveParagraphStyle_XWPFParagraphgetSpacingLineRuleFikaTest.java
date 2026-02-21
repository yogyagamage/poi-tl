package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_XWPFParagraphgetSpacingLineRuleFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create a minimal DOCX document in memory
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (XWPFDocument doc = new XWPFDocument()) {
            // Create a paragraph with spacing
            XWPFParagraph paragraph = doc.createParagraph();
            
            // Set spacing between lines to trigger the target method call
            paragraph.setSpacingBetween(240.0); // 240 twips = 12 points
            
            // Write document to stream so paragraph gets proper CT objects
            doc.write(baos);
        }
        
        // Read the document back to get a paragraph with proper CT objects
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try (XWPFDocument doc = new XWPFDocument(bais)) {
            XWPFParagraph paragraph = doc.getParagraphs().get(0);
            
            // This will invoke paragraph.getSpacingLineRule() inside retriveParagraphStyle
            StyleUtils.retriveParagraphStyle(paragraph);
        }
    }
}
