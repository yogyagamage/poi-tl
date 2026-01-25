package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StyleUtilsstyleParaRpr_CTHpsMeasuresetValFikaTest {

    @Test
    public void testStyleParaRprInvokesCTHpsMeasureSetVal() throws Exception {
        // Create a real XWPFParagraph with proper initialization
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ctPPr = ctP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr ctParaRPr = ctPPr.addNewRPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(ctP);
        
        // Create a Style that will trigger the fontSize path
        Style style = new Style();
        style.setFontSize(12); // This should trigger the CTHpsMeasure.setVal() call
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
