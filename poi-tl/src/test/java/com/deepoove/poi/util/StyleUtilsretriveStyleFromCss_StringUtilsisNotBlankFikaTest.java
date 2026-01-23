package com.deepoove.poi.util;

import com.deepoove.poi.data.style.Style;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class StyleUtilsretriveStyleFromCss_StringUtilsisNotBlankFikaTest {

    @Test
    public void testRetriveStyleFromCss() {
        StyleUtils styleUtils = new StyleUtils();
        
        Map<String, String> propertyValues = new HashMap<>();
        propertyValues.put("font-style", "italic");
        propertyValues.put("font-weight", "bold");
        propertyValues.put("color", "#FF0000");
        propertyValues.put("font-size", "12pt");
        
        StyleUtils.retriveStyleFromCss(propertyValues);
    }
}
