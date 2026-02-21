package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class StyleUtilsretriveParagraphStyleFromCss_StringUtilsisNotBlankFikaTest {

    @Test
    void testRetriveParagraphStyleFromCss() {
        Map<String, String> propertyValues = new HashMap<>();
        propertyValues.put("background", "#FFFFFF");
        propertyValues.put("color", "#000000");
        
        StyleUtils.retriveParagraphStyleFromCss(propertyValues);
    }
}
