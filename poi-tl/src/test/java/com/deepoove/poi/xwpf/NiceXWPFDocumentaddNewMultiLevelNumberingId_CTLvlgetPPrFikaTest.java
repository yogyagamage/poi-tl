package com.deepoove.poi.xwpf;

import com.deepoove.poi.data.NumberingFormat;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

public class NiceXWPFDocumentaddNewMultiLevelNumberingId_CTLvlgetPPrFikaTest {

    @Test
    public void test() throws Exception {
        // Create a minimal valid DOCX document as byte array
        byte[] docxBytes = createMinimalDocx();
        InputStream inputStream = new ByteArrayInputStream(docxBytes);
        
        // Use constructor: NiceXWPFDocument(InputStream in, boolean adjustDoc)
        NiceXWPFDocument document = new NiceXWPFDocument(inputStream, false);
        
        // Create NumberingFormat array to trigger the path
        NumberingFormat[] formats = new NumberingFormat[] {
            NumberingFormat.DECIMAL,
            NumberingFormat.BULLET
        };
        
        // Call entry point method - this should traverse the path and invoke CTLvl.getPPr()
        BigInteger result = document.addNewMultiLevelNumberingId(formats);
    }
    
    private byte[] createMinimalDocx() {
        // Create a minimal XWPFDocument with required parts for numbering
        XWPFDocument xwpfDoc = new XWPFDocument();
        
        // Create numbering part (required for getNumbering() to work)
        xwpfDoc.createNumbering();
        
        // Convert to byte array
        try (java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream()) {
            xwpfDoc.write(baos);
            return baos.toByteArray();
        } catch (Exception e) {
            // Fallback to empty byte array if there's an issue
            return new byte[0];
        }
    }
}
