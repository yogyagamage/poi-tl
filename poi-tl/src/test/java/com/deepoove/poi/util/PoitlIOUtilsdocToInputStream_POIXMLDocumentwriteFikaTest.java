package com.deepoove.poi.util;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilsdocToInputStream_POIXMLDocumentwriteFikaTest {

    @Test
    public void testDocToInputStreamTriggersWrite() throws IOException {
        // Create a real POIXMLDocument instance
        // XWPFDocument is a concrete implementation of POIXMLDocument
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             XWPFDocument doc = new XWPFDocument()) {
            
            // Add minimal content to make document valid
            doc.createParagraph().createRun().setText("test");
            
            // This will trigger the call chain:
            // PoitlIOUtils.docToInputStream(doc) -> doc.write(OutputStream)
            PoitlIOUtils.docToInputStream(doc);
        }
    }
}
