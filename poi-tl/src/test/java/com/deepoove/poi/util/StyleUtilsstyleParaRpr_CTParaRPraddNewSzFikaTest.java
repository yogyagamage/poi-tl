package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class StyleUtilsstyleParaRpr_CTParaRPraddNewSzFikaTest {

    @Test
    public void testInvokeAddNewSz() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = Style.builder()
                .buildFontSize(12)
                .build();
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
