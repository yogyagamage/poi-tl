package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrisSetWordWrapFikaTest {

    @Test
    public void testStylePprInvokesIsSetWordWrap() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setAllowWordBreak(true);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
