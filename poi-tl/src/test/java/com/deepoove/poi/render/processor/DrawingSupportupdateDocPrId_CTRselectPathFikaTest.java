package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.IdenifierManagerWrapper;
import com.deepoove.poi.xwpf.NiceXWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class DrawingSupportupdateDocPrId_CTRselectPathFikaTest {

    @Test
    public void testUpdateDocPrId() throws Exception {
        DrawingSupport drawingSupport = new DrawingSupport();
        
        NiceXWPFDocument mockDocument = Mockito.mock(NiceXWPFDocument.class);
        IdenifierManagerWrapper mockManager = Mockito.mock(IdenifierManagerWrapper.class);
        Mockito.when(mockDocument.getDocPrIdenifierManager()).thenReturn(mockManager);
        Mockito.when(mockManager.isValid()).thenReturn(true);
        
        CTR mockCTR = Mockito.mock(CTR.class);
        Mockito.when(mockCTR.getDrawingList()).thenReturn(java.util.Collections.emptyList());
        
        XmlObject[] mockXmlObjects = new XmlObject[1];
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        Mockito.when(mockXmlObject.xmlText()).thenReturn("<xml/>");
        mockXmlObjects[0] = mockXmlObject;
        
        Mockito.when(mockCTR.selectPath(Mockito.anyString())).thenReturn(mockXmlObjects);
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        Mockito.when(mockRun.getDocument()).thenReturn(mockDocument);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCTR);
        
        DrawingSupport.updateDocPrId(mockRun);
    }
}
