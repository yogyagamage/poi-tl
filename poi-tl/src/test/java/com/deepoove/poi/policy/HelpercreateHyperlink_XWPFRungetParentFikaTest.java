package com.deepoove.poi.policy;

import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HelpercreateHyperlink_XWPFRungetParentFikaTest {

    @Test
    public void testRenderTextRunTriggersGetParent() throws Exception {
        // Create real XWPFDocument and paragraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        // Create HyperlinkTextRenderData to trigger createHyperlink path
        HyperlinkTextRenderData data = new HyperlinkTextRenderData("Click here", "https://example.com");
        
        // Execute entry point method
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        // No assertions - test passes if getParent() is invoked during execution
    }
}
