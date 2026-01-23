package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_EnumforStringFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP and set up paragraph.getCTP()
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create Style with underline color set to "auto" to trigger the target method
        Style style = new Style();
        style.setUnderlineColor("auto");
        style.setUnderlinePatterns(org.apache.poi.xwpf.usermodel.UnderlinePatterns.SINGLE);
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
