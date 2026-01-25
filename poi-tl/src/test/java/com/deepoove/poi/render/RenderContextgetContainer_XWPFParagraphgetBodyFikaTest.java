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
        // Create mock objects for constructor parameters
        ElementTemplate mockEleTemplate = Mockito.mock(RunTemplate.class);
        Object mockData = new Object();
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        // Create mock XWPFRun and XWPFParagraph for the call chain
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        
        // Set up the call chain: getRun().getParent() returns XWPFParagraph
        when(((RunTemplate) mockEleTemplate).getRun()).thenReturn(mockRun);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        
        // Create the RenderContext instance
        RenderContext<Object> renderContext = new RenderContext<>(
            mockEleTemplate, mockData, mockTemplate
        );
        
        // Invoke the entry point method
        renderContext.getContainer();
    }
}
