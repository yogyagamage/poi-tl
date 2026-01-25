package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_XWPFRunsetColorFikaTest {

    @Test
    public void testStyleRunInvokesSetColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun srcRun = paragraph.createRun();
        XWPFRun destRun = paragraph.createRun();
        
        srcRun.setColor("FF0000");
        
        StyleUtils.styleRun(destRun, srcRun);
        
        document.close();
    }
}
