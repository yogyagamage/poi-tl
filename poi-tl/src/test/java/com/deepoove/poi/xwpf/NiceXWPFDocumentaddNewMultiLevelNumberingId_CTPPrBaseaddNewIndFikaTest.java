package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBaseaddNewIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path
        // and eventually invoke CTPPrBase.addNewInd()
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
    }
    
    private byte[] createMinimalDocx() {
        // Create a new XWPFDocument which generates valid DOCX content
        XWPFDocument tempDoc = new XWPFDocument();
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            tempDoc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty but non-zero byte array
            return new byte[] { 0x50, 0x4B, 0x03, 0x04 }; // ZIP header
        }
    }
}
