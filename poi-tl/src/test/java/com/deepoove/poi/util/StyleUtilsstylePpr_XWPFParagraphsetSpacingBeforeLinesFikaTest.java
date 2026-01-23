package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBeforeLinesFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBeforeLines() throws Exception {
        XWPFParagraph paragraph = new XWPFParagraph(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance(),
            new org.apache.poi.xwpf.usermodel.XWPFDocument()
        );
        
        ParagraphStyle style = new ParagraphStyle();
        style.setSpacingBeforeLines(1.5);
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
