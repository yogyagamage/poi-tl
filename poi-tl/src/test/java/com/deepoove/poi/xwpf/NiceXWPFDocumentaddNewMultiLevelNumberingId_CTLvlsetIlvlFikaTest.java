package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlsetIlvlFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws IOException {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that takes InputStream
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
        // Create a minimal XWPFDocument in memory
        XWPFDocument xwpfDoc = new XWPFDocument();
        xwpfDoc.createParagraph().createRun().setText("Test");
        
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            xwpfDoc.write(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            // Fallback to empty bytes if there's an error
            return new byte[0];
        }
    }
}
