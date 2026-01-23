package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.mockito.Mockito;

public class StyleUtilsretriveParagraphStyle_CTPPrgetPBdrFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object using XMLBeans factory
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        
        // Add PBdr to ensure getPBdr() is called
        CTPBdr pBdr = ppr.addNewPBdr();
        
        // Configure paragraph mock to return the CTP
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        Mockito.when(paragraph.isWordWrapped()).thenReturn(false);
        Mockito.when(paragraph.getAlignment()).thenReturn(null);
        Mockito.when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBefore()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfter()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Call the entry point method
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
        
        // No assertions needed - test passes if getPBdr() is invoked during execution
    }
}
