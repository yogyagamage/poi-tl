package com.deepoove.poi.render.processor;

import com.deepoove.poi.xwpf.NiceXWPFDocument;
import com.deepoove.poi.xwpf.IdenifierManagerWrapper;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DrawingSupportupdateDocPrId_DocumentFactoryparseFikaTest {

    @Mock
    private NiceXWPFDocument mockDocument;
    
    @Mock
    private IdenifierManagerWrapper mockIdentifierManager;
    
    @Mock
    private XWPFRun mockRun;
    
    @Mock
    private CTR mockCTR;
    
    @Mock
    private CTDrawing mockCTDrawing;
    
    @Mock
    private XmlObject mockXmlObject;

    @Test
    public void testUpdateDocPrId() throws Exception {
        // Setup mock document and identifier manager
        when(mockDocument.getDocPrIdenifierManager()).thenReturn(mockIdentifierManager);
        when(mockIdentifierManager.isValid()).thenReturn(true);
        
        // Setup run and its CTR
        when(mockRun.getDocument()).thenReturn(mockDocument);
        when(mockRun.getCTR()).thenReturn(mockCTR);
        
        // Setup drawing list with one CTDrawing
        List<CTDrawing> drawingList = Collections.singletonList(mockCTDrawing);
        when(mockCTR.getDrawingList()).thenReturn(drawingList);
        
        // Setup XML objects for selectPath
        XmlObject[] xmlObjects = new XmlObject[]{mockXmlObject};
        when(mockCTR.selectPath(IdenifierManagerWrapper.XPATH_DRAWING)).thenReturn(xmlObjects);
        
        // Setup XML text that will trigger CTDrawing.Factory.parse()
        when(mockXmlObject.xmlText()).thenReturn("<xml>test</xml>");
        
        // Execute the entry point method
        DrawingSupport.updateDocPrId(mockRun);
    }
}
