package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class StyleUtilsstyleCTBorder_CTBordersetSzFikaTest {

    @Test
    public void testStyleCTBorder() {
        StyleUtils styleUtils = new StyleUtils();
        
        CTBorder ctBorder = CTBorder.Factory.newInstance();
        BorderStyle borderStyle = new BorderStyle();
        
        borderStyle.setSize(4);
        borderStyle.setSpace(0);
        
        StyleUtils.styleCTBorder(ctBorder, borderStyle);
    }
}
