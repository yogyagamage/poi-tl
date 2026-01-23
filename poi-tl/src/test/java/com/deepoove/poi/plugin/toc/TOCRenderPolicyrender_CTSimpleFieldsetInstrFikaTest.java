package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TOCRenderPolicyrender_CTSimpleFieldsetInstrFikaTest {

    @Test
    public void testRender() throws Exception {
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        RunTemplate mockRunTemplate = Mockito.mock(RunTemplate.class);
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        XWPFFieldRun mockFieldRun = Mockito.mock(XWPFFieldRun.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField mockToc = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField.class);
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        when(mockRunTemplate.getRun()).thenReturn(mockRun);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        when(mockParagraph.insertNewFieldRun(0)).thenReturn(mockFieldRun);
        when(mockFieldRun.getCTField()).thenReturn(mockToc);
        
        policy.render(mockRunTemplate, null, mockTemplate);
    }
}
