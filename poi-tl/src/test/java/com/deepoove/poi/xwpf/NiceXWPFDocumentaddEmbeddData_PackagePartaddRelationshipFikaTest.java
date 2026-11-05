package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentaddEmbeddData_PackagePartaddRelationshipFikaTest {

    @Test
    void testAddEmbeddDataInvokesPackagePartAddRelationship() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        byte[] embeddData = new byte[] { 1 };
        String contentType = "application/vnd.openxmlformats-officedocument.oleObject";
        String part = "/embeddings/oleObject1.bin";
        document.addEmbeddData(embeddData, contentType, part);
    }
}
