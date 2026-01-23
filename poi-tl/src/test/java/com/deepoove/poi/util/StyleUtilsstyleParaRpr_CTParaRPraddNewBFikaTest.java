package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTParaRPraddNewBFikaTest {

    @Test
    public void testStyleParaRpr() throws Exception {
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr mockCTPPr = 
            mockCTP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr mockCTParaRPr = 
            mockCTPPr.addNewRPr();
        
        when(paragraph.getCTP()).thenReturn(mockCTP);
        
        Style style = new Style();
        style.setBold(true);
        
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
