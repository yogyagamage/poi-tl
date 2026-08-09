package com.deepoove.poi;

import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;

public class XWPFTemplate_StyleUtilsstyleRun_XWPFRunsetVerticalAlignmentFikaTest {

    @Test
    public void testCreateDocumentRenderDataInvokesSetVerticalAlignment() {
        // Create a DocumentRenderData instance
        DocumentRenderData data = new DocumentRenderData();
        
        // Create a Style with vertical alignment set
        Style style = new Style();
        style.setVertAlign("superscript");
        
        // Invoke the entry point method which should trigger the call chain
        XWPFTemplate.create(data, style);
    }
}
