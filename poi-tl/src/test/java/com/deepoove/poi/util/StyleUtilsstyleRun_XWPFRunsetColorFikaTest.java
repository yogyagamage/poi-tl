package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_XWPFRunsetColorFikaTest {

    @Test
    public void testStyleRunInvokesSetColor() throws Exception {
        // Create a real document with real runs
        XWPFDocument document = new XWPFDocument();
        
        // Create source run with color
        XWPFRun srcRun = document.createParagraph().createRun();
        srcRun.setText("Source");
        srcRun.setColor("FF0000"); // Set color to trigger the condition
        
        // Create destination run
        XWPFRun destRun = document.createParagraph().createRun();
        destRun.setText("Destination");
        
        // Invoke the method under test - this should trigger dest.setColor(src.getColor())
        StyleUtils.styleRun(destRun, srcRun);
        
        // Clean up resources
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.write(baos);
        document.close();
        baos.close();
    }
}
