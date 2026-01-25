package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.junit.jupiter.api.Test;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

import java.math.BigInteger;

public class StyleUtilsstyleCTBorder_XWPFBorderTypetoStringFikaTest {

    @Test
    public void testStyleCTBorderInvokesXWPFBorderTypeToString() {
        CTBorder ctBorder = CTBorder.Factory.newInstance();
        BorderStyle borderStyle = new BorderStyle();
        
        borderStyle.setType(XWPFTable.XWPFBorderType.SINGLE);
        borderStyle.setSize(4);
        borderStyle.setSpace(0);
        borderStyle.setColor("000000");
        
        StyleUtils.styleCTBorder(ctBorder, borderStyle);
    }
}
