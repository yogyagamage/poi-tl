package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlisSetPPrFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal valid DOCX in memory to avoid NotOfficeXmlFileException
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create at least one NumberingFormat to ensure the loop executes
        NumberingFormat[] numFmts = new NumberingFormat[] {
            NumberingFormat.DECIMAL
        };
        
        // Call the entry point method - this should traverse the path to CTLvl.isSetPPr()
        BigInteger result = document.addNewMultiLevelNumberingId(numFmts);
    }
    
    private byte[] createMinimalDocx() throws IOException {
        // Create a new empty XWPFDocument which generates valid DOCX content
        XWPFDocument tempDoc = new XWPFDocument();
        byte[] bytes;
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            tempDoc.write(baos);
            bytes = baos.toByteArray();
        }
        tempDoc.close();
        return bytes;
    }
}
