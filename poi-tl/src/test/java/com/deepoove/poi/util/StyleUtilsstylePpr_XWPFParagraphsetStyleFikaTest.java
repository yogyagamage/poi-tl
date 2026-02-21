package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstylePpr_XWPFParagraphsetStyleFikaTest {

    @Test
    public void testStylePprInvokesSetStyle() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withStyleId("CustomStyle")
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
