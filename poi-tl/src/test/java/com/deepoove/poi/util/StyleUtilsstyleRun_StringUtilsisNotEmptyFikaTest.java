package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testStyleRunInvokesStringUtilsIsNotEmpty() throws Exception {
        // Create real XWPFDocument to get real XWPFRun objects
        XWPFDocument document = new XWPFDocument();
        
        // Create source run with style to trigger StringUtils.isNotEmpty
        XWPFRun srcRun = document.createParagraph().createRun();
        srcRun.setStyle("CustomStyle");
        
        // Create destination run
        XWPFRun destRun = document.createParagraph().createRun();
        
        // Invoke entry point method - this should call StringUtils.isNotEmpty internally
        StyleUtils.styleRun(destRun, srcRun);
        
        // Clean up
        document.close();
    }
}
