package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlgetPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create at least one NumberingFormat to ensure the loop executes
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path to CTLvl.getPPr()
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
    }
    
    private byte[] createMinimalDocx() {
        // Create a new empty XWPFDocument and convert to bytes
        // This ensures we have valid DOCX content
        try (XWPFDocument tempDoc = new XWPFDocument()) {
            // Add minimal content to make it non-empty
            tempDoc.createParagraph().createRun().setText("Test");
            
            // Write to byte array
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            tempDoc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback: return a minimal DOCX structure
            return getFallbackDocxBytes();
        }
    }
    
    private byte[] getFallbackDocxBytes() {
        // Minimal valid DOCX structure as byte array
        // This is a base64 encoded minimal DOCX file with just the required parts
        String base64 = "UEsDBBQAAAAIAFB8b1cAAAAAAAAAAAAAAAAIAAAAX3JlbHMvLnJlbHNQSwECLQAUAAAACABQfG9XAAAAAAAAAAAAAAAACAAkAAAAAAAAACAAAAAAAAAAX3JlbHMvLnJlbHMKACAAAAAAAAEAGACQlQ8qQ9vTAZCV" +
                       "DypD29MBkJUPKkPb0wFQSwUGAAAAAAEAAQBVAAAAVwAAAAAA";
        return java.util.Base64.getDecoder().decode(base64);
    }
}
