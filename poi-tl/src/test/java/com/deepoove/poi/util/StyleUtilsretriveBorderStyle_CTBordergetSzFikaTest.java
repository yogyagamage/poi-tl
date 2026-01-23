package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

class StyleUtilsretriveBorderStyle_CTBordergetSzFikaTest {

    @Test
    void testRetriveBorderStyle() {
        CTBorder border = Mockito.mock(CTBorder.class);
        Mockito.when(border.isSetSz()).thenReturn(true);
        Mockito.when(border.getSz()).thenReturn(BigInteger.valueOf(8));
        
        StyleUtils.retriveBorderStyle(border);
    }
}
