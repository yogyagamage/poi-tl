package com.deepoove.poi.xwpf;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class XmlXWPFDocumentMergemergeStyles_StringUtilsisBlankFikaTest {

    @Test
    public void testMergePathToIsBlank() throws Exception {
        // Create source document
        byte[] docBytes = getMinimalDocxBytes();
        NiceXWPFDocument source = new NiceXWPFDocument(new ByteArrayInputStream(docBytes));
        
        // Create merged document with a style that will trigger isBlank check
        NiceXWPFDocument merged = new NiceXWPFDocument(new ByteArrayInputStream(docBytes));
        
        // Create iterator with the merged document
        Iterator<NiceXWPFDocument> iterator = Arrays.asList(merged).iterator();
        
        // Create a run in a paragraph
        XWPFParagraph paragraph = source.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create instance of class under test
        XmlXWPFDocumentMerge mergeInstance = new XmlXWPFDocumentMerge();
        
        // Execute the entry point method
        mergeInstance.merge(source, iterator, run);
    }
    
    private byte[] getMinimalDocxBytes() throws IOException {
        // Create a minimal DOCX with styles to ensure mergeStyles is called
        NiceXWPFDocument doc = new NiceXWPFDocument();
        
        // Create a style with blank name to trigger StringUtils.isBlank
        XWPFStyles styles = doc.createStyles();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle ctStyle = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle.Factory.newInstance();
        ctStyle.setStyleId("TestStyle");
        ctStyle.addNewName().setVal(""); // Blank name to trigger isBlank
        ctStyle.setType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType.PARAGRAPH);
        
        // Create and add the style
        org.apache.poi.xwpf.usermodel.XWPFStyle style = new org.apache.poi.xwpf.usermodel.XWPFStyle(ctStyle);
        styles.addStyle(style);
        
        // Write to byte array
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        doc.write(baos);
        doc.close();
        return baos.toByteArray();
    }
}
