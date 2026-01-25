package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBasegetIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX document in memory
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use the constructor that takes InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create a simple numbering format to trigger the path
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path
        // and eventually invoke CTPPrBase.getInd()
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal XWPFDocument in memory
        XWPFDocument xwpfDoc = new XWPFDocument();
        
        // Add minimal content to make it valid
        xwpfDoc.createParagraph().createRun().setText("Test");
        
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            xwpfDoc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback: return empty bytes, let the test handle the exception
            return new byte[0];
        }
    }
}
