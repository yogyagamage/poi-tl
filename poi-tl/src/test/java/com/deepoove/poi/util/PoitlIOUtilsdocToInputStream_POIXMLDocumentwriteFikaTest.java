package com.deepoove.poi.util;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

public class PoitlIOUtilsdocToInputStream_POIXMLDocumentwriteFikaTest {

    @Test
    public void testDocToInputStream() throws Exception {
        POIXMLDocument doc = new XSSFWorkbook();
        PoitlIOUtils.docToInputStream(doc);
    }
}
