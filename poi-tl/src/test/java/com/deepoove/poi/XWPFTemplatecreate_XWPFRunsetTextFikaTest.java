package com.deepoove.poi;

import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;

public class XWPFTemplatecreate_XWPFRunsetTextFikaTest {

    @Test
    public void testCreateMethodTriggersXWPFRunSetText() {
        DocumentRenderData data = new DocumentRenderData();
        Style style = new Style();
        
        XWPFTemplate.create(data, style);
    }
}
