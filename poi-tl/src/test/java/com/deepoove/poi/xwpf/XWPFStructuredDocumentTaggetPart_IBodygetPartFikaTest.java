package com.deepoove.poi.xwpf;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

import static org.mockito.Mockito.when;

public class XWPFStructuredDocumentTaggetPart_IBodygetPartFikaTest {

    @Test
    public void testGetPart() {
        // Create mock dependencies
        CTSdtRun mockSdtRun = Mockito.mock(CTSdtRun.class);
        IBody mockPart = Mockito.mock(IBody.class);
        POIXMLDocumentPart mockDocumentPart = Mockito.mock(POIXMLDocumentPart.class);
        
        // Setup mock behavior
        when(mockPart.getPart()).thenReturn(mockDocumentPart);
        
        // Instantiate the class under test using the first constructor
        XWPFStructuredDocumentTag sdt = new XWPFStructuredDocumentTag(mockSdtRun, mockPart);
        
        // Call the entry point method
        sdt.getPart();
    }
}
