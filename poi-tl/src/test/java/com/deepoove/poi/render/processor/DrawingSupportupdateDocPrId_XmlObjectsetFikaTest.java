package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.NiceXWPFDocument;
import com.deepoove.poi.xwpf.IdenifierManagerWrapper;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class DrawingSupportupdateDocPrId_XmlObjectsetFikaTest {

    @Test
    public void testUpdateDocPrId() throws Exception {
        // Create mock NiceXWPFDocument with valid identifier manager
        NiceXWPFDocument mockDocument = Mockito.mock(NiceXWPFDocument.class);
        IdenifierManagerWrapper mockManager = Mockito.mock(IdenifierManagerWrapper.class);
        Mockito.when(mockDocument.getDocPrIdenifierManager()).thenReturn(mockManager);
        Mockito.when(mockManager.isValid()).thenReturn(true);
        
        // Create mock CTR with drawing list
        CTR mockCtr = Mockito.mock(CTR.class);
        CTDrawing mockCtDrawing = Mockito.mock(CTDrawing.class);
        Mockito.when(mockCtr.getDrawingList()).thenReturn(Collections.singletonList(mockCtDrawing));
        
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        Mockito.when(mockRun.getDocument()).thenReturn(mockDocument);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCtr);
        
        // Create mock XmlObject that will be used in selectPath
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        Mockito.when(mockXmlObject.xmlText()).thenReturn("<xml>test</xml>");
        Mockito.when(mockCtr.selectPath(IdenifierManagerWrapper.XPATH_DRAWING))
               .thenReturn(new XmlObject[]{mockXmlObject});
        
        // Execute the entry point method
        DrawingSupport.updateDocPrId(mockRun);
        
        // The test will invoke XmlObject.set() through the execution path
        // No assertions needed as per requirements
    }
}
