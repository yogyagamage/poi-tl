package com.deepoove.poi.plugin.field;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.plugin.field.SimpleFieldRenderPolicy;
import com.deepoove.poi.template.run.RunTemplate;
import com.deepoove.poi.render.RenderContext;

public class SimpleFieldRenderPolicydoRender_XWPFRunsetTextFikaTest {

    @Test
    public void testDoRender() throws Exception {
        SimpleFieldRenderPolicy policy = new SimpleFieldRenderPolicy();
        
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        
        RunTemplate runTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(runTemplate.getRunPos()).thenReturn(0);
        
        @SuppressWarnings("unchecked")
        RenderContext<String> context = Mockito.mock(RenderContext.class);
        Mockito.when(context.getEleTemplate()).thenReturn(runTemplate);
        Mockito.when(context.getRun()).thenReturn(run);
        Mockito.when(context.getData()).thenReturn("test data");
        
        policy.doRender(context);
        
        document.close();
    }
}
