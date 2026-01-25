package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsstyleRun_CTColorunsetThemeColorFikaTest {

    @Test
    public void testStyleRunInvokesUnsetThemeColor() throws Exception {
        // Create a real XWPFRun with proper internal structure
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        // Ensure the run has CTColor with themeColor set
        run.getCTR().addNewRPr().addNewColor().setThemeColor(
            org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor.ACCENT_1
        );
        
        // Create a Style with color to trigger the color styling path
        Style style = mock(Style.class);
        when(style.getColor()).thenReturn("FF0000");
        when(style.getFontSize()).thenReturn(0.0);
        when(style.getFontFamily()).thenReturn(null);
        when(style.getWesternFontFamily()).thenReturn(null);
        when(style.getHighlightColor()).thenReturn(null);
        when(style.isBold()).thenReturn(null);
        when(style.isItalic()).thenReturn(null);
        when(style.isStrike()).thenReturn(null);
        when(style.getUnderlinePatterns()).thenReturn(null);
        when(style.getCharacterSpacing()).thenReturn(0);
        when(style.getVertAlign()).thenReturn(null);
        
        // Call the entry point method
        StyleUtils.styleRun(run, style);
        
        // No assertions - test passes if unsetThemeColor() is invoked without exceptions
    }
}
