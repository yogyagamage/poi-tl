package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

import static org.mockito.Mockito.when;

public class StyleUtilsretriveParagraphStyle_CTPPrgetPBdrFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create a real XWPFParagraph mock
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object using reflection since it's an auto-generated class
        CTP ctp = CTP.Factory.newInstance();
        CTPPr pr = ctp.addNewPPr();
        
        // Create and set PBdr to ensure pr.isSetPBdr() returns true
        CTPBdr pBdr = pr.addNewPBdr();
        CTBorder leftBorder = pBdr.addNewLeft();
        leftBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        // Mock paragraph to return the CTP
        when(paragraph.getCTP()).thenReturn(ctp);
        
        // Mock other required method calls
        when(paragraph.isWordWrapped()).thenReturn(false);
        when(paragraph.getAlignment()).thenReturn(ParagraphAlignment.LEFT);
        when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        when(paragraph.getSpacingBefore()).thenReturn(-1);
        when(paragraph.getSpacingAfter()).thenReturn(-1);
        when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Call the method - this will invoke pr.getPBdr()
        StyleUtils.retriveParagraphStyle(paragraph);
    }
}
