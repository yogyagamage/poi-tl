package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

public class XWPFTextboxContentsetParagraph_CTTxbxContentaddNewPFikaTest {

    @Test
    public void testSetParagraphInvokesAddNewP() throws Exception {
        // Create real CTTxbxContent that will be used in the constructor
        CTTxbxContent ctTxbxContent = CTTxbxContent.Factory.newInstance();
        
        // Mock dependencies that are not directly related to the target method call
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        IBody mockBody = Mockito.mock(IBody.class);
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        
        // Create instance of class under test using provided constructor
        XWPFTextboxContent textboxContent = new XWPFTextboxContent(
            ctTxbxContent, mockRun, mockBody, mockXmlObject
        );
        
        // Create a mock paragraph with a real CTP
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        CTP realCtp = CTP.Factory.newInstance();
        Mockito.when(mockParagraph.getCTP()).thenReturn(realCtp);
        
        // Execute the entry point method - this should trigger ctTxbxContent.addNewP()
        // when ctTxbxContent.sizeOfPArray() == 0
        textboxContent.setParagraph(mockParagraph);
    }
}
