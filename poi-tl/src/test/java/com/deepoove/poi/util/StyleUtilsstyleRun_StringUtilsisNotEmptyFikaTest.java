package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testStyleRunInvokesStringUtilsIsNotEmpty() throws Exception {
        // Create real XWPFRun objects
        XWPFDocument document = new XWPFDocument();
        XWPFRun srcRun = document.createParagraph().createRun();
        XWPFRun destRun = document.createParagraph().createRun();
        
        // Set style on source run to trigger StringUtils.isNotEmpty call
        srcRun.setStyle("TestStyle");
        
        // Call the entry point method
        StyleUtils.styleRun(destRun, srcRun);
        
        // Clean up
        document.close();
    }
}
