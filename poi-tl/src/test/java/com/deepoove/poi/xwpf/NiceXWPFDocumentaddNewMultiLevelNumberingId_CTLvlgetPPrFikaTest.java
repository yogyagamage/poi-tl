package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlgetPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal XWPFDocument input stream
        byte[] docBytes = XWPFDocument.class.getResourceAsStream("/blank.docx") != null
                ? XWPFDocument.class.getResourceAsStream("/blank.docx").readAllBytes()
                : createMinimalDocxBytes();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path and invoke CTLvl.getPPr()
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
        
        // No assertions or verifications - just ensure the method executes
    }
    
    private byte[] createMinimalDocxBytes() {
        // Create minimal .docx bytes for a valid XWPFDocument
        try (XWPFDocument doc = new XWPFDocument()) {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            doc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if creation fails
            return new byte[0];
        }
    }
}
