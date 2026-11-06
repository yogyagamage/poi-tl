package com.deepoove.poi.policy;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.deepoove.poi.data.TextRenderData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest {

    @Test
    public void testRenderTextRun() {
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        TextRenderData data = new TextRenderData("Test text");
        
        TextRenderPolicy.Helper.renderTextRun(mockRun, data);
    }
}
