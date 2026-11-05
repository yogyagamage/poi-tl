package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

public class XWPFParagraphWrapperinsertNewRunAfter_XmlCursorbeginElementFikaTest {

    @Test
    void testInsertNewRunAfterReachesBeginElement() throws Exception {
        try (XWPFDocument document = new XWPFDocument()) {
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.createRun();
            paragraph.createRun();

            XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
            wrapper.insertNewRunAfter(0);
        }
    }
}
