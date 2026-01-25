package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_XWPFParagraphsetNumIDFikaTest {

    @Test
    public void testStylePprInvokesSetNumID() {
        // Create a real ParagraphStyle with numId set
        ParagraphStyle style = new ParagraphStyle();
        style.setNumId(1L);
        
        // Create a mock XWPFParagraph that will return a non-null CTP when getCTP() is called
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Mock the getCTP() method to return a non-null CTP with proper structure
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP ctp = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        ctp.addNewPPr();
        
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Call the entry point method
        StyleUtils.stylePpr(paragraph, style);
        
        // The test will execute the full chain and reach paragraph.setNumID(BigInteger.valueOf(style.getNumId()))
        // No assertions needed as per requirements
    }
}
