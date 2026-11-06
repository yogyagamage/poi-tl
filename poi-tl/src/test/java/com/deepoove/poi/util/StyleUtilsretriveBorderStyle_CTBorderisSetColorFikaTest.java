package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;

public class StyleUtilsretriveBorderStyle_CTBorderisSetColorFikaTest {

    @Test
    public void testRetriveBorderStyleInvokesIsSetColor() {
        CTBorder border = CTBorder.Factory.newInstance();
        CTColor color = CTColor.Factory.newInstance();
        color.setThemeColor(STThemeColor.ACCENT_1);
        border.setColor(color);
        border.setVal(STBorder.SINGLE);
        
        StyleUtils.retriveBorderStyle(border);
    }
}
