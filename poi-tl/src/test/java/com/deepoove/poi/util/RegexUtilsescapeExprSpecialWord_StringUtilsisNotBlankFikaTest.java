package com.deepoove.poi.util;

import org.junit.jupiter.api.Test;

public class RegexUtilsescapeExprSpecialWord_StringUtilsisNotBlankFikaTest {

    @Test
    public void testEscapeExprSpecialWordInvokesStringUtilsIsNotBlank() {
        // Test with a string that will trigger the isNotBlank check
        String input = "test$string";
        RegexUtils.escapeExprSpecialWord(input);
        
        // Test with null to ensure the isNotBlank method is still invoked
        RegexUtils.escapeExprSpecialWord(null);
        
        // Test with empty string
        RegexUtils.escapeExprSpecialWord("");
        
        // Test with whitespace string
        RegexUtils.escapeExprSpecialWord("   ");
        
        // Test with string containing special characters
        RegexUtils.escapeExprSpecialWord("test\\string(with)special*characters+.[]?^{}|");
    }
}
