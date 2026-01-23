package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTFontssetAsciiFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        Style style = Mockito.mock(Style.class);
        when(style.getFontFamily()).thenReturn("Arial");
        
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ctPPr = ctP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr ctParaRPr = ctPPr.addNewRPr();
        
        when(paragraph.getCTP()).thenReturn(ctP);
        
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
