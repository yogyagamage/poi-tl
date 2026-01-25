package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleRun_CTColorisSetThemeColorFikaTest {

    @Test
    public void testStyleRunToCTColorIsSetThemeColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        Style style = new Style();
        style.setColor("FF0000");
        
        StyleUtils.styleRun(run, style);
        
        document.close();
    }
}
