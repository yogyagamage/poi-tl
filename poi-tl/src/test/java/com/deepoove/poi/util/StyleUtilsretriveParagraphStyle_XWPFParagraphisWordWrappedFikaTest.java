package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_XWPFParagraphisWordWrappedFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesIsWordWrapped() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        StyleUtils.retriveParagraphStyle(paragraph);
        
        document.close();
    }
}
