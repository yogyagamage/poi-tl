package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyleUtilsstyleParaRpr_CTHpsMeasuresetValFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        // Create a real XWPFParagraph with a real XWPFDocument
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create a Style that will trigger the fontSize path
        Style style = new Style();
        style.setFontSize(12); // This should trigger the CTHpsMeasure.setVal() call
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
        
        // Close the document to release resources
        document.close();
    }
}
