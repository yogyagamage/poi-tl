package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class NiceXWPFDocumentaddEmbeddData_PackagePartaddRelationshipFikaTest {

    @Test
    public void testAddEmbeddData() throws Exception {
        // Create a valid XWPFDocument first to ensure proper OPCPackage initialization
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (XWPFDocument doc = new XWPFDocument()) {
            doc.createParagraph().createRun().setText("Test");
            doc.write(out);
        }
        
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        NiceXWPFDocument niceDoc = new NiceXWPFDocument(in);
        
        byte[] embeddData = new byte[]{1, 2, 3, 4};
        String contentType = "application/octet-stream";
        String part = "/embeddings/test.bin";
        
        niceDoc.addEmbeddData(embeddData, contentType, part);
    }
}
