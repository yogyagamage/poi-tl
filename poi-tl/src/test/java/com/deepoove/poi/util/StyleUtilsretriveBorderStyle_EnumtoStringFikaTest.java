package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsretriveBorderStyle_EnumtoStringFikaTest {

    @Test
    public void testRetriveBorderStyle() {
        CTBorder border = CTBorder.Factory.newInstance();
        border.setVal(STBorder.Enum.forString("single"));
        border.setSz(BigInteger.valueOf(4));
        border.setColor("FF0000");
        
        StyleUtils.retriveBorderStyle(border);
    }
}
