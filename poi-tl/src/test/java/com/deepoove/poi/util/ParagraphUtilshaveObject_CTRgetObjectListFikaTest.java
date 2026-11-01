package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class ParagraphUtilshaveObject_CTRgetObjectListFikaTest {

    @Test
    public void testHaveObject() {
        // Create mock paragraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock run
        XWPFRun run = Mockito.mock(XWPFRun.class);
        List<XWPFRun> runs = new ArrayList<>();
        runs.add(run);
        
        // Create mock CTR object with non-empty object list
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR ctr = 
            Mockito.mock(org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR.class);
        
        // Setup mock chain
        when(paragraph.getRuns()).thenReturn(runs);
        when(run.getCTR()).thenReturn(ctr);
        when(ctr.getObjectList()).thenReturn(new ArrayList<>());
        
        // Execute the method - this will invoke ctr.getObjectList()
        ParagraphUtils.haveObject(paragraph);
    }
}
