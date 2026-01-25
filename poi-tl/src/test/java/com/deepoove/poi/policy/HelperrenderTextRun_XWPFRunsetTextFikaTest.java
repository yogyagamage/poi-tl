package com.deepoove.poi.policy;

import com.deepoove.poi.data.BookmarkTextRenderData;
import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.policy.TextRenderPolicy.Helper;
import com.deepoove.poi.util.StyleUtils;
import com.deepoove.poi.util.TableTools;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.lang.reflect.Field;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest {

    @Test
    public void testRenderTextRun() throws Exception {
        // Create real XWPFDocument and XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        
        // Create real XWPFRun using the paragraph
        XWPFRun run = paragraph.createRun();
        
        // Create TextRenderData with text that will trigger the setText call
        TextRenderData data = new TextRenderData("Test text");
        
        // Call the entry point method
        Helper.renderTextRun(run, data);
    }
}
