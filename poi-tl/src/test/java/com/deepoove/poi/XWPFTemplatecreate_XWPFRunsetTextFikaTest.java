package com.deepoove.poi;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;

public class XWPFTemplatecreate_XWPFRunsetTextFikaTest {

    @Test
    public void testCreateDocumentRenderDataStyle() {
        DocumentRenderData data = new DocumentRenderData();
        Style style = new Style();
        
        XWPFTemplate.create(data, style);
    }
}
