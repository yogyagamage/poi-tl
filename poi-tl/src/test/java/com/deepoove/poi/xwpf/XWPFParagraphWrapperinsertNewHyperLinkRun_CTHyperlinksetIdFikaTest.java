package com.deepoove.poi.xwpf;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_CTHyperlinksetIdFikaTest {

    @Test
    public void test() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        
        wrapper.insertNewHyperLinkRun(0, "http://example.com");
        
        document.close();
    }
}
