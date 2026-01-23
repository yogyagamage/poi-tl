package com.deepoove.poi.util;

import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StyleUtilsstyleRun_XWPFRunsetColorFikaTest {

    @Test
    public void testStyleRunInvokesSetColor() {
        XWPFRun destRun = mock(XWPFRun.class);
        XWPFRun srcRun = mock(XWPFRun.class);
        
        when(srcRun.getColor()).thenReturn("FF0000");
        
        StyleUtils.styleRun(destRun, srcRun);
    }
}
