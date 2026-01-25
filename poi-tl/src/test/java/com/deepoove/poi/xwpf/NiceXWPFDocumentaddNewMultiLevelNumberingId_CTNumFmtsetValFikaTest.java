package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTNumFmtsetValFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal XWPFDocument input stream
        byte[] docBytes = XWPFDocument.class.getResourceAsStream("/blank.docx") != null
                ? XWPFDocument.class.getResourceAsStream("/blank.docx").readAllBytes()
                : createMinimalDocxBytes();
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);
        
        // Instantiate NiceXWPFDocument using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array that will trigger the target method call
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path and invoke
        // CTNumFmt.setVal(STNumberFormat.Enum) inside the loop
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
        
        // No assertions - test completes when method returns without exception
    }
    
    private byte[] createMinimalDocxBytes() {
        // Create a minimal valid .docx document in memory
        XWPFDocument tempDoc = new XWPFDocument();
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            tempDoc.close();
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if creation fails
            return new byte[0];
        }
    }
}
