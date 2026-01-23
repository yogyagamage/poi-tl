package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_XWPFNumberingaddNumFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use the constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to pass to the method
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.LOWER_LETTER
        };
        
        // Call the entry point method - this should invoke XWPFNumbering.addNum()
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal XWPFDocument with required structure
        XWPFDocument tempDoc = new XWPFDocument();
        
        // Add minimal content to avoid empty document
        tempDoc.createParagraph().createRun().setText("Test");
        
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            tempDoc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if write fails
            return new byte[0];
        }
    }
}
