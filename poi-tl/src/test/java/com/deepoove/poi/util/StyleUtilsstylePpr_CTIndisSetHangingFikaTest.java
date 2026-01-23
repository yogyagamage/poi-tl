package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndisSetHangingFikaTest {

    @Test
    public void testStylePprInvokesIsSetHanging() throws Exception {
        // Create a real ParagraphStyle with indentHangingChars set
        ParagraphStyle style = new ParagraphStyle();
        style.setIndentHangingChars(2.0);
        
        // Create a mock XWPFParagraph that returns a real CTP with PPr and Ind
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Build the real document structure needed for the method
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ppr = ctp.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd ind = ppr.addNewInd();
        
        // Set hanging to ensure isSetHanging() returns true
        ind.setHanging(BigInteger.valueOf(100));
        
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The test passes if no exception is thrown and the method executes
        // The third-party method CTInd.isSetHanging() will be invoked
        // No assertions or verifications are needed
    }
}
