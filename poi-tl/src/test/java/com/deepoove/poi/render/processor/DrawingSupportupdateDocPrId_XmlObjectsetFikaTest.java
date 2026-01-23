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

import java.util.Collections;

class DrawingSupportupdateDocPrId_XmlObjectsetFikaTest {

    @Test
    void test() throws Exception {
        DrawingSupport drawingSupport = new DrawingSupport();
        
        NiceXWPFDocument mockDocument = Mockito.mock(NiceXWPFDocument.class);
        IdenifierManagerWrapper mockManager = Mockito.mock(IdenifierManagerWrapper.class);
        Mockito.when(mockDocument.getDocPrIdenifierManager()).thenReturn(mockManager);
        Mockito.when(mockManager.isValid()).thenReturn(true);
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        Mockito.when(mockRun.getDocument()).thenReturn(mockDocument);
        
        CTR mockCtr = Mockito.mock(CTR.class);
        Mockito.when(mockRun.getCTR()).thenReturn(mockCtr);
        
        CTDrawing mockCtDrawing = CTDrawing.Factory.newInstance();
        Mockito.when(mockCtr.getDrawingList()).thenReturn(Collections.singletonList(mockCtDrawing));
        
        XmlObject mockXmlObject = Mockito.mock(XmlObject.class);
        Mockito.when(mockXmlObject.xmlText()).thenReturn("<xml/>");
        Mockito.when(mockCtr.selectPath(IdenifierManagerWrapper.XPATH_DRAWING))
               .thenReturn(new XmlObject[]{mockXmlObject});
        
        drawingSupport.updateDocPrId(mockRun);
    }
}
