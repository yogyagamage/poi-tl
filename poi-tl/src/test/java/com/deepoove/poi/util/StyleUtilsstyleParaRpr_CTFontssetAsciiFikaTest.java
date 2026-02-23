package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleParaRpr_CTFontssetAsciiFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = Style.builder()
                .buildFontFamily("Arial")
                .build();
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
