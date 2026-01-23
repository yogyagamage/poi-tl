package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder.Enum;
import org.junit.jupiter.api.Test;

public class StyleUtilsstyleCTBorder_XWPFBorderTypetoStringFikaTest {

    @Test
    public void test() {
        CTBorder ctBorder = CTBorder.Factory.newInstance();
        BorderStyle borderStyle = new BorderStyle();
        
        XWPFBorderType borderType = XWPFBorderType.NONE;
        borderStyle.setType(borderType);
        borderStyle.setSize(1);
        borderStyle.setSpace(0);
        borderStyle.setColor("000000");
        
        StyleUtils.styleCTBorder(ctBorder, borderStyle);
    }
}
