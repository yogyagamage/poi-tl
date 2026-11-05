package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_CTHyperlinksetIdFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        // Create real document and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create wrapper with real paragraph
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        
        // Invoke the entry point method
        wrapper.insertNewHyperLinkRun(0, "https://example.com");
    }
}
