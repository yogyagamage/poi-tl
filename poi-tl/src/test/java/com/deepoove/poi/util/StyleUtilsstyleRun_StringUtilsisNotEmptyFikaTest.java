package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class StyleUtilsstyleRun_StringUtilsisNotEmptyFikaTest {

    @Test
    void testStyleRun() {
        XWPFRun destRun = Mockito.mock(XWPFRun.class);
        XWPFRun srcRun = Mockito.mock(XWPFRun.class);
        
        when(srcRun.getStyle()).thenReturn("TestStyle");
        
        StyleUtils.styleRun(destRun, srcRun);
    }
}
