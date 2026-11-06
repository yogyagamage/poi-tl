package com.deepoove.poi;

import com.deepoove.poi.data.DocumentRenderData;
import com.deepoove.poi.data.style.Style;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

public class XWPFTemplatecreate_XWPFRunsetTextFikaTest {

    @Test
    public void test() {
        DocumentRenderData data = mock(DocumentRenderData.class);
        Style templateTagStyle = mock(Style.class);
        
        XWPFTemplate.create(data, templateTagStyle);
    }
}
