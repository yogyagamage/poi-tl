package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleParaRpr_CTParaRPrgetSzArrayFikaTest {

    @Test
    public void test() {
        // Create a mock XWPFParagraph that will return non-null CTP with PPr
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr mockPPr = 
            mockCTP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr mockParaRPr = 
            mockPPr.addNewRPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(mockCTP);
        
        // Create a Style with fontSize set to trigger the getSzArray call
        Style style = new Style();
        style.setFontSize(12); // Non-zero font size to trigger the path
        
        // Call the entry point method
        StyleUtils.styleParaRpr(paragraph, style);
    }
}
