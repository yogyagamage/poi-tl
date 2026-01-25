package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class TOCRenderPolicyrender_CTSimpleFieldsetDirtyFikaTest {

    @Test
    public void testRenderPath() throws Exception {
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        org.apache.poi.xwpf.usermodel.XWPFFieldRun mockFieldRun = 
            Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFFieldRun.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField mockToc = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField.class);
        
        Mockito.when(mockParagraph.insertNewFieldRun(0)).thenReturn(mockFieldRun);
        Mockito.when(mockFieldRun.getCTField()).thenReturn(mockToc);
        Mockito.when(mockRun.getParent()).thenReturn(mockParagraph);
        
        RunTemplate mockElementTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(mockElementTemplate.getRun()).thenReturn(mockRun);
        
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        policy.render(mockElementTemplate, null, mockTemplate);
    }
}
