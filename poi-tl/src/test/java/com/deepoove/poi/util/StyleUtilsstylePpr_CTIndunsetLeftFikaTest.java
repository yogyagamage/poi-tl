package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetLeftFikaTest {

    @Test
    public void testStylePprInvokesCTIndUnsetLeft() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        CTP ctp = paragraph.getCTP();
        CTPPr ppr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        CTInd indent = ppr.isSetInd() ? ppr.getInd() : ppr.addNewInd();
        indent.setLeft(BigInteger.valueOf(100));
        
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(1.5)
                .build();
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
