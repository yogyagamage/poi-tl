package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentaddEmbeddData_PackagePartaddRelationshipFikaTest {

    @Test
    public void testAddEmbeddData() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        byte[] embeddData = new byte[] { 0x00 };
        document.addEmbeddData(embeddData, "application/octet-stream", "/embeddings/oleObject1.bin");
    }
}
