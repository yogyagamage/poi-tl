package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

public class StyleUtilsstylePpr_CTIndisSetHangingFikaTest {

    @Test
    public void stylePprInvokesCTIndIsSetHanging() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        ParagraphStyle style = new ParagraphStyle();
        style.setIndentHangingChars(1.0);
        StyleUtils.stylePpr(paragraph, style);
    }
}
