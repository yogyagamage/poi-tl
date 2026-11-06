package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstylePpr_XWPFParagraphsetAlignmentFikaTest {

    @Test
    public void testStylePprCallsSetAlignment() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setAlign(ParagraphAlignment.CENTER);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
