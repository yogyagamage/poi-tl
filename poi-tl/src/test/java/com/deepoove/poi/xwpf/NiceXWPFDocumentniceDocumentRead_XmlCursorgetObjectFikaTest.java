package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.apache.xmlbeans.XmlObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NiceXWPFDocumentniceDocumentRead_XmlCursorgetObjectFikaTest {

    @Test
    public void test() throws IOException {
        // Create a minimal DOCX document with structured content controls
        XWPFDocument doc = new XWPFDocument();
        
        // Create a structured document tag (SDT) block
        CTSdtBlock sdtBlock = doc.getDocument().getBody().addNewSdt();
        CTSdtPr sdtPr = sdtBlock.addNewSdtPr();
        CTString tag = sdtPr.addNewTag();
        tag.setVal("TestTag");
        CTSdtContentBlock content = sdtBlock.addNewSdtContent();
        CTP p = content.addNewP();
        CTR r = p.addNewR();
        r.addNewT().setStringValue("Test content");
        
        // Write to input stream
        byte[] docBytes;
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            doc.write(baos);
            docBytes = baos.toByteArray();
        }
        
        InputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument with adjustDoc=true to ensure niceDocumentRead() is called
        NiceXWPFDocument niceDoc = new NiceXWPFDocument(inputStream, true);
    }
}
