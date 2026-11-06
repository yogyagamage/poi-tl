package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPBdrisSetTopFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrIsSetTop() throws Exception {
        // Create mock paragraph
        XWPFParagraph paragraph = mock(XWPFParagraph.class);
        
        // Create real CTP object using XMLBeans factory
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTPBdr pbdr = ppr.addNewPBdr();
        
        // Configure pbdr to have top border set
        CTBorder topBorder = pbdr.addNewTop();
        topBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        // Configure mock paragraph to return the CTP
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(null);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Execute the entry point method - this will invoke ct.isSetTop()
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
