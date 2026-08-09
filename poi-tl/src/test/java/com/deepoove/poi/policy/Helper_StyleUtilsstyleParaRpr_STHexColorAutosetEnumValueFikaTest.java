package com.deepoove.poi.policy;

import com.deepoove.poi.data.ParagraphRenderData;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.util.StyleUtils;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColorAuto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Helper_StyleUtilsstyleParaRpr_STHexColorAutosetEnumValueFikaTest {

    @Test
    public void testRenderParagraphPath() throws Exception {
        // Create the Helper instance
        ParagraphRenderPolicy.Helper helper = new ParagraphRenderPolicy.Helper();
        
        // Create a real XWPFDocument and paragraph to get a real XWPFRun
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create ParagraphRenderData with content
        ParagraphRenderData data = new ParagraphRenderData();
        List<RenderData> contents = new ArrayList<>();
        TextRenderData textData = new TextRenderData("test");
        contents.add(textData);
        // Use reflection to set contents since setter might not be public
        try {
            java.lang.reflect.Field contentsField = ParagraphRenderData.class.getDeclaredField("contents");
            contentsField.setAccessible(true);
            contentsField.set(data, contents);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // Create ParagraphStyle with underline that will trigger the target path
        ParagraphStyle paragraphStyle = new ParagraphStyle();
        Style style = new Style();
        
        // Set underline pattern and color to "auto" to trigger STHexColorAuto.setEnumValue
        style.setUnderlinePatterns(UnderlinePatterns.SINGLE);
        style.setUnderlineColor("auto");
        
        // Set other required style properties to avoid null checks
        style.setColor("000000");
        style.setItalic(false);
        style.setBold(false);
        style.setFontSize(12);
        style.setStrike(false);
        style.setFontFamily("Arial");
        
        paragraphStyle.setGlyphStyle(style);
        
        // Set the paragraph style to the data
        try {
            java.lang.reflect.Field styleField = ParagraphRenderData.class.getDeclaredField("paragraphStyle");
            styleField.setAccessible(true);
            styleField.set(data, paragraphStyle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // Create default control styles list (can be empty)
        List<ParagraphStyle> defaultControlStyles = new ArrayList<>();
        
        // Invoke the entry point method
        helper.renderParagraph(run, data, defaultControlStyles);
        
        // Clean up
        document.close();
    }
}
