package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class XWPFParagraphWrapperinsertNewBookmark_CTBookmarksetIdFikaTest {

    @Test
    void testInsertNewBookmark() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("bookmark");

        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        wrapper.insertNewBookmark(run);
    }
}
