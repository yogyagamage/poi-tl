package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleParaRpr_CTFontssetEastAsiaFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = Style.builder()
                .buildFontFamily("SimSun")
                .build();
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.write(new ByteArrayOutputStream());
        document.close();
    }
}
