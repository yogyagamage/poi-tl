package com.deepoove.poi.util;

import com.deepoove.poi.data.style.BorderStyle;
import com.deepoove.poi.data.style.BorderStyle.Builder;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigInteger;

public class StyleUtilsretriveBorderStyle_XWPFBorderTypevalueOfFikaTest {

    @Test
    public void testRetriveBorderStyle() {
        CTBorder border = Mockito.mock(CTBorder.class);
        
        Mockito.when(border.isSetColor()).thenReturn(false);
        Mockito.when(border.isSetSz()).thenReturn(false);
        
        STBorder.Enum borderEnum = Mockito.mock(STBorder.Enum.class);
        Mockito.when(borderEnum.toString()).thenReturn("SINGLE");
        Mockito.when(border.getVal()).thenReturn(borderEnum);
        
        StyleUtils.retriveBorderStyle(border);
    }
}
