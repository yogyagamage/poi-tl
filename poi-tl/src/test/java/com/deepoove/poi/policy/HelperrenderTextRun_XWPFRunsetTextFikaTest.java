package com.deepoove.poi.policy;

import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class HelperrenderTextRun_XWPFRunsetTextFikaTest {

    @Test
    public void testRenderTextRun() throws Exception {
        // Create real XWPFDocument and XWPFRun
        XWPFDocument document = new XWPFDocument();
        XWPFRun realRun = document.createParagraph().createRun();
        
        // Create a mock TextRenderData that will return a simple text
        TextRenderData mockData = mock(TextRenderData.class);
        when(mockData.getText()).thenReturn("Test text");
        when(mockData.getStyle()).thenReturn(Style.builder().build());
        
        // Call the entry point method
        TextRenderPolicy.Helper.renderTextRun(realRun, mockData);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
}
