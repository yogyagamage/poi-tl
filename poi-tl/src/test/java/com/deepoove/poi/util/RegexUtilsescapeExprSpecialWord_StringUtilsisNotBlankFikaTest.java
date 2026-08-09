package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.StringUtils;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWordInvokesStringUtilsIsNotBlank() {
        // Instantiate the class using the provided constructor
        RegexUtils regexUtils = new RegexUtils();
        
        // Call the entry point method with a string that will trigger the path
        // The string contains special characters to ensure the method executes fully
        String input = "test$string.with[special]characters";
        RegexUtils.escapeExprSpecialWord(input);
    }
}
