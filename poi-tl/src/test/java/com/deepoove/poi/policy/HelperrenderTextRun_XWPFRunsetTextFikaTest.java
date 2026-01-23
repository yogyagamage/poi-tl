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
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HelperrenderTextRun_XWPFRunsetTextFikaTest {

    @Test
    void testRenderTextRun() throws Exception {
        Helper helper = new Helper();
        
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        TextRenderData data = new TextRenderData("Test text");
        
        Helper.renderTextRun(run, data);
    }
}
