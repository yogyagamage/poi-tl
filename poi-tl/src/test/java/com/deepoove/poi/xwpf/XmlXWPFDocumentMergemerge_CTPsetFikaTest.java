package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import java.util.Collections;
import java.util.Iterator;

public class XmlXWPFDocumentMergemerge_CTPsetFikaTest {

    @Test
    public void testMergeTriggersCTPSet() throws Exception {
        // Create required objects
        NiceXWPFDocument sourceDocument = new NiceXWPFDocument();
        XWPFRun run = createRun(sourceDocument);
        
        // Create empty iterator
        Iterator<NiceXWPFDocument> mergeIterator = Collections.<NiceXWPFDocument>emptyIterator();
        
        // Instantiate class under test using default constructor
        XmlXWPFDocumentMerge merger = new XmlXWPFDocumentMerge();
        
        // Call entry point method - this should trigger thirdPartyMethod
        merger.merge(sourceDocument, mergeIterator, run);
    }
    
    private XWPFRun createRun(NiceXWPFDocument document) {
        // Create a paragraph and get its first run
        XWPFParagraph paragraph = document.createParagraph();
        return paragraph.createRun();
    }
}
