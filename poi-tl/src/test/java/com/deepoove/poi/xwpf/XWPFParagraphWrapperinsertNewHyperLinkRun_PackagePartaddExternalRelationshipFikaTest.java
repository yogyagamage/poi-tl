package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_PackagePartaddExternalRelationshipFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        wrapper.insertNewHyperLinkRun(0, "https://example.com");
        
        document.close();
    }
}
