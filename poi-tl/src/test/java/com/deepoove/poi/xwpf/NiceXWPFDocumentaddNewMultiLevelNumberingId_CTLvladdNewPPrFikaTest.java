package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvladdNewPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal XWPFDocument input stream
        byte[] docBytes = XWPFDocument.class.getResourceAsStream("/empty.docx") != null 
            ? XWPFDocument.class.getResourceAsStream("/empty.docx").readAllBytes()
            : createMinimalDocxBytes();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] numberingFormats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path 
        // and invoke CTLvl.addNewPPr() internally
        BigInteger result = document.addNewMultiLevelNumberingId(numberingFormats);
    }
    
    private byte[] createMinimalDocxBytes() {
        // Create minimal .docx bytes for a valid XWPFDocument
        // This is a fallback when no resource file is available
        try (XWPFDocument tempDoc = new XWPFDocument()) {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            // Return empty bytes as last resort
            return new byte[0];
        }
    }
}
