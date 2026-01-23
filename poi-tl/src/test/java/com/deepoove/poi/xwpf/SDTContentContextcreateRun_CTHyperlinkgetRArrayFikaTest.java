package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.IRunBody;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

class SDTContentContextcreateRun_CTHyperlinkgetRArrayFikaTest {

    @Test
    void testCreateRunInvokesGetRArray() throws Exception {
        // Create mock dependencies
        XWPFStructuredDocumentTagContent mockContent = Mockito.mock(XWPFStructuredDocumentTagContent.class);
        IRunBody mockRunBody = Mockito.mock(IRunBody.class);
        
        // Create real CTHyperlink object
        CTHyperlink ctHyperlink = CTHyperlink.Factory.newInstance();
        // Add at least one r element so getRArray(0) doesn't throw IndexOutOfBoundsException
        ctHyperlink.addNewR();
        
        // Create instance of class under test
        SDTContentContext context = new SDTContentContext(mockContent);
        
        // Call entry point method with CTHyperlink instance
        // This will trigger the path: createRun -> CTHyperlink.getRArray(0)
        XWPFRun result = context.createRun(ctHyperlink, mockRunBody);
    }
}
