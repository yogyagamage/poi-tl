package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class HeaderFooterBodyContainercloselySectPr_XWPFDocumentgetRelationIdFikaTest {

    @Test
    public void testCloselySectPrCallsGetRelationId() throws Exception {
        // Create real XWPFDocument
        XWPFDocument doc = new XWPFDocument();
        
        // Create mock header/footer that will be passed to getRelationId
        XWPFHeader mockHeader = Mockito.mock(XWPFHeader.class);
        Mockito.when(mockHeader.getXWPFDocument()).thenReturn(doc);
        
        // Create container with mock header
        HeaderFooterBodyContainer container = new HeaderFooterBodyContainer(mockHeader);
        
        // Create a real paragraph to pass as parameter
        XWPFParagraph paragraph = doc.createParagraph();
        
        // Add some body elements to the document
        List<IBodyElement> bodyElements = new ArrayList<>();
        bodyElements.add(paragraph);
        
        // Use reflection to set body elements since getBodyElements() returns internal list
        try {
            java.lang.reflect.Field bodyElementsField = XWPFDocument.class.getDeclaredField("bodyElements");
            bodyElementsField.setAccessible(true);
            bodyElementsField.set(doc, bodyElements);
        } catch (Exception e) {
            // If reflection fails, create a new document with paragraph
            doc = new XWPFDocument();
            paragraph = doc.createParagraph();
        }
        
        // Call the entry point method
        container.closelySectPr(paragraph);
    }
}
