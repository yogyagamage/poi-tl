package com.deepoove.poi.policy;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.deepoove.poi.data.TextRenderData;
import org.junit.jupiter.api.Test;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest {

    @Test
    public void testRenderTextRun() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        TextRenderData data = new TextRenderData("Test text");
        
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        document.close();
    }
}
