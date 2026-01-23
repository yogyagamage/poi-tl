package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class NiceXWPFDocumentinsertNewParagraph_XWPFParagraphmethodFikaTest {

    @Test
    public void testInsertNewParagraph() throws Exception {
        // Create a minimal valid DOCX content to avoid NotOfficeXmlFileException
        byte[] docxBytes = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Get the document body and create a cursor at the beginning
        CTBody body = document.getDocument().getBody();
        XmlCursor cursor = body.newCursor();
        
        // Move cursor to a position where isCursorInBody will return true
        cursor.toFirstContentToken();
        
        // Call the entry point method
        document.insertNewParagraph(cursor);
        
        // Clean up
        cursor.dispose();
        document.close();
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal valid DOCX file in memory
        // This avoids the NotOfficeXmlFileException by providing proper DOCX structure
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            try (org.apache.poi.xwpf.usermodel.XWPFDocument tempDoc = new org.apache.poi.xwpf.usermodel.XWPFDocument()) {
                // Add minimal required content
                tempDoc.createParagraph();
                tempDoc.write(baos);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty array if creation fails
            return new byte[0];
        }
    }
}
