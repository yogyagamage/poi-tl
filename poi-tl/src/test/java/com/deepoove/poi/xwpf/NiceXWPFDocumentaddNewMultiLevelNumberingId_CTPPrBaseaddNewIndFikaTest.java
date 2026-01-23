package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTPPrBaseaddNewIndFikaTest {

    @Test
    public void testAddNewMultiLevelNumberingId() throws Exception {
        // Create a minimal valid DOCX content to avoid EmptyFileException
        byte[] docxBytes = createMinimalDocx();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor that accepts InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call the entry point method - this should traverse the path
        // and eventually invoke CTPPrBase.addNewInd()
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
        
        // No assertions needed - test passes if no exception is thrown
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal XWPFDocument in memory
        XWPFDocument xwpfDocument = new XWPFDocument();
        xwpfDocument.createParagraph().createRun().setText("Test");
        
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            xwpfDocument.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty but valid DOCX structure
            return new byte[] {
                0x50, 0x4B, 0x03, 0x04, 0x14, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00, 0x00, 0x00
            };
        }
    }
}
