package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentaddEmbeddData_OPCPackagecreatePartFikaTest {
    @Test
    public void testAddEmbeddDataInvokesCreatePart() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        byte[] embeddData = new byte[] {1, 2, 3};
        document.addEmbeddData(embeddData, "application/octet-stream", "/word/embeddings/test.bin");
    }
}
