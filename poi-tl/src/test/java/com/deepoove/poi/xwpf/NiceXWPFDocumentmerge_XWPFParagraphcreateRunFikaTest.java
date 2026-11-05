package com.deepoove.poi.xwpf;

import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentmerge_XWPFParagraphcreateRunFikaTest {

    @Test
    public void testMergeReachesCreateRun() throws Exception {
        NiceXWPFDocument document = new NiceXWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();

        XWPFRun firstRun = paragraph.createRun();
        firstRun.setText("a");

        XWPFRun secondRun = paragraph.createRun();
        secondRun.setText("b");

        Iterator<NiceXWPFDocument> iterator = Collections.emptyIterator();
        document.merge(iterator, secondRun);
    }
}
