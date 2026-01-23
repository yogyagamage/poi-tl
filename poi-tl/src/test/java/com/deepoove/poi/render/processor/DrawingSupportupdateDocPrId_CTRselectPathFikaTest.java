package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.IdenifierManagerWrapper;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class DrawingSupportupdateDocPrId_CTRselectPathFikaTest {

    @Test
    public void testUpdateDocPrId() throws Exception {
        DrawingSupport drawingSupport = new DrawingSupport();
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        NiceXWPFDocument mockDocument = Mockito.mock(NiceXWPFDocument.class);
        IdenifierManagerWrapper mockManager = Mockito.mock(IdenifierManagerWrapper.class);
        CTR mockCtr = Mockito.mock(CTR.class);
        
        Mockito.when(mockRun.getDocument()).thenReturn(mockDocument);
        Mockito.when(mockDocument.getDocPrIdenifierManager()).thenReturn(mockManager);
        Mockito.when(mockManager.isValid()).thenReturn(true);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCtr);
        
        XmlObject[] xmlObjects = new XmlObject[1];
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        xmlObjects[0] = mockXmlObject;
        
        Mockito.when(mockCtr.selectPath(Mockito.anyString())).thenReturn(xmlObjects);
        Mockito.when(mockXmlObject.xmlText()).thenReturn("<xml>drawing</xml>");
        
        DrawingSupport.updateDocPrId(mockRun);
    }
}
