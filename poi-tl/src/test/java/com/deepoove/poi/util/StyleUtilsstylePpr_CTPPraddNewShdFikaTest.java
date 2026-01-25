package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.xwpf.XWPFShadingPattern;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewShdFikaTest {

    @Test
    public void testStylePprInvokesAddNewShd() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        ParagraphStyle style = ParagraphStyle.builder()
            .withBackgroundColor("FF0000")
            .build();
        
        StyleUtils.stylePpr(paragraph, style);
        
        document.close();
    }
}
