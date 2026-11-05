package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleRun_XWPFRunsetColorFikaTest {

    @Test
    public void testStyleRunInvokesSetColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun srcRun = document.createParagraph().createRun();
        XWPFRun destRun = document.createParagraph().createRun();
        
        srcRun.setColor("FF0000");
        
        StyleUtils.styleRun(destRun, srcRun);
        
        document.close();
    }
}
