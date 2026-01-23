package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBaseisSetIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal XWPFDocument to use as base
        XWPFDocument baseDoc = new XWPFDocument();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baseDoc.write(baos);
        baseDoc.close();
        
        // Create input stream from the written document
        ByteArrayInputStream inputStream = new ByteArrayInputStream(baos.toByteArray());
        
        // Create NiceXWPFDocument instance using the constructor that takes InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to pass to the method
        NumberingFormat[] numberingFormats = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should trigger the third-party method call
        BigInteger result = document.addNewMultiLevelNumberingId(numberingFormats);
        
        // Clean up
        document.close();
        IOUtils.closeQuietly(inputStream);
    }
}
