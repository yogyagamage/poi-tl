package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetPageBreakFikaTest {

    @Test
    public void testStylePprInvokesSetPageBreak() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setPageBreakBefore(true);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
