package com.deepoove.poi.policy;

import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest2 {

    @Test
    public void testRenderTextRun() throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFRun run = document.createParagraph().createRun();
        
        TextRenderData data = new TextRenderData("Test\nText");
        TextRenderPolicy.Helper.renderTextRun(run, data);
        
        document.close();
    }
}
