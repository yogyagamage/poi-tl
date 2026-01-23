package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.deepoove.poi.xwpf.XWPFOnOff;
import org.apache.poi.xwpf.usermodel.XWPFFieldRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;

import static org.mockito.Mockito.*;

class TOCRenderPolicyrender_CTSimpleFieldsetDirtyFikaTest {

    @Test
    void test() throws Exception {
        // Create the policy instance
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        // Create mock ElementTemplate (RunTemplate)
        RunTemplate mockRunTemplate = mock(RunTemplate.class);
        
        // Create mock XWPFRun
        XWPFRun mockRun = mock(XWPFRun.class);
        when(mockRunTemplate.getRun()).thenReturn(mockRun);
        
        // Create mock XWPFParagraph as parent
        XWPFParagraph mockParagraph = mock(XWPFParagraph.class);
        when(mockRun.getParent()).thenReturn(mockParagraph);
        
        // Create mock XWPFFieldRun
        XWPFFieldRun mockFieldRun = mock(XWPFFieldRun.class);
        when(mockParagraph.insertNewFieldRun(0)).thenReturn(mockFieldRun);
        
        // Create real CTSimpleField that will receive setDirty call
        CTSimpleField mockToc = mock(CTSimpleField.class, Mockito.CALLS_REAL_METHODS);
        when(mockFieldRun.getCTField()).thenReturn(mockToc);
        
        // Create mock XWPFTemplate
        XWPFTemplate mockTemplate = mock(XWPFTemplate.class);
        
        // Execute the entry point
        policy.render(mockRunTemplate, null, mockTemplate);
    }
}
