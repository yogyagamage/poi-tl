package com.deepoove.poi.xwpf;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

class XWPFStructuredDocumentTaggetPart_IBodygetPartFikaTest {

    @Test
    void testGetPart() {
        CTSdtRun mockSdtRun = Mockito.mock(CTSdtRun.class);
        IBody mockPart = Mockito.mock(IBody.class);
        POIXMLDocumentPart mockDocumentPart = Mockito.mock(POIXMLDocumentPart.class);
        
        Mockito.when(mockPart.getPart()).thenReturn(mockDocumentPart);
        
        XWPFStructuredDocumentTag sdt = new XWPFStructuredDocumentTag(mockSdtRun, mockPart);
        sdt.getPart();
    }
}
