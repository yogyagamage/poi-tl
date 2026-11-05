package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstylePpr_CTPPraddNewKeepLinesFikaTest {

    @Test
    public void testStylePprInvokesAddNewKeepLines() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setKeepLines(true);
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
