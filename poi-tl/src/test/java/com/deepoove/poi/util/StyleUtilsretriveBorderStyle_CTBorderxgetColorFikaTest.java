package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsretriveBorderStyle_CTBorderxgetColorFikaTest {

    @Test
    public void testRetriveBorderStyle() {
        CTBorder border = CTBorder.Factory.newInstance();
        border.setColor(STHexColor.Factory.newInstance());
        border.setSz(BigInteger.valueOf(4));
        border.setVal(STBorder.Enum.forString("single"));
        
        StyleUtils.retriveBorderStyle(border);
    }
}
