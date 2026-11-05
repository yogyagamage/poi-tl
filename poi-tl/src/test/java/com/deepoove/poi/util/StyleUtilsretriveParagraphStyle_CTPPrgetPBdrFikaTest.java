package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPPrgetPBdrFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesGetPBdr() throws Exception {
        // Create mock paragraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP object
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        
        // Create CTPPr with PBdr set
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr pr = ctp.addNewPPr();
        pr.addNewPBdr();
        
        // Configure paragraph mock
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(null);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Execute the entry point method
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
