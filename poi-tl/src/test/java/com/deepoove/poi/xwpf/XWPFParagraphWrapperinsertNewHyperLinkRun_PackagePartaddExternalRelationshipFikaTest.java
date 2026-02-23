package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

public class XWPFParagraphWrapperinsertNewHyperLinkRun_PackagePartaddExternalRelationshipFikaTest {

    @Test
    public void testInsertNewHyperLinkRun() throws Exception {
        // Create a real XWPFDocument to get real PackagePart
        XWPFDocument document = new XWPFDocument();
        
        // Create a real paragraph from the document
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create the wrapper with the real paragraph
        XWPFParagraphWrapper wrapper = new XWPFParagraphWrapper(paragraph);
        
        // Add some initial text to ensure there's at least one run
        paragraph.createRun().setText("Initial text");
        
        // Call the entry point method with a valid hyperlink
        // This should trigger the PackagePart.addExternalRelationship call
        XWPFHyperlinkRun result = wrapper.insertNewHyperLinkRun(0, "https://example.com");
        
        // Clean up
        document.close();
    }
}
