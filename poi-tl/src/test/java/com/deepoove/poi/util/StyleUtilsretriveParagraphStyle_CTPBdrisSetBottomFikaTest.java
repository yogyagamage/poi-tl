package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import com.deepoove.poi.data.style.ParagraphStyle;

public class StyleUtilsretriveParagraphStyle_CTPBdrisSetBottomFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create mock paragraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTPBdr pbdr = ppr.addNewPBdr();
        pbdr.addNewBottom();
        
        // Configure paragraph mock
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        Mockito.when(paragraph.isWordWrapped()).thenReturn(false);
        Mockito.when(paragraph.getAlignment()).thenReturn(null);
        Mockito.when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBefore()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfter()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Execute the method - this will invoke ct.isSetBottom() on the real CTPBdr object
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
    }
}
