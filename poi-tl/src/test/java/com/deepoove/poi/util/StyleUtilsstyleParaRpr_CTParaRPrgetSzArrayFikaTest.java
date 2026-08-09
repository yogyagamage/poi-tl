package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.IRunBody;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.Style;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyleUtilsstyleParaRpr_CTParaRPrgetSzArrayFikaTest {

    @Test
    public void testStyleParagraphToGetSzArray() throws Exception {
        // Create a real XWPFDocument and paragraph as the source
        XWPFDocument srcDoc = new XWPFDocument();
        XWPFParagraph srcParagraph = srcDoc.createParagraph();
        
        // Create a real XWPFDocument and paragraph as the destination
        XWPFDocument destDoc = new XWPFDocument();
        XWPFParagraph destParagraph = destDoc.createParagraph();
        
        // Create a style with fontSize to trigger the getSzArray call
        Style glyphStyle = new Style();
        glyphStyle.setFontSize(12); // Non-zero font size to trigger the code path
        
        ParagraphStyle paragraphStyle = new ParagraphStyle();
        paragraphStyle.setGlyphStyle(glyphStyle);
        
        // We need to make srcParagraph have a style that will be retrieved
        // Since we can't directly set the style on XWPFParagraph, we'll use the second
        // styleParagraph method that takes ParagraphStyle directly
        StyleUtils.styleParagraph(destParagraph, paragraphStyle);
        
        // Now call the entry point method with srcParagraph as IRunBody
        // This will go through the full chain and eventually call getSzArray
        StyleUtils.styleParagraph(destParagraph, (IRunBody) srcParagraph);
    }
}
