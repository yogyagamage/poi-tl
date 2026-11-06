package com.deepoove.poi.plugin.toc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class TOCRenderPolicyrender_XWPFParagraphinsertNewFieldRunFikaTest {

    @Test
    public void test() throws Exception {
        // Create real XWPFParagraph
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph realParagraph = document.createParagraph();
        
        // Create real XWPFRun inside the paragraph
        XWPFRun realRun = realParagraph.createRun();
        realRun.setText("placeholder");
        
        // Create mock RunTemplate that returns the real run
        RunTemplate mockRunTemplate = Mockito.mock(RunTemplate.class);
        Mockito.when(mockRunTemplate.getRun()).thenReturn(realRun);
        
        // Create mock XWPFTemplate
        XWPFTemplate mockTemplate = Mockito.mock(XWPFTemplate.class);
        
        // Create the policy instance
        TOCRenderPolicy policy = new TOCRenderPolicy();
        
        // Execute the entry point method
        policy.render(mockRunTemplate, new Object(), mockTemplate);
    }
}
