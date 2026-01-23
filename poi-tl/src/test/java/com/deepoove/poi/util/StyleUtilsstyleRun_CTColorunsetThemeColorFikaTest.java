package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import com.deepoove.poi.xwpf.XWPFHighlightColor;
import org.apache.poi.xwpf.usermodel.XWPFRun.FontCharRange;

import java.lang.reflect.Method;

public class StyleUtilsstyleRun_CTColorunsetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesUnsetThemeColor() throws Exception {
        // Create a real XWPFRun
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create a real Style with color to trigger the path
        Style style = new Style();
        style.setColor("FF0000");
        
        // Use reflection to access private static method getRunProperties
        Method getRunPropertiesMethod = StyleUtils.class.getDeclaredMethod("getRunProperties", XWPFRun.class);
        getRunPropertiesMethod.setAccessible(true);
        CTRPr pr = (CTRPr) getRunPropertiesMethod.invoke(null, run);
        
        // Ensure CTColor exists and has themeColor set
        CTColor ctColor = pr.addNewColor();
        ctColor.setVal("FF0000");
        // Set themeColor so that unsetThemeColor() will be called
        ctColor.setThemeColor(org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor.ACCENT_1);
        
        // Call the entry point
        StyleUtils.styleRun(run, style);
        
        document.close();
    }
}
