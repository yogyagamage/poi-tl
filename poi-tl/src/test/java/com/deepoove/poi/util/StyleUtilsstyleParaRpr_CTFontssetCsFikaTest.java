package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.style.Style;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleParaRpr_CTFontssetCsFikaTest {

    @Test
    public void testStyleParaRprInvokesCTFontsSetCs() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = Style.builder()
                .buildFontFamily("Arial")
                .build();
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
