package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_PackagePartaddExternalRelationshipFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        wrapper.insertNewHyperLinkRun(0, "http://www.example.com");
    }
}
