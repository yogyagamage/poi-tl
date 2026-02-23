package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StyleUtilsretriveParagraphStyle_XWPFParagraphisWordWrappedFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesIsWordWrapped() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        document.write(baos);
        document.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        XWPFDocument loadedDocument = new XWPFDocument(bais);
        XWPFParagraph loadedParagraph = loadedDocument.getParagraphArray(0);
        
        StyleUtils.retriveParagraphStyle(loadedParagraph);
        
        loadedDocument.close();
        bais.close();
    }
}
