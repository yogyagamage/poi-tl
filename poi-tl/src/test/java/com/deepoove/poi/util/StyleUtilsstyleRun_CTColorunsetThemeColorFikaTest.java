package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;

import static org.mockito.Mockito.mock;

public class StyleUtilsstyleRun_CTColorunsetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesCTColorUnsetThemeColor() throws Exception {
        // Create real XWPFRun from a real XWPFDocument
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        // Create a Style with color to trigger the CTColor.unsetThemeColor() path
        Style style = Style.builder()
                .buildColor("FF0000")  // Any non-blank color
                .build();
        
        // Execute the entry point method
        StyleUtils.styleRun(run, style);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
}
