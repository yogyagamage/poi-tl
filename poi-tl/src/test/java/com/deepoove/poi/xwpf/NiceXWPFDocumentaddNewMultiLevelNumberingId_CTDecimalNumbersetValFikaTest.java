package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTDecimalNumbersetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a valid empty XWPF document byte array
        byte[] docBytes;
        try (XWPFDocument tempDoc = new XWPFDocument()) {
            // Create minimal document structure
            tempDoc.createParagraph();
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            docBytes = baos.toByteArray();
        }
        
        // Use the constructor that takes an InputStream
        InputStream inputStream = new ByteArrayInputStream(docBytes);
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        // Call the entry point method - this should traverse the path
        // and eventually call CTDecimalNumber.setVal(BigInteger)
        document.addNewMultiLevelNumberingId(formats);
    }
}
