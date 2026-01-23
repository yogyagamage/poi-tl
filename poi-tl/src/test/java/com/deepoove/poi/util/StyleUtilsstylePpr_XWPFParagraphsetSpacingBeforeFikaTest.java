package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetSpacingBeforeFikaTest {

    @Test
    public void testStylePprInvokesSetSpacingBefore() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setSpacingBefore(10.0);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
