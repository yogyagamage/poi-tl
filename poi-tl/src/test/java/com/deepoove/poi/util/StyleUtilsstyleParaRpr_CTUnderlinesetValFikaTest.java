package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleParaRpr_CTUnderlinesetValFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        Style style = new Style();
        style.setUnderlinePatterns(UnderlinePatterns.SINGLE);
        
        StyleUtils.styleParaRpr(paragraph, style);
        
        document.close();
    }
}
