package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import com.deepoove.poi.xwpf.NiceXWPFDocument;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.Iterator;

public class XmlXWPFDocumentMergemerge_CTPsetFikaTest {

    @Test
    public void testMerge() throws Exception {
        XmlXWPFDocumentMerge merge = new XmlXWPFDocumentMerge();
        
        byte[] docxBytes = createMinimalDocx();
        NiceXWPFDocument sourceDoc = new NiceXWPFDocument(new ByteArrayInputStream(docxBytes));
        
        NiceXWPFDocument mergeDoc = new NiceXWPFDocument(new ByteArrayInputStream(docxBytes));
        Iterator<NiceXWPFDocument> mergeIterator = Collections.singletonList(mergeDoc).iterator();
        
        XWPFParagraph paragraph = sourceDoc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("test");
        
        merge.merge(sourceDoc, mergeIterator, run);
    }
    
    private byte[] createMinimalDocx() {
        XWPFDocument doc = new XWPFDocument();
        doc.createParagraph().createRun().setText("test");
        
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            doc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
