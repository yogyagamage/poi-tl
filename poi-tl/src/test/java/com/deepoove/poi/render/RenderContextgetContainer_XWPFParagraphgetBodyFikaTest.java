package com.deepoove.poi.render;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class RenderContextgetContainer_XWPFParagraphgetBodyFikaTest {

    @Test
    public void testGetContainerCallsGetBody() {
        // Create mock RunTemplate
        RunTemplate mockRunTemplate = Mockito.mock(RunTemplate.class);
        
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        when(mockRunTemplate.getRun()).thenReturn(mockRun);
        
        // Create mock XWPFParagraph
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        
        // Create mock ElementTemplate (as RunTemplate)
        ElementTemplate mockElementTemplate = mockRunTemplate;
        
        // Create mock data
        Object mockData = new Object();
        
        // Create mock XWPFTemplate
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        // Create RenderContext instance
        RenderContext<Object> renderContext = new RenderContext<>(
            mockElementTemplate, 
            mockData, 
            mockTemplate
        );
        
        // Invoke the entry point method
        renderContext.getContainer();
    }
}
