package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class TOCRenderPolicyrender_XWPFRungetParentFikaTest {

    @Test
    public void testRender() throws Exception {
        // Create the policy instance
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        // Create mock objects
        ElementTemplate mockElementTemplate = Mockito.mock(RunTemplate.class);
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        XWPFRun mockRun = Mockito.mock(XWPFRun.class);
        org.apache.poi.xwpf.usermodel.XWPFParagraph mockParagraph = 
            Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFParagraph.class);
        org.apache.poi.xwpf.usermodel.XWPFFieldRun mockFieldRun = 
            Mockito.mock(org.apache.poi.xwpf.usermodel.XWPFFieldRun.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField mockCTField = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField.class);
        
        // Setup the chain of method calls
        when(((RunTemplate) mockElementTemplate).getRun()).thenReturn(mockRun);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        when(mockParagraph.insertNewFieldRun(0)).thenReturn(mockFieldRun);
        when(mockFieldRun.getCTField()).thenReturn(mockCTField);
        
        // Execute the entry point method
        policy.render(mockElementTemplate, null, mockTemplate);
    }
}
