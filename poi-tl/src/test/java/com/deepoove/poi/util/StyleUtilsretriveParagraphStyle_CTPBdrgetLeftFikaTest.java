package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetLeftFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetLeft() {
        // Create mock paragraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        
        // Create and set up paragraph mock
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(null);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Get or create PPr
        CTPPr pr = ctp.isSetPPr() ? ctp.getPPr() : ctp.addNewPPr();
        
        // Create and set PBdr with Left border
        CTPBdr pBdr = pr.addNewPBdr();
        CTBorder leftBorder = pBdr.addNewLeft();
        leftBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        // Execute the method - this will invoke ct.getLeft() inside
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
