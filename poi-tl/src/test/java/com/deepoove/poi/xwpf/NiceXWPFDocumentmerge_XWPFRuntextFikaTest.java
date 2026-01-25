package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.util.Collections;
import java.util.Iterator;
import java.io.ByteArrayInputStream;

public class NiceXWPFDocumentmerge_XWPFRuntextFikaTest {

    @Test
    public void testMergePathToXWPFRunText() throws Exception {
        // Create a minimal valid DOCX document as input stream
        XWPFDocument baseDoc = new XWPFDocument();
        XWPFParagraph paragraph = baseDoc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("test");
        
        byte[] docBytes;
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            baseDoc.write(baos);
            docBytes = baos.toByteArray();
        }
        
        // Create NiceXWPFDocument using constructor that accepts InputStream
        NiceXWPFDocument niceDoc = new NiceXWPFDocument(new ByteArrayInputStream(docBytes));
        
        // Create another document for the iterator
        XWPFDocument otherDoc = new XWPFDocument();
        XWPFParagraph otherParagraph = otherDoc.createParagraph();
        XWPFRun otherRun = otherParagraph.createRun();
        otherRun.setText("other");
        
        byte[] otherDocBytes;
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            otherDoc.write(baos);
            otherDocBytes = baos.toByteArray();
        }
        
        NiceXWPFDocument otherNiceDoc = new NiceXWPFDocument(new ByteArrayInputStream(otherDocBytes));
        
        // Create iterator with the other document
        Iterator<NiceXWPFDocument> iterator = Collections.singletonList(otherNiceDoc).iterator();
        
        // Call the entry point method
        niceDoc.merge(iterator, run);
    }
}
