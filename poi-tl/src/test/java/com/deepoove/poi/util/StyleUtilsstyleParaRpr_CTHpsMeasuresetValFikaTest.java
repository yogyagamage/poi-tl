package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleParaRpr_CTHpsMeasuresetValFikaTest {

    @Test
    public void testStyleParaRpr() {
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr pPr = ctp.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr pr = pPr.addNewRPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        Style style = new Style();
        style.setFontSize(12);
        
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
