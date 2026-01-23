package com.deepoove.poi.util;

import com.deepoove.poi.data.style.ParagraphStyle;
import com.deepoove.poi.data.style.ParagraphStyle.Builder;
import com.deepoove.poi.data.style.Style;
import com.deepoove.poi.data.style.Style.StyleBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class StyleUtilsretriveParagraphStyleFromCss_StringUtilsisNotBlankFikaTest {

    @Test
    void testRetriveParagraphStyleFromCss() {
        StyleUtils styleUtils = new StyleUtils();
        
        Map<String, String> propertyValues = new HashMap<>();
        propertyValues.put("background", "#FF0000");
        propertyValues.put("color", "#00FF00");
        
        ParagraphStyle result = StyleUtils.retriveParagraphStyleFromCss(propertyValues);
    }
}
