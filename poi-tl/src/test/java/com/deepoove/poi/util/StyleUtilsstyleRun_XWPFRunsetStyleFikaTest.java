package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class StyleUtilsstyleRun_XWPFRunsetStyleFikaTest {

    @Test
    public void testStyleRunInvokesSetStyle() {
        XWPFRun srcRun = Mockito.mock(XWPFRun.class);
        XWPFRun destRun = Mockito.mock(XWPFRun.class);
        
        when(srcRun.getStyle()).thenReturn("TestStyle");
        
        StyleUtils.styleRun(destRun, srcRun);
    }
}
