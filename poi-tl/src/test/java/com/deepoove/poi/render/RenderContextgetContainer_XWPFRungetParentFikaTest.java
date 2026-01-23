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
    void testGetContainerInvokesXWPFRunGetParent() {
        // Create mock objects for constructor parameters
        ElementTemplate mockEleTemplate = Mockito.mock(RunTemplate.class);
        Object mockData = new Object();
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        // Create a real XWPFRun that will be returned by WhereDelegate
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        
        // Setup the chain: getRun().getParent() -> XWPFParagraph
        Mockito.when(((RunTemplate) mockEleTemplate).getRun()).thenReturn(mockRun);
        Mockito.when(mockRun.getParent()).thenReturn(mockParagraph);
        
        // Create the RenderContext instance
        RenderContext<Object> renderContext = new RenderContext<>(
            mockEleTemplate, 
            mockData, 
            mockTemplate
        );
        
        // Invoke the entry point method
        renderContext.getContainer();
    }
}
