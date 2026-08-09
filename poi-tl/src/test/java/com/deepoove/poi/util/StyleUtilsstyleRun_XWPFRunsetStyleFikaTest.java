package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.commons.lang3.StringUtils;

public class StyleUtilsstyleRun_XWPFRunsetStyleFikaTest {

    @Test
    public void testStyleRunInvokesSetStyle() throws Exception {
        // Create real XWPFDocument to get real XWPFRun instances
        XWPFDocument document = new XWPFDocument();
        
        // Create source run with style set to trigger the target method
        XWPFRun srcRun = document.createParagraph().createRun();
        // Set style on source run to ensure dest.setStyle() is called
        srcRun.setStyle("TestStyle");
        
        // Create destination run
        XWPFRun destRun = document.createParagraph().createRun();
        
        // Call the entry point method - this should invoke destRun.setStyle("TestStyle")
        StyleUtils.styleRun(destRun, srcRun);
        
        // Close document to clean up resources
        document.close();
    }
}
