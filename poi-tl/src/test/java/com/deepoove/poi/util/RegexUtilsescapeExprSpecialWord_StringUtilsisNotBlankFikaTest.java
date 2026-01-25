package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWord() {
        RegexUtils instance = new RegexUtils();
        String input = "test$input";
        String result = RegexUtils.escapeExprSpecialWord(input);
    }
}
