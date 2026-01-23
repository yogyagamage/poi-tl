package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBorderImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

class StyleUtilsretriveBorderStyle_CTBordergetValFikaTest {

    @Test
    void testRetriveBorderStyle() {
        CTBorder border = CTBorder.Factory.newInstance();
        border.setVal(STBorder.Enum.forString("single"));
        
        StyleUtils.retriveBorderStyle(border);
    }
}
