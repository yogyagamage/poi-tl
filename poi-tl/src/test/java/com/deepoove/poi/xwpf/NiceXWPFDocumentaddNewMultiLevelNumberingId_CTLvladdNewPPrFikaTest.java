package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvladdNewPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX in-memory to avoid ZipException
        byte[] docxBytes = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that takes InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create at least one NumberingFormat to ensure the loop executes
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path 
        // and invoke CTLvl.addNewPPr()
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
        
        // No assertions required - test passes if no exception is thrown
    }
    
    private byte[] createMinimalDocx() {
        // Create a new empty XWPFDocument which generates valid DOCX structure
        XWPFDocument tempDoc = new XWPFDocument();
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            tempDoc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if something goes wrong
            return new byte[0];
        }
    }
}
