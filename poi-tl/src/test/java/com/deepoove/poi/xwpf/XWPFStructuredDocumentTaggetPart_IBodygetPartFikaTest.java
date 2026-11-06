package com.deepoove.poi.xwpf;

import com.deepoove.poi.xwpf.XWPFStructuredDocumentTag;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class XWPFStructuredDocumentTaggetPart_IBodygetPartFikaTest {

    @Test
    public void testGetPartChain() throws Exception {
        // Create a real XWPFDocument which implements IBody
        XWPFDocument document = new XWPFDocument();
        
        // Create a real paragraph to add to the document
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Test");
        
        // Create the XWPFStructuredDocumentTag with the real document as the IBody
        XWPFStructuredDocumentTag sdt = new XWPFStructuredDocumentTag(
            paragraph.getCTP().addNewSdt(),
            document
        );
        
        // Invoke the entry point method - this should trigger the chain
        sdt.getPart();
    }
}
