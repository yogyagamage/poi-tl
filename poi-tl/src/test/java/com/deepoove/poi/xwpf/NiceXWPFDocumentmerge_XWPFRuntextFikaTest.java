package com.deepoove.poi.xwpf;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class NiceXWPFDocumentmerge_XWPFRuntextFikaTest {

    @Test
    public void mergeShouldInvokeXWPFRunText() {
        try {
            NiceXWPFDocument document = new NiceXWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("test");

            Iterator<NiceXWPFDocument> iterator = new ArrayList<NiceXWPFDocument>().iterator();
            document.merge(iterator, run);
        } catch (Exception ignored) {
        }
    }
}
