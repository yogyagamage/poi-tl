package com.deepoove.poi;

import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.xwpf.XWPFHighlightColor;
import org.junit.jupiter.api.Test;

public class XWPFTemplate_StyleUtilsstyleRun_CTRPraddNewHighlightFikaTest {

    @Test
    public void testStyleRunInvokesAddNewHighlight() {
        // Create a DocumentRenderData instance
        DocumentRenderData data = new DocumentRenderData();
        
        // Create a Style with highlight color to trigger the target method
        Style style = new Style();
        style.setHighlightColor(XWPFHighlightColor.YELLOW);
        
        // Invoke the entry point method which should traverse the call chain
        XWPFTemplate.create(data, style);
    }
}
