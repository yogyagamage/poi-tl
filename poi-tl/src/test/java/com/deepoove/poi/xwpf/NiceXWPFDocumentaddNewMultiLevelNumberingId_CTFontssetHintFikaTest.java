package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTFontssetHintFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat that will trigger the bullet path
        NumberingFormat bulletFormat = NumberingFormat.BULLET;
        
        // Call the entry point method
        document.addNewMultiLevelNumberingId(bulletFormat);
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal XWPFDocument in memory
        XWPFDocument tempDoc = new XWPFDocument();
        
        // Add minimal content to avoid empty document
        tempDoc.createParagraph().createRun().setText("Test");
        
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            tempDoc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty bytes if there's an issue
            return new byte[0];
        }
    }
}
