package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTPPraddNewWidowControlFikaTest {

    @Test
    public void testStylePprInvokesAddNewWidowControl() throws Exception {
        // Create a mock XWPFParagraph that will return a CTP with a CTPPr
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real CTP and CTPPr objects using the XMLBeans factory
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr ctpPr = 
            ctp.addNewPPr();
        
        // Make paragraph.getCTP() return our real CTP object
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Create a ParagraphStyle with widowControl set to true to trigger the target method
        ParagraphStyle style = ParagraphStyle.builder()
            .withWidowControl(true)
            .build();
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The method call should have invoked ctpPr.addNewWidowControl() internally
        // No assertions or verifications needed as per requirements
    }
}
