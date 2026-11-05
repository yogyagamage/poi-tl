package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstylePpr_CTPPrisSetWordWrapFikaTest {

    @Test
    public void testStylePprInvokesIsSetWordWrap() throws Exception {
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ctPPr = 
            ctP.addNewPPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(ctP);
        
        ParagraphStyle style = new ParagraphStyle();
        style.setAllowWordBreak(true);
        
        StyleUtils.stylePpr(paragraph, style);
    }
}
