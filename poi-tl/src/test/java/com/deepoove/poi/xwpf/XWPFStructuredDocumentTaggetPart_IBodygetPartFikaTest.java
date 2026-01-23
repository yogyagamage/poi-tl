package com.deepoove.poi.xwpf;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.IBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;

class XWPFStructuredDocumentTaggetPart_IBodygetPartFikaTest {

    @Test
    void testGetPart() {
        CTSdtRun mockSdtRun = Mockito.mock(CTSdtRun.class);
        IBody mockPart = Mockito.mock(IBody.class);
        
        XWPFStructuredDocumentTag sdt = new XWPFStructuredDocumentTag(mockSdtRun, mockPart);
        sdt.getPart();
    }
}
