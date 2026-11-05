package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.xwpf.XWPFParagraphWrapper;

import java.math.BigInteger;

public class StyleUtilsstylePpr_CTIndunsetLeftFikaTest {

    @Test
    public void testStylePprInvokesCTIndUnsetLeft() throws Exception {
        // Create a real ParagraphStyle with indentLeftChars to trigger the target code path
        ParagraphStyle style = ParagraphStyle.builder()
                .withIndentLeftChars(2.5)
                .build();
        
        // Create a mock XWPFParagraph that returns a CTP with PPr and Ind already set
        XWPFParagraph paragraph = Mockito.mock(XWPFParagraph.class);
        
        // Create real XML beans structure
        CTP ctp = CTP.Factory.newInstance();
        CTPPr ppr = ctp.addNewPPr();
        CTInd indent = ppr.addNewInd();
        
        // Set left attribute so isSetLeft() returns true
        indent.setLeft(BigInteger.valueOf(1000));
        
        // Mock paragraph to return our CTP
        Mockito.when(paragraph.getCTP()).thenReturn(ctp);
        
        // Create a wrapper to access the package-private method
        // Since we cannot directly call the static method, we need to use reflection
        java.lang.reflect.Method method = StyleUtils.class.getDeclaredMethod(
            "stylePpr", 
            XWPFParagraph.class, 
            ParagraphStyle.class
        );
        method.setAccessible(true);
        
        // Invoke the method - this should trigger indent.unsetLeft() 
        // because style.getIndentLeftChars() is not null and indent.isSetLeft() is true
        method.invoke(null, paragraph, style);
    }
}
