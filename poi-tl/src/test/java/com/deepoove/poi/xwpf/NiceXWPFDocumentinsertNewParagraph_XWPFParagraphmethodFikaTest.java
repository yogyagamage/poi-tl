package com.deepoove.poi.xwpf;

import com.deepoove.poi.util.PoitlIOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class NiceXWPFDocumentinsertNewParagraph_XWPFParagraphmethodFikaTest {

    @Test
    public void testInsertNewParagraph() throws IOException {
        // Create a minimal XWPFDocument to use as base
        XWPFDocument baseDoc = new XWPFDocument();
        baseDoc.createParagraph();
        
        // Convert to byte array for NiceXWPFDocument constructor
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baseDoc.write(baos);
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        
        // Create NiceXWPFDocument instance using constructor with InputStream
        NiceXWPFDocument document = new NiceXWPFDocument(bais);
        
        // Get cursor from the document's XML
        XmlCursor cursor = document.getDocument().newCursor();
        
        // Move cursor to a position where it can insert a paragraph
        cursor.toFirstChild(); // Move to body
        cursor.toFirstChild(); // Move to first element in body
        
        // Call the entry point method
        document.insertNewParagraph(cursor);
        
        // Clean up
        cursor.dispose();
        document.close();
    }
}
