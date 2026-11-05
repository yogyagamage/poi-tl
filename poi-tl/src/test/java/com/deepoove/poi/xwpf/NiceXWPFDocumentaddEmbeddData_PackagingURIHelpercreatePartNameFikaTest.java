package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentaddEmbeddData_PackagingURIHelpercreatePartNameFikaTest {

    @Test
    public void testAddEmbeddData() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        document.addEmbeddData(new byte[] { 1 }, "application/octet-stream", "/word/embeddings/oleObject1.bin");
    }
}
