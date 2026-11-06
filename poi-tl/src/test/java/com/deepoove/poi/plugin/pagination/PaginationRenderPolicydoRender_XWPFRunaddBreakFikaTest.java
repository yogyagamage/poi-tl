package com.deepoove.poi.plugin.pagination;

import com.deepoove.poi.render.RenderContext;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PaginationRenderPolicydoRender_XWPFRunaddBreakFikaTest {

    @Test
    public void testDoRenderToAddBreak() throws Exception {
        PaginationRenderPolicy policy = new PaginationRenderPolicy();
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        RenderContext<Boolean> mockContext = Mockito.mock(RenderContext.class);
        
        Mockito.when(mockContext.getRun()).thenReturn(mockRun);
        Mockito.when(mockContext.getData()).thenReturn(Boolean.TRUE);
        
        policy.doRender(mockContext);
    }
}
