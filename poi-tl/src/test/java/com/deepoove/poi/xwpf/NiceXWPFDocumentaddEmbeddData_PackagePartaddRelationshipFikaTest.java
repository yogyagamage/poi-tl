package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NiceXWPFDocumentaddEmbeddData_PackagePartaddRelationshipFikaTest {

    @Test
    public void testAddEmbeddData() throws InvalidFormatException, IOException {
        // Create a minimal valid DOCX input stream
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Prepare parameters for addEmbeddData
        byte[] embeddData = new byte[] { 1, 2, 3, 4 };
        String contentType = "application/octet-stream";
        String part = "/embeddings/data.bin";
        
        // Call the entry point method which should trigger the third-party method
        document.addEmbeddData(embeddData, contentType, part);
    }
    
    private byte[] createMinimalDocx() throws IOException {
        // Create a minimal XWPFDocument and convert to bytes
        XWPFDocument minimalDoc = new XWPFDocument();
        minimalDoc.createParagraph().createRun().setText("Test");
        
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        minimalDoc.write(baos);
        minimalDoc.close();
        
        return baos.toByteArray();
    }
}
