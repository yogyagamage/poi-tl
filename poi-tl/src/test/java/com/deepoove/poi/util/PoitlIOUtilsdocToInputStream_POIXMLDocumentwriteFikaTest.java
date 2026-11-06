package com.deepoove.poi.util;

import org.apache.poi.ooxml.POIXMLDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PoitlIOUtilsdocToInputStream_POIXMLDocumentwriteFikaTest {

    @Test
    public void testDocToInputStream() throws IOException {
        POIXMLDocument mockDoc = Mockito.mock(POIXMLDocument.class);
        PoitlIOUtils.docToInputStream(mockDoc);
    }
}
