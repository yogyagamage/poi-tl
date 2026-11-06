package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;

public class StyleUtilsstyleParaRpr_CTParaRPrsizeOfBArrayFikaTest {

    @Test
    public void testStyleParaRprPath() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = new Style();
        style.setBold(true);
        style.setColor("000000");
        style.setFontFamily("Arial");
        style.setFontSize(12);
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
