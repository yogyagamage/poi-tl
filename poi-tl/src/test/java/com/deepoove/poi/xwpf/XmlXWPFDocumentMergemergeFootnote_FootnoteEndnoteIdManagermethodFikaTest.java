package com.deepoove.poi.xwpf;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.FootnoteEndnoteIdManager;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlXWPFDocumentMergemergeFootnote_FootnoteEndnoteIdManagermethodFikaTest {

    @Test
    public void test() throws Exception {
        XmlXWPFDocumentMerge instance = new XmlXWPFDocumentMerge();
        
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        XWPFDocument doc1 = new XWPFDocument();
        doc1.createParagraph().createRun().setText("Source");
        doc1.write(baos1);
        NiceXWPFDocument source = new NiceXWPFDocument(new ByteArrayInputStream(baos1.toByteArray()));
        
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        XWPFDocument doc2 = new XWPFDocument();
        XWPFParagraph paragraph = doc2.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Merge");
        doc2.write(baos2);
        NiceXWPFDocument mergeDoc = new NiceXWPFDocument(new ByteArrayInputStream(baos2.toByteArray()));
        
        List<NiceXWPFDocument> mergeList = new ArrayList<>();
        mergeList.add(mergeDoc);
        Iterator<NiceXWPFDocument> mergeIterator = mergeList.iterator();
        
        instance.merge(source, mergeIterator, run);
    }
}
