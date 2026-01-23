package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBorderImpl;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsretriveBorderStyle_STHexColorgetStringValueFikaTest {

    @Test
    public void testRetriveBorderStyle() {
        CTBorder border = CTBorder.Factory.newInstance();
        
        // Create and set color to trigger the target method call
        STHexColor color = STHexColor.Factory.newInstance();
        color.setStringValue("FF0000");
        border.setColor(color);
        
        // Set size to avoid NPE
        border.setSz(BigInteger.valueOf(4));
        
        // Set border type
        border.setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.SINGLE);
        
        // Execute the entry point method
        StyleUtils.retriveBorderStyle(border);
    }
}
