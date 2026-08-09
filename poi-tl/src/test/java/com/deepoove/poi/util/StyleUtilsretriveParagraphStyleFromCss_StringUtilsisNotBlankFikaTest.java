package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import com.deepoove.poi.data.style.ParagraphStyle;
import org.apache.commons.lang3.StringUtils;

public class StyleUtilsretriveParagraphStyleFromCss_StringUtilsisNotBlankFikaTest {

    @Test
    public void testRetriveParagraphStyleFromCss() {
        Map<String, String> propertyValues = new HashMap<>();
        propertyValues.put("background", "#FF0000");
        propertyValues.put("color", "#00FF00");
        
        StyleUtils.retriveParagraphStyleFromCss(propertyValues);
    }
}
