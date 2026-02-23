package com.deepoove.poi.policy;

import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class HelpercreateHyperlink_XWPFRunsetTextFikaTest {

    @Test
    public void testRenderTextRunTriggersSetText() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        TextRenderData data = new HyperlinkTextRenderData("Test Text", "http://example.com");
        
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        document.close();
    }
}
