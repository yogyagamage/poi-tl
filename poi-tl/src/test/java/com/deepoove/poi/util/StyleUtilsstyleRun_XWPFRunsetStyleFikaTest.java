package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleRun_XWPFRunsetStyleFikaTest {

    @Test
    public void testStyleRunInvokesSetStyle() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFRun srcRun = doc.createParagraph().createRun();
        XWPFRun destRun = doc.createParagraph().createRun();
        
        srcRun.setStyle("TestStyle");
        
        StyleUtils.styleRun(destRun, srcRun);
        
        doc.close();
    }
}
