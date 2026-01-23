package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.ooxml.POIXMLDocument;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PoitlIOUtilsdocToInputStream_POIXMLDocumentwriteFikaTest {

    @Test
    public void testDocToInputStream() throws IOException {
        // Create a real POIXMLDocument instance
        // Since POIXMLDocument is abstract, we need a concrete implementation
        // We'll use XWPFDocument which extends POIXMLDocument
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        org.apache.poi.xwpf.usermodel.XWPFDocument doc = 
            new org.apache.poi.xwpf.usermodel.XWPFDocument();
        
        // Add minimal content to make the document valid
        doc.createParagraph().createRun().setText("Test");
        
        // Call the entry point method which will invoke the third-party method
        InputStream result = PoitlIOUtils.docToInputStream(doc);
        
        // Close resources
        result.close();
        doc.close();
    }
}
