package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFEndnotes;
import org.apache.poi.xwpf.usermodel.XWPFEndnote;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class XmlXWPFDocumentMergemergeEndnote_CTFtnEdnsetIdFikaTest {

    @Test
    public void testMergePathToSetId() throws Exception {
        XmlXWPFDocumentMerge merge = new XmlXWPFDocumentMerge();
        
        NiceXWPFDocument sourceDoc = new NiceXWPFDocument();
        NiceXWPFDocument mergeDoc = new NiceXWPFDocument();
        
        XWPFParagraph paragraph = sourceDoc.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Test");
        
        XWPFEndnotes endnotes = mergeDoc.createEndnotes();
        XWPFEndnote endnote = endnotes.createEndnote();
        endnote.getCTFtnEdn().setId(BigInteger.ONE);
        
        List<NiceXWPFDocument> docs = Arrays.asList(mergeDoc);
        Iterator<NiceXWPFDocument> iterator = docs.iterator();
        
        merge.merge(sourceDoc, iterator, run);
        
        sourceDoc.close();
        mergeDoc.close();
    }
}
