package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;

public class StyleUtilsstyleRun_CTColorunsetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesCTColorUnsetThemeColor() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        Style style = Style.builder()
                .buildColor("FF0000")
                .build();
        
        StyleUtils.styleRun(run, style);
        
        document.close();
    }
}
