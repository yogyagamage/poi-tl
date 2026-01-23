package com.deepoove.poi.xwpf;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import java.util.List;
import java.util.ArrayList;

public class XWPFTextboxContentinsertNewParagraph_CTPnewCursorFikaTest {

    @Test
    public void testInsertNewParagraphInvokesNewCursor() throws Exception {
        // Create required dependencies
        CTTxbxContent ctTxbxContent = CTTxbxContent.Factory.newInstance();
        // Add at least one paragraph to make isCursorInTextBox return true
        ctTxbxContent.addNewP();
        
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        // Create instance using constructor
        XWPFTextboxContent textboxContent = new XWPFTextboxContent(
            ctTxbxContent, 
            run, 
            document, 
            ctTxbxContent
        );
        
        // Create a cursor positioned inside the textbox content
        XmlCursor cursor = ctTxbxContent.newCursor();
        cursor.toFirstChild(); // Position at the first paragraph
        
        // Call the entry point method
        textboxContent.insertNewParagraph(cursor);
        
        // Clean up
        cursor.dispose();
        document.close();
    }
}
