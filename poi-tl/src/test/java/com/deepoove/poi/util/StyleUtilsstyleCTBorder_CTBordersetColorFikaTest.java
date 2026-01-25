package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class StyleUtilsstyleCTBorder_CTBordersetColorFikaTest {

    @Test
    public void test() {
        CTBorder ctBorder = CTBorder.Factory.newInstance();
        BorderStyle borderStyle = new BorderStyle();
        
        borderStyle.setColor("FF0000");
        borderStyle.setSize(4);
        borderStyle.setSpace(2);
        
        StyleUtils.styleCTBorder(ctBorder, borderStyle);
    }
}
