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
import java.util.ArrayList;
import java.util.List;

public class DrawingSupportupdateDocPrId_XmlObjectsetFikaTest {

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
        
        List<CTDrawing> drawingList = new ArrayList<>();
        CTDrawing mockCtDrawing = Mockito.mock(CTDrawing.class);
        drawingList.add(mockCtDrawing);
        Mockito.when(mockCtr.getDrawingList()).thenReturn(drawingList);
        
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        XmlObject[] xmlObjects = new XmlObject[]{mockXmlObject};
        
        Mockito.when(mockCtr.selectPath(Mockito.anyString())).thenReturn(xmlObjects);
        Mockito.when(mockXmlObject.xmlText()).thenReturn("<xml>test</xml>");
        
        CTDrawing parsedDrawing = CTDrawing.Factory.newInstance();
        Mockito.when(mockCtDrawing.xmlText()).thenReturn("<xml>test</xml>");
        
        DrawingSupport.updateDocPrId(mockRun);
    }
}
