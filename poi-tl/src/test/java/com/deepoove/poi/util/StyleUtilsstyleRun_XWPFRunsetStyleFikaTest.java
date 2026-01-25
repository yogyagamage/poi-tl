package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleRun_XWPFRunsetStyleFikaTest {

    @Test
    public void testStyleRunInvokesSetStyle() {
        // Create mock XWPFRun objects
        XWPFRun srcRun = Mockito.mock(XWPFRun.class);
        XWPFRun destRun = Mockito.mock(XWPFRun.class);
        
        // Configure srcRun to return a non-empty style string
        when(srcRun.getStyle()).thenReturn("SomeStyle");
        
        // Call the entry point method
        StyleUtils.styleRun(destRun, srcRun);
        
        // No assertions or verifications - just ensuring the method chain executes
    }
}
