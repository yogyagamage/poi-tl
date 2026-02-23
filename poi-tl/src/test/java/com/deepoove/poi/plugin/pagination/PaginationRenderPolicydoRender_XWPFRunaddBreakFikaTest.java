package com.deepoove.poi.plugin.pagination;

import com.deepoove.poi.render.RenderContext;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class PaginationRenderPolicydoRender_XWPFRunaddBreakFikaTest {

    @Test
    public void testDoRender() throws Exception {
        // Create mock XWPFRun
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        
        // Create mock RenderContext
        RenderContext<Boolean> mockContext = Mockito.mock(RenderContext.class);
        
        // Configure context to return the mock run
        when(mockContext.getRun()).thenReturn(mockRun);
        
        // Configure context to return Boolean.TRUE to trigger the addBreak call
        when(mockContext.getData()).thenReturn(Boolean.TRUE);
        
        // Create the actual policy instance
        PaginationRenderPolicy policy = new PaginationRenderPolicy();
        
        // Execute the entry point method
        policy.doRender(mockContext);
    }
}
