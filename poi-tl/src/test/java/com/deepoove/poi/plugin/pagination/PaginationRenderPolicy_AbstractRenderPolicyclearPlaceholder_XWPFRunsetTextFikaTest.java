package com.deepoove.poi.plugin.pagination;

import com.deepoove.poi.render.RenderContext;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PaginationRenderPolicy_AbstractRenderPolicyclearPlaceholder_XWPFRunsetTextFikaTest {

    @Test
    public void testDoRenderCallsClearPlaceholderCallsSetText() throws Exception {
        PaginationRenderPolicy policy = new PaginationRenderPolicy();
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        RenderContext<Boolean> mockContext = Mockito.mock(RenderContext.class);
        
        Mockito.when(mockContext.getRun()).thenReturn(mockRun);
        Mockito.when(mockContext.getData()).thenReturn(Boolean.FALSE);
        
        policy.doRender(mockContext);
    }
}
