package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class StyleUtilsstyleParaRpr_CTParaRPrsizeOfSzArrayFikaTest {

    @Test
    public void testStyleParaRprPath() throws Exception {
        // Create a real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a Style with font size to trigger the sizeOfSzArray() call
        Style style = Style.builder()
                .buildFontSize(12)  // Non-zero font size to trigger the path
                .build();
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
        
        // Close resources
        document.close();
    }
}
