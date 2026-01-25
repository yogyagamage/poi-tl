package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrBase;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPrisSetWidowControlFikaTest {

    @Test
    public void testStylePprInvokesIsSetWidowControl() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.addNewPPr();
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withWidowControl(true)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
