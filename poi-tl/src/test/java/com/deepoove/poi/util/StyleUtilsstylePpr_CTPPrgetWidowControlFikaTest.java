package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrgetWidowControlFikaTest {

    @Test
    public void testStylePprTriggersGetWidowControl() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setWidowControl(true);
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.addNewPPr();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
