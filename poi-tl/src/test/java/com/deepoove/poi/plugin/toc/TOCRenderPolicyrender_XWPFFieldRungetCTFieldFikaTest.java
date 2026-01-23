package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TOCRenderPolicyrender_XWPFFieldRungetCTFieldFikaTest {

    @Test
    public void test() throws Exception {
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        ElementTemplate eleTemplate = Mockito.mock(RunTemplate.class);
        XWPFTemplate template = Mockito.mock(XWPFTemplate.class);
        
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        org.apache.poi.xwpf.usermodel.XWPFFieldRun mockFieldRun = 
            Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFFieldRun.class);
        
        when(((RunTemplate) eleTemplate).getRun()).thenReturn(mockRun);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        when(mockParagraph.insertNewFieldRun(0)).thenReturn(mockFieldRun);
        
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField mockCtField = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField.class);
        when(mockFieldRun.getCTField()).thenReturn(mockCtField);
        
        policy.render(eleTemplate, null, template);
    }
}
