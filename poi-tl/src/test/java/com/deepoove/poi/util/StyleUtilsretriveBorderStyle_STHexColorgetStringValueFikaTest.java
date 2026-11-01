package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;

import static org.mockito.Mockito.when;

public class StyleUtilsretriveBorderStyle_STHexColorgetStringValueFikaTest {

    @Test
    public void testRetriveBorderStyle() throws Exception {
        CTBorder border = Mockito.mock(CTBorder.class);
        STHexColor hexColor = Mockito.mock(STHexColor.class);
        
        when(border.isSetColor()).thenReturn(true);
        when(border.xgetColor()).thenReturn(hexColor);
        when(hexColor.getStringValue()).thenReturn("FF0000");
        
        StyleUtils.retriveBorderStyle(border);
    }
}
