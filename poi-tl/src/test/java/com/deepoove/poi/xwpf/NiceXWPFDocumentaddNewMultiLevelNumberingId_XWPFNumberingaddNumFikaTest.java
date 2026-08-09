package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_XWPFNumberingaddNumFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal XWPFDocument input stream
        byte[] docBytes = XWPFDocument.class.getResourceAsStream("/blank.docx") != null 
            ? XWPFDocument.class.getResourceAsStream("/blank.docx").readAllBytes()
            : createMinimalDocxBytes();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to pass to the method
        NumberingFormat[] numberingFormats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        // Call the entry point method - this should traverse the path and invoke XWPFNumbering.addNum()
        BigInteger result = document.addNewMultiLevelNumberingId(numberingFormats);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
    
    private byte[] createMinimalDocxBytes() {
        // Create minimal .docx bytes for a blank document
        // This is a fallback when the resource is not available
        try (XWPFDocument tempDoc = new XWPFDocument()) {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            // Return empty bytes as fallback - will likely cause constructor to fail
            // but this is just for test setup
            return new byte[0];
        }
    }
}
