package com.deepoove.poi.util;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilsdocToInputStream_POIXMLDocumentwriteFikaTest {

    @Test
    public void testDocToInputStream() throws IOException {
        // Create a real POIXMLDocument instance
        ByteArrayOutputStream initialContent = new ByteArrayOutputStream();
        try (XWPFDocument doc = new XWPFDocument()) {
            // Add minimal content to make document valid
            doc.createParagraph().createRun().setText("test");
            doc.write(initialContent);
        }
        
        ByteArrayInputStream input = new ByteArrayInputStream(initialContent.toByteArray());
        XWPFDocument document = new XWPFDocument(input);
        
        // Invoke the method under test - this will trigger POIXMLDocument.write()
        PoitlIOUtils.docToInputStream(document);
        
        // Clean up
        document.close();
    }
}
