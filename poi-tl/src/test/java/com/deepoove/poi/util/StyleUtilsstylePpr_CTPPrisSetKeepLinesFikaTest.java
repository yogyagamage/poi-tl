package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;

public class StyleUtilsstylePpr_CTPPrisSetKeepLinesFikaTest {

    @Test
    public void testStylePprInvokesIsSetKeepLines() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = new ParagraphStyle();
        style.setKeepLines(true);
        
        CTP ctp = paragraph.getCTP();
        CTPPr pr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
