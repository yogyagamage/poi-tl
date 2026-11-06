package com.deepoove.poi.policy;

import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class HelpercreateHyperlink_XWPFRungetParentFikaTest {

    @Test
    public void testRenderTextRunCreatesHyperlinkAndGetsParent() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        TextRenderData data = new HyperlinkTextRenderData("Test", "http://example.com");
        
        TextRenderPolicy.Helper.renderTextRun(run, data);
    }
}
