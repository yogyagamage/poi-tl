package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testStyleRunInvokesStringUtilsIsNotEmpty() {
        // Create mock XWPFRun objects
        XWPFRun srcRun = Mockito.mock(XWPFRun.class);
        XWPFRun destRun = Mockito.mock(XWPFRun.class);
        
        // Configure srcRun to have a non-empty style to trigger the target method call
        Mockito.when(srcRun.getStyle()).thenReturn("SomeStyle");
        
        // Execute the entry point method
        StyleUtils.styleRun(destRun, srcRun);
        
        // No assertions or verifications - test passes if no exceptions are thrown
    }
}
