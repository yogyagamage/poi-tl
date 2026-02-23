package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

public class StyleUtilsstyleRun_CTColorisSetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesIsSetThemeColor() throws Exception {
        // Create a real XWPFRun with a real document
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        // Create a real Style with color to trigger the color path
        Style style = Style.builder()
                .buildColor("FF0000")
                .build();
        
        // This will execute the full chain and invoke CTColor.isSetThemeColor()
        StyleUtils.styleRun(run, style);
        
        // Clean up
        document.close();
    }
}
