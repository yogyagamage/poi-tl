package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetLeftFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetLeft() throws Exception {
        // Create a real XWPFParagraph mock
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTPBdr pBdr = ppr.addNewPBdr();
        CTBorder leftBorder = pBdr.addNewLeft();
        
        // Configure paragraph mock to return the CTP
        when(paragraph.getCTP()).thenReturn(ctp);
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(ParagraphAlignment.LEFT);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // This will execute the method and invoke ct.getLeft() on the real CTPBdr object
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
