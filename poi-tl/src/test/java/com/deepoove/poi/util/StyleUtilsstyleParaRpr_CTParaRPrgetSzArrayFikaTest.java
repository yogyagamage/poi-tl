package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.Style.StyleBuilder;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleParaRpr_CTParaRPrgetSzArrayFikaTest {

    @Test
    public void testStyleParaRprPathToGetSzArray() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = Style.builder()
                .buildFontSize(12)
                .build();
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
