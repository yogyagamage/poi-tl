package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StyleUtilsstyleRun_XWPFRunsetStyleFikaTest {

    @Test
    public void testStyleRunInvokesSetStyle() {
        XWPFRun destRun = Mockito.mock(XWPFRun.class);
        XWPFRun srcRun = Mockito.mock(XWPFRun.class);
        
        Mockito.when(srcRun.getStyle()).thenReturn("TestStyle");
        
        StyleUtils.styleRun(destRun, srcRun);
    }
}
