package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleParaRpr_CTParaRPrsizeOfSzArrayFikaTest {

    @Test
    public void test() throws Exception {
        // Create mock XWPFParagraph
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create mock CTP
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        
        // Create mock CTPPr
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr pPr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr.Factory.newInstance();
        
        // Create real CTParaRPr
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr pr = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr.Factory.newInstance();
        
        // Configure paragraph mock to return CTP
        when(paragraph.getCTP()).thenReturn(ctp);
        
        // Configure CTP to return CTPPr that has RPr
        pPr.setRPr(pr);
        ctp.setPPr(pPr);
        
        // Create Style with font size to trigger sizeOfSzArray() call
        Style style = new Style();
        style.setFontSize(12); // Non-zero font size to trigger the path
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
