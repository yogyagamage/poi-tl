package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.ParagraphStyle;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBetweenFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBetween() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setSpacing(12.5);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
