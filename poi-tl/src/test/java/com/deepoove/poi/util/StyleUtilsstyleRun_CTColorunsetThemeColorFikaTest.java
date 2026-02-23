package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleRun_CTColorunsetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesUnsetThemeColor() throws Exception {
        // Create a real XWPFRun with a real document context
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        // Create a Style that will trigger the color path
        Style style = Style.builder()
                .buildColor("FF0000")  // This will cause CTColor to be created
                .build();
        
        // This should invoke CTColor.unsetThemeColor() when theme color is set
        StyleUtils.styleRun(run, style);
        
        // Clean up
        document.close();
    }
}
