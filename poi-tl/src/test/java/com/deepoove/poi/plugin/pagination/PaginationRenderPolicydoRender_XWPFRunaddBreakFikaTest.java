package com.deepoove.poi.plugin.pagination;

import com.deepoove.poi.render.RenderContext;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class PaginationRenderPolicydoRender_XWPFRunaddBreakFikaTest {

    @Test
    public void testDoRender() throws Exception {
        PaginationRenderPolicy policy = new PaginationRenderPolicy();
        
        RenderContext<Boolean> context = Mockito.mock(RenderContext.class);
        XWPFRun run = Mockito.mock(XWPFRun.class);
        
        when(context.getRun()).thenReturn(run);
        when(context.getData()).thenReturn(Boolean.TRUE);
        
        policy.doRender(context);
    }
}
