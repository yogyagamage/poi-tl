package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class StyleUtilsretriveStyleFromCss_StringUtilsisNotBlankFikaTest {

    @Test
    void testRetriveStyleFromCss() {
        Map<String, String> propertyValues = new HashMap<>();
        propertyValues.put("font-style", "italic");
        propertyValues.put("font-weight", "bold");
        propertyValues.put("color", "#FF0000");
        propertyValues.put("font-size", "12px");
        
        StyleUtils.retriveStyleFromCss(propertyValues);
    }
}
