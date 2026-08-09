package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.mockito.Mockito;

public class StyleUtilsretriveParagraphStyle_CTPBdrgetTopFikaTest {

    @Test
    public void testRetriveParagraphStyleInvokesCTPBdrGetTop() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        CTPPr pr = ctp.addNewPPr();
        
        // Create and configure CTPBdr with top border
        CTPBdr pBdr = pr.addNewPBdr();
        CTBorder topBorder = pBdr.addNewTop();
        topBorder.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum.forString("single"));
        
        // Configure paragraph mock behavior
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        Mockito.when(paragraph.isWordWrapped()).thenReturn(false);
        Mockito.when(paragraph.getAlignment()).thenReturn(null);
        Mockito.when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBefore()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfter()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Execute the entry point method
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
        
        // No assertions - test only needs to invoke the chain
    }
}
