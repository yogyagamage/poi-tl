package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.mockito.Mockito;

public class StyleUtilsretriveParagraphStyle_CTPPrgetShdFikaTest {

    @Test
    public void testRetriveParagraphStyle() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP object
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        
        // Create and configure CTShd
        CTShd shd = ppr.addNewShd();
        shd.setVal(STShd.Enum.forInt(1));
        shd.setFill("FFFFFF");
        
        // Configure paragraph mock
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        Mockito.when(paragraph.isWordWrapped()).thenReturn(false);
        Mockito.when(paragraph.getAlignment()).thenReturn(null);
        Mockito.when(paragraph.getSpacingBeforeLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfterLines()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBefore()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingAfter()).thenReturn(-1);
        Mockito.when(paragraph.getSpacingBetween()).thenReturn(-1.0);
        
        // Execute the method - this will trigger pr.getShd() call
        ParagraphStyle result = StyleUtils.retriveParagraphStyle(paragraph);
    }
}
