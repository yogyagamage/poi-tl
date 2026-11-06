package com.deepoove.poi.xwpf;

import java.util.Collections;
import java.util.Iterator;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class XmlXWPFDocumentMergemergeNamespaces_XmlCursorgetAllNamespacesFikaTest {

    @Test
    public void test() throws Exception {
        NiceXWPFDocument source = new NiceXWPFDocument();
        NiceXWPFDocument mergeDocument = new NiceXWPFDocument();

        source.createStyles();
        mergeDocument.createStyles();

        XWPFParagraph paragraph = source.createParagraph();
        XWPFRun run = paragraph.createRun();

        Iterator<NiceXWPFDocument> iterator = Collections.singletonList(mergeDocument).iterator();

        XmlXWPFDocumentMerge merge = new XmlXWPFDocumentMerge();
        try {
            merge.merge(source, iterator, run);
        } catch (Exception e) {
        }
    }
}
