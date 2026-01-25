package com.deepoove.poi.render;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RenderContextgetContainer_XWPFRungetParentFikaTest {

    @Test
    void test() {
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        
        Mockito.when(runTemplate.getRun()).thenReturn(mockRun);
        Mockito.when(mockRun.getParent()).thenReturn(mockParagraph);
        
        ElementTemplate eleTemplate = runTemplate;
        Object data = new Object();
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        RenderContext<Object> context = new RenderContext<>(eleTemplate, data, template);
        context.getContainer();
    }
}
