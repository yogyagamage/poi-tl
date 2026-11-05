package com.deepoove.poi.util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    public void testStyleRunTriggersStringUtilsIsNotEmpty() {
        XWPFRun mockSrcRun = mock(XWPFRun.class);
        XWPFRun mockDestRun = mock(XWPFRun.class);
        
        when(mockSrcRun.getStyle()).thenReturn("SomeStyle");
        
        StyleUtils.styleRun(mockDestRun, mockSrcRun);
    }
}
