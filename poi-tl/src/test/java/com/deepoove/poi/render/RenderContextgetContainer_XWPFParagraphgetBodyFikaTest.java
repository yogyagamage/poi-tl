package com.deepoove.poi.render;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RenderContextgetContainer_XWPFParagraphgetBodyFikaTest {

    @Test
    public void testGetContainerInvokesGetBody() throws Exception {
        // Create mock objects for constructor parameters
        ElementTemplate mockEleTemplate = Mockito.mock(RunTemplate.class);
        Object mockData = new Object();
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        // Create mock XWPFRun and XWPFParagraph for the call chain
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        
        // Setup the mock chain: getRun().getParent() returns XWPFParagraph
        Mockito.when(((RunTemplate) mockEleTemplate).getRun()).thenReturn(mockRun);
        Mockito.when(mockRun.getParent()).thenReturn(mockParagraph);
        
        // Create instance using constructor
        RenderContext<Object> context = new RenderContext<>(mockEleTemplate, mockData, mockTemplate);
        
        // Execute the entry point method
        context.getContainer();
    }
}
