package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

public class XWPFParagraphWrapperinsertNewAnchor_XWPFFieldRunsetFieldInstructionFikaTest {
    @Test
    public void testInsertNewAnchor() {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        wrapper.insertNewAnchor(0, "anchor");
    }
}
