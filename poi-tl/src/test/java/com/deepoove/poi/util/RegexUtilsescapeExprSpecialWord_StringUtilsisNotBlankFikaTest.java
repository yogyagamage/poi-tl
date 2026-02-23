package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWord() {
        String input = "test$string";
        String result = RegexUtils.escapeExprSpecialWord(input);
    }
}
