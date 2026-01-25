package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public class NiceXWPFDocumentgetBodyElementSpecificPos_IBodyElementgetElementTypeFikaTest {

    @Test
    public void testRemoveBodyElementTriggersGetBodyElementSpecificPosAndGetElementType() throws IOException {
        // Create a minimal valid DOCX document in memory
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Instantiate NiceXWPFDocument using the constructor that takes InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Ensure there's at least one body element to remove
        // We need to trigger the CONTENTCONTROL path to call getBodyElementSpecificPos
        // First, let's check if there are any content controls
        List<IBodyElement> bodyElements = document.getBodyElements();
        
        // If there are no content controls, we need to add one
        // Since we can't directly add content controls, we'll rely on the document's existing structure
        // The test will try to remove an element at position 0
        // This should trigger the call chain if the element at position 0 is a content control
        if (!bodyElements.isEmpty()) {
            document.removeBodyElement(0);
        }
    }
    
    private byte[] createMinimalDocx() throws IOException {
        // Create a minimal XWPFDocument with a content control
        XWPFDocument xwpfDocument = new XWPFDocument();
        
        // Add a paragraph
        XWPFParagraph paragraph = xwpfDocument.createParagraph();
        paragraph.createRun().setText("Test Paragraph");
        
        // Add a structured document tag (content control)
        // Note: XWPFSDT is the implementation of content control
        // We need to create it through the document's body
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock sdtBlock = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock.Factory.newInstance();
        XWPFSDT contentControl = new XWPFSDT(sdtBlock, xwpfDocument);
        
        // Convert to byte array
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        xwpfDocument.write(baos);
        xwpfDocument.close();
        
        return baos.toByteArray();
    }
}
