package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndsetHangingCharsFikaTest {

    @Test
    public void testStylePpr() {
        // Create a mock XWPFParagraph with necessary CT objects
        XWPFParagraph mockParagraph = Mockito.mock(XWPFParagraph.class);
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP mockCTP = 
            org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP.Factory.newInstance();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr mockPPr = mockCTP.addNewPPr();
        org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd mockInd = mockPPr.addNewInd();
        
        Mockito.when(mockParagraph.getCTP()).thenReturn(mockCTP);
        
        // Create ParagraphStyle with hanging chars to trigger the target method
        ParagraphStyle style = new ParagraphStyle();
        style.setIndentHangingChars(2.0);
        
        // Execute the entry point method
        StyleUtils.stylePpr(mockParagraph, style);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
}
