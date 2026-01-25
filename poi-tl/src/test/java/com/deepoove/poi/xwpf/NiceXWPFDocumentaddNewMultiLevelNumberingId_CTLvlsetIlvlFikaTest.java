package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlsetIlvlFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxContent = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxContent);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the loop where CTLvl.setIlvl is called
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path and invoke CTLvl.setIlvl
        document.addNewMultiLevelNumberingId(formats);
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
