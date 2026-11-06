package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingAfterLinesFikaTest {

    @Test
    public void testStylePprToSetSpacingAfterLines() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setSpacingAfterLines(2.0);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
