package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBaseisSetIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal XWPFDocument input stream
        byte[] docBytes = XWPFDocument.class.getResourceAsStream("/blank.docx") != null
                ? XWPFDocument.class.getResourceAsStream("/blank.docx").readAllBytes()
                : createMinimalDocxBytes();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to pass to the method
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should trigger the third-party method
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
        
        // No assertions - test only needs to execute the chain
    }
    
    private byte[] createMinimalDocxBytes() {
        // Create minimal .docx content to avoid null InputStream
        try (XWPFDocument tempDoc = new XWPFDocument()) {
            tempDoc.createParagraph().createRun().setText("Test");
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if creation fails
            return new byte[0];
        }
    }
}
